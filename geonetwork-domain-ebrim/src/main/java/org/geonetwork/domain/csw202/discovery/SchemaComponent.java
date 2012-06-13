package org.geonetwork.domain.csw202.discovery;

/**
 * A schema component includes a schema fragment (type definition) or an entire schema from some 
 * target namespace; the schema language is identified by URI. If the component is a schema 
 * fragment its parent MUST be referenced (parentSchema).
 * 
 * @author heikki doeleman
 *
 */
public class SchemaComponent {

	// this is
	// <xsd:any namespace="##any" processContents="lax"/>
	private Object schema;
	
	private String targetNamespace;
	
	private String parentSchema;
	
	private String schemaLanguage;

	public String getTargetNamespace() {
		return targetNamespace;
	}

	public void setTargetNamespace(String targetNamespace) {
		this.targetNamespace = targetNamespace;
	}

	public String getParentSchema() {
		return parentSchema;
	}

	public void setParentSchema(String parentSchema) {
		this.parentSchema = parentSchema;
	}

	public String getSchemaLanguage() {
		return schemaLanguage;
	}

	public void setSchemaLanguage(String schemaLanguage) {
		this.schemaLanguage = schemaLanguage;
	}

	public Object getSchema() {
		return schema;
	}

	public void setSchema(Object schema) {
		this.schema = schema;
	}
	
  @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((schema == null) ? 0 : schema.hashCode());
        result = prime * result + ((targetNamespace == null) ? 0 : targetNamespace.hashCode());
        result = prime * result + ((parentSchema == null) ? 0 : parentSchema.hashCode());
        result = prime * result + ((schemaLanguage == null) ? 0 : schemaLanguage.hashCode());
 		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof SchemaComponent)) {
			return false;
		}
		SchemaComponent other = (SchemaComponent) obj;

        if (schema == null) {
            if (other.schema != null)
                return false;
        } else if (!schema
                .equals(other.schema))
            return false;

        if (targetNamespace == null) {
            if (other.targetNamespace != null)
                return false;
        } else if (!targetNamespace
                .equals(other.targetNamespace))
            return false;

        if (parentSchema == null) {
            if (other.parentSchema != null)
                return false;
        } else if (!parentSchema
                .equals(other.parentSchema))
            return false;

        if (schemaLanguage == null) {
            if (other.schemaLanguage != null)
                return false;
        } else if (!schemaLanguage
                .equals(other.schemaLanguage))
            return false;

		return true;
	}
}
