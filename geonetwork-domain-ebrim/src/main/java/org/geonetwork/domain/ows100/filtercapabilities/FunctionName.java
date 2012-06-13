package org.geonetwork.domain.ows100.filtercapabilities;


public class FunctionName {

    private String name;
    private String nArgs;

    public String getNArgs() {
        return nArgs;
    }

    public void setNArgs(String nArgs) {
        this.nArgs = nArgs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((name == null) ? 0 : name.hashCode());
        result = prime
                * result
                + ((nArgs == null) ? 0 : nArgs
                .hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof FunctionName)) {
			return false;
		}
        FunctionName other = (FunctionName) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (nArgs == null) {
            if (other.nArgs != null)
                return false;
        } else if (!nArgs.equals(other.nArgs))
            return false;
        return true;
    }
}
