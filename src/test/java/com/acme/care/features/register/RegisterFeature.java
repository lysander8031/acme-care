package com.acme.care.features.register;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;

import com.acme.care.features.CucumberConfig;
import com.acme.care.model.user.User;
import com.acme.care.persistence.UserRepository;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// http://stackoverflow.com/questions/35779758/no-test-results-with-eclipse-maven-cucumber-serenity
@CucumberConfig
public class RegisterFeature {
	
	private User user;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RegistrerFeatureSteps step;
	
	@Given("I am not a registered user")
	public void i_am_not_registered_user() throws Throwable {
		user = step.createNotRegisteredUser();
	}

	@When("I submit valid registration details")
	public void i_submit_valid_registration_details() throws Throwable {
		step.validateRegistrationDetailsAndRegister(user);
	}

	@Then("I should be registered")
	public void i_should_be_registered() throws Throwable {
	    assertTrue(user.isRegistered());
	}

	@Then("I should receive a registration email")
	public void i_should_receive_registration_email() throws Throwable {
	    throw new PendingException();
	}

	@Given("I am a registered user")
	public void i_am_registered_user() throws Throwable {
		user = step.createNotRegisteredUser();
		user = userRepository.save(user);
	}

	@When("I submit already existing registration details")
	public void i_submit_already_existing_registration_details() throws Throwable {
		step.validateRegistrationDetailsAndRegister(user);
	}

	@Then("I should not be allowed to register")
	public void i_should_not_be_allowed_to_register() throws Throwable {
		assertFalse(user.isRegistered());
	}

}