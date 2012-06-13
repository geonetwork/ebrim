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
package org.geonetwork.utils.visitor;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * Adaptation of the classic ObjectGraphVisitor. This class is identical to ObjectGraphVisitor
 * but with the added behaviour that if the actor class has a method called reset(), it is 
 * invoked. This allows for resetting of stuff that is built up during recursion but needs to
 * be broken down when recursion pops, such as building paths.
 * 
 * First draft of generic way to apply an action to all objects of a specific type in an object graph.
 * 
 * The traversal is done using reflection and the objects that the action is applied to are selected
 * by (runtime) type; this way there's no need to mess around with "Visitable" interfaces or stuff 
 * like that.
 * 
 * Limitations:
 * 
 * - doesn't handle arrays
 * - only traverses object graph by invoking no-args "getXXX" methods
 * - excludes classes in java.lang (a preliminary hack to avoid infinite recursion)
 * - is still susceptible to infinite recursion if your domain structure is like that
 * - the action must be a single-arg void method; thus immutable objects (like String) cannot be operated on
 *   
 * @author heikki doeleman
 *
 */
public class ObjectGraphVisitorPlus {
	/**
	 * Performs an action on all objects of a targeted type (and subclasses thereof) in an object graph.
	 * 
	 * @param objectGraph - the object graph that is traversed
	 * @param target - the type of objects in the graph that the action is performed to
	 * @param action - the method to be invoked on objects of type target
	 * @param actor - the class where the action is defined
	 * @return Modified objectGraph after applying action to all objects of target type
	 * @throws ObjectGraphVisitorException
	 */
	public Object performAction(Object objectGraph, Class<?> target, Method action, Object actor) throws ObjectGraphVisitorException {
		try {
			if(objectGraph == null || objectGraph.getClass() == null) {
				return objectGraph;
			}
			
			// root of objectgraph is of the target type
			if(target.isAssignableFrom(objectGraph.getClass())) {
				action.invoke(actor, objectGraph);
			}
			// perform action on all objects of target type further down in this object graph
			for(Method method : objectGraph.getClass().getMethods()) {
				//log.debug("examining method: " + method.getName());
				if(method.getName().startsWith("get") && method.getParameterTypes().length == 0) {
					Class<?> declaredType = method.getReturnType();
					// getter returns a Collection
					if(java.util.Collection.class.isAssignableFrom(declaredType)) {
						//log.debug("invoking method: " + method.getName());
						Object result =  method.invoke(objectGraph);
						Collection<?> collection = (Collection<?>) result;
						if(collection != null) {
							for(Object next : collection) {
								performAction(next, target, action, actor);
							}
						}
					}
					// getter returns a single object
					// traverse deeper only if the declared return type is not a primitive, and is not 
					// in the java.lang package (String and Class from java.lang get each other, and 
					// cause infinite recursion)
					// TODO better way to detect and avoid infinite recursion
					else if((declaredType.getPackage() == null) ||
							declaredType != void.class &&
							declaredType.getPackage().toString().equals("java.lang")){
						//log.debug("invoking method: " + method.getName());
						Object result =  method.invoke(objectGraph);
						performAction(result, target, action, actor);						
					}
					// TODO handle Arrays as well
				}
			}
			// the reset() method is invoked here, if it exists.
			Method[] methods = actor.getClass().getMethods();
			for(Method m : methods) {
				if(m.getName().equals("reset")) {
					m.invoke(actor);
					break;
				}
			}
			return objectGraph;
		}
		catch(Exception x) {
			x.printStackTrace();
			throw new ObjectGraphVisitorException(x);
		}
	}


    public Object performAction2(Object objectGraph, Class<?> target, Method action, Object actor, Object[] aditionalArgs) throws ObjectGraphVisitorException {
		try {
			if(objectGraph == null || objectGraph.getClass() == null) {
				return objectGraph;
			}
			
			// root of objectgraph is of the target type
			if(target.isAssignableFrom(objectGraph.getClass())) {
                List<Object> objs = new ArrayList<Object>();

                Object[] methodArgs = new Object[aditionalArgs.length + 1];
                System.arraycopy(new Object[] {objectGraph}, 0, methodArgs, 0, 1);
                System.arraycopy(aditionalArgs, 0, methodArgs, 1, aditionalArgs.length);

				action.invoke(actor, methodArgs);
			}
			// perform action on all objects of target type further down in this object graph
			for(Method method : objectGraph.getClass().getMethods()) {
				//log.debug("examining method: " + method.getName());
				if(method.getName().startsWith("get") && method.getParameterTypes().length == 0) {
					Class<?> declaredType = method.getReturnType();
					// getter returns a Collection
					if(java.util.Collection.class.isAssignableFrom(declaredType)) {
						//log.debug("invoking method: " + method.getName());
						Object result =  method.invoke(objectGraph);
						Collection<?> collection = (Collection<?>) result;
						if(collection != null) {
							for(Object next : collection) {
								performAction2(next, target, action, actor, aditionalArgs);
							}
						}
					}
					// getter returns a single object
					// traverse deeper only if the declared return type is not a primitive, and is not
					// in the java.lang package (String and Class from java.lang get each other, and
					// cause infinite recursion)
					// TODO better way to detect and avoid infinite recursion
					else if((declaredType.getPackage() == null) ||
							declaredType != void.class &&
							declaredType.getPackage().toString().equals("java.lang")){
						//log.debug("invoking method: " + method.getName());
						Object result =  method.invoke(objectGraph);
						performAction2(result, target, action, actor, aditionalArgs);
					}
					// TODO handle Arrays as well
				}
			}
			// the reset() method is invoked here, if it exists.
			Method[] methods = actor.getClass().getMethods();
			for(Method m : methods) {
				if(m.getName().equals("reset")) {
					m.invoke(actor);
					break;
				}
			}
			return objectGraph;
		}
		catch(Exception x) {
			x.printStackTrace();
			throw new ObjectGraphVisitorException(x);
		}
	}
}
