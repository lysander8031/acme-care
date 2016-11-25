package com.acme.care.model.user;

import static com.acme.care.model.user.builder.AddressMaker.Address;
import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static org.junit.Assert.*;

import org.junit.Test;

public class AddressTest {
	
	@Test(expected=NullPointerException.class)
	public void shouldThrowExceptionWhenEmailIsCreatedWithNullValue() {
		new Address(null, null);
	}
	
	@Test
	public void shoulBeEqualToEmailWithSameValue() {
		Address one = make(an(Address));
		Address two = make(an(Address));
		
		assertEquals(one, two);
	}

}