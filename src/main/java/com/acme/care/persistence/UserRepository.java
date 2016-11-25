package com.acme.care.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.care.model.user.Email;
import com.acme.care.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByCredentialEmail(Email email);

}