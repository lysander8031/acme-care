package com.acme.care.features.register;

import static com.acme.care.model.user.builder.UserMaker.CareSeeker;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.acme.care.model.user.User;
import com.acme.care.persistence.UserRepository;
import com.acme.care.service.RegistrationService;

@Component
public class RegistrerFeatureSteps {

	private Validator userValidator;
	
	private RegistrationService service;
	
	private UserRepository userRepository;
	
	public RegistrerFeatureSteps(RegistrationService service, Validator userValidator, UserRepository userRepository) {
		checkNotNull(service);
		checkNotNull(userValidator);
		checkNotNull(userRepository);
		
		this.service = service;
		this.userValidator = userValidator; 
		this.userRepository = userRepository;
	}
	
	public User createRegisteredUser() {
		return userRepository.save(createNotRegisteredUser());
	}
	
	public User createNotRegisteredUser() {
		return make(a(CareSeeker));
	}
	
	public Optional<User> validateRegistrationDetailsAndRegister(User user) {
		if (isValid(user))
			return register(user);
		
		return Optional.empty();
	}	
	
	private boolean isValid(User user) {
		checkNotNull(user);
		
		Errors errors = new BeanPropertyBindingResult(user, "user");
		
		userValidator.validate(user, errors);
		
		return ! errors.hasErrors();
	}
	
	private Optional<User> register(User user) {
		return service.register(user);
	}
}