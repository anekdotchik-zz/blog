package com.anekdotchik.blog.persistence;

import java.io.Serializable;

public interface IdentifiedEntity<T> extends Serializable {
	T getId();

	void setId(T id);
}
