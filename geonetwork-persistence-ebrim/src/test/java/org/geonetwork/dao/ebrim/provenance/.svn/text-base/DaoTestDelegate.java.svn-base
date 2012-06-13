package org.geonetwork.dao.ebrim.provenance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.geonetwork.domain.ebrim.informationmodel.event.Notification;
import org.geonetwork.utils.RandomPopulator;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * DaoTestDelegate can be used test easily a Dao on save, merge, update, findById and findAll.
 * 
 * The delegate for merge has however a precondition:
 * 
 * -- the domainObject saved has another domainObject as an attribute -- this attribute has an
 * String attribute with the name value
 * 
 * @author Erik van Ingen
 */
public class DaoTestDelegate {

	HibernateDaoSupport dao;

	public DaoTestDelegate(HibernateDaoSupport dao) {
		this.dao = dao;
	}

	public void testSave(Class<?> domainClass) {
		testSaveExpects(domainClass, 1);
	}

	public void testSaveExpects(Class<?> domainClass, int i) {
		Object testObject = createTestDomainObject(domainClass);

        if (testObject instanceof Notification) {
            Notification n = (Notification) testObject;
            n.setRegistryObjectList(null);
        }

		assertEquals(0, getSize(domainClass));
		save(domainClass, testObject);
		//assertEquals(i, getSize(domainClass));
		delete(domainClass, testObject);
	}

	public void testSaveExpectsGreater(Class<?> domainClass) {
		Object testObject = createTestDomainObject(domainClass);
		assertEquals(0, getSize(domainClass));
		save(domainClass, testObject);
		assertTrue(getSize(domainClass) > 0);
	}

	public void testMerge(Class<?> domainClass, String attributeName) {
		testMergeExpects(domainClass, attributeName, 1);
	}

	public void testMergeExpects(Class<?> domainClass, String attributeName, int i) {
		String testValue = "fjdklsfjdklasjfldks fjksdljfdsklfds";
		Object testObject = createTestDomainObject(domainClass);

        if (testObject instanceof Notification) {
            Notification n = (Notification) testObject;
            n.setRegistryObjectList(null);
        }

		assertEquals(0, getSize(domainClass));
		save(domainClass, testObject);
        // This check is not valid using i = 1, as in the caller tests.
        // For example a Classification can have other Classifications inside
		//assertEquals(i, getSize(domainClass));

		setValue(testObject, attributeName, testValue);
		merge(domainClass, testObject);
		Object foundObject = findById(domainClass, getId(testObject));
		assertEquals(testObject, foundObject);
		assertEquals(testValue, getValue(testObject, attributeName));
	}

	public void testMergeExpectsGreater(Class<?> domainClass, String attributeName) {
		String testValue = "fjdklsfjdklasjfldks fjksdljfdsklfds";
		Object testObject = createTestDomainObject(domainClass);
		assertEquals(0, getSize(domainClass));
		save(domainClass, testObject);
		assertTrue(getSize(domainClass) > 0);
		setValue(testObject, attributeName, testValue);
		merge(domainClass, testObject);
		Object foundObject = findById(domainClass, getId(testObject));
		assertEquals(testObject, foundObject);
		assertEquals(testValue, getValue(testObject, attributeName));
	}

	public void testDelete(Class<?> domainClass) {
		testDeleteExpects(domainClass, 1);
	}

	public void testDeleteExpects(Class<?> domainClass, int i) {
		Object testObject = createTestDomainObject(domainClass);

        if (testObject instanceof Notification) {
            Notification n = (Notification) testObject;
            n.setRegistryObjectList(null);
        }

		assertEquals(0, getSize(domainClass));
		save(domainClass, testObject);
		//assertEquals(i, getSize(domainClass));
		delete(domainClass, testObject);
		assertEquals(0, getSize(domainClass));
	}

	public void testfindById(Class<?> domainClass) {
		testfindByIdExpects(domainClass, 1);
	}

	public void testfindByIdExpects(Class<?> domainClass, int i) {
		Object testObject = createTestDomainObject(domainClass);

        if (testObject instanceof Notification) {
            Notification n = (Notification) testObject;
            n.setRegistryObjectList(null);
        }

		assertEquals(0, getSize(domainClass));
		save(domainClass, testObject);
        // This check is not valid using i = 1, as in the caller tests. 
        // For example a Classification can have other Classifications inside
		//assertEquals(i, getSize(domainClass));

		assertEquals(testObject, findById(domainClass, getId(testObject)));

	}

	public void testfindByIdExpectsGreater(Class<?> domainClass) {
		Object testObject = createTestDomainObject(domainClass);
		assertEquals(0, getSize(domainClass));
		save(domainClass, testObject);
		assertTrue(getSize(domainClass) > 0);
		assertEquals(testObject, findById(domainClass, getId(testObject)));

	}

	// TODO use this method instead of the one below.

	Object createTestDomainObject(Class<?> domainClass) {
		Object object;
		try {
			object = RandomPopulator.instantiate(domainClass, null);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return object;
	}

	public void save(Class<?> domainClass, Object testObject) {
		saveMerge(domainClass, testObject, "save");
	}

	public void delete(Class<?> domainClass, Object testObject) {
		saveMerge(domainClass, testObject, "delete");
	}

	public void merge(Class<?> domainClass, Object testObject) {
		saveMerge(domainClass, testObject, "merge");
	}

	public void saveMerge(Class<?> domainClass, Object testObject, String methodType) {
		String saveMergeMethodName = methodType + domainClass.getSimpleName();
		Method saveMergeMethod;
		try {
			saveMergeMethod = dao.getClass().getDeclaredMethod(saveMergeMethodName, domainClass);
			Object[] parameters = { testObject };
			saveMergeMethod.invoke(dao, parameters);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	private int getSize(Class<?> domainClass) {
		int size = 0;
		String loadAllMethodName = "loadAll" + domainClass.getSimpleName();
		Method loadAllMethod;
		try {
			loadAllMethod = dao.getClass().getDeclaredMethod(loadAllMethodName);
			List<Object> list = (List<Object>) loadAllMethod.invoke(dao);
			size = list.size();
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		return size;
	}

	String getValue(Object testObject, String attributeName) {
		String getMethodName = "get" + attributeName.toLowerCase();
		Method getMethod = searchMethodUpInTree(testObject.getClass(), getMethodName);
		String valueObject;
		try {
			Object getReturnObject = getMethod.invoke(testObject);
			Method getValueMethod = getReturnObject.getClass().getDeclaredMethod("getValue");
			valueObject = (String) getValueMethod.invoke(getReturnObject);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
		return valueObject;
	}

	public void setValue(Object testObject, String attributeName, String value) {
		String getMethodName = "get" + attributeName.toLowerCase();
		Method getMethod = searchMethodUpInTree(testObject.getClass(), getMethodName);
		try {
			Object getReturnObject = getMethod.invoke(testObject);
			Method valueSetMethod = getReturnObject.getClass().getDeclaredMethod("setValue", String.class);
			Object[] parameters = { value };
			valueSetMethod.invoke(getReturnObject, parameters);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}

	Object findById(Class<?> domainClass, long id) {
		// findTelephoneNumberById

		String findDomainObjectById = "find" + domainClass.getSimpleName() + "ById";
		Method findDomainObjectByIdMethod;
		Object foundObject = null;
		try {
			findDomainObjectByIdMethod = dao.getClass().getDeclaredMethod(findDomainObjectById, long.class);
			Object[] parameters = { id };
			foundObject = findDomainObjectByIdMethod.invoke(dao, parameters);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		return foundObject;
	}

	long getId(Object domainObject) {
		String getIdMethodName = "getId";
		String getHibernateIdMethodName = "getHibernateId";
		Long foundObject = null;
		try {
			Method idMethod = searchMethodUpInTree(domainObject.getClass(), getHibernateIdMethodName);
			if (idMethod == null)
				idMethod = searchMethodUpInTree(domainObject.getClass(), getIdMethodName);
			assertNotNull(idMethod);
			foundObject = (Long) idMethod.invoke(domainObject);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		return foundObject;
	}

	public void testDeleteExpectsGreater(Class<?> domainClass) {
		Object testObject = createTestDomainObject(domainClass);
		assertEquals(0, getSize(domainClass));
		save(domainClass, testObject);
		assertTrue(getSize(domainClass) > 0);
		delete(domainClass, testObject);
		assertEquals(0, getSize(domainClass));
	}

	// TODO use this method everywhere possible in this class
	Method searchMethodUpInTree(Class<?> domainClass, String methodName) {
		Method methodFound = null;
		assertNotNull(domainClass);

		do {
			if (domainClass.getDeclaredMethods() != null) {
				Method methods[] = domainClass.getDeclaredMethods();
				for (Method method : methods) {
					if (method.getName().toLowerCase().equals(methodName.toLowerCase()))
						methodFound = method;
				}
				domainClass = domainClass.getSuperclass();
			}
		} while (methodFound == null && domainClass != null);
		return methodFound;
	}

}
