package com.anekdotchik.blog.persistence;

public interface User extends IdentifiedEntity<Long> {
	String getLogin();

	void setLogin(String login);

	String getPassword();

	void setPassword(String password);
}
