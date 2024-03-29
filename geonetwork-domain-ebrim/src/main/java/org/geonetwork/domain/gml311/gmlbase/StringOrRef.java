package org.geonetwork.domain.gml311.gmlbase;
/**
 * This type is available wherever there is a need for a "text" type property. It is of 
 * string type, so the text can be included inline, but the value can also be referenced 
 * remotely via xlinks from the AssociationAttributeGroup. If the remote reference is 
 * present, then the value obtained by traversing the link should be used, and the string 
 * content of the element can be used for an annotation.
 * 
 * @author heikki doeleman
 *
 */
public class StringOrRef {
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actuate == null) ? 0 : actuate.hashCode());
		result = prime * result + ((arcrole == null) ? 0 : arcrole.hashCode());
		result = prime * result + ((href == null) ? 0 : href.hashCode());
		result = prime * result
				+ ((remoteSchema == null) ? 0 : remoteSchema.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((show == null) ? 0 : show.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StringOrRef other = (StringOrRef) obj;
		if (actuate == null) {
			if (other.actuate != null)
				return false;
		} else if (!actuate.equals(other.actuate))
			return false;
		if (arcrole == null) {
			if (other.arcrole != null)
				return false;
		} else if (!arcrole.equals(other.arcrole))
			return false;
		if (href == null) {
			if (other.href != null)
				return false;
		} else if (!href.equals(other.href))
			return false;
		if (remoteSchema == null) {
			if (other.remoteSchema != null)
				return false;
		} else if (!remoteSchema.equals(other.remoteSchema))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (show == null) {
			if (other.show != null)
				return false;
		} else if (!show.equals(other.show))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	private String value;
	
	private String remoteSchema;
	
	// xlink:simpleLink attributegroup :
	
	private final String type = "simple";
	
	private String href;
	private String role;
	private String arcrole;
	private String title;
	/**
	 * The 'show' attribute is used to communicate the desired presentation of the ending 
	 * resource on traversal from the starting resource; it's value should be treated as 
	 * follows: 
	 * 
	 * new - load ending resource in a new window, frame, pane, or other presentation context
	 * replace - load the resource in the same window, frame, pane, or other presentation context
	 * embed - load ending resource in place of the presentation of the starting resource
	 * other - behavior is unconstrained; examine other markup in the link for hints 
	 * none - behavior is unconstrained 
	 * 
	 */
	private String show;
	
	/**
	 * The 'actuate' attribute is used to communicate the desired timing of traversal from 
	 * the starting resource to the ending resource; it's value should be treated as follows:
	 * 
	 * onLoad - traverse to the ending resource immediately on loading the starting resource 
	 * onRequest - traverse from the starting resource to the ending 
	 * resource only on a post-loading event triggered for this purpose 
	 * other - behavior is unconstrained; examine other markup in link for hints 
	 * none - behavior is unconstrained
	 */
	private String actuate;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRemoteSchema() {
		return remoteSchema;
	}

	public void setRemoteSchema(String remoteSchema) {
		this.remoteSchema = remoteSchema;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getArcrole() {
		return arcrole;
	}

	public void setArcrole(String arcrole) {
		this.arcrole = arcrole;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public String getActuate() {
		return actuate;
	}

	public void setActuate(String actuate) {
		this.actuate = actuate;
	}

	public String getType() {
		return type;
	}
	
	
	
}
