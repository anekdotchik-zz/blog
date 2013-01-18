package com.anekdotchik.blog.impl.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.anekdotchik.blog.persistence.User;

@Entity(name = "User")
public class UserImpl extends IdentifiedEntityImpl<Long> implements User {
	private static final long serialVersionUID = 1263690372071068135L;
	@Column(nullable = false, unique = true)
	private String login;
	@Column(nullable = false)
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
