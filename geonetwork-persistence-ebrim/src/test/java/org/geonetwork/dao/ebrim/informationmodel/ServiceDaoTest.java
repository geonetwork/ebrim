package org.geonetwork.dao.ebrim.informationmodel;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

import org.geonetwork.dao.ebrim.AbstractDaoTest;
import org.geonetwork.dao.ebrim.provenance.DaoTestDelegate;
import org.geonetwork.domain.ebrim.informationmodel.service.Service;
import org.geonetwork.domain.ebrim.informationmodel.service.ServiceBinding;
import org.geonetwork.domain.ebrim.informationmodel.service.SpecificationLink;
import org.geonetwork.domain.ebrim.test.utilities.service.ServiceBindingFactory;
import org.geonetwork.domain.ebrim.test.utilities.service.ServiceFactory;

public class ServiceDaoTest extends AbstractDaoTest {

    ServiceDao serviceDao;

    public void setServiceDao(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

    /**
     * Service
     */
    public void testSaveService() {
        clean();
        new DaoTestDelegate(serviceDao).testSave(Service.class);
    }

    public void testMergeService1() {
        clean();
        Service service = ServiceFactory.create();
        ServiceBinding serviceBinding = ServiceBindingFactory.create();
        Set<ServiceBinding> serviceBindings = new HashSet<ServiceBinding>();
        serviceBindings.add(serviceBinding);
        service.setServiceBindings(serviceBindings);
        assertEquals(0, serviceDao.loadAllService().size());
        serviceDao.saveService(service);
        assertEquals(1, serviceDao.loadAllService().size());
        serviceBinding.getAccessURI().setValue("check");
        serviceDao.mergeService(service);
        Service serviceFound = serviceDao.findServiceById(service.getHibernateId());
        ServiceBinding serviceBindingFound = serviceFound.getServiceBindings().iterator().next();
        assertEquals("check", serviceBindingFound.getAccessURI().getValue());
    }

    public void testDeleteService() {
        clean();
        new DaoTestDelegate(serviceDao).testDelete(Service.class);
    }

    public void testfindServiceById() {
        clean();
        new DaoTestDelegate(serviceDao).testfindById(Service.class);
    }

    /**
     * ServiceBinding
     */
    public void testSaveServiceBinding() {
        clean();
        new DaoTestDelegate(serviceDao).testSave(ServiceBinding.class);
    }

    public void testMergeServiceBinding1() {
        clean();
        new DaoTestDelegate(serviceDao).testMerge(ServiceBinding.class, "accessURI");
    }

    public void testMergeServiceBinding2() {
        clean();
        new DaoTestDelegate(serviceDao).testMerge(ServiceBinding.class, "service");
    }

    public void testMergeServiceBinding3() {
        clean();
        new DaoTestDelegate(serviceDao).testMerge(ServiceBinding.class, "targetBinding");
    }

    public void testDeleteServiceBinding() {
        clean();
        new DaoTestDelegate(serviceDao).testDelete(ServiceBinding.class);
    }

    public void testfindServiceBindingById() {
        clean();
        new DaoTestDelegate(serviceDao).testfindById(ServiceBinding.class);
    }

    /**
     * SpecificationLink
     */
    public void testSaveSpecificationLink() {
        clean();
        new DaoTestDelegate(serviceDao).testSave(SpecificationLink.class);
    }

    public void testMergeSpecificationLink1() {
        clean();
        new DaoTestDelegate(serviceDao).testMerge(SpecificationLink.class, "serviceBinding");
    }

    public void testMergeSpecificationLink2() {
        clean();
        new DaoTestDelegate(serviceDao).testMerge(SpecificationLink.class, "specificationObject");
    }

    public void testDeleteSpecificationLink() {
        clean();
        new DaoTestDelegate(serviceDao).testDelete(SpecificationLink.class);
    }

    public void testfindSpecificationLinkById() {
        clean();
        new DaoTestDelegate(serviceDao).testfindById(SpecificationLink.class);
    }

    public void clean() {
        List<Service> trash7 = serviceDao.loadAllService();
        for (Service leftOver : trash7) {
            serviceDao.deleteService(leftOver);
        }

        List<ServiceBinding> trash8 = serviceDao.loadAllServiceBinding();
        for (ServiceBinding leftOver : trash8) {
            serviceDao.deleteServiceBinding(leftOver);
        }

        List<SpecificationLink> trash10 = serviceDao.loadAllSpecificationLink();
        for (SpecificationLink leftOver : trash10) {
            serviceDao.deleteSpecificationLink(leftOver);
        }
    }
}
