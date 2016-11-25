package com.acme.care.model.specification;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.acme.care.model.specification.user.RegisteredUserSpecificationTest;
import com.acme.care.model.specification.user.StrongPasswordSpecificationTest;

@RunWith(Suite.class)
@SuiteClasses({
	RegisteredUserSpecificationTest.class,
	StrongPasswordSpecificationTest.class
})
public class AllSpecificationTestSuite { }