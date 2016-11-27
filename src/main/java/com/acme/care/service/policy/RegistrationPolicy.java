package com.acme.care.service.policy;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.acme.care.model.user.User;
import com.acme.care.persistence.UserRepository;

@Component
public class RegistrationPolicy {
	
	private final UserRepository repository;

	public RegistrationPolicy(UserRepository repository) {
		checkNotNull(repository);
		
		this.repository = repository;
	}

	public boolean isAllowed(User user) {
		Optional<User> result = checkIfAlreadyRegistered(user);
		
		return ! result.isPresent();
	}

	private Optional<User> checkIfAlreadyRegistered(User user) {
		return repository.findByCredentialEmail(user.getEmail());
	}
}