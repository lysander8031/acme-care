package com.acme.care.features;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

//@RunWith(CucumberWithSerenity.class)
@RunWith(Cucumber.class)
@CucumberOptions(
		glue = {"com.acme.care.features", "cucumber.api.spring"},
		features="classpath:features", 
		snippets=SnippetType.CAMELCASE)
public class AllAcceptanceTestSuite {}