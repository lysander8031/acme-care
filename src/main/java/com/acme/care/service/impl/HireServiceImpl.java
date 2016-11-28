package com.acme.care.service.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.care.model.user.CareGiver;
import com.acme.care.model.user.CareSeeker;
import com.acme.care.model.user.Hiree;
import com.acme.care.persistence.HireeRepository;
import com.acme.care.service.HireService;

@Service
public class HireServiceImpl implements HireService {

	private final HireeRepository repository;

	public HireServiceImpl(HireeRepository repository) {
		checkNotNull(repository);
		
		this.repository = repository;
	}

	@Override
	@Transactional
	public Optional<Hiree> hire(CareSeeker careSeeker, CareGiver careGiver) {
		checkNotNull(careSeeker);
		checkNotNull(careGiver);
		
		Hiree hiree = careSeeker.hire(careGiver);

		repository.save(hiree);
		
		return Optional.of(hiree);
	}

}
