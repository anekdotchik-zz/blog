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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this instanceof IdentifiedEntityImpl)
			return false;
		IdentifiedEntityImpl<?> other = (IdentifiedEntityImpl<?>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
