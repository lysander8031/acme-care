package com.acme.care;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.acme.care.persistence.AllPersistenceTestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	AllPersistenceTestSuite.class
})
public class AllIntegrationTestSuite { }