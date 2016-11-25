package com.acme.care.web.validator;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.acme.care.model.user.Password;

@Component
public class PasswordValidator implements Validator {
	
	public PasswordValidator() {}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Password.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		checkNotNull(target);
		checkNotNull(errors);
		
		Password password = (Password) target;
		
		rejectIfEmpty(password, errors);
		
		rejectIfWeak(password, errors);
	}
	
	private void rejectIfEmpty(Password password, Errors errors) {
		if (! errors.hasErrors()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "value", "password.required");
		}
	}
	
	private void rejectIfWeak(Password password, Errors errors) {
		if (! errors.hasErrors()) {
			if (password.isWeak()) {
				errors.rejectValue("value", "password.invalid");
			}
		}
	}
	
}