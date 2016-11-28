package com.acme.care.model.user;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class CareTeam {
	
	private List<Hiree> hirees = new ArrayList<>();
	
	public CareTeam() {}

	public void addHiree(CareSeeker careSeeker, CareGiver careGiver) {
		this.hirees.add(new Hiree(careSeeker, careGiver));
	}

	public boolean hasHiree(CareSeeker careSeeker, CareGiver careGiver) {
		return this.hirees.contains(new Hiree(careSeeker, careGiver));
	}

	public void removeHiree(CareSeeker careSeeker, CareGiver careGiver) {
		this.hirees.remove(new Hiree(careSeeker, careGiver));
	}

}