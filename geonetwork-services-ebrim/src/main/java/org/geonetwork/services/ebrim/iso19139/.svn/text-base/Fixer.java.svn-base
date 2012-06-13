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
package org.geonetwork.services.ebrim.iso19139;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.List;

import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.informationmodel.classification.Classification;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.domain.ebrim.informationmodel.core.Identifiable;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject.WrsExtrinsicObject;

/**
 * The result of the XSLT transformation of the incoming ISO 19139 document is incomplete. This class
 * is a utility to fix the resulting object graph.
 * 
 * This class simply defines some methods and advertises their names in an enum; users of this class then
 * pass these methods to an ObjectGraphVisitor, which will invoke the method on each object in the graph
 * that is of the targeted type.
 * 
 * What this utility needs to do is:
 * 
 * - generate IDs for new Identifiable data
 * - fill IDs for Identifiable data in the graph that already exists;
 * - repair Classifications, which should use existing IDs ClassificationNode and ClassificationScheme
 * 
 * @author heikki doeleman
 *
 */
public class Fixer {
	
	
	public enum ACTION {
		fixID("fixID"),
		referID("referID"),
        fixClassificationNodeId("fixClassificationNodeId");

		private final String methodName;
		String getMethodName() {
			return methodName;
		}
		ACTION(String methodName) {
			this.methodName = methodName;
		}
	}
	
	/**
	 * Maps ids generated in the XSLT to UUID ids generated here.
	 */
	private static Map<URN, URN> ids = new HashMap<URN, URN>();

	public static Map<URN, URN> getIds() {
		return ids;
	}

	public static void setIds(Map<URN, URN> ids) {
		Fixer.ids = ids;
	}

	/**
	 * Fixes an Identifiable's id.
	 * @param o
	 */
	public void fixID(Identifiable o) {
		URN idFromXSLT = o.getId();
		URN newId = new URN(UUID.randomUUID().toString());
		o.setId(newId);
		ids.put(idFromXSLT, newId);
	}
	
	public void referID(Identifiable o) {
		
		if(o instanceof Association) {
			Association a = (Association) o;
			
			URN sourceURN = new URN(a.getSourceObject().getValue());
			URN sourceUUID  = ids.get(sourceURN);
			if(sourceUUID == null) throw new RuntimeException("in association " + a.getId() +" sourceUUID is null: " + sourceURN);
			a.setSourceObject(new URI(sourceUUID.getValue()));
			
			// the target of CodeSpace association refers to a pre-existing codespace classification node, not
			// to a newly created object. Ignore target for that case.
			if(! a.getAssociationType().getValue().equals("urn:x-ogc:specification:csw-ebrim-cim:AssociationType:CodeSpace")) { 
				URN targetURN = new URN(a.getTargetObject().getValue());
				URN targetUUID  = ids.get(targetURN);
				if(targetUUID == null) throw new RuntimeException("in association " + a.getId() +" targetUUID is null: " + targetURN);
				a.setTargetObject(new URI(targetUUID.getValue()));
			}
		}
		if(o instanceof Classification) {
			Classification c = (Classification) o;
			
			URN classifiedObjectURN = new URN(c.getClassifiedObject().getValue());
			URN classifiedObjectUUID  = ids.get(classifiedObjectURN);
            if(classifiedObjectUUID == null) throw new RuntimeException("in classification " + c.getId() +" classifiedObjectUUID is null: " + classifiedObjectURN);
			c.setClassifiedObject(new URI(classifiedObjectUUID.getValue()));
		}

        if(o instanceof WrsExtrinsicObject) {
            WrsExtrinsicObject eo = (WrsExtrinsicObject) o;

            if (eo.getRepositoryItemRef() != null) {
                URN repositoryItemURN = new URN(eo.getRepositoryItemRef().getHref());
                URN repositoryItemUUID  = ids.get(repositoryItemURN);
                if(repositoryItemUUID == null) throw new RuntimeException("in extrinsic object " + eo.getId() +" repositoryItemUUID is null: " + repositoryItemURN);                
                eo.getRepositoryItemRef().setHref(repositoryItemUUID.getValue());
            }
        }
	}

    /**
	 * Fixes an Classification classifinationNode id.
	 * @param o
     * @param classificationSchemeId        classificationSchemeId used to filter the classifications
     * @param classificationNodes           List of classificationNodes for the classificationSchemeId
	 */
    public void fixClassificationNodeId(Identifiable o, String classificationSchemeId, List<ClassificationNode> classificationNodes) {
         if (o instanceof Classification) {
             Classification c = (Classification) o;

             if (c.getClassificationScheme().getValue().equals(classificationSchemeId)) {
                 String classNode = c.getClassificationNode().getValue();

                 // Search the classificationnode id               
                 for (ClassificationNode cn : classificationNodes) {
                     if (classNode.equals(cn.getCode().getValue())) {
                         c.setClassificationNode(new URI(cn.getId().getValue()));
                         break;
                     }
                 }
             }
         }
    }
}
