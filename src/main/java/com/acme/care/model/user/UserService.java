package com.acme.care.model.user;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import com.acme.care.model.specification.user.RegisteredUserSpecification;
import com.acme.care.model.specification.user.StrongPasswordSpecification;

public interface UserService {
	
	public UnaryOperator<User> register = user -> {
		return new User(user.getName(), user.getAddress(), user.getCredential(), Status.REGISTERED);
	};
	
	public Predicate<User> isRegistered = user -> {
		return new RegisteredUserSpecification().isSatisfiedBy(user);
	};
	
	public Predicate<Password> isWeak = password -> {
		return new StrongPasswordSpecification().isSatisfiedBy(password);
	};
	
	/*default Supplier<User> register() {
		//user.register();
		
		//user.status = Status.REGISTERED;
		
		return () -> new User(this.);
	}*/
} 
