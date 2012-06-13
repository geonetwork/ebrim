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
package org.geonetwork.search.ebrim.filter;
        
import org.geotools.filter.FunctionExpressionImpl;
import org.geotools.filter.FunctionExpression;
import org.geotools.filter.LiteralExpressionImpl;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.RangeQuery;
import org.geonetwork.search.ebrim.filter.queryfields.Field;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to convert a During function call in filter to a lucene RangeQuery
 *
 * Example of function call:
 * 
 * <ogc:Function name="During">
 *      <ogc:PropertyName>rim:AuditableEvent/@timestamp</ogc:PropertyName>
 *      <ogc:Literal>
 *          <gml:TimePeriod>
 *              <gml:beginPosition>2005-08-01T00:00-08:00</gml:beginPosition>
 *              <gml:endPosition indeterminatePosition="now" />
 *          </gml:TimePeriod>
 *      </ogc:Literal>
 * </ogc:Function>
 *
 * @author Jose
 */
public class During extends FunctionExpressionImpl implements
        FunctionExpression {

    public During() {
        super("During");
    }

    public int getArgCount() {
        return 2;
    }

    public Object evaluate(Object feature) {
        Object arg0;
        LiteralExpressionImpl arg1;

        try {
            arg0 = getExpression(0);
            arg1 = (LiteralExpressionImpl) getExpression(1);

            Map dates = (HashMap) arg1.getValue();
            String beginPosition = (String) dates.get("beginPosition");
            String endPosition = (String) dates.get("endPosition");

            // Resolve query property
            String name = arg0.toString();
            PropertyResolver propertyResolver = PropertyResolverFactory.getPropertyResolver(name);
            Field fld =  propertyResolver.resolveProperty("");

            Term lower = null;
            if (!beginPosition.equals("")) lower = new Term(fld.getFieldName(), beginPosition);

            Term upper = null;
            if (!endPosition.equals("")) upper = new Term(fld.getFieldName(), endPosition);

			return fld.process(new RangeQuery(lower, upper, true));

        } catch (Exception e) // probably a type error
        {
            throw new IllegalArgumentException(
                    "Filter Function problem for function arguments");
        }
    }
}