package com.acme.care.model.user;

import static com.acme.care.model.user.builder.EmailMaker.Email;
import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static org.junit.Assert.*;

import org.junit.Test;

public class EmailTest {
	
	@Test(expected=NullPointerException.class)
	public void shouldThrowExceptionWhenEmailIsCreatedWithNullValue() {
		new Email(null);
	}
	
	@Test
	public void shoulBeEqualToEmailWithSameValue() {
		Email one = make(an(Email));
		Email two = make(an(Email));
		
		assertEquals(one, two);
	}

}