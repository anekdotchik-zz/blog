package com.anekdotchik.blog.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anekdotchik.blog.dao.CommentDAO;
import com.anekdotchik.blog.persistence.Comment;
import com.anekdotchik.blog.persistence.Topic;
import com.anekdotchik.blog.persistence.User;

@Repository
public class CommentDAOImpl implements CommentDAO {
	@Autowired(required = true)
	private SessionFactory sessionFactory;

	public Comment findById(Long id) {
		Comment comment = (Comment) sessionFactory.getCurrentSession()
				.createQuery("from Comment where id=:id")
				.setParameter("id", id).uniqueResult();
		return comment;
	}

	public List<Comment> findCommentsByUser(User user) {
		@SuppressWarnings("unchecked")
		List<Comment> comment = (List<Comment>) sessionFactory
				.getCurrentSession()
				.createQuery("from Comment where user=:user")
				.setParameter("user", user).list();
		return comment;
	}

	public List<Comment> findCommentsByTopic(Topic topic) {
		@SuppressWarnings("unchecked")
		List<Comment> comments = (List<Comment>) sessionFactory
				.getCurrentSession()
				.createQuery("from Comment where topic=:topic")
				.setParameter("topic", topic).list();
		return comments;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Comment comment) {
		sessionFactory.getCurrentSession().saveOrUpdate(comment);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Long id) {
		sessionFactory.getCurrentSession().delete(id);
	}
}
