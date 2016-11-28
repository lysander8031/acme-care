package com.acme.care.model.user;

import static com.acme.care.model.user.builder.UserMaker.CareGiver;
import static com.acme.care.model.user.builder.UserMaker.CareSeeker;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static org.junit.Assert.*;

import org.junit.Test;

public class CareTeamTest {

	@Test
	public void shouldAddHiree() {
		CareSeeker careSeeker = make(a(CareSeeker));
		CareGiver careGiver = make(a(CareGiver));
		
		CareTeam careTeam = new CareTeam();
		
		careTeam.addHiree(careSeeker, careGiver);
		
		boolean isHired = careTeam.hasHiree(careSeeker, careGiver);
		
		assertTrue(isHired);
	}
	
	@Test
	public void shouldRemoveHiree() {
		CareSeeker careSeeker = make(a(CareSeeker));
		CareGiver careGiver = make(a(CareGiver));
		
		CareTeam careTeam = new CareTeam();
		
		careTeam.addHiree(careSeeker, careGiver);
		careTeam.removeHiree(careSeeker, careGiver);
		
		boolean isHired = careTeam.hasHiree(careSeeker, careGiver);
		
		assertFalse(isHired);
	}

}
