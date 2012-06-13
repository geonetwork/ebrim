package org.geonetwork.dao.ebrim.informationmodel;

import java.util.List;

import org.geonetwork.domain.ebrim.informationmodel.event.*;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 
 * Dao for AdhocQuery, NotifyAction, QueryExpression, Subscription
 * 
 * 
 * QueryExpression is not an entity because it is only used as an attribute of AdhocQuery. See also
 * EventDaoTest.testSaveAdhocQuery2
 * 
 * 
 * TODO Heikki AuditableEvent and Notification do not have a Factory. Does that mean that no Dao is
 * needed for them or have you simply forgotten to make a factory for them?
 * 
 * 
 * 
 * @author Erik van Ingen
 * 
 */

public class EventDao extends HibernateDaoSupport {

	/**
	 * AdhocQuery
	 */
	public void saveAdhocQuery(AdhocQuery adhocQuery) {
		this.getHibernateTemplate().save(adhocQuery);
	}

	public void mergeAdhocQuery(AdhocQuery adhocQuery) {
		this.getHibernateTemplate().merge(adhocQuery);
	}

	public void deleteAdhocQuery(AdhocQuery adhocQuery) {
		this.getHibernateTemplate().delete(adhocQuery);
	}

	@SuppressWarnings("unchecked")
	public List<AdhocQuery> loadAllAdhocQuery() {
		return this.getHibernateTemplate().loadAll(AdhocQuery.class);
	}

	public AdhocQuery findAdhocQueryById(long id) {
		return (AdhocQuery) this.getHibernateTemplate().load(AdhocQuery.class, id);
	}

    public AdhocQuery findAdhocQueryByUrnId(String urnId) {
         List<AdhocQuery> adhocQueries = this.getHibernateTemplate().find(
                "from org.geonetwork.domain.ebrim.informationmodel.event.AdhocQuery query where query.id.value = ?",urnId);

        if (!adhocQueries.isEmpty())
            return adhocQueries.get(0);
        else
            return null;
    }

	/**
	 * NotifyAction
	 */
	public void saveNotifyAction(NotifyAction notifyAction) {
		this.getHibernateTemplate().save(notifyAction);
	}

	public void mergeNotifyAction(NotifyAction notifyAction) {
		this.getHibernateTemplate().merge(notifyAction);
	}

	public void deleteNotifyAction(NotifyAction notifyAction) {
		this.getHibernateTemplate().delete(notifyAction);
	}

	@SuppressWarnings("unchecked")
	public List<NotifyAction> loadAllNotifyAction() {
		return this.getHibernateTemplate().loadAll(NotifyAction.class);
	}

	public NotifyAction findNotifyActionById(long id) {
		return (NotifyAction) this.getHibernateTemplate().load(NotifyAction.class, id);
	}

	/**
	 * Subscription
	 */
	public void saveSubscription(Subscription subscription) {
		this.getHibernateTemplate().save(subscription);
	}

	public void mergeSubscription(Subscription subscription) {
		this.getHibernateTemplate().merge(subscription);
	}

	public void deleteSubscription(Subscription subscription) {
		this.getHibernateTemplate().delete(subscription);
	}

	@SuppressWarnings("unchecked")
	public List<Subscription> loadAllSubscription() {
		return this.getHibernateTemplate().loadAll(Subscription.class);
	}

	public Subscription findSubscriptionById(long id) {
		return (Subscription) this.getHibernateTemplate().load(Subscription.class, id);
	}


    /**
	 * AuditableEvent
	 */
    public void saveAuditableEvent(AuditableEvent auditableEvent) {
		this.getHibernateTemplate().save(auditableEvent);
	}

	public void mergeAuditableEvent(AuditableEvent auditableEvent) {
		this.getHibernateTemplate().merge(auditableEvent);
	}

	public void deleteAuditableEvent(AuditableEvent auditableEvent) {
		this.getHibernateTemplate().delete(auditableEvent);
	}

	@SuppressWarnings("unchecked")
	public List<AuditableEvent> loadAllAuditableEvent() {
		return this.getHibernateTemplate().loadAll(AuditableEvent.class);
	}

	public AuditableEvent findAuditableEventById(long id) {
		return (AuditableEvent) this.getHibernateTemplate().load(AuditableEvent.class, id);
	}

    /**
     * Notification
     */
    public void saveNotification(Notification notification) {
		this.getHibernateTemplate().save(notification);
	}

	public void mergeNotification(Notification notification) {
		this.getHibernateTemplate().merge(notification);
	}

	public void deleteNotification(Notification notification) {
		this.getHibernateTemplate().delete(notification);
	}

	@SuppressWarnings("unchecked")
	public List<Notification> loadAllNotification() {
		return this.getHibernateTemplate().loadAll(Notification.class);
	}

	public Notification findNotificationById(long id) {
		return (Notification) this.getHibernateTemplate().load(Notification.class, id);
	}

}
