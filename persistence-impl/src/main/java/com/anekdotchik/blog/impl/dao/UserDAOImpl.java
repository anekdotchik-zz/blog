package com.anekdotchik.blog.impl.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anekdotchik.blog.dao.UserDAO;
import com.anekdotchik.blog.persistence.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public User findById(Long id) {
		User user = (User) entityManager.createQuery("from User where id=:id")
				.setParameter("id", id).getSingleResult();
		return user;
	}

	public User findUserByLogin(String login) {
		User user = (User) entityManager
				.createQuery("from User where login=:login")
				.setParameter("login", login).getSingleResult();
		return user;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void persist(User user) {
		entityManager.persist(user);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public User merge(User user) {
		return entityManager.merge(user);
	}
}
