package com.acme.care.model.user.builder;

import com.acme.care.model.user.Name;

import static com.acme.care.support.UserProperty.*;
import static com.natpryce.makeiteasy.Property.newProperty;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;

public class NameMaker {
	
	public static final Property<Name, String> firstName = newProperty();
	
	public static final Property<Name, String> lastName = newProperty();
	
	public static final Instantiator<Name> Name = new Instantiator<Name>() {
		@Override
		public Name instantiate(PropertyLookup<Name> lookup) {
			Name name = new Name(
					lookup.valueOf(firstName, USER_FIRST_NAME), 
					lookup.valueOf(lastName, USER_LAST_NAME));

			return name;
		}
	};
	
}