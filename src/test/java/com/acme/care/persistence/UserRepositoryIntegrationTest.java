package com.acme.care.persistence;

import static com.acme.care.model.user.builder.UserMaker.User;
import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.acme.care.model.user.User;

public class UserRepositoryIntegrationTest extends AbstractIntegrationTest {
	
	private User newUser;
	
	@Autowired
	private UserRepository repository;
	
	@Before
	public void setup() {
		newUser = make(an(User));
	}

	@Test
	public void saveUser() {
		User savedUser = repository.saveAndFlush(newUser);
		
		List<User> result = repository.findAll();
		
		assertTrue(result.contains(savedUser));
	}
	
	@Test
	public void findUserByEmail() {
		User savedUser = repository.saveAndFlush(newUser);
		
		Optional<User> result = repository.findByCredentialEmail(savedUser.getEmail());
		
		assertTrue(result.isPresent());
	}
	
	/*private void assertCascade(User expected, User actual) {
		assertEquals("should be cascaded", expected.criteria(),  actual.criteria());
		assertEquals("should be cascaded", expected.favorites(),   actual.favorites());
		assertEquals("should be cascaded", expected.views(),   actual.views());
	}*/

}