//=============================================================================
//===	Copyright (C) 2009 European Space Agency (ESA).
//===
//===	This program is free software; you can redistribute it and/or modify
//===	it under the terms of the GNU General Public License as published by
//===	the Free Software Foundation; either version 2 of the License, or (at
//===	your option) any later version.
//===
//===	This program is distributed in the hope that it will be useful, but
//===	WITHOUT ANY WARRANTY; without even the implied warranty of
//===	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//===	General Public License for more details.
//===
//===	You should have received a copy of the GNU General Public License
//===	along with this program; if not, write to the Free Software
//===	Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
//===
//===	Contact: Jeroen Ticheler - E-mail: geonetwork@osgeo.org

//==============================================================================package org.geonetwork.gaap.services;
package org.geonetwork.gaap.services.exception;

/**
 *
 * 
 * @author Heikki Doeleman
 *
 */
public class GaapServiceException extends Exception {
    private static final long serialVersionUID = -1074066802419921224L;

    private GaapExceptionData faultMessage;

    public void setFaultMessage(GaapExceptionData msg) {
		faultMessage = msg;
	}

	public GaapExceptionData getFaultMessage() {
		return faultMessage;
	}

    public GaapServiceException() {}

    public GaapServiceException(String message) {
        super(message);
    }

    public GaapServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public GaapServiceException(Throwable cause) {
        super(cause);
    }
}
