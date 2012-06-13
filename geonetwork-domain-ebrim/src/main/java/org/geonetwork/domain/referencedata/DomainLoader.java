package org.geonetwork.domain.referencedata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationScheme;
import org.geonetwork.domain.ebrim.informationmodel.core.Identifiable;
import org.geonetwork.domain.ebrs.SubmitObjectsRequest;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;

/**
 * 
 * Load classification schemes for canonical ebrim, the basic extension package and the
 * core iso metadata extension package into memory. To be run at application start-up.
 * 
 * @author heikki doeleman
 *
 */
public class DomainLoader {

	/**
	 * For test purposes.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File canonicalDir = new File(CANONICAL_LOCATION);
			DomainLoader.load(canonicalDir);
		}
		catch(Throwable x) {
			System.out.println(x.getMessage());
			x.printStackTrace();
		}
	}
	
	public static final String CANONICAL_LOCATION = "src/main/resources/canonicalClassificationSchemes";
	
	public static void load(File dir) throws FileNotFoundException, JiBXException {
		List<Identifiable> referenceData = ReferenceData.getReferenceData();
		if(dir.exists()) {
			if(dir.isDirectory()) {
				File[] files = dir.listFiles(new DomainLoaderFilenameFilter());
				for(File f : files) {
					FileInputStream fis = new FileInputStream(f);
					IBindingFactory bfact = BindingDirectory.getFactory(SubmitObjectsRequest.class);
					IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();
					SubmitObjectsRequest unMarshallingResult = (SubmitObjectsRequest) unMarshallingContext.unmarshalDocument(fis, "UTF-8");
					List<? extends Identifiable> submittedObjects = unMarshallingResult.getRegistryObjectList();
					for(Iterator<? extends Identifiable> i = submittedObjects.iterator(); i.hasNext();) {
						Identifiable identifiable = i.next();
						referenceData.add(identifiable);
						System.out.println(identifiable.getClass().getCanonicalName());
						if(identifiable.getClass().equals(ClassificationScheme.class)) {
							ClassificationScheme classificationScheme = (ClassificationScheme) identifiable;
							Set<ClassificationNode> classificationNodes = classificationScheme.getClassificationNodes();
							if(classificationNodes != null) {
								for(Iterator<ClassificationNode> j = classificationNodes.iterator(); j.hasNext();){
									ClassificationNode classificationNode = j.next();
									referenceData.add(classificationNode);
								}
							}
						}
						if(identifiable.getClass().equals(ClassificationNode.class)) {
							ClassificationNode classificationNode = (ClassificationNode) identifiable;
							Set<ClassificationNode> classificationNodes = classificationNode.getClassificationNodes();
							if(classificationNodes != null) {
								for(Iterator<ClassificationNode> j = classificationNodes.iterator(); j.hasNext();){
									System.out.println("\n\n\tadaaan\n");
									ClassificationNode nestedClassificationNode = j.next();
									referenceData.add(nestedClassificationNode);
								}
							}
						}					}
				}
				
				for(Iterator<Identifiable> i = referenceData.iterator(); i.hasNext();) {
					Identifiable ide = i.next();
					System.out.println("type: " + ide.getClass() + "\tid: " + ide.getId());
				}
				System.out.println("loaded #" + referenceData.size() + " objects");
				
				
			}
			else {
				System.out.println(dir.getAbsolutePath() + " is not a directory");				
			}
		}
		else {
			System.out.println("cannot find: " + dir.getAbsolutePath());
		}
	}

}
