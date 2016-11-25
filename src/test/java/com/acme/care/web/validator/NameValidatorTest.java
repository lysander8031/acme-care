package com.acme.care.web.validator;

import static com.acme.care.model.user.builder.NameMaker.*;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;

import org.junit.Test;
import org.springframework.validation.Validator;

import com.acme.care.model.user.Name;

public class NameValidatorTest extends AbstractValidatorTest {
	
	private Name name;
	
	@Override
	public Validator getValidator() {
		return new NameValidator();
	}
	
	@Test
	public void shouldPassValidationWhenNameIsValid() {
		enterValidName();
		
		validate(name);
		
		assertHasNoErrors();
	}
	
	@Test
	public void shouldFailValidationWhenFirstNameIsInvalid() {
		enterInvalidFirstName();
		
		validate(name);
		
		assertHasErrorsForField("firstName");
	}
	
	@Test
	public void shouldFailValidationWhenLastNameIsInvalid() {
		enterInvalidLastName();
		
		validate(name);
		
		assertHasErrorsForField("lastName");
	}
	
	private void enterValidName() {
		this.name = make(a(Name));
		super.bindProperty(this.name);
	}
	
	private void enterInvalidFirstName() {
		this.name = make(a(Name, with(firstName, "")));
		super.bindProperty(this.name);
	}
	
	private void enterInvalidLastName() {
		this.name = make(a(Name, with(lastName, "")));
		super.bindProperty(this.name);
	}
	
}