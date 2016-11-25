package com.acme.care.features.register;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;

import com.acme.care.features.CucumberConfig;
import com.acme.care.model.user.User;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@CucumberConfig
public class RegisterFeature {
	
	private User user;
	
	@Autowired
	private RegistrerFeatureSteps step;
	
	@Given("I am not a registered user")
	public void givenNotRegisteredUser() throws Throwable {
		user = step.createNotRegisteredUser();
	}

	@When("I submit valid registration details")
	public void whenISubmitValidRegistrationDetails() throws Throwable {
		step.validateRegistrationDetailsAndRegister(user);
	}

	@Then("I should be registered")
	public void shouldBeRegistered() throws Throwable {
	    assertTrue(user.isRegistered());
	}

	@Then("I should receive a registration email")
	public void shouldReceiveRegistrationEmail() throws Throwable {
	    throw new PendingException();
	}

	@Given("I am a registered user")
	public void givenRegisteredUser() throws Throwable {
		user = step.createNotRegisteredUser();
		 
		step.register(user);
	}

	@When("I submit already existing registration details")
	public void whenISubmitAlreadyExistingRegistrationDetails() throws Throwable {
		step.validateRegistrationDetailsAndRegister(user);
	}

	@Then("I should not be allowed to register")
	public void shouldNotBeAllowedToRegister() throws Throwable {
		assertFalse(user.isRegistered());
	}

}