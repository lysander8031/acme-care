package com.acme.care.model.user;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.acme.care.model.common.EntityObject;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@EntityObject
public class Hiree extends AbstractPersistable<Long> implements Serializable {
	private static final long serialVersionUID = 5300794461073063828L;

	private CareSeeker hirer;
	
	private CareGiver hired;
	
	protected Hiree(){ }
	
	public Hiree(CareSeeker hirer, CareGiver hired) {
		checkNotNull(hirer);
		checkNotNull(hired);
		
		this.hirer = hirer;
		this.hired = hired;
	}

	public CareSeeker getHirer() {
		return hirer;
	}

	public CareGiver getHired() {
		return hired;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof Hiree)) return false;
		
		final Hiree that = (Hiree) obj;
		
		return Objects.equal(this.hirer, that.hirer)
			&& Objects.equal(this.hired, that.hired);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.hirer, this.hired);
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				  .add("id", super.getId())
				  .add("hirer", this.hirer)
				  .add("hired", this.hired)
				  .toString();
	}

}