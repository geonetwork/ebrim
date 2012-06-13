package org.geonetwork.gaap.domain.util;

import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.group.GroupDescription;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

/**
 * Factory class for Group test
 *
 * @author Jose
 */
public class GroupFactory {
    public static Group create() {
        Group group = new Group();
        group.setUuid("aaa-bbb-ccc-ddd");
        
        group.setName("group1");
        group.setDescription("description group 1");
        group.setEmail("group@mail.com");
        group.setReferrer(true);

        Set<GroupDescription> descriptions = new HashSet<GroupDescription>();
        GroupDescription gd = new GroupDescription();
        gd.setLangId("en");
        gd.setLabel("test group");
        descriptions.add(gd);

        gd = new GroupDescription();
        gd.setLangId("es");
        gd.setLabel("grupo de test");
        descriptions.add(gd);

        group.setDescriptions(descriptions);

        return group;
    }

    public static List<Group> createList() {
        List<Group> groups = new ArrayList<Group>();
        groups.add(create());

        Group group = create();

        group.setUuid("nnn-eee-fds-rew");
        group.setName("group2");
        group.setDescription("description group 2");
        group.setEmail("group@mail.com");
        group.setReferrer(true);

        Set<GroupDescription> descriptions = new HashSet<GroupDescription>();
        GroupDescription gd = new GroupDescription();
        gd.setLangId("en");
        gd.setLabel("test group 2");
        descriptions.add(gd);

        group.setDescriptions(descriptions);

        groups.add(group);

        return groups;
    }
}
