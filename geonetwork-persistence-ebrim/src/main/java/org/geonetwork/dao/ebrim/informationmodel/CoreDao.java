package org.geonetwork.dao.ebrim.informationmodel;

import java.util.ArrayList;
import java.util.List;

import org.geonetwork.domain.ebrim.informationmodel.core.ExternalIdentifier;
import org.geonetwork.domain.ebrim.informationmodel.core.ExternalLink;
import org.geonetwork.domain.ebrim.informationmodel.core.ExtrinsicObject;
import org.geonetwork.domain.ebrim.informationmodel.core.ObjectRef;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryPackage;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject.WrsExtrinsicObject;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 * Dao for ExternalIdentifier ExternalLink ExtrinsicObject Identifiable ObjectRef RegistryObject
 * RegistryPackage Slot
 * <p/>
 * VersionInfo is not an entity and therefore not directly implemented on Dao level.
 *
 * @author Erik van Ingen
 */
@Transactional
public class CoreDao extends HibernateDaoSupport {

    /**
     * ExternalIdentifier
     */
    public void saveExternalIdentifier(ExternalIdentifier externalIdentifier) {
        this.getHibernateTemplate().save(externalIdentifier);
    }

    public void mergeExternalIdentifier(ExternalIdentifier externalIdentifier) {
        this.getHibernateTemplate().merge(externalIdentifier);
    }

    public void deleteExternalIdentifier(ExternalIdentifier externalIdentifier) {
        this.getHibernateTemplate().delete(externalIdentifier);
    }

    @SuppressWarnings("unchecked")
    public List<ExternalIdentifier> loadAllExternalIdentifier() {
        return this.getHibernateTemplate().loadAll(ExternalIdentifier.class);
    }

    public ExternalIdentifier findExternalIdentifierById(long id) {
        return (ExternalIdentifier) this.getHibernateTemplate().load(ExternalIdentifier.class, id);
    }

    /**
     * ExternalLink
     */
    public void saveExternalLink(ExternalLink externalLink) {
        this.getHibernateTemplate().save(externalLink);
    }

    public void mergeExternalLink(ExternalLink externalLink) {
        this.getHibernateTemplate().merge(externalLink);
    }

    public void deleteExternalLink(ExternalLink externalLink) {
        this.getHibernateTemplate().delete(externalLink);
    }

    @SuppressWarnings("unchecked")
    public List<ExternalLink> loadAllExternalLink() {
        return this.getHibernateTemplate().loadAll(ExternalLink.class);
    }

    public ExternalLink findExternalLinkById(long id) {
        return (ExternalLink) this.getHibernateTemplate().load(ExternalLink.class, id);
    }

    /**
     * ExtrinsicObject
     */
    public void saveExtrinsicObject(ExtrinsicObject extrinsicObject) {
        this.getHibernateTemplate().save(extrinsicObject);
    }

    public void mergeExtrinsicObject(ExtrinsicObject extrinsicObject) {
        this.getHibernateTemplate().merge(extrinsicObject);
    }

    public void deleteExtrinsicObject(ExtrinsicObject extrinsicObject) {
        this.getHibernateTemplate().delete(extrinsicObject);
    }

    @SuppressWarnings("unchecked")
    public List<ExtrinsicObject> loadAllExtrinsicObject() {
        return this.getHibernateTemplate().loadAll(ExtrinsicObject.class);
    }

    public ExtrinsicObject findExtrinsicObjectById(long id) {
        return (ExtrinsicObject) this.getHibernateTemplate().load(ExtrinsicObject.class, id);
    }


   /**
    * WrsExtrinsicObject
    */
    public void saveWrsExtrinsicObject(WrsExtrinsicObject extrinsicObject) {
        this.getHibernateTemplate().save(extrinsicObject);
    }

    public void mergeWrsExtrinsicObject(WrsExtrinsicObject extrinsicObject) {
        this.getHibernateTemplate().merge(extrinsicObject);
    }

    public void deleteWrsExtrinsicObject(WrsExtrinsicObject extrinsicObject) {
        this.getHibernateTemplate().delete(extrinsicObject);
    }

    @SuppressWarnings("unchecked")
    public List<WrsExtrinsicObject> loadAllWrsExtrinsicObject() {
        return this.getHibernateTemplate().loadAll(WrsExtrinsicObject.class);
    }

    public WrsExtrinsicObject findWrsExtrinsicObjectById(long id) {
        return (WrsExtrinsicObject) this.getHibernateTemplate().load(WrsExtrinsicObject.class, id);
    }

    /**
     * ObjectRef
     */
    public void saveObjectRef(ObjectRef objectRef) {
        this.getHibernateTemplate().save(objectRef);
    }

    public void mergeObjectRef(ObjectRef objectRef) {
        this.getHibernateTemplate().merge(objectRef);
    }

    public void deleteObjectRef(ObjectRef objectRef) {
        this.getHibernateTemplate().delete(objectRef);
    }

    @SuppressWarnings("unchecked")
    public List<ObjectRef> loadAllObjectRef() {
        return this.getHibernateTemplate().loadAll(ObjectRef.class);
    }

    public ObjectRef findObjectRefById(long id) {
        return (ObjectRef) this.getHibernateTemplate().load(ObjectRef.class, id);
    }

    /**
     * RegistryObject
     */
    public void saveRegistryObject(RegistryObject registryObject) {
        this.getHibernateTemplate().save(registryObject);
    }

    public void mergeRegistryObject(RegistryObject registryObject) {
        this.getHibernateTemplate().merge(registryObject);
    }

    public void deleteRegistryObject(RegistryObject registryObject) {
        this.getHibernateTemplate().delete(registryObject);
    }

    @SuppressWarnings("unchecked")
    public List<RegistryObject> loadAllRegistryObject() {
        return this.getHibernateTemplate().loadAll(RegistryObject.class);
    }

    public RegistryObject findRegistryObjectById(long id) {
        return (RegistryObject) this.getHibernateTemplate().load(RegistryObject.class, id);
    }


    
    
    // TODO this should return an Identifiable
    @SuppressWarnings("unchecked")
    public RegistryObject findRegistryObjectByUrnId(String urnId) {
        List<RegistryObject> registryObjects = this.getHibernateTemplate().find(
                "from org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject reg where reg.id.value = ?",urnId);

        if (!registryObjects.isEmpty())
            return registryObjects.get(0);
        else
            return null;
    }

    @SuppressWarnings("unchecked")
    public List<RegistryObject> findRegistryObjectByExternalIdentifierValue(String registryObjectName) {
        List<ExternalIdentifier> externalIdentifiers = this.getHibernateTemplate().find(
                "from org.geonetwork.domain.ebrim.informationmodel.core.ExternalIdentifier extIdentifier " +
                        " where extIdentifier.value.value = ?", registryObjectName);

        // Get RegistryObject instances associated with ExternalIdentifier
        if (!externalIdentifiers.isEmpty()) {
            List<RegistryObject> registryObjects = new ArrayList<RegistryObject>();

            for (ExternalIdentifier extId : externalIdentifiers) {
                registryObjects.add(findRegistryObjectByUrnId(extId.getRegistryObject().getValue()));
            }

            return registryObjects;
        } else {
            return null;
        }
    }

    /**
     * RegistryPackage
     */
    public void saveRegistryPackage(RegistryPackage registryPackage) {
        try {
            this.getHibernateTemplate().save(registryPackage);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void mergeRegistryPackage(RegistryPackage registryPackage) {
        this.getHibernateTemplate().merge(registryPackage);
    }

    public void deleteRegistryPackage(RegistryPackage registryPackage) {
        this.getHibernateTemplate().delete(registryPackage);
    }

    @SuppressWarnings("unchecked")
    public List<RegistryPackage> loadAllRegistryPackage() {
        return this.getHibernateTemplate().loadAll(RegistryPackage.class);
    }

    public RegistryPackage findRegistryPackageById(long id) {
        return (RegistryPackage) this.getHibernateTemplate().load(RegistryPackage.class, id);
    }

    /**
     * Slot
     */
    public void saveSlot(Slot slot) {
        this.getHibernateTemplate().save(slot);
    }

    public void mergeSlot(Slot slot) {
        this.getHibernateTemplate().merge(slot);
    }

    public void deleteSlot(Slot slot) {
        this.getHibernateTemplate().delete(slot);
    }

    @SuppressWarnings("unchecked")
    public List<Slot> loadAllSlot() {
        return this.getHibernateTemplate().loadAll(Slot.class);
    }

    public Slot findSlotById(long id) {
        return (Slot) this.getHibernateTemplate().load(Slot.class, id);
    }

    /**
     * Returns a list of RegistryObjects that have slots with specified name and contains specified value
     *
     * @param name          Slot name
     * @param value         Slot value
     * @return List of slots                 
     */
    @SuppressWarnings("unchecked")
	public List<RegistryObject> findRegistryObjectBySlotNameAndValue(String name, String value) {
        List<RegistryObject> registryObjects = new ArrayList<RegistryObject>();

        List<Object[]> results = (List<Object[]>) this.getHibernateTemplate().find(
                         "from org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject reg " +
                         "join reg.slots s " +
                         "join s.valueList.values v " +
                         "where s.name.value = ? and v.value =?", new Object[] {name, value});

        if (!results.isEmpty()) {
            for(Object[] o:results) {
                for(int i = 0; i < o.length; i++) {
                    if (o[i] instanceof RegistryObject) registryObjects.add((RegistryObject) o[i]);
                }

            }
        }

        return registryObjects;
    }

	public void flush() {
		this.getHibernateTemplate().flush();
	}
}