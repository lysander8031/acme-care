package com.acme.care.web.validator;

import static com.acme.care.model.user.builder.UserMaker.User;
import static com.acme.care.model.user.builder.UserMaker.city;
import static com.acme.care.model.user.builder.UserMaker.email;
import static com.acme.care.model.user.builder.UserMaker.firstName;
import static com.acme.care.model.user.builder.UserMaker.lastName;
import static com.acme.care.model.user.builder.UserMaker.password;
import static com.acme.care.model.user.builder.UserMaker.street;
import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.Validator;

import com.acme.care.model.user.User;
import com.acme.care.persistence.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserValidatorTest extends AbstractValidatorTest {
	
	@Mock
	private UserRepository repository;
	
	private User user;
	
	@Override
	public Validator getValidator() {
		return new UserValidator(
				new AddressValidator(), new EmailValidator(), 
				new NameValidator(), new PasswordValidator());
	}
	
	@Test
	public void shouldPassValidationWhenUserIsValid() {
		enterValidUser();
		
		validate(user);
		
		assertHasNoErrors();
	}
	
	@Test
	public void shouldFailValidationWhenFirstNameIsEmpty() {
		enterEmptyFirstName();
		
		validate(user);
		
		assertHasErrorsForField("name.firstName");
	}
	
	@Test
	public void shouldFailValidationWhenLastNameIsEmpty() {
		enterEmptyLastName();
		
		validate(user);
		
		assertHasErrorsForField("name.lastName");
	}
	
	@Test
	public void shouldFailValidationWhenStreetIsEmpty() {
		enterEmptyStreet();
		
		validate(user);
		
		assertHasErrorsForField("address.street");
	}
	
	@Test
	public void shouldFailValidationWhenCityIsEmpty() {
		enterEmptyCity();
		
		validate(user);
		
		assertHasErrorsForField("address.location.city");
	}
	
	@Test
	public void shouldFailValidationWhenEmailIsEmpty() {
		enterEmptyEmail();
		
		validate(user);
		
		assertHasErrorsForField("credential.email.value");
	}
	
	@Test
	public void shouldFailValidationWhenEmailIsInvalid() {
		enterInvalidEmail();
		
		validate(user);
		
		assertHasErrorsForField("credential.email.value");
	}
	
	@Test
	public void shouldFailValidationWhenPasswordIsEmpty() {
		enterEmptyPassword();
		
		validate(user);
		
		assertHasErrorsForField("credential.password.value");
	}
	
	@Test
	public void shouldFailValidationWhenPasswordIsWeak() {
		enterWeakPassword();
		
		validate(user);
		
		assertHasErrorsForField("credential.password.value");
	}
	
	private void enterValidUser() {
		this.user = make(an(User));
		super.bindProperty(this.user);
	}
	
	private void enterEmptyFirstName() {
		this.user = make(an(User, with(firstName, "")));
		super.bindProperty(this.user);
	}
	
	private void enterEmptyLastName() {
		this.user = make(an(User, with(lastName, "")));
		super.bindProperty(this.user);
	}
	
	private void enterEmptyStreet() {
		this.user = make(an(User, with(street, "")));
		super.bindProperty(this.user);
	}
	
	private void enterEmptyCity() {
		this.user = make(an(User, with(city, "")));
		super.bindProperty(this.user);
	}
	
	private void enterEmptyEmail() {
		this.user = make(an(User, with(email, "")));
		super.bindProperty(this.user);
	}
	
	private void enterInvalidEmail() {
		this.user = make(an(User, with(email, "no@good")));
		super.bindProperty(this.user);
	}
	
	private void enterEmptyPassword() {
		this.user = make(an(User, with(password, "")));
		super.bindProperty(this.user);
	}
	
	private void enterWeakPassword() {
		this.user = make(an(User, with(password, "weak")));
		super.bindProperty(this.user);
	}
	
}