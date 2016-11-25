package com.acme.care.model.user;

import static com.google.common.base.Preconditions.checkNotNull;

import com.acme.care.model.common.Immutable;
import com.acme.care.model.common.ValueObject;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Immutable @ValueObject
public class Location {
	
	private String city;
	
	private String state;
	
	private String zip;

	protected Location() {}
	
	public Location(String city, String state, String zip) {
		checkNotNull(city);
		checkNotNull(state);
		checkNotNull(zip);
		
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof Location)) return false;
		
		final Location that = (Location) obj;
		
		return Objects.equal(this.city, that.city)
			&& Objects.equal(this.state, that.state)
			&& Objects.equal(this.zip, that.zip);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.city, this.state, this.zip);
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				  .add("city", this.city)
				  .add("state", this.state)
				  .add("zip", this.zip)
				  .toString();
	}
	
}