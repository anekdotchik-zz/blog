package com.anekdotchik.blog.persistence;

import java.util.List;

public interface Topic extends IdentifiedEntity<Long> {
	User getAuthor();

	void setAuthor(User author);

	String getBody();

	void setBody(String body);

	String getHead();

	void setHead(String head);

	List<Comment> getComments();
}
