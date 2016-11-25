package com.acme.care.model.specification.user;

import com.acme.care.model.specification.Specification;
import com.acme.care.model.user.Password;

public class StrongPasswordSpecification implements Specification {

	private static final int STRENGTH_THRESHOLD = 6;
	
	@Override
	public boolean isSatisfiedBy(Object candidate) {
		if (! (candidate instanceof Password)) return false;
		
		Password password = (Password) candidate;
		
		return password.length() >= STRENGTH_THRESHOLD;
	}

}
