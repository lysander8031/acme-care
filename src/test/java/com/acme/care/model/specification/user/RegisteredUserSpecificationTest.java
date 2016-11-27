package com.acme.care.model.specification.user;

import static com.acme.care.model.user.UserService.*;
import static com.acme.care.model.user.builder.UserMaker.CareSeeker;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static org.junit.Assert.*;

import java.util.Optional;

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
		boolean registered = Optional.of(make(a(CareSeeker)))
				 					   .filter(isRegistered)
		        					   .isPresent();
		
		assertFalse(registered);
	}
	
	@Test
	public void shouldCheckIfUserIsRegistered() {
		boolean registered = Optional.of(make(a(CareSeeker)))
								  	 .flatMap(register)
								  	 .filter(isRegistered)
								  	 .isPresent();
		assertTrue(registered);
	}
	
	@Test
	public void shouldCheckIfUserIsRegistered_Old() {
		User user = make(a(CareSeeker));
		user.register();
		
		boolean isRegistered = specification.isSatisfiedBy(user);
		
		assertTrue(isRegistered);
	}
	
	@Test
	public void shouldCheckIfUserIsNotRegistered_Old() {
		User user = make(a(CareSeeker));
		
		boolean isRegistered = specification.isSatisfiedBy(user);
		
		assertFalse(isRegistered);
	}

}