//=============================================================================
//===	Copyright (C) 2008 European Space Agency (ESA).
//===
//===	This program is free software; you can redistribute it and/or modify
//===	it under the terms of the GNU General Public License as published by
//===	the Free Software Foundation; either version 2 of the License, or (at
//===	your option) any later version.
//===
//===	This program is distributed in the hope that it will be useful, but
//===	WITHOUT ANY WARRANTY; without even the implied warranty of
//===	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//===	General Public License for more details.
//===
//===	You should have received a copy of the GNU General Public License
//===	along with this program; if not, write to the Free Software
//===	Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
//===
//===	Contact: Jeroen Ticheler - E-mail: geonetwork@osgeo.org

//==============================================================================
package org.geonetwork.services.ebrim.iso19139;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.List;

import org.apache.log4j.Logger;
import org.geonetwork.dao.facade.DeleteFacade;
import org.geonetwork.dao.facade.RegistryObjectListStoreFacade;
import org.geonetwork.dao.ebrim.informationmodel.ClassificationDao;
import org.geonetwork.domain.ebrim.informationmodel.core.Identifiable;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObjectList;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.services.ebrim.GeonetworkServiceException;
import org.geonetwork.utils.visitor.ObjectGraphVisitorPlus;
import org.geonetwork.utils.xslt.GeonetworkTransformerException;
import org.geonetwork.utils.xslt.Transformer;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;
import org.springframework.core.io.ClassPathResource;

/**
 * Metadata in ISO19139 format is processed into a number of ebRIM objects that are stored in persistent storage.
 * 
 * See OGC 07-038 appendix F for the specification on how this is done.
 * 
 * The first step in the conversion are the XSLT transformations. The results of the transformations are then further
 * processed to add information the XSLT has no access to, such as IDs of existing ebRIM data.
 * 
 * @author heikki doeleman
 * 
 */
public class ISO19139Service {

	private static Logger log = Logger.getLogger(ISO19139Service.class);
	RegistryObjectListStoreFacade registryObjectListStoreFacade;
	DeleteFacade deleteFacade;

    ClassificationDao classificationDao;

    public void setClassificationDao(ClassificationDao classificationDao) {
        this.classificationDao = classificationDao;
    }

	/**
	 * Deletes the RegistryObjects related to an ISO 19139 metadata from the persistent registry.
	 * 
	 * @param iso19139Id
	 * @throws GeonetworkServiceException
	 */
	public synchronized void delete(String iso19139Id) throws GeonetworkServiceException {
		try {
			deleteFacade.deleteByISOId(iso19139Id);
		} catch (Exception x) {
			System.err.println(x.getMessage());
			x.printStackTrace();
			throw new GeonetworkServiceException(x);
		}
	}

	/**
	 * Transforms an incoming ISO19139 document in to various ebRIM documents, according to OGC 07-038 Annex F
	 * "Mapping between the Core ISO Metadata (CIM) information model and ISO 19115 / ISO 19119", post-processes the
	 * XSLT results, and stores them persistently.
	 * 
	 * @param iso19139
	 * @throws GeonetworkServiceException
	 */
	public synchronized void insert(InputStream iso19139) throws GeonetworkServiceException {
		try {
			log.debug("ISO19139Service insert start");
			// transform incoming ISO19139 to ebRIM
			RegistryObjectList transformationResults = transformToEbRIM(iso19139);
			Fixer.getIds().clear();
			// generate UUIDs for IDs generated in XSLT
			for (Identifiable identifiable : transformationResults.getRegistryObjects()) {
                Fixer fixer = new Fixer();
				Method action = fixer.getClass().getMethod(Fixer.ACTION.fixID.getMethodName(), Identifiable.class);
				ObjectGraphVisitorPlus visitor = new ObjectGraphVisitorPlus();
				Identifiable fixedIdentifiable = (Identifiable) visitor.performAction(identifiable, Identifiable.class,
						action, fixer);
            }

			log.debug("# UUIDs: " + Fixer.getIds().size() + "\nthey are:");
			for (Map.Entry<URN, URN> urn : Fixer.getIds().entrySet()) {
				log.debug(urn.getKey() + "\t\t\t\t" + urn.getValue());
                System.out.println(urn.getKey() + "\t\t\t\t" + urn.getValue());
			}
            int i = 0;
			for (Identifiable identifiable : transformationResults.getRegistryObjects()) {
                log.debug("# " + ++i + " " + identifiable.getId());
				Fixer fixer = new Fixer();
				Method action = fixer.getClass().getMethod(Fixer.ACTION.referID.getMethodName(), Identifiable.class);
				ObjectGraphVisitorPlus visitor = new ObjectGraphVisitorPlus();
				Identifiable fixedIdentifiable = (Identifiable) visitor.performAction(identifiable, Identifiable.class,
						action, fixer);
            }

            // associate values to CharacterSet
            List<ClassificationNode> cc = classificationDao.findClassificationNodesByParent("urn:ogc:def:ebRIM-ClassificationScheme:CharacterSet") ;

            for (Identifiable identifiable : transformationResults.getRegistryObjects()) {
                Fixer fixer = new Fixer();
                Method action = fixer.getClass().getMethod(Fixer.ACTION.fixClassificationNodeId.getMethodName(), new Class[] {Identifiable.class, String.class, List.class} );
                ObjectGraphVisitorPlus visitor = new ObjectGraphVisitorPlus();
                Identifiable fixedIdentifiable = (Identifiable) visitor.performAction2(identifiable, Identifiable.class,
                        action, fixer, new Object[] {"urn:ogc:def:ebRIM-ClassificationScheme:CharacterSet", cc});
            }

            // associate values to TopicCategory
            cc = classificationDao.findClassificationNodesByParent("urn:ogc:def:ebRIM-ClassificationScheme:TopicCategory") ;

            for (Identifiable identifiable : transformationResults.getRegistryObjects()) {
                Fixer fixer = new Fixer();
                Method action = fixer.getClass().getMethod(Fixer.ACTION.fixClassificationNodeId.getMethodName(), new Class[] {Identifiable.class, String.class, List.class} );
                ObjectGraphVisitorPlus visitor = new ObjectGraphVisitorPlus();
                Identifiable fixedIdentifiable = (Identifiable) visitor.performAction2(identifiable, Identifiable.class,
                        action, fixer, new Object[] {"urn:ogc:def:ebRIM-ClassificationScheme:TopicCategory", cc});
            }

            // associate values to SpatialRepresentation
            cc = classificationDao.findClassificationNodesByParent("urn:ogc:def:ebRIM-ClassificationScheme:SpatialRepresentation") ;

            for (Identifiable identifiable : transformationResults.getRegistryObjects()) {
               Fixer fixer = new Fixer();
               Method action = fixer.getClass().getMethod(Fixer.ACTION.fixClassificationNodeId.getMethodName(), new Class[] {Identifiable.class, String.class, List.class} );
               ObjectGraphVisitorPlus visitor = new ObjectGraphVisitorPlus();
               Identifiable fixedIdentifiable = (Identifiable) visitor.performAction2(identifiable, Identifiable.class,
                       action, fixer, new Object[] {"urn:ogc:def:ebRIM-ClassificationScheme:SpatialRepresentation", cc});
            }

            // associate values to KeywordType
            cc = classificationDao.findClassificationNodesByParent("urn:ogc:def:ebRIM-ClassificationScheme:KeywordType") ;

            for (Identifiable identifiable : transformationResults.getRegistryObjects()) {
              Fixer fixer = new Fixer();
              Method action = fixer.getClass().getMethod(Fixer.ACTION.fixClassificationNodeId.getMethodName(), new Class[] {Identifiable.class, String.class, List.class} );
              ObjectGraphVisitorPlus visitor = new ObjectGraphVisitorPlus();
              Identifiable fixedIdentifiable = (Identifiable) visitor.performAction2(identifiable, Identifiable.class,
                      action, fixer, new Object[] {"urn:ogc:def:ebRIM-ClassificationScheme:KeywordType", cc});
            }

            // associate values to RestrictionCode
            cc = classificationDao.findClassificationNodesByParent("urn:ogc:def:ebRIM-ClassificationScheme:RestrictionCode") ;

            for (Identifiable identifiable : transformationResults.getRegistryObjects()) {
              Fixer fixer = new Fixer();
              Method action = fixer.getClass().getMethod(Fixer.ACTION.fixClassificationNodeId.getMethodName(), new Class[] {Identifiable.class, String.class, List.class} );
              ObjectGraphVisitorPlus visitor = new ObjectGraphVisitorPlus();
              Identifiable fixedIdentifiable = (Identifiable) visitor.performAction2(identifiable, Identifiable.class,
                      action, fixer, new Object[] {"urn:ogc:def:ebRIM-ClassificationScheme:RestrictionCode", cc});
            }

            // associate values to RestrictionType
            cc = classificationDao.findClassificationNodesByParent("urn:ogc:def:ebRIM-ClassificationScheme:RestrictionType") ;

            for (Identifiable identifiable : transformationResults.getRegistryObjects()) {
              Fixer fixer = new Fixer();
              Method action = fixer.getClass().getMethod(Fixer.ACTION.fixClassificationNodeId.getMethodName(), new Class[] {Identifiable.class, String.class, List.class} );
              ObjectGraphVisitorPlus visitor = new ObjectGraphVisitorPlus();
              Identifiable fixedIdentifiable = (Identifiable) visitor.performAction2(identifiable, Identifiable.class,
                      action, fixer, new Object[] {"urn:ogc:def:ebRIM-ClassificationScheme:RestrictionType", cc});
            }

            // associate values to ClassificationCode
            cc = classificationDao.findClassificationNodesByParent("urn:ogc:def:ebRIM-ClassificationScheme:ClassificationCode") ;

            for (Identifiable identifiable : transformationResults.getRegistryObjects()) {
              Fixer fixer = new Fixer();
              Method action = fixer.getClass().getMethod(Fixer.ACTION.fixClassificationNodeId.getMethodName(), new Class[] {Identifiable.class, String.class, List.class} );
              ObjectGraphVisitorPlus visitor = new ObjectGraphVisitorPlus();
              Identifiable fixedIdentifiable = (Identifiable) visitor.performAction2(identifiable, Identifiable.class,
                      action, fixer, new Object[] {"urn:ogc:def:ebRIM-ClassificationScheme:ClassificationCode", cc});
            }

            // associate values to DCPList
            cc = classificationDao.findClassificationNodesByParent("urn:ogc:def:ebRIM-ClassificationScheme:DCPList") ;

            for (Identifiable identifiable : transformationResults.getRegistryObjects()) {
              Fixer fixer = new Fixer();
              Method action = fixer.getClass().getMethod(Fixer.ACTION.fixClassificationNodeId.getMethodName(), new Class[] {Identifiable.class, String.class, List.class} );
              ObjectGraphVisitorPlus visitor = new ObjectGraphVisitorPlus();
              Identifiable fixedIdentifiable = (Identifiable) visitor.performAction2(identifiable, Identifiable.class,
                      action, fixer, new Object[] {"urn:ogc:def:ebRIM-ClassificationScheme:DCPList", cc});
            }

            // associate values to CouplingType
            cc = classificationDao.findClassificationNodesByParent("urn:ogc:def:ebRIM-ClassificationScheme:CouplingType") ;

            for (Identifiable identifiable : transformationResults.getRegistryObjects()) {
              Fixer fixer = new Fixer();
              Method action = fixer.getClass().getMethod(Fixer.ACTION.fixClassificationNodeId.getMethodName(), new Class[] {Identifiable.class, String.class, List.class} );
              ObjectGraphVisitorPlus visitor = new ObjectGraphVisitorPlus();
              Identifiable fixedIdentifiable = (Identifiable) visitor.performAction2(identifiable, Identifiable.class,
                      action, fixer, new Object[] {"urn:ogc:def:ebRIM-ClassificationScheme:CouplingType", cc});
            }

            // associate values to GlobalRegions
            cc = classificationDao.findClassificationNodesByParent("urn:ogc:def:ebRIM-ClassificationScheme:UNSD:GlobalRegions") ;

            for (Identifiable identifiable : transformationResults.getRegistryObjects()) {
              Fixer fixer = new Fixer();
              Method action = fixer.getClass().getMethod(Fixer.ACTION.fixClassificationNodeId.getMethodName(), new Class[] {Identifiable.class, String.class, List.class} );
              ObjectGraphVisitorPlus visitor = new ObjectGraphVisitorPlus();
              Identifiable fixedIdentifiable = (Identifiable) visitor.performAction2(identifiable, Identifiable.class,
                      action, fixer, new Object[] {"urn:ogc:def:ebRIM-ClassificationScheme:UNSD:GlobalRegions", cc});
            }


			transformationResults = new PostJibxStep().enrichAssociationRelations(transformationResults);
			// persist RegistryObjectList
			registryObjectListStoreFacade.save(transformationResults);

		} catch (Exception x) {
			System.err.println(x.getMessage());
			x.printStackTrace();
			throw new GeonetworkServiceException(x);
		}
	}

	/**
	 * 
	 * @param iso19139
	 * @return
	 * @throws GeonetworkTransformerException
	 * @throws GeonetworkServiceException
	 * @throws IOException
	 */
	protected RegistryObjectList transformToEbRIM(InputStream iso19139) throws GeonetworkTransformerException,
			GeonetworkServiceException, IOException {
		log.debug("ISO19139Service transformToEbRIM start");
		ClassPathResource cpr = new ClassPathResource(Resource.ISO19139toCIM);
		InputStream CIM_transformer = cpr.getInputStream();
		// InputStream CIM_transformer = new FileInputStream(new File(Resource.ISO19139toCIM));
		ByteArrayOutputStream CIM_transformer_target = new ByteArrayOutputStream();
		Transformer.transform(iso19139, CIM_transformer, CIM_transformer_target);
		log.debug("ISO19139Service transformToEbRIM transformation done");
		RegistryObjectList registryObjectList = unmarshal(CIM_transformer_target);

		/*
		 * try { // set up JiBX marshalling context IBindingFactory bfact =
		 * BindingDirectory.getFactory(RegistryObjectList.class); IMarshallingContext marshallingContext =
		 * bfact.createMarshallingContext();
		 * 
		 * // marshal to console - nice if you're looking Writer outConsole = new BufferedWriter(new
		 * OutputStreamWriter(System.out)); marshallingContext.setOutput(outConsole); marshallingContext.setIndent(3);
		 * marshallingContext.marshalDocument(registryObjectList, "UTF-8", null); } catch(Exception x) {
		 * System.err.println(x.getMessage()); }
		 */log.debug("ISO19139Service transformToEbRIM end");
		return registryObjectList;
	}

	/**
	 * 
	 * @param bos
	 * @return
	 * @throws GeonetworkServiceException
	 * @throws IOException
	 */
	private RegistryObjectList unmarshal(ByteArrayOutputStream bos) throws GeonetworkServiceException, IOException {
		try {
			log.debug("ISO19139Service unmarshal received: ");
			bos.writeTo(System.out);

			// create JiBX unmarshal context
			IBindingFactory bfact = BindingDirectory.getFactory(RegistryObjectList.class);
			IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

			// convert to inputstream for JiBX
			ByteArrayInputStream transformationResult = new ByteArrayInputStream(bos.toByteArray());

			// unmarshal to RegistryObjectList
			RegistryObjectList unMarshallingResult = (RegistryObjectList) unMarshallingContext.unmarshalDocument(
					transformationResult, "UTF-8");
			log.debug("ISO19139Service unmarshal end");
			return unMarshallingResult;
		} catch (JiBXException x) {
			throw new GeonetworkServiceException(x);
		}
	}

    public void setDeleteFacade(DeleteFacade deleteFacade) {
		this.deleteFacade = deleteFacade;
	}

	public void setRegistryObjectListStoreFacade(RegistryObjectListStoreFacade registryObjectListStoreFacade) {
		this.registryObjectListStoreFacade = registryObjectListStoreFacade;
	}
}
