package com.anekdotchik.blog.dao;

import static org.junit.Assert.*;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.anekdotchik.blog.dao.UserDAO;
import com.anekdotchik.blog.persistence.User;
import com.anekdotchik.blog.persistence.UserImpl;

@ContextConfiguration(locations = { "classpath:spring/context.xml" })
public class UserDAOImplTest extends
		AbstractTransactionalTestNGSpringContextTests {
	private static final String LOGIN = "login";
	private static final String PASS = "pass";
	@Autowired(required = true)
	private UserDAO userDAO;
	private long id;

	@BeforeClass
	public void save() {
		User user = new UserImpl();
		user.setLogin(LOGIN);
		user.setPassword(PASS);
		assertNull(user.getId());
		userDAO.save(user);
		id = user.getId();
		assertNotNull(id);
		assertTrue(id > 0L);
	}

	@Test(priority = 0)
	public void saveUserWithNonExistingName() {
		User user = new UserImpl();
		user.setLogin(getLogin());
		user.setPassword(PASS);
		assertNull(user.getId());
		userDAO.save(user);
		long id = user.getId();
		assertNotNull(id);
		assertTrue(id > 0L);
	}

	@Test(priority = 1, expectedExceptions = { ConstraintViolationException.class })
	public void saveUserWithExistingName() {
		User user = new UserImpl();
		user.setLogin(LOGIN);
		user.setPassword(PASS);
		userDAO.save(user);
	}

	@Test(priority = 1)
	public void saveUserWithExistedId() {
		User user = new UserImpl();
		user.setId(id);
		user.setLogin(getLogin());
		user.setPassword(PASS);
		userDAO.save(user);
		assertEquals(Long.valueOf(id), user.getId());
	}

	@Test(priority = 1, expectedExceptions = { ConstraintViolationException.class })
	public void saveUserWithNullPass() {
		User user = new UserImpl();
		user.setLogin(getLogin());
		assertNull(user.getId());
		userDAO.save(user);
	}

	@Test(priority = 1, expectedExceptions = { ConstraintViolationException.class })
	public void saveUserWithEmptyPass() {
		User user = new UserImpl();
		user.setLogin(getLogin());
		user.setPassword("");
		assertNull(user.getId());
		userDAO.save(user);
	}

	@Test(enabled = false)
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test(enabled = false)
	public void testFindUserByLogin() {
		fail("Not yet implemented");
	}

	private synchronized String getLogin() {
		return String.format("login_%s_%s", Thread.currentThread().getName(),
				System.currentTimeMillis());
	}
}
