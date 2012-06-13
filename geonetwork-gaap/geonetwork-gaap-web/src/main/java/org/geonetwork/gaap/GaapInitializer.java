package org.geonetwork.gaap;

import org.geonetwork.gaap.dao.GroupDao;
import org.geonetwork.gaap.dao.OperationDao;
import org.geonetwork.gaap.dao.UserDao;
import org.geonetwork.gaap.domain.group.GroupUuid;
import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.group.GroupDescription;
import org.geonetwork.gaap.domain.operation.Operation;
import org.geonetwork.gaap.domain.operation.OperationName;
import org.geonetwork.gaap.domain.operation.OperationDescription;
import org.geonetwork.gaap.domain.user.User;

import java.util.Set;
import java.util.HashSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;

/**
 * Class to initialize Gaap database. Init method is invoked by Spring in bean
 * initialization
 *
 * @author Jose
 */
public class GaapInitializer {
    private String[] langs = {"en", "es", "fr", "cn"};

    GroupDao groupDao;
    OperationDao operationDao;
    UserDao userDao;

    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public void setOperationDao(OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * Init Gaap database with default values (if not in database yet)
     * <p/>
     * Method invoked by Spring
     */
    public void init() {
        // Init default groups
        Group group = groupDao.findGroupByUuid(GroupUuid.GUEST.toString());
        if (group == null) {
            createGroup(GroupUuid.GUEST.toString());
        }

        group = groupDao.findGroupByUuid(GroupUuid.ALL.toString());
        if (group == null) {
            createGroup(GroupUuid.ALL.toString());
        }

        group = groupDao.findGroupByUuid(GroupUuid.INTRANET.toString());
        if (group == null) {
            createGroup(GroupUuid.INTRANET.toString());
        }

        group = groupDao.findGroupByUuid(GroupUuid.SAMPLE.toString());
        if (group == null) {
            createGroup(GroupUuid.SAMPLE.toString());
        }

        // Init default operations
        Operation op = operationDao.findOperationByName(OperationName.VIEW.toString());
        if (op == null) {
            createOperation(OperationName.VIEW.toString());
        }

        op = operationDao.findOperationByName(OperationName.DOWNLOAD.toString());
        if (op == null) {
            createOperation(OperationName.DOWNLOAD.toString());
        }

        op = operationDao.findOperationByName(OperationName.DYNAMIC.toString());
        if (op == null) {
            createOperation(OperationName.DYNAMIC.toString());
        }

        op = operationDao.findOperationByName(OperationName.EDITING.toString());
        if (op == null) {
            createOperation(OperationName.EDITING.toString());
        }

        op = operationDao.findOperationByName(OperationName.FEATURED.toString());
        if (op == null) {
            createOperation(OperationName.FEATURED.toString());
        }

        op = operationDao.findOperationByName(OperationName.NOTIFY.toString());
        if (op == null) {
            createOperation(OperationName.NOTIFY.toString());
        }

        // Default users
        User user = userDao.findUserByUuid("admin");
        if (user == null) {
            createUser("admin", "Administrator");
        }

    }

    /**
     * Creates a default user
     *
     * @param uuid    Uuid for the user
     * @param profile Profile of the user
     */
    private void createUser(String uuid, String profile) {
        User user = new User();

        user.setUuid(uuid);
        user.setName(uuid);
        user.setUsername(uuid);
        user.setPassword(scramble(uuid));

        user.setProfile(profile);
        userDao.saveUser(user);

    }

    /**
     * Creates a default operation
     *
     * @param name Operation name
     */
    private void createOperation(String name) {
        Operation op = new Operation();
        op.setName(name);

        Set<OperationDescription> descriptions = new HashSet<OperationDescription>();
        for (int i = 0; i < langs.length; i++) {
            OperationDescription opDescription = new OperationDescription();
            opDescription.setLangId(langs[i]);
            opDescription.setLabel(name);

            descriptions.add(opDescription);
        }
        op.setDescriptions(descriptions);

        operationDao.saveOperation(op);
    }

    /**
     * Creates a default group
     *
     * @param uuid Group uuid
     */
    private void createGroup(String uuid) {
        Group group = new Group();
        group.setUuid(uuid);
        group.setName(uuid);

        Set<GroupDescription> descriptions = new HashSet<GroupDescription>();
        for (int i = 0; i < langs.length; i++) {
            GroupDescription groupDescription = new GroupDescription();
            groupDescription.setLangId(langs[i]);
            groupDescription.setLabel(uuid);

            descriptions.add(groupDescription);
        }
        group.setDescriptions(descriptions);
        
        groupDao.saveGroup(group);
    }

    /**
     * Calculates SHA-1 encryption of a text
     *
     * @param text
     * @return
     */
    private static String scramble(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            md.update(text.getBytes("UTF-8"));

            StringBuffer sb = new StringBuffer();

            for (byte b : md.digest())
                sb.append(Integer.toString(b & 0xFF, 16));

            return sb.toString();
        }
        catch (UnsupportedEncodingException e) {
            return null;
        }
        catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

}
