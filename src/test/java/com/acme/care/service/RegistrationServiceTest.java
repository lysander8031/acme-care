package com.acme.care.service;

import static com.acme.care.model.user.builder.UserMaker.User;
import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.acme.care.model.user.User;
import com.acme.care.persistence.UserRepository;
import com.acme.care.service.impl.RegistrartionServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {
	
	@Mock 
	private UserRepository repository;
	
	private RegistrationService service;
	
	@Before
	public void setup() {
		this.service = new RegistrartionServiceImpl(repository);
	}

	@Test
	public void shouldRegisterWhenUserNotAlreadyRegistered() {
		User user = make(an(User));
		
		when(repository.findByCredentialEmail(any())).thenReturn(Optional.empty());
		
		when(repository.save(user)).thenReturn(user);
		
		Optional<User> registeredUser = service.register(user);
		
		assertTrue(registeredUser.isPresent());
	}
	
	@Test
	public void shouldNotRegisterWhenUserAlreadyRegistered() {
		User user = make(an(User));
		
		when(repository.findByCredentialEmail(any())).thenReturn(Optional.of(user));
		
		when(repository.save(user)).thenReturn(user);
		
		Optional<User> registeredUser = service.register(user);
		
		assertFalse(registeredUser.isPresent());
	}
	
}