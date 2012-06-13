package org.geonetwork.domain.ebrim.test.utilities.csw202.discovery;

import org.geonetwork.domain.csw202.discovery.GetDomain;

public class GetDomainFactory {
    public synchronized static GetDomain createWithParameterName() {
        GetDomain c = new GetDomain();

        c.setService("CSW");
        c.setVersion("2.0.2");
        c.setParameterName("GetRecords.outputFormat");
        return c;
    }

    public synchronized static GetDomain createWithPropertyName() {
        GetDomain c = new GetDomain();

        c.setService("CSW");
        c.setVersion("2.0.2");        
        c.setPropertyName("Title");
        return c;
    }
}
