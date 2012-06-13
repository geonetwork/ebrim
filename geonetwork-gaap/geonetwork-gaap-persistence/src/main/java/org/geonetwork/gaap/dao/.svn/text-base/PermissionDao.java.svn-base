package org.geonetwork.gaap.dao;

import org.geonetwork.gaap.domain.operation.Permission;
import org.geonetwork.gaap.domain.operation.Operation;
import org.geonetwork.gaap.domain.operation.MetadataPermissions;
import org.geonetwork.gaap.domain.group.Group;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.index.Term;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;

/**
 * Dao to manage Permission entities
 *
 * @author Jose
 */
@Transactional
public class PermissionDao extends HibernateDaoSupport {

    /**
     * Saves a permission
     *
     * @param permission Permission to save
     */
    public void savePermission(Permission permission) {
        this.getHibernateTemplate().save(permission);
    }

    /**
     * Saves a list of permissions for a metadata
     *
     * @param metadataPermissions Permissions to save
     */
    public void saveMetadataPermissions(MetadataPermissions metadataPermissions) {
        this.getHibernateTemplate().saveOrUpdateAll(metadataPermissions.getPermissions());
    }


    public void mergePermission(Permission op) {
        this.getHibernateTemplate().merge(op);
    }

    /**
     * Deletes a permission
     *
     * @param permission Permission to delete
     */
    public void deletePermission(Permission permission) {
        this.getHibernateTemplate().delete(permission);
    }

    /**
     * Delete all permissions for a metadata
     *
     * @param uuid Metadata uuid
     */
    public void deletePermissionsByMetadataUuid(String uuid) {
        List<Permission> permissions = findPermissionsByMetadataUuid(uuid);
        this.getHibernateTemplate().deleteAll(permissions);
    }

    /**
     * Returns a list of all permissions defined for metadata
     *
     * @return List of all permissions defined for metadata
     */
    @SuppressWarnings("unchecked")
    public List<Permission> loadAllPermissions() {
        return this.getHibernateTemplate().loadAll(Permission.class);
    }

    /**
     * Finds a permission using the internal id
     *
     * @param id Id of the permission
     * @return Permission
     */
    public Permission findPermissionById(long id) {
        return (Permission) this.getHibernateTemplate().get(Permission.class, id);
    }

    /**
     * Finds a permission using all identifier info: metadataUuid, groupUuid, operationName
     *
     * @param metadataUuid  Metadata uuid
     * @param groupUuid     Group uuid
     * @param operationName Operation
     *
     * @return Permission
     */
    public Permission findPermission(String metadataUuid, String groupUuid, String operationName) {
        String queryTemplate = "from org.geonetwork.gaap.domain.operation.Permission where " +
                "metadataUuid = ? and group.uuid = ? and operation.name = ?";

        List<Permission> permissions =  this.getHibernateTemplate().find(queryTemplate, new Object[] {metadataUuid, groupUuid, operationName});

        if (!permissions.isEmpty())
            return permissions.get(0);
        else
            return null;       
    }

    /**
     * Returns a list of permissions for a metadata
     *
     * @param uuid Metadata uuid
     */
    public List<Permission> findPermissionsByMetadataUuid(String uuid) {
        String queryTemplate = "from org.geonetwork.gaap.domain.operation.Permission where metadataUuid = ?";

        return this.getHibernateTemplate().find(queryTemplate, uuid);
    }

    /**
     * Filter a list of metadata uuids, returning only the elements allowed for the
     * operation and groups provided
     *
     * @param metadataUuids List of metadata uuids to filter
     * @param groups        List of groups to check for permissions
     * @param op            Operation to check if the groups are allowed for the metadata
     * @return List of metadata uuids allowed for the operation and groups provided
     */
    public List<String> filterMetadataAllowed(List<String> metadataUuids, List<Group> groups, Operation op) throws Exception {
        FullTextSession fullTextSession = Search.getFullTextSession(this.getSession());

        Query query = buildFilterMetadataAllowedQuery(metadataUuids, groups, op);

        QueryParser parser =
                new QueryParser("metadataUuid", fullTextSession.getSearchFactory().getAnalyzer(Permission.class));
        Query querya = parser.parse(query.toString());

        org.hibernate.search.FullTextQuery hibQuery = fullTextSession.createFullTextQuery(querya, Permission.class);

        List<Permission> results = hibQuery.list();
        List<String> returnResults = new ArrayList<String>();
        for (Permission result : results) {
            returnResults.add(result.getMetadataUuid());
        }
        return returnResults;
    }


    /**
     * Filter all metadata in the catalog, returning only the elements allowed for the
     * operation and groups provided
     *
     * @param groupUuids List of groups to check for permissions
     * @param op         Operation to check if the groups are allowed for the metadata
     * @return List of metadata uuids allowed for the operation and groups provided
     */
    public List<String> filterMetadataAllowedForGroupsOperation(List<String> groupUuids, Operation op) throws Exception {
        FullTextSession fullTextSession = Search.getFullTextSession(this.getSession());

        Query query = buildFilterMetadataAllowedQuery(groupUuids, op);

        QueryParser parser =
                new QueryParser("metadataUuid", fullTextSession.getSearchFactory().getAnalyzer(Permission.class));
        Query querya = parser.parse(query.toString());

        org.hibernate.search.FullTextQuery hibQuery = fullTextSession.createFullTextQuery(querya, Permission.class);

        List<Permission> results = hibQuery.list();
        List<String> returnResults = new ArrayList<String>();
        for (Permission result : results) {
            returnResults.add(result.getMetadataUuid());
        }
        return returnResults;
    }

    /**
     * Builds a query to filter a metadata list
     *
     * @param metadataUuids List of metadata uuids to filter
     * @param groups        List of groups to check for permissions
     * @param op            Operation to check if the groups are allowed for the metadata
     * @return Query to filter a metadata list
     */
    private Query buildFilterMetadataAllowedQuery(List<String> metadataUuids, List<Group> groups, Operation op) {
        TermQuery opTerm = new TermQuery(new Term("operation.name", op.getName()));

        BooleanQuery groupsQuery = new BooleanQuery();

        for (Group g : groups) {
            TermQuery groupTerm = new TermQuery(new Term("group.uuid", g.getUuid()));
            groupsQuery.add(groupTerm, BooleanClause.Occur.SHOULD);
        }

        BooleanQuery query = new BooleanQuery();

        for (String uuid : metadataUuids) {
            BooleanQuery metadataQuery = new BooleanQuery();

            metadataQuery.add(new TermQuery(new Term("metadataUuid", QueryParser.escape(uuid))), BooleanClause.Occur.MUST);
            metadataQuery.add(groupsQuery, BooleanClause.Occur.MUST);
            metadataQuery.add(opTerm, BooleanClause.Occur.MUST);

            query.add(metadataQuery, BooleanClause.Occur.SHOULD);
        }

        return query;
    }


    /**
     * Builds a query to filter all metadata allowed to a groups and for an operation
     *
     * @param groupUuids List of groups to check for permissions
     * @param op         Operation to check if the groups are allowed for the metadata
     * @return Query to filter all metadata
     */
    private Query buildFilterMetadataAllowedQuery(List<String> groupUuids, Operation op) {
        TermQuery opTerm = new TermQuery(new Term("operation.name", op.getName()));

        BooleanQuery groupsQuery = new BooleanQuery();

        for (String uuid : groupUuids) {
            TermQuery groupTerm = new TermQuery(new Term("group.uuid", uuid));
            groupsQuery.add(groupTerm, BooleanClause.Occur.SHOULD);
        }

        BooleanQuery query = new BooleanQuery();

        query.add(groupsQuery, BooleanClause.Occur.MUST);
        query.add(opTerm, BooleanClause.Occur.MUST);

        return query;
    }

}
