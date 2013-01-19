package com.anekdotchik.blog.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anekdotchik.blog.dao.TopicDAO;
import com.anekdotchik.blog.impl.persistence.TopicImpl;
import com.anekdotchik.blog.persistence.Topic;

@Repository
public class TopicDAOImpl implements TopicDAO {
	@Autowired(required = true)
	private SessionFactory sessionFactory;

	public Topic findById(Long id) {
		Topic topic = (Topic) sessionFactory.getCurrentSession()
				.createQuery("from Topic where id=:id").setParameter("id", id)
				.uniqueResult();
		return topic;
	}

	public List<Topic> findAllTopics() {
		@SuppressWarnings("unchecked")
		List<Topic> topic = (List<Topic>) sessionFactory.getCurrentSession()
				.createCriteria(TopicImpl.class).list();
		return topic;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Topic topic) {
		sessionFactory.getCurrentSession().saveOrUpdate(topic);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Long id) {
		sessionFactory.getCurrentSession().delete(id);
	}
}
