package com.lifemagazine.scrapper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lifemagazine.scrapper.domain.P2pScheduleSub;
import com.lifemagazine.scrapper.repository.P2pScheduleSubRepository;

@Component
public class P2pScheduleSubService {

	@Autowired(required=true)
	P2pScheduleSubRepository service;
	
	public P2pScheduleSub save(P2pScheduleSub p2pScheduleSub) {
		return service.save(p2pScheduleSub);
	}
}
