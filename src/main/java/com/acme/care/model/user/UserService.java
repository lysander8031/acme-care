package com.acme.care.model.user;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public interface UserService {
	
	public Function<User, Optional<User>> register = user -> {
		/*if (user instanceof CareSeeker) {
			return Optional.of(
					new CareSeeker(
							user.getName(), user.getAddress(),
							user.getCredential(), Status.REGISTERED));
		}
		else  {
			return Optional.of(
					new CareGiver(
							user.getName(), user.getAddress(),
							user.getCredential(), Status.REGISTERED));
		}*/
		
		/*User registeredUser = new User(
				user.getName(), user.getAddress(), 
				user.getCredential(), Status.REGISTERED);
		
		return Optional.of(registeredUser);*/
		
		user.register();
		
		return Optional.of(user);
	};
	
	public Predicate<User> isRegistered = user -> {
		return Status.REGISTERED.equals(user.getStatus());
	};
	
	public Predicate<Password> isWeak = password -> {
		final int STRENGTH_THRESHOLD = 6;
		
		return password.length() < STRENGTH_THRESHOLD;
	};
	
} 
