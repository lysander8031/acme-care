package com.acme.care.service.policy;

import static com.acme.care.model.user.builder.UserMaker.CareSeeker;
import static com.natpryce.makeiteasy.MakeItEasy.a;
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
import com.acme.care.service.policy.RegistrationPolicy;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationPolicyTest {
	
	@Mock 
	private UserRepository repository;
	
	private RegistrationPolicy policy;
	
	@Before
	public void setup() {
		this.policy = new RegistrationPolicy(repository);
	}

	@Test
	public void shouldAllowToRegisterIfUserNotAlreadyRegistered() {
		User user = make(a(CareSeeker));
		
		when(repository.findByCredentialEmail(any())).thenReturn(Optional.empty());
		
		boolean isAllowed = policy.isAllowed(user);
		
		assertTrue(isAllowed);
	}
	
	@Test
	public void shouldNotAllowToRegisterIfUserAlreadyRegistered() {
		User user = make(a(CareSeeker));
		
		when(repository.findByCredentialEmail(any())).thenReturn(Optional.of(user));
		
		boolean isAllowed = policy.isAllowed(user);
		
		assertFalse(isAllowed);
	}

}