package com.acme.care.persistence;

import static com.acme.care.model.user.builder.UserMaker.*;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.care.model.user.CareGiver;
import com.acme.care.model.user.CareSeeker;
import com.acme.care.model.user.Hiree;

@PersistenceConfig
@RunWith(SpringJUnit4ClassRunner.class)
public class HireeRepositoryIntegrationTest  {
	
	private Hiree newHiree;
	
	@Autowired
	private HireeRepository repository;
	
	@Before
	public void setup() {
		newHiree = makeHiree();
	}

	@Test
	public void saveHiree() {
		Hiree savedHiree = repository.save(newHiree);
		
		List<Hiree> result = repository.findAll();
		
		assertTrue(result.contains(savedHiree));
	}
	
	@Test
	public void findAllCareGiversHiredByCareSeeker() {
		Hiree savedHiree = repository.save(newHiree);
		
		CareSeeker careSeeker = savedHiree.getHirer();
		CareGiver careGiver = savedHiree.getHired();
		
		List<CareGiver> hiredCareGivers = repository.findAllCareGiversHiredBy(careSeeker);
		
		assertTrue(hiredCareGivers.contains(careGiver));
	}
	
	private Hiree makeHiree() {
		CareSeeker careSeeker = make(a(CareSeeker));
		CareGiver careGiver = make(a(CareGiver));
		
		Hiree hiree = careSeeker.hire(careGiver);
		
		return hiree;
	}
	
}