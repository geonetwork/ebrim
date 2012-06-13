package org.geonetwork.dao.ebrim.informationmodel;

import org.geonetwork.dao.ebrim.AbstractDaoTest;
import org.geonetwork.dao.ebrim.provenance.DaoTestDelegate;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrim.informationmodel.core.*;
import org.geonetwork.domain.ebrim.informationmodel.event.*;
import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.test.utilities.event.AdhocQueryFactory;
import org.geonetwork.domain.ebrim.test.utilities.event.QueryExpressionFactory;
import org.geonetwork.utils.RandomPopulator;
import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;

import java.util.List;

public class EventDaoTest extends AbstractDaoTest {

    EventDao eventDao;

    public void setCoreDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    /**
     * AdhocQuery
     */
    public void testSaveAdhocQuery1() {
        clean();
        new DaoTestDelegate(eventDao).testSave(AdhocQuery.class);
    }

    /**
     * TODO Heikki question: I don't understand well how Hibernate treats this. In the database I
     * don't see any table QueryExpression. The attributes of the dhocQuery table don't have any
     * attributes of QueryExpression. Where is the information in the database?
     */
    public void testSaveAdhocQuery2() {
        clean();
        AdhocQuery adhocQuery = AdhocQueryFactory.create();
        QueryExpression queryExpression = QueryExpressionFactory.create();
        adhocQuery.setQueryExpression(queryExpression);
        eventDao.saveAdhocQuery(adhocQuery);
        AdhocQuery adhocQueryFound = eventDao.findAdhocQueryById(adhocQuery.getHibernateId());
        assertEquals(queryExpression, adhocQueryFound.getQueryExpression());
    }

    public void testMergeAdhocQuery1() {
        clean();
        AdhocQuery adhocQuery = AdhocQueryFactory.create();
        assertEquals(0, eventDao.loadAllAdhocQuery().size());
        eventDao.saveAdhocQuery(adhocQuery);
        assertEquals(1, eventDao.loadAllAdhocQuery().size());
        URI queryLanguage = new URI();
        queryLanguage.setValue("piet");
        adhocQuery.getQueryExpression().setQueryLanguage(queryLanguage);
        eventDao.mergeAdhocQuery(adhocQuery);
        AdhocQuery adhocQueryFound = eventDao.findAdhocQueryById(adhocQuery.getHibernateId());
        assertEquals("piet", adhocQueryFound.getQueryExpression().getQueryLanguage().getValue());
    }

    public void testDeleteAdhocQuery() {
        clean();
        new DaoTestDelegate(eventDao).testDelete(AdhocQuery.class);
    }

    public void testfindAdhocQueryById() {
        clean();
        new DaoTestDelegate(eventDao).testfindById(AdhocQuery.class);
    }

    public void testfindAdhocQueryByUrnId() {
        clean();
        AdhocQuery testAdhocQuery;
        try {
            // create the AdhocQuery for test
            testAdhocQuery = (AdhocQuery) RandomPopulator.instantiate(AdhocQuery.class, null);
            testAdhocQuery.setId(new URN("stored-query"));
            eventDao.saveAdhocQuery(testAdhocQuery);

            AdhocQuery findedAdhocQuery = eventDao.findAdhocQueryByUrnId("stored-query");
            assertNotNull(findedAdhocQuery);
            assertEquals(testAdhocQuery.getId(), findedAdhocQuery.getId());
        } catch (Exception e) {
            fail();
            throw new RuntimeException(e);
        }
    }

    /**
     * NotifyAction
     */
    public void testSaveNotifyAction() {
        clean();
        new DaoTestDelegate(eventDao).testSave(NotifyAction.class);
    }

    public void testMergeNotifyAction1() {
        clean();
        new DaoTestDelegate(eventDao).testMerge(NotifyAction.class, "endPoint");
    }

    public void testMergeNotifyAction2() {
        clean();
        new DaoTestDelegate(eventDao).testMerge(NotifyAction.class, "notificationOption");
    }

    public void testDeleteNotifyAction() {
        clean();
        new DaoTestDelegate(eventDao).testDelete(NotifyAction.class);
    }

    public void testfindNotifyActionById() {
        clean();
        new DaoTestDelegate(eventDao).testfindById(NotifyAction.class);
    }

    /**
     * Subscription
     */
    public void testSaveSubscription() {
        clean();
        new DaoTestDelegate(eventDao).testSave(Subscription.class);
    }

    public void testMergeSubscription1() {
        clean();
        new DaoTestDelegate(eventDao).testMerge(Subscription.class, "selector");
    }

    public void testDeleteSubscription() {
        clean();
        new DaoTestDelegate(eventDao).testDelete(Subscription.class);
    }

    public void testfindSubscriptionById() {
        clean();
        new DaoTestDelegate(eventDao).testfindById(Subscription.class);
    }


    /**
     * AuditableEvent
     */

    public void testSaveAuditableEvent() {
        clean();
        new DaoTestDelegate(eventDao).testSave(AuditableEvent.class);
    }

    public void testMergeAuditableEvent() {
        clean();
        new DaoTestDelegate(eventDao).testMerge(AuditableEvent.class, "user");
    }

    public void testDeleteAuditableEvent() {
        clean();
        new DaoTestDelegate(eventDao).testDelete(AuditableEvent.class);
    }

    public void testfindAuditableEventById() {
        clean();
        new DaoTestDelegate(eventDao).testfindById(AuditableEvent.class);
    }


    /**
     * Notification
     */

    public void testSaveNotification() {
        clean();
        new DaoTestDelegate(eventDao).testSave(Notification.class);
    }

    public void testMergeNotification() {
        clean();
        new DaoTestDelegate(eventDao).testMerge(Notification.class, "subscription");
    }

    public void testDeleteNotification() {
        clean();
        new DaoTestDelegate(eventDao).testDelete(Notification.class);
    }

    public void testfindNotificationById() {
        clean();
        new DaoTestDelegate(eventDao).testfindById(Notification.class);
    }


    public void clean() {

        List<AdhocQuery> trashAdhocQuery = eventDao.loadAllAdhocQuery();
        for (AdhocQuery leftOver : trashAdhocQuery) {
            eventDao.deleteAdhocQuery(leftOver);
        }

        List<AuditableEvent> trashAuditableEvent = eventDao.loadAllAuditableEvent();
        for (AuditableEvent leftOver : trashAuditableEvent) {
            eventDao.deleteAuditableEvent(leftOver);
        }


        List<Notification> trashNotification = eventDao.loadAllNotification();
        for (Notification leftOver : trashNotification) {
            eventDao.deleteNotification(leftOver);
        }

        List<NotifyAction> trashNotifyAction = eventDao.loadAllNotifyAction();
        for (NotifyAction leftOver : trashNotifyAction) {
            eventDao.deleteNotifyAction(leftOver);
        }

        List<Subscription> trashSubscription = eventDao.loadAllSubscription();
        for (Subscription leftOver : trashSubscription) {
            eventDao.deleteSubscription(leftOver);
        }

    }
}