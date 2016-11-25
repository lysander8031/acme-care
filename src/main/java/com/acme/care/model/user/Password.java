package com.acme.care.model.user;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import com.acme.care.model.common.Immutable;
import com.acme.care.model.common.ValueObject;
import com.acme.care.model.specification.user.StrongPasswordSpecification;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Immutable @ValueObject
public class Password implements Serializable {
	private static final long serialVersionUID = -8337647501997875743L;
	
	private String value;
	
	protected Password() {}

	public Password(String value) {
		checkNotNull(value);
		
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public int length() {
		return this.value.length();
	}
	
	public boolean isWeak() {
		return ! new StrongPasswordSpecification().isSatisfiedBy(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof Password)) return false;
		
		final Password that = (Password) obj;
		
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