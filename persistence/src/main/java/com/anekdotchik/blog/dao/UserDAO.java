package com.anekdotchik.blog.dao;

import com.anekdotchik.blog.persistence.User;

public interface UserDAO extends IdentifiedDAO<Long, User> {
	User findUserByLogin(String login);
}
