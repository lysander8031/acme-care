package com.acme.care.model.user.builder;

import com.acme.care.model.user.Password;

import static com.acme.care.support.UserProperty.*;
import static com.natpryce.makeiteasy.Property.newProperty;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;

public class PasswordMaker {
	
	public static final Property<Password, String> value = newProperty();
	
	public static final Instantiator<Password> Password = new Instantiator<Password>() {
		@Override
		public Password instantiate(PropertyLookup<Password> lookup) {
			Password password = new Password(lookup.valueOf(value, USER_PASSWORD));

			return password;
		}
	};
}