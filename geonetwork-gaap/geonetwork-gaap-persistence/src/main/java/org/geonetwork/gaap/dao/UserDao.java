package org.geonetwork.gaap.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import org.geonetwork.gaap.domain.user.User;

import java.util.List;

/**
 * Dao to manage User entities                       
 */
@Transactional
public class UserDao extends HibernateDaoSupport {

    /**
     * Saves a user
     *
     * @param user User to save
     */
    public void saveUser(User user) {
        this.getHibernateTemplate().save(user);
    }

    public void mergeUser(User user) {
        this.getHibernateTemplate().merge(user);
    }

    /**
     * Deletes a user
     *
     * @param user User to save
     */
    public void deleteUser(User user) {
        this.getHibernateTemplate().delete(user);
    }

    /**
     * Returns a list of all users
     *
     */
    @SuppressWarnings("unchecked")
    public List<User> loadAllUsers() {
        return this.getHibernateTemplate().loadAll(User.class);
    }

    /**
     * Find a user by internal id
     *
     * @param id    Internal user id
     * @return      Finded user using id, null if not finded
     */
    public User findUserById(long id) {
        return (User) this.getHibernateTemplate().get(User.class, id);
    }


    /**
     * Find a user by uuid
     *
     * @param uuid  User uuid
     * @return      Finded user using uuid, null if not finded
     */
    public User findUserByUuid(String uuid) {
        String queryTemplate = "from org.geonetwork.gaap.domain.user.User where uuid = ?";

        List<User> users = this.getHibernateTemplate().find(queryTemplate, uuid);

        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            return null;            
        }
    }

    /**
     * Find a user by username
     *
     * @param username  User username
     * @return          Finded user using username, null if not finded
     */
    public User findUserByUsername(String username) {
        String queryTemplate = "from org.geonetwork.gaap.domain.user.User where username = ?";

        List<User> users = this.getHibernateTemplate().find(queryTemplate, username);

        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            return null;
        }
    }

}
