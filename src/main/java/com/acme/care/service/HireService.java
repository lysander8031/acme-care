package com.acme.care.service;

import java.util.Optional;

import com.acme.care.model.user.CareGiver;
import com.acme.care.model.user.CareSeeker;
import com.acme.care.model.user.Hiree;

public interface HireService {

	Optional<Hiree> hire(CareSeeker careSeeker, CareGiver careGiver);

}
