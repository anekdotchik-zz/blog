package com.anekdotchik.blog.impl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anekdotchik.blog.dao.CommentDAO;
import com.anekdotchik.blog.persistence.Comment;
import com.anekdotchik.blog.persistence.Topic;
import com.anekdotchik.blog.persistence.User;

@Repository
public class CommentDAOImpl implements CommentDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public Comment findById(Long id) {
		Comment comment = (Comment) entityManager
				.createQuery("from Comment where id=:id")
				.setParameter("id", id).getSingleResult();
		return comment;
	}

	public List<Comment> findCommentsByUser(User user) {
		@SuppressWarnings("unchecked")
		List<Comment> comment = (List<Comment>) entityManager
				.createQuery("from Comment where user=:user")
				.setParameter("user", user).getResultList();
		return comment;
	}

	public List<Comment> findCommentsByTopic(Topic topic) {
		@SuppressWarnings("unchecked")
		List<Comment> comments = (List<Comment>) entityManager
				.createQuery("from Comment where topic=:topic")
				.setParameter("topic", topic).getResultList();
		return comments;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void persist(Comment comment) {
		entityManager.persist(comment);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Comment merge(Comment comment) {
		return entityManager.merge(comment);
	}
}
