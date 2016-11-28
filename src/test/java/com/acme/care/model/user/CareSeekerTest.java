package com.acme.care.model.user;

import static com.acme.care.model.user.builder.UserMaker.CareGiver;
import static com.acme.care.model.user.builder.UserMaker.CareSeeker;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CareSeekerTest {
	
	private CareSeeker careSeeker = make(a(CareSeeker));
	private CareGiver careGiver = make(a(CareGiver));
	
	@Before
	public void setup() {
		careSeeker = make(a(CareSeeker));
		careGiver = make(a(CareGiver));
	}

	@Test
	public void shouldHireCareGiver() {
		Hiree hiree = careSeeker.hire(careGiver);
		
		assertEquals(careGiver, hiree.getHired());
	}
	
	@Test(expected=NullPointerException.class)
	public void shouldThrowExceptionWhenUserIsCreatedWithNullValue() {
		new CareSeeker(null, null, null);
	}


}