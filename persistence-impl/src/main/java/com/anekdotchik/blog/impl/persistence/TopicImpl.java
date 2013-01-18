package com.anekdotchik.blog.impl.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.anekdotchik.blog.persistence.Comment;
import com.anekdotchik.blog.persistence.Topic;
import com.anekdotchik.blog.persistence.User;

@Entity(name = "Topic")
public class TopicImpl extends IdentifiedEntityImpl<Long> implements Topic {
	private static final long serialVersionUID = 6857494333158017118L;
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE }, targetEntity = UserImpl.class, optional = false)
	private User author;
	@Column(nullable = false)
	private String head;
	@Column(nullable = false)
	private String body;
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE }, targetEntity = CommentImpl.class)
	private List<Comment> comments = new ArrayList<Comment>();

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<Comment> getComments() {
		return comments;
	}

}
