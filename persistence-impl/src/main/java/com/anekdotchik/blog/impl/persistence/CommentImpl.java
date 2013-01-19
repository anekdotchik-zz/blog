package com.anekdotchik.blog.impl.persistence;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.anekdotchik.blog.persistence.Comment;
import com.anekdotchik.blog.persistence.User;

@Entity(name = "Comment")
@Table(name = "comment")
public class CommentImpl extends IdentifiedEntityImpl<Long> implements Comment {
	private static final long serialVersionUID = -2407795799419285183L;
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE }, targetEntity = UserImpl.class, optional = false)
	private User author;
	@Column(nullable = false)
	private String message;

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
