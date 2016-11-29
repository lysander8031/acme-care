package com.acme.care;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		glue = {"com.acme.care.features", "com.acme.care.features.hooks"},
		features="classpath:features", 
		snippets=SnippetType.CAMELCASE)
public class AllAcceptanceTestSuite {}