package com.lifemagazine.scrapper.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifemagazine.scrapper.amqp.MessageSender;
import com.lifemagazine.scrapper.domain.CheckSchedLog;
import com.lifemagazine.scrapper.domain.VesselSchedule;
import com.lifemagazine.scrapper.service.CheckSchedLogService;
import com.lifemagazine.scrapper.service.ScrapperInfoService;
import com.lifemagazine.scrapper.service.VesselScheduleService;
import com.lifemagazine.scrapper.util.Utility;

@RestController
@RequestMapping("api/vesselschedule")
public class VesselScheduleRestController {
	
	@Value("${spring.dbinsert.vesselschedule.scrappertype}")
	private String scrapperType;
	
	@Autowired
	private VesselScheduleService service;
	
	@Autowired
    private MessageSender checkSchedLogSender;
	
	@Autowired
	private CheckSchedLogService checkSchedLogService;
	
	@Autowired
	private ScrapperInfoService scrapperInfoService;
	
	@RequestMapping(method=RequestMethod.POST)
	public VesselSchedule create(@RequestBody VesselSchedule vesselSchedule) {
		VesselSchedule vs = service.save(vesselSchedule);
		
		if (vs != null) {
			CheckSchedLog checkSchedLog = new CheckSchedLog();
			checkSchedLog.setErrorMsg(null);
			checkSchedLog.setResultYn("Y");
			checkSchedLog.setModifyUser(CheckSchedLogRestController.MODIFY_USER);
			checkSchedLog.setModifyDate(Utility.getCurrentTime(null));
			Utility.saveCheckSchedLogNsendMsg(checkSchedLog, vesselSchedule.getShprCd(), scrapperType,
					checkSchedLogService, checkSchedLogSender, scrapperInfoService);
		}
		
		return vs;
	}
}
