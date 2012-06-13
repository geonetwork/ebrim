package org.geonetwork.gaap.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import org.geonetwork.gaap.domain.group.Group;

import java.util.List;

/**
 * Dao to manage Group entities
 */
@Transactional
public class GroupDao extends HibernateDaoSupport {

    /**
     * Saves a group
     *
     * @param group Group to save
     */
    public void saveGroup(Group group) {
        this.getHibernateTemplate().save(group);
    }

    public void mergeGroup(Group group) {
        this.getHibernateTemplate().merge(group);
    }

    /**
     * Deletes a group
     *
     * @param group Group to delete
     */
    public void deleteGroup(Group group) {
        this.getHibernateTemplate().delete(group);
    }
        
    /**
     * Returns a list of all groups
     *
     */
    @SuppressWarnings("unchecked")
    public List<Group> loadAllGroups() {
        return this.getHibernateTemplate().loadAll(Group.class);
    }

    /**
     * Find a group by internal id
     *
     * @param id    Internal group id
     * @return      Finded group using id, null if not finded
     */
    public Group findGroupById(long id) {
        return (Group) this.getHibernateTemplate().get(Group.class, id);
    }                                       

    /**
     * Find a group by uuid
     *
     * @param uuid  Group uuid
     * @return      Finded group using uuid, null if not finded
     */
    public Group findGroupByUuid(String uuid) {
        String queryTemplate = "from org.geonetwork.gaap.domain.group.Group where uuid = ?";

        List<Group> groups = this.getHibernateTemplate().find(queryTemplate, uuid);

        if (!groups.isEmpty()) {
            return groups.get(0);
        } else {
            return null;
        }
    }

    /**
     * Find a group by name
     *
     * @param name  Group name
     * @return      Finded group using name, null if not finded
     */
    public Group findGroupByName(String name) {
        String queryTemplate = "from org.geonetwork.gaap.domain.group.Group where name = ?";

        List<Group> groups = this.getHibernateTemplate().find(queryTemplate, name);

        if (!groups.isEmpty()) {
            return groups.get(0);
        } else {
            return null;
        }
    }
}