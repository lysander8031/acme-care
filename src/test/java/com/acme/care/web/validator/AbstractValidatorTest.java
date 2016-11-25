package com.acme.care.web.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class AbstractValidatorTest {
	
	private Errors errors;
	
	public AbstractValidatorTest() { 
		errors = new BeanPropertyBindingResult(new Object(), "target");
	}
	
	public void bindProperty(Object target) {
		this.errors = new BeanPropertyBindingResult(target, "target");
	}
	
	public void validate(Object target) {
		this.getValidator().validate(target, this.errors);
	}
	
	public void assertHasNoErrors() {
		assertFalse(this.errors.hasErrors()); 
	}
	
	public void assertHasErrorsForField(String fieldName) {
		assertTrue(this.errors.hasErrors()); 
		assertEquals(fieldName, this.errors.getFieldError().getField()); 
	}
	
	public abstract Validator getValidator();

}