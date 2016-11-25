package com.acme.care.model.user.builder;

import static com.acme.care.model.user.builder.EmailMaker.Email;
import static com.acme.care.model.user.builder.PasswordMaker.Password;

import static com.natpryce.makeiteasy.MakeItEasy.*;

import com.acme.care.model.user.Credential;
import com.acme.care.model.user.Email;
import com.acme.care.model.user.Password;

import static com.natpryce.makeiteasy.Property.newProperty;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;

public class CredentialMaker {
	
	public static final Property<Credential, Email> email = newProperty();
	
	public static final Property<Credential, Password> password = newProperty();
	
	public static final Instantiator<Credential> Credential = new Instantiator<Credential>() {
		@Override
		public Credential instantiate(PropertyLookup<Credential> lookup) {
			Credential credential = new Credential(
					lookup.valueOf(email, make(an(Email))),
					lookup.valueOf(password, make(a(Password))));

			return credential;
		}
	};
}