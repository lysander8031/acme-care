package com.acme.care.model.user;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import com.acme.care.model.common.Immutable;
import com.acme.care.model.common.ValueObject;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Immutable @ValueObject
public class Name implements Serializable {
	private static final long serialVersionUID = 893248846617488458L;

	private String firstName;
	
	private String lastName;

	protected Name() {}
	
	public Name(String firstName, String lastName) {
		checkNotNull(firstName);
		checkNotNull(lastName);
		
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof Name)) return false;
		
		final Name that = (Name) obj;
		
		return Objects.equal(this.firstName, that.firstName)
			&& Objects.equal(this.lastName, that.lastName);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.firstName, this.lastName);
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				  .add("firstName", this.firstName)
				  .add("lastName", this.lastName)
				  .toString();
	}

}