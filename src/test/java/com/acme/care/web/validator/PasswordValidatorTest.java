package com.acme.care.web.validator;

import static com.acme.care.model.user.builder.PasswordMaker.*;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;

import org.junit.Test;

import org.springframework.validation.Validator;

import com.acme.care.model.user.Password;

public class PasswordValidatorTest extends AbstractValidatorTest {
	
	private Password password;
	
	@Override
	public Validator getValidator() {
		return new PasswordValidator();
	}
	
	@Test
	public void shouldPassValidationWhenPasswordIsValid() {
		enterValidPassword();
		
		validate(password);
		
		assertHasNoErrors();
	}
	
	@Test
	public void shouldFailValidationWhenPasswordIsEmpty() {
		enterEmptyPassword();
		
		validate(password);
		
		assertHasErrorsForField("value");
	}
	
	@Test
	public void shouldFailValidationWhenPasswordIsWeak() {
		enterWeakPassword();
		
		validate(password);
		
		assertHasErrorsForField("value");
	}
	
	private void enterValidPassword() {
		this.password = make(a(Password));
		super.bindProperty(this.password);
	}
	
	private void enterEmptyPassword() {
		this.password = make(a(Password, with(value, "")));
		super.bindProperty(this.password);
	}
	
	private void enterWeakPassword() {
		this.password = make(a(Password, with(value, "weak")));
		super.bindProperty(this.password);
	}

}