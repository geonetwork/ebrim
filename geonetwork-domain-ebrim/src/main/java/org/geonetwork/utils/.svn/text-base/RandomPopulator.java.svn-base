//=============================================================================
//===	Copyright (C) 2008 European Space Agency (ESA).
//===
//===	This program is free software; you can redistribute it and/or modify
//===	it under the terms of the GNU General Public License as published by
//===	the Free Software Foundation; either version 2 of the License, or (at
//===	your option) any later version.
//===
//===	This program is distributed in the hope that it will be useful, but
//===	WITHOUT ANY WARRANTY; without even the implied warranty of
//===	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//===	General Public License for more details.
//===
//===	You should have received a copy of the GNU General Public License
//===	along with this program; if not, write to the Free Software
//===	Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
//===
//===	Contact: Jeroen Ticheler - E-mail: geonetwork@osgeo.org

//==============================================================================
package org.geonetwork.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.xsd.Duration;
import org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList;
import org.geonetwork.utils.Reflection.Constructor;

/**
 * Utility to instantiate an object graph and populate it with random values.
 * 
 * Method: instantiate()
 * 
 * The <code>instantiate()</code> method is the entry point of the RandomPopulator; you pass it a
 * class, and <code>null</code> for its second parameter <code>genericParameterType</code>. (if you
 * want to populate a generified collection, then the class must be a Collection class or interface
 * and genericParameterType the Type Variable for the elements to put in it). Then:
 * 
 * case 1: if the class is one of several "supported classes", an object of that class is
 * instantiated and given some random value. Examples of supported classes are String, Integer,
 * Date, most primitives, etc. The object is returned.
 * 
 * case 2: if the class is not one of those supported classes and is not a Collection, an object of
 * that class is instantiated and passed to the <code>populate()</code> method, which returns the
 * object with its members recursively populated, see description below. The populated object is
 * returned by <code>instantiate()</code>. In case the class is abstract, an object of a
 * non-abstract subclass is instantiated, if the abstract class is a "supported abstract class". The
 * only supported abstract class at the time of writing is AbstractValueList in the ebrim domain. In
 * case of non-supported abstract classes, <code>null</code> is returned.
 * 
 * case 3: if the class is a Collection and it has a known generic Type Parameter ('generified
 * collection', e.g. java.util.ArrayList<java.lang.String>) and it is not an interface, an object of
 * the raw type (e.g. java.util.ArrayList) is instantiated. Then a random number of objects is
 * created of the class of the generic Type Parameter; they are populated by the
 * <code>populate()</code> method, and added to the Collection object, which is returned.
 * 
 * case 4: if the class is a generified collection and it is an interface (e.g.
 * java.util.List<java.lang.String>), a common implementation of the interface is used to
 * instantiate the collection object. List is instantiated as an ArrayList, Set is instantiated as a
 * HashSet, and Queue is instantiated as a LinkedList. Otherwise processing proceeds as in case 3.
 * 
 * case 5: if the class is a non-generified Collection and not an interface, processing is as in
 * case 3 except that the collection elements are simply instantiated as Strings.
 * 
 * case 6: if the class is a non-generified Collection interface (e.g. java.util.List), it is
 * handled as in case 4 except that the collection elements are simply instantiated as Strings.
 * 
 * 
 * Method: populate()
 * 
 * This method takes an Object and calls all its setXXX methods to populate the object's members. It
 * examines the type of the parameter to each setXXX method, instantiates an object of that type
 * using the <code>instantiate()</code> method, then invokes the setXXX method to set the
 * instantiated parameter to the object being populated. The populated object is returned.
 * 
 * 
 * LIMITATIONS
 * 
 * - no handling for Map, Enums, arrays, byte and short; - no handling for interfaces other than
 * Collection interfaces; - it would be nice if there was a way to add "supported classes" and
 * "supported abstract classes" as a decoration to this class; - supported classes must have a
 * default constructor; - prone to StackOverFlow if the recursion goes too deep. Depending on the
 * structure of your object graph, try varying the value of MAX_COLLECTION_SIZE, which is the upper
 * bound on the random size for collections in your object graph; - prone to endless recursion if
 * your object graph is like that;
 * 
 * 
 * @author heikki doeleman
 * 
 */
public class RandomPopulator {

	private static final int MAX_COLLECTION_SIZE = 3;
	private static final int MAX_GRAPH_DEPTH = 200;
	private int graphDepth = 0;

	/**
	 * Populates an object. See javadoc at class level.
	 * 
	 * @param o
	 * @return
	 * @throws Exception
	 */
	private Object populate(Object o) throws Exception {
		if (o != null) {
			// examine methods in object o
			for (Method method : o.getClass().getMethods()) {
				// a candidate setter method
				Class<?>[] parameterTypes = method.getParameterTypes();

				// TODO remove the construction with setHibernateId and setId and come up with a
				// more generic solution.
				if (method.getName().startsWith("set")) {
					Type[] genericParameterTypes = method.getGenericParameterTypes();
					boolean methodIsNonHibernateIdSetter = true;

                    boolean methodIsNonRegistryPackageInverse = true;

                    if (method.getName().equals("setRegistryPackageInverse")) {
                        methodIsNonRegistryPackageInverse = false;    
                    }

					if (method.getName().equals("setHibernateId") || method.getName().equals("setId")) {
						methodIsNonHibernateIdSetter = false;
					}
					if (parameterTypes.length > 0 && parameterTypes[0] != long.class) {
						methodIsNonHibernateIdSetter = true;
					}
					if ((methodIsNonHibernateIdSetter) && (methodIsNonRegistryPackageInverse)) {

						// unsupported set method: takes zero or more than one parameter, or is not
						// void
						if (parameterTypes.length != 1 || method.getReturnType() != void.class) {
							// ignore that method
						}
						// setter is OK
						else {
							// the type of the setter's parameter
							Class<?> parameterType = parameterTypes[0];
							// the type variable if the setter's parameter is a generified
							// collection
							Type genericParameterType = genericParameterTypes[0];
							// instantiate the parameter
							Object param = instantiateLocal(parameterType, genericParameterType);
							// set the instantiated parameter to this object using the setter method
							method.invoke(o, param);
						}
					}
				}
			}
		}
		return o;
	}

	/**
	 * Convenience method in order to use the RandomPopulator without having to give a null as a
	 * second parameter.
	 * 
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static Object instantiate(Class<?> clazz) throws Exception {
		return RandomPopulator.instantiate(clazz, null);
	}

	public static Object instantiate(Class<?> clazz, Type genericParameterType) throws Exception {
		RandomPopulator randomPopulator = new RandomPopulator();
		return randomPopulator.instantiateLocal(clazz, genericParameterType);
	}

	/**
	 * Instantiates an object. See javadoc at class level.
	 * 
	 * See also the TODO infinite object graphs: adding 1 without condition is not correct but does
	 * work in most situations.
	 * 
	 * @param clazz
	 * @param genericParameterType
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private Object instantiateLocal(Class<?> clazz, Type genericParameterType) throws Exception {

		graphDepth++; // TODO infinite object graphs: There should be an intelligent condition
		// before doing the ++

		Object o = null;
		// case 1: supported type
		if (supportedTypes.contains(clazz)) {
			o = handleSupportedClass(clazz);
		}
		// not a supported type
		else {
			// System.out.println(clazz);

			// case 2: not a collection
			if (!java.util.Collection.class.isAssignableFrom(clazz)) {
				// abstract
				if (Modifier.isAbstract(clazz.getModifiers())) {
					// supported abstract classes are instantiated as a non-abstract subclass
					if (supportedAbstractTypes.contains(clazz)) {
						if (clazz.getName()
								.equals("org.geonetwork.domain.ebrim.informationmodel.xsd.AbstractValueList")) {
							o = new ValueList();
							o = populate(o);
						}
						System.out.println(clazz);
						if (clazz.getName().equals("org.geonetwork.domain.ebrim.informationmodel.core.Identifiable")) {
							o = instantiateLocal(RegistryObject.class, null);
						}
					}
					// non-supported abstract class: give up
					else {
						o = null;
					}
				}
				// not abstract
				else {
					Reflection.Constructor constructor = Reflection.getConstructor(clazz.getName() + "()");
					o = constructor.newInstance();
					o = populate(o);
				}
			}
			// a collection
			else {
				Collection collection = (Collection) o;
				// generified collection
				if (genericParameterType != null && genericParameterType.toString().endsWith(">")) {
					// determine the class of the elements to go in this collection
					ParameterizedType pt = (ParameterizedType) genericParameterType;
					Type actualTypeArgument = pt.getActualTypeArguments()[0];
					String actualTypeArgumentName = actualTypeArgument.toString().substring(
							actualTypeArgument.toString().indexOf(' ') + 1);
					Class<?> elementClass = Class.forName(actualTypeArgumentName);

					// case 3: generified collection, not an interface
					if (!clazz.isInterface()) {
						// obtain constructor
						Constructor ccc = Reflection.getConstructor(clazz.getName() + "()");
						// instantiate collection
						collection = (Collection) ccc.newInstance();
						int size = getRandomSize();
						for (int i = 0; i < size; i++) {
							Object element = instantiateLocal(elementClass, null);
							collection.add(element);
						}
						o = collection;
						// TODO check if this populate() is necessary
						o = populate(o);
					}
					// case 4: generified collection interface
					else {
						// use some common implementation for each supported Collection interface
						if (clazz == java.util.List.class) {
							collection = new ArrayList();
						}
						if (clazz == java.util.Set.class) {
							collection = new HashSet();
						}
						if (clazz == java.util.Queue.class) {
							collection = new LinkedList();
						}
						if (clazz == java.util.Set.class) {
							collection = new HashSet();
						}
						int size = getRandomSize();
						for (int i = 0; i < size; i++) {
							// if (!Modifier.isAbstract(clazz.getModifiers())) {
							Object element = instantiateLocal(elementClass, null);
							if (element != null)
								collection.add(element);
							// } else
							// System.out.println(clazz);
						}
						o = collection;
						// TODO check if this populate() is necessary
						o = populate(o);
					}
				}
				// non-generified collection
				else {
					// case 5: non-generified collection, not an interface
					if (!clazz.isInterface()) {
						// obtain constructor
						Constructor ccc = Reflection.getConstructor(clazz.getName() + "()");
						// instantiate collection
						collection = (Collection) ccc.newInstance();
						int size = getRandomSize();
						for (int i = 0; i < size; i++) {
							// non-generified Collection: just fill with Strings
							Object collectionElement = instantiateLocal(Class.forName("java.lang.String"), null);
							collection.add(collectionElement);
						}
						o = collection;
					}
					// case 6: non-generified collection interface
					else {
						if (clazz == java.util.List.class) {
							collection = new ArrayList();
						}
						if (clazz == java.util.Set.class) {
							collection = new HashSet();
						}
						if (clazz == java.util.Queue.class) {
							collection = new LinkedList();
						}
						int size = getRandomSize();
						for (int i = 0; i < size; i++) {
							// non-generified Collection: just fill with Strings
							Object collectionElement = instantiateLocal(Class.forName("java.lang.String"), null);
							collection.add(collectionElement);
						}
						o = collection;
					}
				}
			}
		}
		return o;
	}

	private static List<Class<?>> supportedTypes = new ArrayList<Class<?>>();
	private static List<Class<?>> supportedAbstractTypes = new ArrayList<Class<?>>();
	static {
		supportedTypes.add(java.lang.String.class);
		supportedTypes.add(java.lang.Integer.class);
		supportedTypes.add(java.lang.Boolean.class);
		supportedTypes.add(java.lang.Float.class);
		supportedTypes.add(java.lang.Double.class);
		supportedTypes.add(java.lang.Character.class);
		supportedTypes.add(java.lang.Long.class);
		supportedTypes.add(java.lang.Object.class);
		supportedTypes.add(java.util.Date.class);
		supportedTypes.add(org.geonetwork.domain.ebrim.informationmodel.xsd.Duration.class);
		supportedTypes.add(int.class);
		supportedTypes.add(long.class);
		supportedTypes.add(double.class);
		supportedTypes.add(float.class);
		supportedTypes.add(boolean.class);
		supportedTypes.add(char.class);

		supportedAbstractTypes.add(org.geonetwork.domain.ebrim.informationmodel.xsd.AbstractValueList.class);
		supportedAbstractTypes.add(org.geonetwork.domain.ebrim.informationmodel.core.Identifiable.class);
	}

	private Object handleSupportedClass(Class<?> clazz) {
		Object o = null;
		Random r = new Random();
		if (clazz == java.lang.String.class) {
            o = Long.toString(Math.abs(r.nextLong()), 36);
		}
		if (clazz == java.lang.Integer.class) {
			o = new Integer(r.nextInt());
		}
		if (clazz == java.lang.Boolean.class) {
			o = new Boolean(r.nextBoolean());
		}
		if (clazz == java.lang.Float.class) {
			o = new Float(r.nextFloat());
		}
		if (clazz == java.lang.Double.class) {
			o = new Double(r.nextDouble());
		}
		if (clazz == java.lang.Character.class) {
			o = new Character((char) r.nextInt());
		}
		if (clazz == java.lang.Long.class) {
			o = new Long(r.nextLong());
		}
		// in case of Object, let's give it a String
		if (clazz == java.lang.Object.class) {
			o = Long.toString(Math.abs(r.nextLong()), 36);
		}
		if (clazz == java.util.Date.class) {
			o = new Date();
		}
		if (clazz == org.geonetwork.domain.ebrim.informationmodel.xsd.Duration.class) {
			int y = r.nextInt();
			int m = r.nextInt();
			int d = r.nextInt();
			int h = r.nextInt();
			int mm = r.nextInt();
			double s = r.nextDouble();
			o = new Duration(false, y, m, d, h, mm, s);
		}
		if (clazz == int.class) {
			o = r.nextInt();
		}
		if (clazz == long.class) {
			o = r.nextLong();
		}
		if (clazz == double.class) {
			o = r.nextDouble();
		}
		if (clazz == float.class) {
			o = r.nextFloat();
		}
		if (clazz == boolean.class) {
			o = r.nextBoolean();
		}
		if (clazz == char.class) {
			o = (char) r.nextInt();
		}
		return o;
	}

	/**
	 * There can be an issue while generating object grapsh. What to do with a a list of objects who
	 * are also a list of objects? In this case you can generate infinite object graphs. The problem
	 * did not occur because the random size generator was generating at a certain point 0.
	 * 
	 * 
	 * But what if you want the object graphs with lists to have at least always 1 element in the
	 * first order? That's where I started and ended up with having the graphDepth.
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	private int getRandomSize() {
		int size = new Random().nextInt(MAX_COLLECTION_SIZE);
		if (size == 0)
			size = 1;
		if (graphDepth > MAX_GRAPH_DEPTH)
			size = 0;
		return size;
	}

}
