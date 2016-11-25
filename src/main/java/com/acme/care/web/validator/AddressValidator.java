package com.acme.care.web.validator;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.acme.care.model.user.Address;

@Component
public class AddressValidator implements Validator {

	public AddressValidator() {}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Address.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		checkNotNull(target);
		checkNotNull(errors);
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "street.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location.city", "city.required");
	}

}