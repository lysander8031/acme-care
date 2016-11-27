package com.acme.care.model.user;

import static com.acme.care.model.user.UserService.isRegistered;
import static com.acme.care.model.user.UserService.register;
import static com.acme.care.model.user.builder.UserMaker.CareSeeker;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

public class UserTest {

	@Test
	public void shouldBeNotRegisteredWhenFirstCreated() {
		assertFalse(Optional.of(make(a(CareSeeker)))
							.filter(isRegistered)
							.isPresent());
	}
	
	@Test
	public void shouldRegisterUser() {
		assertTrue(Optional.of(make(a(CareSeeker)))
						   .flatMap(register)
						   .filter(isRegistered)
						   .isPresent());
	}
	
	@Test(expected=NullPointerException.class)
	public void shouldThrowExceptionWhenUserIsCreatedWithNullValue() {
		new CareSeeker(null, null, null);
	}
	
	@Test
	public void shoulBeEqualToUserWithSameValue() {
		User one = make(a(CareSeeker));
		User two = make(a(CareSeeker));
		
		assertEquals(one, two);
	}

}