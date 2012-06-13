package org.geonetwork.domain.filter110.spatialop;

import org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.Envelope;
import org.geonetwork.domain.filter110.expression.PropertyName;

/**
 * 
 * @author heikki doeleman
 *
 */
public class BBOX extends SpatialOps {

	private PropertyName propertyName;
	private Envelope envelope;
	
	public PropertyName getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(PropertyName propertyName) {
		this.propertyName = propertyName;
	}
	public Envelope getEnvelope() {
		return envelope;
	}
	public void setEnvelope(Envelope envelope) {
		this.envelope = envelope;
	}
	
	
	
}
