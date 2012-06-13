package org.geonetwork.dao.ebrim;

import org.geonetwork.dao.ebrim.informationmodel.AssociationDao;
import org.geonetwork.dao.ebrim.informationmodel.ClassificationDao;
import org.geonetwork.dao.ebrim.informationmodel.CooperatingRegistriesDao;
import org.geonetwork.dao.ebrim.informationmodel.CoreDao;
import org.geonetwork.dao.ebrim.informationmodel.EventDao;
import org.geonetwork.dao.ebrim.informationmodel.ProvenanceDao;
import org.geonetwork.dao.ebrim.informationmodel.ServiceDao;

public class TrashDetector {

	ProvenanceDao provenanceDao;
	CoreDao coreDao;
	AssociationDao associationDao;
	ClassificationDao classificationDao;
	CooperatingRegistriesDao cooperatingRegistriesDao;
	EventDao eventDao;
	ServiceDao serviceDao;

	public void runReport() {
		runReportClassificationDao();
		runReportAssociationDao();
		runReportClassificationDao();
		runReportCooperatingRegistriesDao();
		runReportCoreDao();
		runReportProvenanceDao();
		runReportServiceDao();
	}

	void runReportProvenanceDao() {
		System.out.println("loadAllEmailAddress = " + provenanceDao.loadAllEmailAddress().size());
		System.out.println("loadAllOrganization = " + provenanceDao.loadAllOrganization().size());
		System.out.println("loadAllOrganization = " + provenanceDao.loadAllOrganization().size());
		System.out.println("loadAllPerson = " + provenanceDao.loadAllPerson().size());
		System.out.println("loadAllPostalAddress = " + provenanceDao.loadAllPostalAddress().size());
		System.out.println("loadAllTelephoneNumber = " + provenanceDao.loadAllTelephoneNumber().size());
		System.out.println("loadAllUser = " + provenanceDao.loadAllUser().size());
	}

	void runReportCoreDao() {
		System.out.println("loadAllExternalIdentifier = " + coreDao.loadAllExternalIdentifier().size());
		System.out.println("loadAllExternalLink = " + coreDao.loadAllExternalLink().size());
		System.out.println("loadAllExtrinsicObject = " + coreDao.loadAllExtrinsicObject().size());
		System.out.println("loadAllObjectRef = " + coreDao.loadAllObjectRef().size());
		System.out.println("loadAllRegistryObject = " + coreDao.loadAllRegistryObject().size());
		System.out.println("loadAllRegistryPackage = " + coreDao.loadAllRegistryPackage().size());
		System.out.println("loadAllSlot = " + coreDao.loadAllSlot().size());
	}

	void runReportClassificationDao() {
		System.out.println("loadAllClassification = " + classificationDao.loadAllClassification().size());
		System.out.println("loadAllClassificationNode = " + classificationDao.loadAllClassificationNode().size());
		System.out.println("loadAllClassificationScheme = " + classificationDao.loadAllClassificationScheme().size());
	}

	void runReportCooperatingRegistriesDao() {
		System.out.println("loadAllFederation = " + cooperatingRegistriesDao.loadAllFederation().size());
		System.out.println("loadAllRegistry = " + cooperatingRegistriesDao.loadAllRegistry().size());
	}

	void runReportServiceDao() {
		System.out.println("loadAllService = " + serviceDao.loadAllService().size());
		System.out.println("loadAllServiceBinding = " + serviceDao.loadAllServiceBinding().size());
		System.out.println("loadAllSpecificationLink = " + serviceDao.loadAllSpecificationLink().size());
	}

	void runReportAssociationDao() {
		System.out.println("loadAllAssociation = " + associationDao.loadAllAssociation().size());

	}

	public void setProvenanceDao(ProvenanceDao provenanceDao) {
		this.provenanceDao = provenanceDao;
	}

	public void setCoreDao(CoreDao coreDao) {
		this.coreDao = coreDao;
	}

	public void setAssociationDao(AssociationDao associationDao) {
		this.associationDao = associationDao;
	}

	public void setClassificationDao(ClassificationDao classificationDao) {
		this.classificationDao = classificationDao;
	}

	public void setCooperatingRegistriesDao(CooperatingRegistriesDao cooperatingRegistriesDao) {
		this.cooperatingRegistriesDao = cooperatingRegistriesDao;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	public void setServiceDao(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}

}
