package com.acme.care.model.user;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class UserFactory {
	
	private static final Map<String, User> userStore = 
			ImmutableMap.of(
					"Martin", createUserMartin(), 
					"Alice", createUserAlice()
			);
	
	private UserFactory() {}
	
	public static User createUser() {
		return createUserMartin();
	}

	public static User createUserWithName(String name) {
		return userStore.get(name);
	}
	
	private static User createUserMartin() {
		Name name = new Name("Martin", "Jones");
		
		String street = "1801 Hayes Str";
		Location location = new Location("San Francisco", "CA", "94117");
		Address address = new Address(street, location);
		
		
		Email email = new Email("martin@domain.com");
		Password password = new Password("secret");
		Credential credential = new Credential(email, password);
		
		User user = new User(name, address, credential);
		
		return user;
	}
	
	private static User createUserAlice() {
		Name name = new Name("Alice", "Perry");
		
		String street = "673 Catalpa Ave";
		Location location = new Location("Chicago", "IL", "60346");
		Address address = new Address(street, location);
		
		Email email = new Email("alice@domain.com");
		Password password = new Password("strong");
		Credential credential = new Credential(email, password);
		
		User user = new User(name, address, credential);
		
		return user;
	}

}