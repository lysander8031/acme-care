package com.acme.care.model.user;

import static com.acme.care.model.user.builder.UserMaker.CareGiver;
import static com.acme.care.model.user.builder.UserMaker.CareSeeker;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static org.junit.Assert.*;

import org.junit.Test;

public class HireeTest {
	
	@Test(expected=NullPointerException.class)
	public void shouldThrowExceptionWhenHireeIsCreatedWithNullValue() {
		new Hiree(null, null);
	}
	
	@Test
	public void shoulBeEqualToHireeWithSameValue() {
		CareSeeker careSeeker = make(a(CareSeeker));
		CareGiver careGiver = make(a(CareGiver));
		
		Hiree one = new Hiree(careSeeker, careGiver);
		Hiree two = new Hiree(careSeeker, careGiver);
		
		assertEquals(one, two);
	}

}