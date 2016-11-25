package com.acme.care.model.user;

import static com.acme.care.model.user.builder.UserMaker.User;
import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void shouldBeNotRegisteredWhenFirstCreated() {
		User user = make(an(User));
		
		assertFalse(user.isRegistered());
	}
	
	@Test
	public void shouldRegisterUser() {
		User user = make(an(User));
		
		user.register();
		
		assertTrue(user.isRegistered());
	}
	
	@Test(expected=NullPointerException.class)
	public void shouldThrowExceptionWhenUserIsCreatedWithNullValue() {
		new User(null, null, null);
	}
	
	@Test
	public void shoulBeEqualToUserWithSameValue() {
		User one = make(an(User));
		User two = make(an(User));
		
		assertEquals(one, two);
	}

}