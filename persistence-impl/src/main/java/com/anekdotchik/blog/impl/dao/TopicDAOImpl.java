package com.anekdotchik.blog.impl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anekdotchik.blog.dao.TopicDAO;
import com.anekdotchik.blog.persistence.Topic;

@Repository
public class TopicDAOImpl implements TopicDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public Topic findById(Long id) {
		Topic topic = (Topic) entityManager
				.createQuery("from Topic where id=:id").setParameter("id", id)
				.getSingleResult();
		return topic;
	}

	public List<Topic> findAllTopics() {
		@SuppressWarnings("unchecked")
		List<Topic> topic = (List<Topic>) entityManager.createQuery(
				"from Topic").getResultList();
		return topic;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void persist(Topic topic) {
		entityManager.persist(topic);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Topic merge(Topic topic) {
		return entityManager.merge(topic);
	}
}
