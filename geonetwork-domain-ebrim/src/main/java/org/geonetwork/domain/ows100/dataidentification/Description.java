package org.geonetwork.domain.ows100.dataidentification;

import org.geonetwork.domain.ows100._19115subset.Keywords;

/**
 * Human-readable descriptive information for the object it is included within. This type 
 * shall be extended if needed for specific OWS use to include additional metadata for each 
 * type of information. This type shall not be restricted for a specific OWS to change the 
 * multiplicity (or optionality) of some elements. 
 * 
 * @author heikki doeleman
 *
 */
public class Description {
	
	private String title ;
	private String abstrakt;
	private Keywords keywords;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbstrakt() {
		return abstrakt;
	}
	public void setAbstrakt(String abstrakt) {
		this.abstrakt = abstrakt;
	}
	public Keywords getKeywords() {
		return keywords;
	}
	public void setKeywords(Keywords keywords) {
		this.keywords = keywords;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((abstrakt == null) ? 0 : abstrakt.hashCode());
        result = prime * result + ((keywords == null) ? 0 : keywords.hashCode());
 		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Description)) {
			return false;
		}
		Description other = (Description) obj;

        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title
                .equals(other.title))
            return false;

        if (abstrakt == null) {
            if (other.abstrakt != null)
                return false;
        } else if (!abstrakt
                .equals(other.abstrakt))
            return false;

        if (keywords == null) {
            if (other.keywords != null)
                return false;
        } else if (!keywords
                .equals(other.keywords))
            return false;

		return true;
	}    
}
