package com.acme.care.web.validator;

import static com.acme.care.model.user.builder.EmailMaker.*;
import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;

import org.junit.Test;

import org.springframework.validation.Validator;

import com.acme.care.model.user.Email;

public class EmailValidatorTest extends AbstractValidatorTest {
	
	private Email email;
	
	@Override
	public Validator getValidator() {
		return new EmailValidator();
	}
	
	@Test
	public void shouldPassValidationWhenNameIsValid() {
		enterValidEmail();
		
		validate(email);
		
		assertHasNoErrors();
	}
	
	@Test
	public void shouldFailValidationWhenEmailIsEmpty() {
		enterEmptyEmail();
		
		validate(email);
		
		assertHasErrorsForField("value");
	}
	
	@Test
	public void shouldFailValidationWhenEmailIsInvalid() {
		enterInvalidEmail();
		
		validate(email);
		
		assertHasErrorsForField("value");
	}
	
	private void enterValidEmail() {
		this.email = make(an(Email));
		super.bindProperty(this.email);
	}
	
	private void enterEmptyEmail() {
		this.email = make(an(Email, with(value, "")));
		super.bindProperty(this.email);
	}
	
	private void enterInvalidEmail() {
		this.email = make(an(Email, with(value, "no@domain")));
		super.bindProperty(this.email);
	}
	
}