package com.acme.care.service.impl;

import static com.acme.care.model.user.UserService.register;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.care.model.user.User;
import com.acme.care.persistence.UserRepository;
import com.acme.care.service.RegistrationService;
import com.acme.care.service.policy.RegistrationPolicy;

@Service
public class RegistrartionServiceImpl implements RegistrationService {

	private final RegistrationPolicy policy;
	
	private final UserRepository repository;
	
	public RegistrartionServiceImpl(RegistrationPolicy policy, UserRepository repository) {
		checkNotNull(policy);
		checkNotNull(repository);
		
		this.policy = policy;
		this.repository = repository;
	}
	
	@Override
	@Transactional
	public Optional<User> register(User user) {
		checkNotNull(user);
		
		if (policy.isAllowed(user))
			return registerAndStore(user);
			
		return Optional.empty();
		
		//return registerFunc(user);
	}
	
	private Optional<User> registerAndStore(User user) {
		user.register();
		
		User savedUser = repository.save(user);
		
		return Optional.of(savedUser);
	}
	
	// ------------------------------------------------------------
	
	@Transactional
	public Optional<User> registerFunc(User user) {
		checkNotNull(user);
		
		Optional<User> result = isNotAlreadyRegistered2(user)
					.flatMap(newUser -> register.apply(newUser)
					.flatMap(registeredUser -> store(registeredUser)));
		
		/*Optional<User> result = isNotAlreadyRegistered2(user)
				.flatMap(newUser -> register.apply(newUser));*/
				//.flatMap(registeredUser -> store(registeredUser));
		
		
		result.ifPresent(System.out::println);
		
		return result;
	}
	
	private Optional<User> isNotAlreadyRegistered2(User user) {
		Optional<User> result = repository.findByCredentialEmail(user.getEmail());
		
		return result.isPresent() ? Optional.empty() : Optional.of(user);
	}
	
	public Optional<User> store(User user) {
		User savedUser = repository.save(user);
		
		return Optional.of(savedUser);
	}
		
}