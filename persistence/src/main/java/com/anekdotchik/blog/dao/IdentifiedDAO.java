package com.anekdotchik.blog.dao;

import com.anekdotchik.blog.persistence.IdentifiedEntity;

public interface IdentifiedDAO<T, C extends IdentifiedEntity<T>> {
	C findById(T id);

	void save(C entity);

	void remove(T id);
}
