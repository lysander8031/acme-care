Feature: Register with regular account

Scenario: Register a new user
	Given I am not a registered user
	When I submit valid registration details
	Then I should be registered
	And I should receive a registration email
	
Scenario: Register an existing user
	Given I am a registered user
	When I submit already existing registration details
	Then I should not be allowed to register