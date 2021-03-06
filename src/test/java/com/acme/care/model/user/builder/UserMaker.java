package com.acme.care.model.user.builder;

import static com.acme.care.model.user.builder.EmailMaker.*;
import static com.acme.care.model.user.builder.LocationMaker.*;
import static com.acme.care.model.user.builder.PasswordMaker.*;
import static com.acme.care.support.UserProperty.*;

import com.acme.care.model.user.Address;
import com.acme.care.model.user.CareGiver;
import com.acme.care.model.user.CareSeeker;
import com.acme.care.model.user.Credential;
import com.acme.care.model.user.Email;
import com.acme.care.model.user.Location;
import com.acme.care.model.user.Name;
import com.acme.care.model.user.Password;
import com.acme.care.model.user.User;

import static com.natpryce.makeiteasy.MakeItEasy.*;

import static com.natpryce.makeiteasy.Property.newProperty;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;

// https://github.com/npryce/make-it-easy
public class UserMaker {
	
	public static final Property<User, String> firstName = newProperty();
	
	public static final Property<User, String> lastName = newProperty();
	
	public static final Property<User, String> street = newProperty();
	
	public static final Property<User, String> city = newProperty();
	
	public static final Property<User, String> email = newProperty();
	
	public static final Property<User, String> password = newProperty();
	
	public static final Property<CareGiver, Integer> age = newProperty();
	
	public static final Instantiator<CareSeeker> CareSeeker = new Instantiator<CareSeeker>() {
		@Override
		public CareSeeker instantiate(PropertyLookup<CareSeeker> lookup) {
			CareSeeker user = new CareSeeker(
					name(lookup),
					address(lookup), 
					credential(lookup));
			
			return user;
		}
	};
	
	public static final Instantiator<CareGiver> CareGiver = new Instantiator<CareGiver>() {
		@Override
		public CareGiver instantiate(PropertyLookup<CareGiver> lookup) {
			CareGiver user = new CareGiver(
					name(lookup),
					address(lookup), 
					credential(lookup),
					age(lookup));
			
			return user;
		}
	};
	
	private static Name name(PropertyLookup<? extends User> lookup) {
		String first = lookup.valueOf(firstName, USER_FIRST_NAME);	
		String last = lookup.valueOf(lastName, USER_LAST_NAME);	
		
		return new Name(first, last);
	}
	
	private static Address address(PropertyLookup<? extends User> lookup) {
		String userStreet = lookup.valueOf(street, USER_STREET);	
		String userCity = lookup.valueOf(city, USER_CITY);	
		
		Location location = make(a(Location, with(LocationMaker.city, userCity)));
		
		return new Address(userStreet, location);
	}
	
	private static Credential credential(PropertyLookup<? extends User> lookup) {
		String userEmail = lookup.valueOf(email, USER_EMAIL);	
		String userPassword = lookup.valueOf(password, USER_PASSWORD);	
		
		Email email = make(an(Email, with(EmailMaker.value, userEmail)));
		Password password = make(a(Password, with(PasswordMaker.value, userPassword)));
		
		return new Credential(email, password);
	}
	
	
	private static Integer age(PropertyLookup<CareGiver> lookup) {
		return lookup.valueOf(age, CARE_GIVER_AGE);	
	}
	
}