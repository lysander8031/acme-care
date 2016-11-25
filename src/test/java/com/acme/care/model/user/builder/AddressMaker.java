package com.acme.care.model.user.builder;

import static com.acme.care.model.user.builder.LocationMaker.Location;
import static com.acme.care.support.UserProperty.*;
import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;

import com.acme.care.model.user.Address;
import com.acme.care.model.user.Location;

import static com.natpryce.makeiteasy.Property.newProperty;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;

public class AddressMaker {
	
	public static final Property<Address, String> street = newProperty();
	
	public static final Property<Address, String> city = newProperty();
	
	public static final Property<Address, Location> location = newProperty();
	
	public static final Instantiator<Address> Address = new Instantiator<Address>() {
		@Override
		public Address instantiate(PropertyLookup<Address> lookup) {
			Address email = new Address(
					lookup.valueOf(street, USER_STREET),
					location(lookup));

			return email;
		}
	};
	
	private static Location location(PropertyLookup<Address> lookup) {
		String userCity = lookup.valueOf(city, USER_CITY);	
		
		Location location = make(a(Location, with(LocationMaker.city, userCity)));
		
		return location;
	}
}