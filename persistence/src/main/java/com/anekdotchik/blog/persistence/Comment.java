package com.anekdotchik.blog.persistence;

public interface Comment extends IdentifiedEntity<Long> {
	User getAuthor();

	void setAuthor(User author);

	String getMessage();

	void setMessage(String message);
}
