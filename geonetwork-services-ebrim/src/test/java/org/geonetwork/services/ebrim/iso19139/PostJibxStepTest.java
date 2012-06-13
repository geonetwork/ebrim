package org.geonetwork.services.ebrim.iso19139;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

import junit.framework.TestCase;

import org.geonetwork.domain.ebrim.exception.GeoNetworkException;
import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObjectList;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;

public class PostJibxStepTest extends TestCase {

	public void testEnrichAssociationRelations1() throws GeoNetworkException {
		String idSourceString = "idSource";
		String idTargetString = "idTarget";
		String idAssociationString = "idAssociationString";

		RegistryObject source = new RegistryObject();
		RegistryObject target = new RegistryObject();
		URN idSource = new URN(idSourceString);
		URN idTarget = new URN(idTargetString);
		URN idAssociation = new URN(idAssociationString);

		Association a1 = new Association();
		a1.setSourceObject(new URI(idSourceString));
		a1.setTargetObject(new URI(idTargetString));

		source.setId(idSource);
		target.setId(idTarget);
		a1.setId(idAssociation);

		PostJibxStep postJibxStep = new PostJibxStep();
		RegistryObjectList registryObjectList = new RegistryObjectList();

		Set<RegistryObject> registryObjects = new HashSet<RegistryObject>();
		registryObjects.add(source);
		registryObjects.add(target);
		registryObjects.add(a1);
		registryObjectList.setRegistryObjects(registryObjects);
		assertEquals(registryObjectList.size(), 3);
		registryObjectList = postJibxStep.enrichAssociationRelations(registryObjectList);
		assertNotNull(registryObjectList);
		assertEquals(registryObjectList.size(), 2);
		RegistryObject sourceFound = null;
		RegistryObject targetFound = null;
		Iterator it = registryObjectList.iterator();

        while (it.hasNext()) {
            RegistryObject reFound = (RegistryObject) it.next();
           if ((reFound.getId() != null) && (reFound.getId().equals(idTarget))) {
                targetFound = reFound;
            } else {
                sourceFound = reFound;
            }
        }

        assertEquals(source, sourceFound);
		assertEquals(target, targetFound);
	}

	/**
	 * check for null value proof with only one RegistryObject
	 * 
	 * @throws GeoNetworkException
	 */
	public void testEnrichAssociationRelations2() throws GeoNetworkException {
		RegistryObject source = new RegistryObject();

		PostJibxStep postJibxStep = new PostJibxStep();
		RegistryObjectList registryObjectList = new RegistryObjectList();

		Set<RegistryObject> registryObjects = new HashSet<RegistryObject>();
		registryObjects.add(source);
		registryObjectList.setRegistryObjects(registryObjects);
		assertEquals(registryObjectList.size(), 1);
		registryObjectList = postJibxStep.enrichAssociationRelations(registryObjectList);
		assertNotNull(registryObjectList);
		assertEquals(registryObjectList.size(), 1);
		RegistryObject sourceFound = (RegistryObject) registryObjectList.get(0);
		assertEquals(source, sourceFound);
	}

	/**
	 * check for null value proof with 2 RegistryObjects and one Association. The Association has
	 * only a sourceObject defined
	 * 
	 * @throws GeoNetworkException
	 */
	public void testEnrichAssociationRelations3() throws GeoNetworkException {
		String idSourceString = "idSource";
		String idAssociationString = "idAssociationString";

		RegistryObject source = new RegistryObject();
		RegistryObject target = new RegistryObject();
		URN idSource = new URN(idSourceString);
		URN idAssociation = new URN(idAssociationString);

		Association a1 = new Association();
		a1.setSourceObject(new URI(idSourceString));

		source.setId(idSource);
		a1.setId(idAssociation);

		PostJibxStep postJibxStep = new PostJibxStep();
		RegistryObjectList registryObjectList = new RegistryObjectList();

		Set<RegistryObject> registryObjects = new HashSet<RegistryObject>();
		registryObjects.add(source);
		registryObjects.add(target);
		registryObjects.add(a1);
		registryObjectList.setRegistryObjects(registryObjects);
		assertEquals(registryObjectList.size(), 3);
		registryObjectList = postJibxStep.enrichAssociationRelations(registryObjectList);
		assertNotNull(registryObjectList);
		assertEquals(registryObjectList.size(), 2);
		Iterator it = registryObjectList.iterator();
        RegistryObject sourceFound = null;
        RegistryObject targetFound = null;

        while (it.hasNext()) {
            RegistryObject reFound = (RegistryObject) it.next();
            if ((reFound.getId() != null) && (reFound.getId().equals(idSource))) {
                sourceFound = reFound;
            } else {
                targetFound = reFound;
            }
        }
 		assertEquals(source, sourceFound);
		assertEquals(target, targetFound);
	}

	/**
	 * check for null value proof with 2 RegistryObjects and one Association. The Association has
	 * only a target defined
	 * 
	 * @throws GeoNetworkException
	 */
	public void testEnrichAssociationRelations4() throws GeoNetworkException {
		String idTargetString = "idTarget";
		String idAssociationString = "idAssociationString";

		RegistryObject source = new RegistryObject();
		RegistryObject target = new RegistryObject();
		URN idTarget = new URN(idTargetString);
		URN idAssociation = new URN(idAssociationString);

		Association a1 = new Association();
		a1.setTargetObject(new URI(idTargetString));

		target.setId(idTarget);
		a1.setId(idAssociation);

		PostJibxStep postJibxStep = new PostJibxStep();
		RegistryObjectList registryObjectList = new RegistryObjectList();

		Set<RegistryObject> registryObjects = new HashSet<RegistryObject>();
		registryObjects.add(source);
		registryObjects.add(target);
		registryObjects.add(a1);
		registryObjectList.setRegistryObjects(registryObjects);
		assertEquals(registryObjectList.size(), 3);
		registryObjectList = postJibxStep.enrichAssociationRelations(registryObjectList);
		assertNotNull(registryObjectList);
		assertEquals(registryObjectList.size(), 3);
		RegistryObject sourceFound = null;
		RegistryObject targetFound = null;
		Association associationFound = null;

        Iterator it = registryObjectList.iterator();

        while (it.hasNext()) {
            RegistryObject reFound = (RegistryObject) it.next();
            if (reFound instanceof Association) {
                associationFound = (Association) reFound;
            } else {
                if ((reFound.getId() != null) && (reFound.getId().equals(idTarget))) {
                    targetFound = reFound;
                } else {
                    sourceFound = reFound;
                }
            }
        }
        assertEquals(source, sourceFound);
		assertEquals(target, targetFound);
		assertEquals(a1, associationFound);
	}
	
	
	
}
