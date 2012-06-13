package org.geonetwork.domain.gml311.geometrybasic0d1d;

/**
 * 
 * @author heikki doeleman
 *
 */
public class Envelope {

	private DirectPosition lowerCorner;
	private DirectPosition upperCorner;
	
	public DirectPosition getLowerCorner() {
		return lowerCorner;
	}
	public void setLowerCorner(DirectPosition lowerCorner) {
		this.lowerCorner = lowerCorner;
	}
	public DirectPosition getUpperCorner() {
		return upperCorner;
	}
	public void setUpperCorner(DirectPosition upperCorner) {
		this.upperCorner = upperCorner;
	}

	
}
