package com.acme.care.model.user;

import static com.acme.care.model.user.builder.NameMaker.Name;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;

import static org.junit.Assert.*;

import org.junit.Test;

public class NameTest {
	
	@Test(expected=NullPointerException.class)
	public void shouldThrowExceptionWhenNameIsCreatedWithNullValue() {
		new Name(null, null);
	}
	
	@Test
	public void shoulBeEqualToNameWithSameValue() {
		Name one = make(a(Name));
		Name two = make(a(Name));
		
		assertEquals(one, two);
	}

}