package com.acme.care.model.user;

import com.google.common.base.Objects;
import com.google.common.base.MoreObjects.ToStringHelper;

public class CareGiver extends User {
	private static final long serialVersionUID = -6462255356392758822L;
	
	private int age;
	
	protected CareGiver() {}

	public CareGiver(Name name, Address address, Credential credential) {
		this(name, address, credential, Status.NOTREGISTERED, 0);
	}
	
	public CareGiver(Name name, Address address, Credential credential, Status status) {
		this(name, address, credential, status, 0);
	}
	
	public CareGiver(Name name, Address address, Credential credential, int age) {
		this(name, address, credential, Status.NOTREGISTERED, age);
	}
	
	public CareGiver(Name name, Address address, Credential credential, Status status, int age) {
		super(name, address, credential, status);
		
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof CareGiver)) return false;
		
		final CareGiver that = (CareGiver) obj;
		
		return Objects.equal(super.getId(), that.getId())
			&& Objects.equal(super.getName(), that.getName())
			&& Objects.equal(super.getAddress(), that.getAddress())
			&& Objects.equal(super.getCredential(), that.getCredential())
			&& Objects.equal(this.getAge(), that.getAge());
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(
				super.getId(), this.getName(), this.getAddress(), 
				this.getCredential(), this.getAge());
	}
	
	@Override
	public ToStringHelper toStringHelper() {
		return super.toStringHelper()
					.add("age", this.age);
	}

}