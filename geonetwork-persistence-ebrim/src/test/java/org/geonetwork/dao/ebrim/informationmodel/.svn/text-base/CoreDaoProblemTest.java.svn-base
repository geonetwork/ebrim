package org.geonetwork.dao.ebrim.informationmodel;

import java.util.HashSet;
import java.util.Set;

import org.geonetwork.dao.ebrim.AbstractCommitDaoTest;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LocalizedString;
import org.geonetwork.utils.RandomPopulator;

/**
 * representation of an issue to solve with LazyInitialization
 * 
 * @author Erik van Ingen
 * 
 */
public class CoreDaoProblemTest extends AbstractCommitDaoTest {

	public void testDummy() {
		assertTrue(true);
	}

	/**
	 * This experiment presents a problem which is not solved yet. TODO: solve this problem:
	 * 
	 * org.hibernate.LazyInitializationException: could not initialize proxy - no Session at
	 * org.hibernate.proxy.AbstractLazyInitializer.initialize(AbstractLazyInitializer.java:86) at
	 * org.hibernate.proxy.AbstractLazyInitializer.getImplementation(AbstractLazyInitializer.java:140) at
	 * org.hibernate.proxy.pojo.javassist.JavassistLazyInitializer.invoke(JavassistLazyInitializer.java:190) at
	 * org.geonetwork .domain.ebrim.informationmodel.core.RegistryObject_$$_javassist_20.getDescription(
	 * RegistryObject_$$_javassist_20 .java) at
	 * org.geonetwork.dao.ebrim.informationmodel.CoreDaoProblemTest.testExperiment(CoreDaoProblemTest.java:28) at
	 * sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) at
	 * sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39) at
	 * sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25) at
	 * java.lang.reflect.Method.invoke(Method.java:597) at junit.framework.TestCase.runTest(TestCase.java:168) at
	 * junit.framework.TestCase.runBare(TestCase.java:134) at
	 * org.springframework.test.ConditionalTestCase.runBare(ConditionalTestCase.java:76) at
	 * junit.framework.TestResult$1.protect(TestResult.java:110) at
	 * junit.framework.TestResult.runProtected(TestResult.java:128) at
	 * junit.framework.TestResult.run(TestResult.java:113) at junit.framework.TestCase.run(TestCase.java:124) at
	 * junit.framework.TestSuite.runTest(TestSuite.java:232) at junit.framework.TestSuite.run(TestSuite.java:227) at
	 * org.junit.internal.runners.JUnit38ClassRunner.run(JUnit38ClassRunner.java:81) at
	 * org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:45) at
	 * org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38) at
	 * org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:460) at
	 * org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:673) at
	 * org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:386) at
	 * org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:196)
	 */
	public void _testExperiment() throws Exception {
		RegistryObject ro = (RegistryObject) RandomPopulator.instantiate(RegistryObject.class, null);
		String value = "Erik";
		LocalizedString localizedString = new LocalizedString();
		localizedString.setValue(value);
		Set<LocalizedString> localizedStringSet = new HashSet<LocalizedString>();
		localizedStringSet.add(localizedString);
		InternationalString internationalString = new InternationalString();
		internationalString.setLocalizedStrings(localizedStringSet);
		ro.setDescription(internationalString);
		coreDao.saveRegistryObject(ro);

		RegistryObject roFound = coreDao.findRegistryObjectById(ro.getHibernateId());
		InternationalString descriptionFound = roFound.getDescription();
		Set<LocalizedString> set = descriptionFound.getLocalizedStrings();
		LocalizedString ls = (LocalizedString) descriptionFound.getLocalizedStrings().toArray()[0];
		assertEquals(value, ls.getValue());

		coreDao.deleteRegistryObject(ro);

	}

}
