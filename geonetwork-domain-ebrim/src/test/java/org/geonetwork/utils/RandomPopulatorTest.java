package org.geonetwork.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.geonetwork.domain.csw202.discovery.GetRecords;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.association.Annotates;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.domain.ebrim.informationmodel.core.ExtrinsicObject;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObjectList;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryPackage;
import org.geonetwork.domain.ebrim.informationmodel.service.SpecificationLink;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.junit.Test;

public class RandomPopulatorTest {

    @Test
    public void testDummy() {
        assertTrue(true);
    }

	@Test
	public void testInstantiate1() throws Exception {
		ExtrinsicObject eo = (ExtrinsicObject) RandomPopulator.instantiate(ExtrinsicObject.class, null);
		// set up JiBX marshalling context
		IBindingFactory bfact = BindingDirectory.getFactory(ExtrinsicObject.class);
		IMarshallingContext marshallingContext = bfact.createMarshallingContext();
		// marshal to console - nice if you're looking
		Writer outConsole = new BufferedWriter(new OutputStreamWriter(System.out));
		marshallingContext.setOutput(outConsole);
		marshallingContext.setIndent(3);
		// marshallingContext.marshalDocument(eo, "UTF-8", null);
	}

	@Test
	public void testInstantiate2() throws Exception {
		Annotates eo = (Annotates) RandomPopulator.instantiate(Annotates.class, null);
		assertNotNull(eo);
		assertNotNull(eo.getAssociationType());
		assertNotNull(eo.getAssociationType().getValue());
		assertNotNull(eo.getAssociationType());
		assertNotNull(eo.getClassifications());
		assertNotNull(eo.getDescription());
	}

	@Test
	public void testInstantiate3() throws Exception {

		for (int i = 0; i < 10; i++) {
			RandomHelperChild randomHelperChild = (RandomHelperChild) RandomPopulator.instantiate(
					RandomHelperChild.class, null);
			assertTrue(randomHelperChild.getRandomHelperAttributeSet().size() > 0);
		}
	}

	@Test
	public void testInstantiate4() throws Exception {

		for (int i = 0; i < 10; i++) {
			SpecificationLink specificationLink = (SpecificationLink) RandomPopulator.instantiate(
					SpecificationLink.class, null);
			assertTrue(specificationLink.getClassifications().size() > 0);
		}
	}

	@Test
	public void testInstantiate5() throws Exception {
		RandomHelperChild randomHelperChild = (RandomHelperChild) RandomPopulator.instantiate(RandomHelperChild.class,
				null);
		assertEquals(0l, randomHelperChild.getHibernateId());
		assertEquals(0l, randomHelperChild.getId());
	}

	@Test
	public void testInstantiate6() throws Exception {
		GetRecords getRecords = (GetRecords) RandomPopulator.instantiate(GetRecords.class, null);
		assertNotNull(getRecords.getDistributedSearch());
	}

	@Test
	public void testInstantiate7() throws Exception {
		RegistryPackage registryPackage = (RegistryPackage) RandomPopulator.instantiate(RegistryPackage.class, null);
		assertNotNull(registryPackage.getRegistryObjectList().toArray()[0]);
	}
	

	@Test
	public void testInstantiate8() throws Exception {
		ClassificationNode classificationNode = (ClassificationNode) RandomPopulator.instantiate(
				ClassificationNode.class, null);
		assertNotNull(classificationNode.getId().getValue());
	}
	
	@Test
	public void testInstantiate9() throws Exception {
		RegistryObjectList registryObjectList = (RegistryObjectList) RandomPopulator.instantiate(
				RegistryObjectList.class, null);
		assertNotNull(registryObjectList.getHibernateId());
	}

	
	

}
