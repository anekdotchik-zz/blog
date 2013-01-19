package com.anekdotchik.blog.impl.persistence;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.anekdotchik.blog.persistence.IdentifiedEntity;

@MappedSuperclass
public abstract class IdentifiedEntityImpl<T> implements IdentifiedEntity<T> {
	private static final long serialVersionUID = -6459340057758740641L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private T id;

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}
}
