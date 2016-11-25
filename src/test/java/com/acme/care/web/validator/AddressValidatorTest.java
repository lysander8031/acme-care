package com.acme.care.web.validator;

import static com.acme.care.model.user.builder.AddressMaker.*;
import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;

import org.junit.Test;
import org.springframework.validation.Validator;

import com.acme.care.model.user.Address;

public class AddressValidatorTest extends AbstractValidatorTest {
	
	private Address address;
	
	@Override
	public Validator getValidator() {
		return new AddressValidator();
	}
	
	@Test
	public void shouldPassValidationWhenAddressIsValid() {
		enterValidAddress();
		
		validate(address);
		
		assertHasNoErrors();
	}
	
	@Test
	public void shouldFailValidationWhenStreetIsInvalid() {
		enterInvalidStreet();
		
		validate(address);
		
		assertHasErrorsForField("street");
	}
	
	@Test
	public void shouldFailValidationWhenCityIsInvalid() {
		enterInvalidCity();
		
		validate(address);
		
		assertHasErrorsForField("location.city");
	}

	private void enterValidAddress() {
		this.address = make(an(Address));
		super.bindProperty(this.address);
	}
	
	private void enterInvalidStreet() {
		this.address = make(an(Address, with(street, "")));
		super.bindProperty(this.address);
	}
	
	private void enterInvalidCity() {
		this.address = make(an(Address, with(city, "")));
		super.bindProperty(this.address);
	}
	
}