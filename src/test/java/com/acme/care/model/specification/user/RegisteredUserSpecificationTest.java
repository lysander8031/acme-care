package com.acme.care.model.specification.user;

import static com.acme.care.model.user.builder.UserMaker.User;
import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.acme.care.model.specification.Specification;
import com.acme.care.model.user.User;

//TODO: Rewrite to Table Driven Test
public class RegisteredUserSpecificationTest {
	
	private Specification specification;
	
	@Before
	public void setup() {
		specification = new RegisteredUserSpecification();
	}

	@Test
	public void shouldCheckIfUserIsNotRegistered() {
		User user = make(an(User));
		
		boolean isRegistered = specification.isSatisfiedBy(user);
		
		assertFalse(isRegistered);
	}
	
	@Test
	public void shouldCheckIfUserIsRegistered() {
		User user = make(an(User));
		user.register();
		
		boolean isRegistered = specification.isSatisfiedBy(user);
		
		assertTrue(isRegistered);
	}

}