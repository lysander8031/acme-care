package com.acme.care.model.specification.user;

import static com.acme.care.model.user.builder.PasswordMaker.Password;
import static com.acme.care.model.user.builder.PasswordMaker.value;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.acme.care.model.specification.Specification;
import com.acme.care.model.user.Password;

//TODO: Rewrite to Table Driven Test
public class StrongPasswordSpecificationTest {
	
	private Specification specification;
	
	@Before
	public void setup() {
		specification = new StrongPasswordSpecification();
	}

	@Test
	public void shouldCheckIfPasswordIsStrong() {
		Password password = make(a(Password, with(value, "strong")));
		
		boolean isStrong = specification.isSatisfiedBy(password);
		
		assertTrue(isStrong);
	}
	
	@Test
	public void shouldCheckIfPasswordIsWeak() {
		Password password = make(a(Password, with(value, "weak")));
		
		boolean isStrong = specification.isSatisfiedBy(password);
		
		assertFalse(isStrong);
	}

}