package com.acme.care.web.validator;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.acme.care.model.user.Name;

@Component
public class NameValidator implements Validator {

	public NameValidator() { }

	@Override
	public boolean supports(Class<?> clazz) {
		return Name.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		checkNotNull(target);
		checkNotNull(errors);
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");
	}

}