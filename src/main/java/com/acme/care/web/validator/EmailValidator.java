package com.acme.care.web.validator;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.acme.care.model.user.Email;

@Component
public class EmailValidator implements Validator {
	
	public EmailValidator() {}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Email.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		checkNotNull(target);
		checkNotNull(errors);
		
		Email email = (Email) target;
		
		rejectIfEmpty(email, errors);
		
		rejectIfInvalid(email, errors);
	}
	
	private void rejectIfEmpty(Email email, Errors errors) {
		if (! errors.hasErrors()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "value", "email.required");
		}
	}
	
	private void rejectIfInvalid(Email email, Errors errors) {
		if (! errors.hasErrors()) {
			if (! isValid(email)) {
				errors.rejectValue("value", "email.invalid");
			}
		}
	}

	private boolean isValid(Email email) {
		return org.apache.commons.validator.routines.EmailValidator.getInstance().isValid(email.getValue());
	}

}