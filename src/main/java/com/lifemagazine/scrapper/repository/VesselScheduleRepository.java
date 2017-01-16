package com.lifemagazine.scrapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifemagazine.scrapper.domain.VesselSchedule;


public interface VesselScheduleRepository extends JpaRepository<VesselSchedule, String> {
	
}