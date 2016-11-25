package com.acme.care.service;

import java.util.Optional;

import com.acme.care.model.user.User;

public interface RegistrationService {

	public Optional<User> register(User user);

}