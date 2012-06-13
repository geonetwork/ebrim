package org.geonetwork.utils.xsd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.geonetwork.utils.collection.CollectionUtil;
import org.geonetwork.utils.string.StringUtil;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

/**
 * 
 * Class to load an XSD document from file into a JDOM element and provides methods to search for 
 * elements in it.
 * 
 * If the XSD contains any <code>xsd:import</code> or <code>xsd:include</code> elements, an attempt is made to load these XSDs as well,
 * thus loading a set of XSD documents. After initialization the state of the instance is either FULLY_LOADED,
 * PARTIALLY_LOADED or NOTHING_LOADED, depending on the success of loading any or all of the schemas.
 * 
 * All namespaces are indexed to point to a list of XSDs that use them; this index is available to clients of 
 * this class.
 * 
 * Usage examples:
 * 
 * <code>
 * //
 * // absolute file location 
 * //
 * XSD xsd = new XSD("file:///C:/temp/xsd/my.xsd");
 * 
 * //
 * // relative file location
 * //
 * XSD xsd = new XSD("xsd/my.xsd");
 * 
 * //
 * // absolute HTTP location 
 * //
 * XSD xsd = new XSD("http://schemas.opengis.net/csw/2.0.2/CSW-discovery.xsd");
 * 
 * </code>
 * 
 * @author heikki doeleman
 *
 */
public class XSD {
	
	private static Logger log = Logger.getLogger(XSD.class);	
	
	/**
	 * Whether to load included and imported schemas.
	 * @author heikki
	 *
	 */
	public static enum LOAD_INCLUSIONS {
		ON, OFF
	}
	
	public XSD(String location) {
		load(location, null);
	}
	public XSD(String location, LOAD_INCLUSIONS loadInclusions) {
		this.loadInclusions = loadInclusions;
		load(location, null);
	}	
	private LOAD_INCLUSIONS loadInclusions = LOAD_INCLUSIONS.ON;
	
	/**
	 * Returns first element in documentRoots as a String.
	 * @return
	 */
	public Element returnSchema() {
		if(CollectionUtil.isNotEmpty(documentRoots)) {
			return documentRoots.get(0);
		}
		else {
			return null;
		}
	}
	
	/**
	 * Returns a list with elements matching the searched name, recursively searching from this XSD's 
	 * root. Namespace is ignored.
	 * 
	 * @param searched - the name of the elements to search
	 * @return
	 * @throws IOException
	 */
	public List<Element> findElement(String searched) throws IOException {
		List<Element> results = new ArrayList<Element>();
		for(Element root : documentRoots) {
			findElement(root, searched, results) ;
		}
		return results;
	}
	
	/**
	 * Fills a list with elements matching the searched name, recursively searching from the provided 
	 * element. Namespace is ignored.
	 * 
	 * @param element - root of the XSD (-fragment) to search from
	 * @param searched - the name of the elements to search
	 * @param results
	 * @throws IOException
	 */
	public void findElement(Element element, String searched, List<Element> results) throws IOException {
		if(element == null) {
			return;
		}
		String candidate = element.getName();
		if(candidate != null && candidate.equals(searched)) {
			results.add(element);
		}
		@SuppressWarnings("unchecked")		 
		List<Element> children = element.getChildren();
		for(Element child : children) {
			findElement(child, searched, results);
		}
	}	
	
	/**
	 * Searches for a named element in this XSD document, starting from the document root. The first 
	 * matching element is returned.
	 * 
	 * @param searched - the value of attribute 'name' of the element to search	 
	 * @param targetNamespace - URI of the namespace of the element to search
	 * @return
	 * @throws IOException
	 */
	public Element findElementByName(String searched, String targetNamespace)  {
		log.debug("findelement by name: " + searched + " " + targetNamespace);
		List<Element> xsdsUsingThisNamespace = namespaceIndex.get(targetNamespace);
		if(xsdsUsingThisNamespace != null) {
			for(Element root : xsdsUsingThisNamespace) {
				String tns = root.getAttributeValue("targetNamespace");
				// XSD has the requested target namespace
				if((StringUtil.isNotEmpty(tns) && tns.equals(targetNamespace)) ||
					// XSD has no target namespace and none is requested
					StringUtil.isEmpty(tns) && StringUtil.isEmpty(targetNamespace)) {
						Element found = findElementByName(root, searched) ;
						if(found != null) {
							return found;
						}
				}
			}
		}
		return null;
	}

	/**
	 * Searches recursively for a named element in this XSD document, starting from the specified 
	 * element. The first matching element is returned.
	 * 
	 * @param element - root of the XSD (-fragment) to search from
	 * @param searched - the value of attribute 'name' of the element to search
	 * @return
	 * @throws IOException
	 */
	private Element findElementByName(Element element, String searched) {
		if(element == null) {
			return null;
		}
		String candidate = element.getAttributeValue("name");
		if(candidate != null && candidate.equals(searched)) {
			return element;
		}
		@SuppressWarnings("unchecked")		 
		List<Element> children = element.getChildren();
		for(Element child : children) {
			Element recurse = findElementByName(child, searched);
			if(recurse != null) {
				return recurse;
			}
		}
		return null;
	}
	
	/**
	 * Loads an XSD document.
	 * 
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	private void load(String location, String locationBase) {
		if(alreadyLoaded.contains(location)) {
			log.debug("skipping already loaded schema from " + location);
			return;
		}
	    try {
			SAXBuilder saxBuilder = new SAXBuilder(SAXBUILDER_VALIDATE_OFF);
			Document document = null;
			if(StringUtil.isNotEmpty(locationBase) && !location.startsWith("http://")) {
				log.debug("loading schema from " + locationBase + "/" + location);
				document = saxBuilder.build(new InputSource(locationBase + "/" + location));
			}
			else {
				locationBase = null;
				log.debug("loading schema from " + location);
				document = saxBuilder.build(new InputSource(location));				
			}
		    Element documentRoot = (Element)document.getRootElement().detach();
			
			//
			// add this XSD's document root to the list of document roots
			//
		    this.documentRoots.add(documentRoot);
		    this.alreadyLoaded.add(location);

		    //
		    // update location base
		    //
		    if(location.lastIndexOf('/') >= 0) {
		    	if(locationBase != null) {
		    		locationBase = locationBase + "/" + location.substring(0, location.lastIndexOf('/'));
		    	}
		    	else {
		    		locationBase = location.substring(0, location.lastIndexOf('/'));
		    	}
		    }
		    
		    //
		    // index default namespace
		    //
		    Namespace namespace = documentRoot.getNamespace();
		    if(namespace == null) {
		    	namespace = Namespace.NO_NAMESPACE;
		    }
		    List<Element> xsdsForNS = namespaceIndex.get(namespace.getURI());
		    if(xsdsForNS == null) {
		    	xsdsForNS = new ArrayList<Element>();
		    }
		    if(!xsdsForNS.contains(documentRoot)) {
		    	xsdsForNS.add(documentRoot);
			    namespaceIndex.put(namespace.getURI(), xsdsForNS);
		    }
		    
		    //
		    // index additional namespaces
		    //
			@SuppressWarnings("unchecked")
		    List<Namespace> additionalNamespaces = documentRoot.getAdditionalNamespaces();
			if(CollectionUtil.isNotEmpty(additionalNamespaces)) {
			    for(Namespace additionalNamespace : additionalNamespaces) {
			    	List<Element> xsdsForAdditionalNS = namespaceIndex.get(additionalNamespace.getURI());
				    if(xsdsForAdditionalNS == null) {
				    	xsdsForAdditionalNS = new ArrayList<Element>();
				    }		    
				    if(!xsdsForAdditionalNS.contains(documentRoot)) {
				    	xsdsForAdditionalNS.add(documentRoot);
					    namespaceIndex.put(additionalNamespace.getURI(), xsdsForAdditionalNS);
				    }
			    }
			}
		    
		    //
		    // index target namespace
		    //
			String tns = documentRoot.getAttributeValue("targetNamespace");
			if(StringUtil.isNotEmpty(tns)) {
		    	List<Element> xsdsForTNS = namespaceIndex.get(tns);
		    	if(xsdsForTNS == null) {
		    		xsdsForTNS = new ArrayList<Element>();
		    	}
			    if(!xsdsForTNS.contains(documentRoot)) {
			    	xsdsForTNS.add(documentRoot);
				    namespaceIndex.put(namespace.getURI(), xsdsForTNS);
			    }			
			}
		    
			if(this.loadInclusions == LOAD_INCLUSIONS.ON) {	
			    //
			    // load imported XSDs
			    //
				List<Element> imports = new ArrayList<Element>();
				findElement(documentRoot, "import", imports);
				for(Element imp0rt : imports) {
					load(imp0rt.getAttributeValue("schemaLocation"), locationBase);
				}
				
				//
				// load included XSDs
				//
				List<Element> includes = new ArrayList<Element>();
				findElement(documentRoot, "include", includes);
				for(Element include : includes) {
					load(include.getAttributeValue("schemaLocation"), locationBase);
				}
			}
	    }
	    catch(Throwable x) {
	    	log.debug("WARNING: Failed to load XSD from location: " + location);	    		
			if(documentRoots.size() == 0) {
				state = State.NOTHING_LOADED;
			}
			else {
				state = State.PARTIALLY_LOADED;
			}
	    }
	}
	
	@SuppressWarnings("unused")
	private static final boolean SAXBUILDER_VALIDATE_ON = true;
	private static final boolean SAXBUILDER_VALIDATE_OFF = false;
	
	/**
	 * List of document roots of loaded XSDs.
	 */
	private List<Element> documentRoots = new ArrayList<Element>();
	
	/**
	 * An index revealing which loaded XSDs use a namespace (either as default, additional or target
	 * namespace).
	 */
	private Map<String, List<Element>> namespaceIndex = new HashMap<String, List<Element>>();
	public Map<String, List<Element>> getNamespaceIndex() {
		return namespaceIndex;
	}
	
	/**
	 * Used in load() to prevent endless circular, and unnecessary schema loading. 
	 * 
	 * E.g. the GML XSDs all include many times some of the same other GML XSDs; we want
	 * to load them just once. 
	 * 
	 * An example of circular reference is http://schemas.opengis.net/gml/3.1.1/smil/smil20.xsd and
	 * http://schemas.opengis.net/gml/3.1.1/smil/smil20-language.xsd that import each other !!
	 */
	private Set<String> alreadyLoaded = new HashSet<String>();
	
	/**
	 * If any or all of the loading fails, this is changed to reflect that.
	 */
	private State state = State.FULLY_LOADED;
	public State getState() {
		return state;
	}

	/**
	 * 
	 * Indicates whether loading the XSD and any imported and included XSDs has succeeded
	 * completely, partially or not at all.
	 * 
	 * @author heikki doeleman
	 *
	 */
	public static enum State {
		FULLY_LOADED, PARTIALLY_LOADED, NOTHING_LOADED
	}

}