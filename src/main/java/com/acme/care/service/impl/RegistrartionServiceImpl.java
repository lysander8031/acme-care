package com.acme.care.service.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.care.model.user.User;
import com.acme.care.persistence.UserRepository;
import com.acme.care.service.RegistrationService;

@Service
public class RegistrartionServiceImpl implements RegistrationService {

	private final UserRepository repository;
	
	public RegistrartionServiceImpl(UserRepository repository) {
		checkNotNull(repository);
		
		this.repository = repository;
	}
	
	@Override
	@Transactional
	public Optional<User> register(User user) {
		checkNotNull(user);
		
		if (isNotAlreadyRegistered(user))
			return registerAndStore(user);
			
		return Optional.empty();
	}

	private boolean isNotAlreadyRegistered(User user) {
		Optional<User> result = repository.findByCredentialEmail(user.getEmail());
		
		return ! result.isPresent();
	}
	
	private Optional<User> registerAndStore(User user) {
		user.register();
		
		User savedUser = repository.save(user);
		
		return Optional.of(savedUser);
	}
	
	// ------------------------------------------------------------
	
	public Optional<User> register2(User user) {
		checkNotNull(user);
		
		/*return verifyUniqueness(user)
				.map(u -> registerUser(u))
				.map(u -> store(u));*/
		
		verifyUniqueness(user)
				.map(u -> registerUser(u))
				.ifPresent(u -> store(u));
		
		return Optional.empty();
		
	}
	
	public Optional<User> verifyUniqueness(User user) {
		Optional<User> result = this.repository.findByCredentialEmail(user.getEmail());
		
		return result.isPresent() ? Optional.empty() : Optional.of(user);
	}
	
	public User registerUser(User user) {
		user.register();
		
		return new User(user);
	}
	
	public User store(User user) {
		return repository.save(user);
	}

}