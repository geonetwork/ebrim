package org.geonetwork.domain.ows100.getcapabilities;

import java.util.List;
import java.util.ArrayList;

/**
 * Unordered list of zero or more names of requested sections in complete service metadata 
 * document. Each Section value shall contain an allowed section name as specified by each OWS 
 * specification. See Sections parameter subclause for more information.
 * 
 * @author heikki doeleman
 *
 */
public class Sections {

	private List<String> section;

	public List<String> getSection() {
		return section;
	}

	public void setSection(List<String> section) {
		this.section = section;
	}
	
    /**
	 * For Jixb binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static  List<String> sectionListFactory() {
		return new ArrayList<String>();
	}


    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Sections)) {
			return false;
		}
		Sections other = (Sections) obj;

        if (section == null) {
            if (other.section != null)
                return false;
        } else if (!section
                .equals(other.section))
            return false;

		return true;
	}
}
