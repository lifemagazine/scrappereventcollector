package com.lifemagazine.scrapper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lifemagazine.scrapper.domain.VesselSchedule;
import com.lifemagazine.scrapper.repository.VesselScheduleRepository;

@Component
public class VesselScheduleService {

	@Autowired(required=true)
	VesselScheduleRepository service;
	
	public VesselSchedule save(VesselSchedule vesselSchedule) {
		return service.save(vesselSchedule);
	}
}
