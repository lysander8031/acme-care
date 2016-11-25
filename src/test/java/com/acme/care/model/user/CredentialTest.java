package com.acme.care.model.user;

import static com.acme.care.model.user.builder.CredentialMaker.Credential;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static org.junit.Assert.*;

import org.junit.Test;

public class CredentialTest {
	
	@Test(expected=NullPointerException.class)
	public void shouldThrowExceptionWhenCredentialIsCreatedWithNullValue() {
		new Credential(null, null);
	}
	
	@Test
	public void shoulBeEqualToCredentialWithSameValue() {
		Credential one = make(a(Credential));
		Credential two = make(a(Credential));
		
		assertEquals(one, two);
	}

}