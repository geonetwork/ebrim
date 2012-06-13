package org.geonetwork.domain.ebrim.test.utilities.csw202.discovery;

import org.geonetwork.domain.csw202.discovery.GetCapabilities;
import org.geonetwork.domain.ows100.getcapabilities.AcceptFormats;
import org.geonetwork.domain.ows100.getcapabilities.AcceptVersions;
import org.geonetwork.domain.ows100.getcapabilities.Sections;
import org.geonetwork.domain.ows100.common.MimeType;

import java.util.ArrayList;
import java.util.List;

public class GetCapabilitiesFactory {
    public synchronized static GetCapabilities create() {
        GetCapabilities c = new GetCapabilities();

        c.setUpdateSequence("XYZ123");
        AcceptFormats af = new AcceptFormats();
        List<MimeType> mtList = new ArrayList<MimeType>();
        MimeType mt = new MimeType();
        mt.setValue("text/xml");
        mtList.add(mt);
        af.setOutputFormat(mtList);
        
        c.setAcceptFormats(af);

        AcceptVersions av = new AcceptVersions();
        List<String> versionList = new ArrayList<String>();
        versionList.add("1.0.0");
        versionList.add("0.8.3");
        av.setVersion(versionList);
        c.setAcceptVersions(av);

        Sections sections = new Sections();
        List<String> sectionList = new ArrayList<String>();
        sectionList.add("Contents");
        sections.setSection(sectionList);
        c.setSections(sections);

        return c;
    }
}
