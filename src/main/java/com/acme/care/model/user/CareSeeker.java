package com.acme.care.model.user;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Objects;

public class CareSeeker extends User {
	private static final long serialVersionUID = -5460511448514629352L;
	
	private CareServiceType careService;
	
	protected CareSeeker() {}
	
	public CareSeeker(Name name, Address address, Credential credential) {
		this(name, address, credential, Status.NOTREGISTERED);
	}
	
	public CareSeeker(Name name, Address address, Credential credential, Status status) {
		this(name, address, credential, status, CareServiceType.CHILD_CARE);
	}
	
	public CareSeeker(Name name, Address address, Credential credential, Status status, CareServiceType careService) {
		super(name, address, credential, status);
		
		checkNotNull(careService);
		
		this.careService = careService;
	}

	public CareServiceType getCareService() {
		return careService;
	}

	public void setCareService(CareServiceType careService) {
		this.careService = careService;
	}
	
	public Hiree hire(CareGiver careGiver) {
		return new Hiree(this, careGiver);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof CareSeeker)) return false;
		
		final CareSeeker that = (CareSeeker) obj;
		
		return Objects.equal(super.getId(), that.getId())
			&& Objects.equal(super.getName(), that.getName())
			&& Objects.equal(super.getAddress(), that.getAddress())
			&& Objects.equal(super.getCredential(), that.getCredential())
			&& Objects.equal(this.getCareService(), that.getCareService());
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(
				super.getId(), this.getName(), this.getAddress(), 
				this.getCredential(), this.getCareService());
	}
	
	@Override
	public ToStringHelper toStringHelper() {
		return super.toStringHelper()
					.add("careService", this.careService);
	}

}