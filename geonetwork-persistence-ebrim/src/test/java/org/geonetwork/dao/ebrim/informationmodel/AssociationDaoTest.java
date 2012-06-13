package org.geonetwork.dao.ebrim.informationmodel;

import java.util.List;

import org.geonetwork.dao.ebrim.AbstractDaoTest;
import org.geonetwork.dao.ebrim.provenance.DaoTestDelegate;
import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.domain.ebrim.informationmodel.classification.Classification;
import org.geonetwork.domain.ebrim.informationmodel.core.ExternalIdentifier;
import org.geonetwork.domain.ebrim.informationmodel.core.ExternalLink;
import org.geonetwork.domain.ebrim.informationmodel.core.ExtrinsicObject;
import org.geonetwork.domain.ebrim.informationmodel.core.ObjectRef;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;

public class AssociationDaoTest extends AbstractDaoTest {
    AssociationDao associationDao;
    CoreDao coreDao;

    public void setAssociationDao(AssociationDao associationDao) {
        this.associationDao = associationDao;
    }

    public void setCoreDao(CoreDao coreDao) {
        this.coreDao = coreDao;
    }

    /**
     * ExternalIdentifier
     */
    public void testSaveExternalIdentifier() {
        clean();
        new DaoTestDelegate(associationDao).testSaveExpectsGreater(Association.class);
    }

    public void testMergeAssociation1() {
        clean();
        new DaoTestDelegate(associationDao).testMergeExpectsGreater(Association.class, "associationType");
    }

    public void testMergeAssociation2() {
        clean();
        new DaoTestDelegate(associationDao).testMergeExpectsGreater(Association.class, "sourceObject");
    }

    public void testMergeAssociation3() {
        clean();
        new DaoTestDelegate(associationDao).testMergeExpectsGreater(Association.class, "targetObject");
    }

    public void testDeleteAssociation() {

        //	new DaoTestDelegate(associationDao).testDeleteExpectsGreater(Association.class);

        // TODO the delete of the association does not delete the target objects
    }

    public void testfindAssociationById() {
        clean();
        new DaoTestDelegate(associationDao).testfindByIdExpectsGreater(Association.class);
    }


    public void clean() {

        List<RegistryObject> trash5 = coreDao.loadAllRegistryObject();
        for (RegistryObject leftOver : trash5) {
            try {
                RegistryObject leftOverAux = coreDao.findRegistryObjectById(leftOver.getHibernateId());
                if (leftOverAux != null)
                    coreDao.deleteRegistryObject(leftOverAux);
            } catch (HibernateObjectRetrievalFailureException e) {
                // Ignore exception > Object already deleted if has a relationship with another object
                // deleted before
            }
        }
        
        List<Association> trashAssociation = associationDao.loadAllAssociation();
        for (Association leftOver : trashAssociation) {
            associationDao.deleteAssociation(leftOver);
        }

        List<ExternalIdentifier> trash = coreDao.loadAllExternalIdentifier();
        for (ExternalIdentifier leftOver : trash) {
            coreDao.deleteExternalIdentifier(leftOver);
        }
        List<ExternalLink> trash2 = coreDao.loadAllExternalLink();
        for (ExternalLink leftOver : trash2) {
            coreDao.deleteExternalLink(leftOver);
        }
        List<ExtrinsicObject> trash3 = coreDao.loadAllExtrinsicObject();
        for (ExtrinsicObject leftOver : trash3) {
            coreDao.deleteExtrinsicObject(leftOver);
        }
        List<ObjectRef> trash4 = coreDao.loadAllObjectRef();
        for (ObjectRef leftOver : trash4) {
            coreDao.deleteObjectRef(leftOver);
        }

        List<Slot> trash6 = coreDao.loadAllSlot();
        for (Slot leftOver : trash6) {
            coreDao.deleteSlot(leftOver);
        }

    }
}