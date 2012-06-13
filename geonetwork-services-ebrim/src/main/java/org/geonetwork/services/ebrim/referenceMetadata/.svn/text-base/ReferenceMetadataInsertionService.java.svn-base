package org.geonetwork.services.ebrim.referenceMetadata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.geonetwork.dao.ebrim.informationmodel.CoreDao;
import org.geonetwork.domain.ebrim.informationmodel.core.ExternalIdentifier;
import org.geonetwork.domain.ebrim.informationmodel.core.ExternalLink;
import org.geonetwork.domain.ebrim.informationmodel.core.ExtrinsicObject;
import org.geonetwork.domain.ebrim.informationmodel.core.Identifiable;
import org.geonetwork.domain.ebrim.informationmodel.core.ObjectRef;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObjectList;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryPackage;
import org.geonetwork.services.ebrim.GeonetworkServiceException;
import org.geonetwork.utils.file.FileUtil;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;
import org.springframework.core.io.ClassPathResource;

/**
 * Service to load XML files with extension packages definitions in ebRim Registry
 *
 * @author Jose
 */
public class ReferenceMetadataInsertionService {


    private static Logger log = Logger.getLogger(ReferenceMetadataInsertionService.class);
    // Path to xml files to process
    private String resourceMetadataPath;

    private String classPathCimReferenceData = "classpath.data.referenceMetadata/CIM-Package.xml";

    CoreDao coreDao;

    public synchronized void insert() throws GeonetworkServiceException {
        try {
            log.debug("ResourceMetadata insert start");
            if (resourceMetadataPath == null) {
                // when no resourceMetadataPath is defined, the referenceData out of the
                // geonetwork-services-ebrim.jar will be loaded.
                ClassPathResource cpr = new ClassPathResource(classPathCimReferenceData);
                inputStream2Database(cpr.getInputStream());
            } else {
                // when resourceMetadataPath is defined, all xml files with reference data will be
                // loaded into DB.
                File[] filesToProcess = FileUtil.getFiles(resourceMetadataPath, "xml");
                for (File file : filesToProcess) {
                    FileInputStream fis = null;
                    try {
                        fis = new FileInputStream(file);
                        inputStream2Database(fis);
                    } finally {
                        if (fis != null)
                            fis.close();
                    }
                }
            }

            System.out.println("end");
        } catch (Exception x) {
            System.err.println(x.getMessage());
            x.printStackTrace();
            throw new GeonetworkServiceException(x);
        }
    }

    private void inputStream2Database(InputStream fis) throws GeonetworkServiceException, IOException {
        // Unmarshall object
        Identifiable unmarshallObject = unmarshal(fis);

        try {
            RegistryPackage rp = (RegistryPackage) unmarshallObject;
            associateRegistryPackage(rp);

            // Remove the RegistryPackage content (if exists) before loading
            RegistryObject ro = coreDao.findRegistryObjectByUrnId(rp.getId().getValue());
            if (ro != null) {
                coreDao.deleteRegistryObject(ro);
            }

            // Stores object
            saveIdentifiable(unmarshallObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void associateRegistryPackage(RegistryPackage rp) {
        for (RegistryObject i : rp.getRegistryObjectList()) {
            i.setRegistryPackageInverse(rp);

            if (i instanceof RegistryPackage) {
                associateRegistryPackage((RegistryPackage) i);
            }
        }
    }

    /**
     * Calls dao method depending on Identifiable object concrete class
     *
     * @param object Object to store
     */
    private void saveIdentifiable(Identifiable object) {
        if (object instanceof RegistryPackage) {
            coreDao.saveRegistryPackage((RegistryPackage) object);

        } else if (object instanceof ExtrinsicObject) {
            coreDao.saveExtrinsicObject((ExtrinsicObject) object);

        } else if (object instanceof ExternalLink) {
            coreDao.saveExternalLink((ExternalLink) object);

        } else if (object instanceof ExternalIdentifier) {
            coreDao.saveExternalIdentifier((ExternalIdentifier) object);

        } else if (object instanceof ObjectRef) {
            coreDao.saveObjectRef((ObjectRef) object);

        } else if (object instanceof RegistryObject) {
            coreDao.saveRegistryObject((RegistryObject) object);
        }
    }

    /**
     * Unmashall xml documents to Java beans using Jibx
     *
     * @param inputStream InputStream of xml file to unmarshall
     * @return Idnetifiable object unmarshalled
     * @throws GeonetworkServiceException
     * @throws java.io.IOException
     */
    private Identifiable unmarshal(InputStream inputStream) throws GeonetworkServiceException, IOException {
        try {
            log.debug("ResourceMetadataInsertionService unmarshal start");

            // create JiBX unmarshal context
            IBindingFactory bfact = BindingDirectory.getFactory(RegistryObjectList.class);
            IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

            // unmarshal to RegistryObjectList
            Identifiable unMarshallingResult = (Identifiable) unMarshallingContext.unmarshalDocument(inputStream,
                    "UTF-8");
            log.debug("ResourceMetadataInsertionService unmarshal end");
            return unMarshallingResult;
        } catch (JiBXException x) {
            throw new GeonetworkServiceException(x);
        }
    }

    public String getResourceMetadataPath() {
        return resourceMetadataPath;
    }

    public void setResourceMetadataPath(String resourceMetadataPath) {
        this.resourceMetadataPath = resourceMetadataPath;
    }

    public void setCoreDao(CoreDao coreDao) {
        this.coreDao = coreDao;
    }
}
