package com.lifemagazine.scrapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifemagazine.scrapper.domain.P2pSchedule;


public interface P2pScheduleRepository extends JpaRepository<P2pSchedule, String> {
	
}
