package com.anekdotchik.blog.dao;

import java.util.List;

import com.anekdotchik.blog.persistence.Comment;
import com.anekdotchik.blog.persistence.Topic;
import com.anekdotchik.blog.persistence.User;

public interface CommentDAO extends IdentifiedDAO<Long, Comment> {
	List<Comment> findCommentsByUser(User user);

	List<Comment> findCommentsByTopic(Topic topic);
}
