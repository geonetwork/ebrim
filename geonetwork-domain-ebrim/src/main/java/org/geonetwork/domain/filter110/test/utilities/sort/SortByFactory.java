package org.geonetwork.domain.filter110.test.utilities.sort;

import java.util.ArrayList;
import java.util.List;

import org.geonetwork.domain.filter110.expression.PropertyName;
import org.geonetwork.domain.filter110.sort.SortBy;
import org.geonetwork.domain.filter110.sort.SortOrder;
import org.geonetwork.domain.filter110.sort.SortProperty;

/**
 * 
 * @author heikki doeleman
 *
 */
public class SortByFactory {

	public static SortBy create() {
		SortBy sortBy = new SortBy();
		
		SortProperty sp1 = new SortProperty();
		PropertyName propertyName1 = new PropertyName();
		propertyName1.setValue("property-one");
		sp1.setPropertyName(propertyName1);
		sp1.setSortOrder(SortOrder.DESC);
		
		SortProperty sp2 = new SortProperty();
		PropertyName propertyName2 = new PropertyName();
		propertyName2.setValue("property-two");
		sp2.setPropertyName(propertyName2);
		sp2.setSortOrder(SortOrder.ASC);
		
		List<SortProperty> sortPropertyList = new ArrayList<SortProperty>();
		sortPropertyList.add(sp1);
		sortPropertyList.add(sp2);
		
		sortBy.setSortPropertyList(sortPropertyList);
		
		return sortBy;
	}
}
