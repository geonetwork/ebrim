package org.geonetwork.domain.ows100._19115subset;

import java.util.List;
import java.util.ArrayList;

/**
 * Unordered list of one or more commonly used or formalised word(s) or phrase(s) used to 
 * describe the subject. When needed, the optional "type" can name the type of the associated 
 * list of keywords that shall all have the same type. Also when needed, the codeSpace attribute 
 * of that "type" can reference the type name authority and/or thesaurus.
 * 
 * For OWS use, the optional thesaurusName element was omitted as being complex information that 
 * could be referenced by the codeSpace attribute of the Type element. 
 * 
 * @author heikki doeleman
 *
 */
public class Keywords {

	private List<String> Keyword;
	private List<CodeType> type;
	public List<String> getKeyword() {
		return Keyword;
	}
	public void setKeyword(List<String> keyword) {
		Keyword = keyword;
	}
	public List<CodeType> getType() {
		return type;
	}
	public void setType(List<CodeType> type) {
		this.type = type;
	}

    /**
	 * For Jixb binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<String> keywordListFactory() {
		return new ArrayList<String>();
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Keyword == null) ? 0 : Keyword.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
 		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Keywords)) {
			return false;
		}
		Keywords other = (Keywords) obj;

        if (Keyword == null) {
            if (other.Keyword != null)
                return false;
        } else if (!Keyword
                .equals(other.Keyword))
            return false;

        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type
                .equals(other.type))
            return false;

		return true;
	}
}
