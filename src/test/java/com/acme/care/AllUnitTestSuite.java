package com.acme.care;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.acme.care.model.AllModelTestSuite;
import com.acme.care.model.specification.AllSpecificationTestSuite;
import com.acme.care.service.AllServiceTestSuite;
import com.acme.care.web.validator.AllValidatorTestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	AllModelTestSuite.class,
	AllServiceTestSuite.class,
	AllSpecificationTestSuite.class,
	AllValidatorTestSuite.class
})
public class AllUnitTestSuite { }