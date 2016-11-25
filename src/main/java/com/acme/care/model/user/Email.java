package com.acme.care.model.user;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import com.acme.care.model.common.Immutable;
import com.acme.care.model.common.ValueObject;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Immutable @ValueObject
public class Email implements Serializable {
	private static final long serialVersionUID = 5640849019629556652L;
	
	private String value;
	
	protected Email() {}
	
	public Email(String value) {
		checkNotNull(value);
		
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof Email)) return false;
		
		final Email that = (Email) obj;
		
		return Objects.equal(this.value, that.value);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.value);
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				  .add("value", this.value)
				  .toString();
	}
	
}