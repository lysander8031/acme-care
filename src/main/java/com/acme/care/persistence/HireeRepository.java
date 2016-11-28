package com.acme.care.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.acme.care.model.user.CareGiver;
import com.acme.care.model.user.CareSeeker;
import com.acme.care.model.user.Hiree;

public interface HireeRepository extends JpaRepository<Hiree, Long> {

	@Query("select h.hired from Hiree h where h.hirer = :careSeeker")
	public List<CareGiver> findAllCareGiversHiredBy(@Param("careSeeker") CareSeeker careSeeker);
	
}