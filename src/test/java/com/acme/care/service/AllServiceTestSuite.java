package com.acme.care.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.acme.care.service.policy.RegistrationPolicyTest;

@RunWith(Suite.class)
@SuiteClasses({
	HireServiceTest.class,
	RegistrationPolicyTest.class,
	RegistrationServiceTest.class
})
public class AllServiceTestSuite {}