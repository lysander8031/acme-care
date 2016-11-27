package com.acme.care.features.register;

import static com.acme.care.model.user.builder.UserMaker.CareSeeker;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;

import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.acme.care.model.user.User;
import com.acme.care.service.RegistrationService;

@Component
public class RegistrerFeatureSteps {

	private Validator userValidator;
	
	private RegistrationService service;
	
	public RegistrerFeatureSteps(RegistrationService service, Validator userValidator) {
		checkNotNull(service);
		checkNotNull(userValidator);
		
		this.service = service;
		this.userValidator = userValidator; 
	}
	
	public User createNotRegisteredUser() {
		return make(a(CareSeeker));
	}
	
	public void register(User user) {
		service.register(user);
	}
	
	public void validateRegistrationDetailsAndRegister(User user) {
		if (isValid(user))
			register(user);
	}	
	
	private boolean isValid(User user) {
		checkNotNull(user);
		
		Errors errors = new BeanPropertyBindingResult(user, "user");
		
		userValidator.validate(user, errors);
		
		return ! errors.hasErrors();
	}

}