package com.acme.care.model.user.builder;

import com.acme.care.model.user.Email;

import static com.acme.care.support.UserProperty.*;
import static com.natpryce.makeiteasy.Property.newProperty;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;

public class EmailMaker {
	
	public static final Property<Email, String> value = newProperty();
	
	public static final Instantiator<Email> Email = new Instantiator<Email>() {
		@Override
		public Email instantiate(PropertyLookup<Email> lookup) {
			Email email = new Email(lookup.valueOf(value, USER_EMAIL));

			return email;
		}
	};
}