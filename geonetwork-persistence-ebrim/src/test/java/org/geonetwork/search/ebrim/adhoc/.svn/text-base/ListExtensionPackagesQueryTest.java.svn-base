package org.geonetwork.search.ebrim.adhoc;

import org.junit.Test;
import org.geonetwork.domain.ebrim.test.utilities.core.RegistryPackageFactory;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryPackage;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.dao.ebrim.informationmodel.CoreDao;
import org.geonetwork.dao.ebrim.AbstractDaoTest;

import java.util.List;

/**
 * Tests for ListExtensionPackagesQuery
 *
 * @author Jose
 */
public class ListExtensionPackagesQueryTest extends AbstractDaoTest {
    CoreDao coreDao;
    ListExtensionPackagesQuery listExtensionPackagesQuery;

    public void setCoreDao(CoreDao coreDao) {
        this.coreDao = coreDao;
    }
    
    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();

        listExtensionPackagesQuery = new ListExtensionPackagesQuery();
        listExtensionPackagesQuery.setCoreDao(this.coreDao);
    }

    @Test
    public void testQuery() {
        try {
            // Test empty results
            List<? extends RegistryObject> retrievedRegistryPackages = listExtensionPackagesQuery.query(null);
            assertEquals(0, retrievedRegistryPackages.size());

            // Test non empty results
            RegistryPackage regPackage = RegistryPackageFactory.create();
            coreDao.saveRegistryPackage(regPackage);

            retrievedRegistryPackages = listExtensionPackagesQuery.query(null);
            assertEquals(1, retrievedRegistryPackages.size());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
