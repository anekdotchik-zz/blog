package com.anekdotchik.blog.dao;

import java.util.List;

import com.anekdotchik.blog.persistence.Topic;

public interface TopicDAO extends IdentifiedDAO<Long, Topic> {
	List<Topic> findAllTopics();
}
