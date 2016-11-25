package com.acme.care.model.user.builder;

import com.acme.care.model.user.Location;

import static com.acme.care.support.UserProperty.*;
import static com.natpryce.makeiteasy.Property.newProperty;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;

public class LocationMaker {
	
	public static final Property<Location, String> city = newProperty();
	
	public static final Property<Location, String> state = newProperty();
	
	public static final Property<Location, String> zip = newProperty();
	
	public static final Instantiator<Location> Location = new Instantiator<Location>() {
		@Override
		public Location instantiate(PropertyLookup<Location> lookup) {
			Location email = new Location(
					lookup.valueOf(city, USER_CITY),
					lookup.valueOf(state, USER_STATE),
					lookup.valueOf(zip, USER_ZIP));

			return email;
		}
	};
}