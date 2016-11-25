package com.acme.care.web.validator;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.acme.care.model.user.Address;
import com.acme.care.model.user.Email;
import com.acme.care.model.user.Name;
import com.acme.care.model.user.Password;
import com.acme.care.model.user.User;

@Component
public class UserValidator implements Validator {

	private Validator addressValidator;
	
	private Validator emailValidator;
	
	private Validator nameValidator;
	
	private Validator passwordValidator;
	
	public UserValidator(
			Validator addressValidator, Validator emailValidator, 
			Validator nameValidator, Validator passwordValidator) {
	
		checkNotNull(addressValidator);
		checkNotNull(emailValidator);
		checkNotNull(nameValidator);
		checkNotNull(passwordValidator);
		
		this.addressValidator = addressValidator;
		this.emailValidator = emailValidator;
		this.nameValidator = nameValidator;
		this.passwordValidator = passwordValidator;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		checkNotNull(target);
		checkNotNull(errors);
		
		User user = (User) target;
		
		validateName(user.getName(), errors);
		
		validateAddress(user.getAddress(), errors);
		
		validateEmail(user.getCredential().getEmail(), errors);
		
		validatePassword(user.getCredential().getPassword(), errors);
	}
	
	private void validateName(Name name, Errors errors) {
		validate(name, errors, this.nameValidator, "name");
	}
	
	private void validateAddress(Address address, Errors errors) {
		validate(address, errors, this.addressValidator, "address");
	}
	
	private void validateEmail(Email email, Errors errors) {
		validate(email, errors, this.emailValidator, "credential.email");
	}
	
	private void validatePassword(Password password, Errors errors) {
		validate(password, errors, this.passwordValidator, "credential.password");
	}
	
	private void validate(Object target, Errors errors, Validator validator, String propertyPath) {
		try {
			errors.pushNestedPath(propertyPath);
				
			ValidationUtils.invokeValidator(validator, target, errors);
		} finally {
			errors.popNestedPath();
		}	
	}

}