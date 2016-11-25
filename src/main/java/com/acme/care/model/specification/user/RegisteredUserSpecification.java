package com.acme.care.model.specification.user;

import com.acme.care.model.specification.Specification;
import com.acme.care.model.user.Status;
import com.acme.care.model.user.User;

public class RegisteredUserSpecification implements Specification {

	@Override
	public boolean isSatisfiedBy(Object candidate) {
		if (! (candidate instanceof User)) return false;
		
		User user = (User) candidate;
		
		return Status.REGISTERED.equals(user.getStatus());
	}

}