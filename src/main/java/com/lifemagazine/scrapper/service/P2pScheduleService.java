package com.lifemagazine.scrapper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lifemagazine.scrapper.domain.P2pSchedule;
import com.lifemagazine.scrapper.repository.P2pScheduleRepository;

@Component
public class P2pScheduleService {

	@Autowired(required=true)
	P2pScheduleRepository service;
	
	public P2pSchedule save(P2pSchedule p2pSchedule) {
		return service.save(p2pSchedule);
	}
}
