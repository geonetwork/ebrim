package org.geonetwork.domain.ows100._19115subset;

import java.util.List;
import java.util.ArrayList;

/**
 * Telephone numbers for contacting the responsible individual or organization. 
 * 
 * @author heikki doeleman
 *
 */
public class Telephone {

	/**
	 * Telephone number by which individuals can speak to the responsible organization or 
	 * individual. 
	 */
	private List<String> voice;
	
	/**
	 * Telephone number of a facsimile machine for the responsible organization or individual.
	 */
	private List<String> facsimile;

	public List<String> getVoice() {
		return voice;
	}

	public void setVoice(List<String> voice) {
		this.voice = voice;
	}

	public List<String> getFacsimile() {
		return facsimile;
	}

	public void setFacsimile(List<String> facsimile) {
		this.facsimile = facsimile;
	}

    /**
	 * For Jixb binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static  List<String> voiceListFactory() {
		return new ArrayList<String>();
	}

	@SuppressWarnings("unused")
	private static  List<String> facsimileListFactory() {
		return new ArrayList<String>();
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((voice == null) ? 0 : voice.hashCode());
        result = prime * result + ((facsimile == null) ? 0 : facsimile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Telephone)) {
			return false;
		}
		Telephone other = (Telephone) obj;

        if (voice == null) {
            if (other.voice != null)
                return false;
        } else if (!voice
                .equals(other.voice))
            return false;

        if (facsimile == null) {
            if (other.facsimile != null)
                return false;
        } else if (!facsimile
                .equals(other.facsimile))
            return false;

		return true;
	}
}
