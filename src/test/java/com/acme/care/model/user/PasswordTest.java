package com.acme.care.model.user;

import static com.acme.care.model.user.builder.PasswordMaker.*;
import static com.natpryce.makeiteasy.MakeItEasy.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordTest {
	
	@Test
	public void shouldCheckPasswordStrength() {
		Password password = make(a(Password, with(value, "weak")));
		
		assertTrue(password.isWeak());
		
		password = make(a(Password, with(value, "strong")));
		
		assertFalse(password.isWeak());
	}

	@Test(expected=NullPointerException.class)
	public void shouldThrowExceptionWhenPasswordIsCreatedWithNullValue() {
		new Password(null);
	}
	
	@Test
	public void shoulBeEqualToPasswordWithSameValue() {
		Password one = make(a(Password));
		Password two = make(a(Password));
		
		assertEquals(one, two);
	}

}