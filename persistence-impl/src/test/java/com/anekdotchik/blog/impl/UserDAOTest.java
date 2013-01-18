package com.anekdotchik.blog.impl;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anekdotchik.blog.dao.UserDAO;
import com.anekdotchik.blog.impl.persistence.UserImpl;
import com.anekdotchik.blog.persistence.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/context.xml" })
public class UserDAOTest extends AbstractJUnit4SpringContextTests {
	@Autowired(required = true)
	private UserDAO userDAO;

	@Test
	@Ignore
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testFindUserByLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		User user = new UserImpl();
		user.setLogin("login");
		user.setPassword("pass");
		Assert.assertNull(user.getId());
		userDAO.persist(user);
		User newUser = userDAO.findUserByLogin("login");
		Assert.assertNotNull(newUser.getId());
	}

}
