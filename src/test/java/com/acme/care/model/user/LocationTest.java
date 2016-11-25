package com.acme.care.model.user;

import static com.acme.care.model.user.builder.LocationMaker.Location;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static org.junit.Assert.*;

import org.junit.Test;

public class LocationTest {

	@Test(expected=NullPointerException.class)
	public void shouldThrowExceptionWhenEmailIsCreatedWithNullValue() {
		new Location(null, null, null);
	}
	
	@Test
	public void shoulBeEqualToEmailWithSameValue() {
		Location one = make(a(Location));
		Location two = make(a(Location));
		
		assertEquals(one, two);
	}

}