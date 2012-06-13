package org.geonetwork.domain.ows100.getcapabilities;

import java.util.List;
import java.util.ArrayList;

import org.geonetwork.domain.ows100.common.MimeType;

/**
 * Prioritized sequence of zero or more GetCapabilities operation response formats desired by 
 * client, with preferred formats listed first. Each response format shall be identified by its 
 * MIME type. See AcceptFormats parameter use subclause for more information.
 * 
 * @author heikki doeleman
 *
 */
public class AcceptFormats {

	private List<MimeType> outputFormat;

	public List<MimeType> getOutputFormat() {
		return outputFormat;
	}

	public void setOutputFormat(List<MimeType> outputFormat) {
		this.outputFormat = outputFormat;
	}

        /**
	 * For Jixb binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static  List<MimeType> outputFormatFactory() {
		return new ArrayList<MimeType>();
	}


    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputFormat == null) ? 0 : outputFormat.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AcceptFormats)) {
			return false;
		}
		AcceptFormats other = (AcceptFormats) obj;

        if (outputFormat == null) {
            if (other.outputFormat != null)
                return false;
        } else if (!outputFormat
                .equals(other.outputFormat))
            return false;

		return true;
	}
}
