package org.geonetwork.domain.ebrim.test.utilities.csw202.discovery;

import org.geonetwork.domain.csw202.discovery.GetDomainResponse;
import org.geonetwork.domain.csw202.discovery.DomainValues;
import org.geonetwork.domain.csw202.discovery.ConceptualScheme;
import org.geonetwork.domain.csw202.discovery.ListOfValues;

import java.util.List;
import java.util.ArrayList;

public class GetDomainResponseFactory {
    public synchronized static GetDomainResponse create() {
        GetDomainResponse c = new GetDomainResponse();

        List<DomainValues> domainValuesList = new ArrayList<DomainValues>();
        DomainValues d = new DomainValues();
        d.setType("csw:SampleRecord");
        d.setParameterName("GetRecords.resultType");
        ConceptualScheme cs = ConceptualSchemeFactory.create();
        d.setConceptualScheme(cs);

        domainValuesList.add(d);

        d = new DomainValues();
        d.setType("csw:Record");
        d.setParameterName("GetRecords.resultType");
        
        ListOfValues lov = new ListOfValues();
        List<Object> values = new ArrayList<Object>();
        values.add("hits");
        values.add("results");
        values.add("validate");

        lov.setValues(values);
        d.setListOfValues(lov);

        domainValuesList.add(d);

        c.setDomainValues(domainValuesList);
        return c;
    }
}
