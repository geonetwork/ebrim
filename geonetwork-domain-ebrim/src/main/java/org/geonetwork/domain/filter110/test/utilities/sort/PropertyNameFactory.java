package org.geonetwork.domain.filter110.test.utilities.sort;

import org.geonetwork.domain.filter110.expression.PropertyName;

/**
 * 
 * @author heikki doeleman
 *
 */
public class PropertyNameFactory {

	public static PropertyName create() {
		PropertyName propertyName = new PropertyName();
		propertyName.setValue("propertyneem");
		return propertyName;
	}
}
