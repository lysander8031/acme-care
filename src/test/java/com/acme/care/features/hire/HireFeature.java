package com.acme.care.features.hire;

import static com.acme.care.model.user.builder.UserMaker.*;
import static com.natpryce.makeiteasy.MakeItEasy.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.acme.care.features.CucumberConfig;
import com.acme.care.model.user.CareGiver;
import com.acme.care.model.user.CareSeeker;
import com.acme.care.model.user.Hiree;
import com.acme.care.service.HireService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@CucumberConfig
public class HireFeature {
	
	private CareSeeker careSeeker;
	
	private CareGiver careGiver;
	
	@Autowired
	private HireService service;

	private Hiree hiree;

	@Given("^I want to find care givers$")
	public void givenNotRegisteredUser() throws Throwable {
		careSeeker = make(a(CareSeeker, with(email, "martin@gmail.com")));
		careGiver = make(a(CareGiver, with(email, "alice@gmail.com")));
		
		assertTrue("No transaction is active", TransactionSynchronizationManager.isActualTransactionActive());
	}

	@When("^I hire a care giver$")
	public void whenISubmitValidRegistrationDetails() throws Throwable {
		Optional<Hiree> hire = service.hire(careSeeker, careGiver);
		hiree = hire.get();
	}

	@Then("^I should see care giver$")
	public void shouldBeRegistered() throws Throwable {
	    assertEquals(careGiver, hiree.getHired());
	}

}