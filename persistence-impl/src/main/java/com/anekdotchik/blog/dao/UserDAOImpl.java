package com.anekdotchik.blog.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anekdotchik.blog.dao.UserDAO;
import com.anekdotchik.blog.persistence.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired(required = true)
	private SessionFactory sessionFactory;

	public User findById(Long id) {
		User user = (User) sessionFactory.getCurrentSession()
				.createQuery("from User where id=:id").setParameter("id", id)
				.uniqueResult();
		return user;
	}

	public User findUserByLogin(String login) {
		User user = (User) sessionFactory.getCurrentSession()
				.createQuery("from User where login=:login")
				.setParameter("login", login).uniqueResult();
		return user;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Long id) {
		sessionFactory.getCurrentSession()
				.createQuery("delete from User where id=:id")
				.setParameter("id", id).executeUpdate();
	}
}
