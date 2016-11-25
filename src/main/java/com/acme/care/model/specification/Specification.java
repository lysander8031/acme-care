package com.acme.care.model.specification;

public interface Specification {
	
	public boolean isSatisfiedBy(Object candidate);

}