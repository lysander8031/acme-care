package com.acme.care.features;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features="classpath:features", 
		snippets=SnippetType.CAMELCASE)
public class AllAcceptanceTestSuite {}