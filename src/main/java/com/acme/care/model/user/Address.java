package com.acme.care.model.user;

import static com.google.common.base.Preconditions.checkNotNull;

import com.acme.care.model.common.Immutable;
import com.acme.care.model.common.ValueObject;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Immutable @ValueObject
public class Address {
	
	private String street;
	
	private Location location;

	protected Address() {}
	
	public Address(String street, Location location) {
		checkNotNull(street);
		checkNotNull(location);
		
		this.street = street;
		this.location = location;
	}

	public String getStreet() {
		return street;
	}

	public Location getLocation() {
		return location;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof Address)) return false;
		
		final Address that = (Address) obj;
		
		return Objects.equal(this.street, that.street)
			&& Objects.equal(this.location, that.location);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.street, this.location);
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				  .add("street", this.street)
				  .add("location", this.location)
				  .toString();
	}
	
}