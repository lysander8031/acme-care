package com.acme.care.service;

import static com.acme.care.model.user.builder.UserMaker.*;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.acme.care.model.user.CareGiver;
import com.acme.care.model.user.CareSeeker;
import com.acme.care.model.user.Hiree;
import com.acme.care.persistence.HireeRepository;
import com.acme.care.service.impl.HireServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class HireServiceTest {
	
	@Mock 
	private HireeRepository repository;
	
	private HireService service;
	
	@Before
	public void setup() {
		this.service = new HireServiceImpl(repository);
	}

	@Test
	public void careSeekerShouldHireCareGiver() {
		CareSeeker careSeeker = make(a(CareSeeker));
		CareGiver careGiver = make(a(CareGiver));
		
		Optional<Hiree> hiree = service.hire(careSeeker, careGiver);
		
		verify(repository).save(hiree.get());
		
		assertTrue(hiree.isPresent());
	}
	
}