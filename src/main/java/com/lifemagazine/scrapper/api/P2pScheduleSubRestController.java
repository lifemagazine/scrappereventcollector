package com.lifemagazine.scrapper.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifemagazine.scrapper.amqp.MessageSender;
import com.lifemagazine.scrapper.domain.CheckSchedLog;
import com.lifemagazine.scrapper.domain.P2pScheduleSub;
import com.lifemagazine.scrapper.service.CheckSchedLogService;
import com.lifemagazine.scrapper.service.P2pScheduleSubService;
import com.lifemagazine.scrapper.service.ScrapperInfoService;
import com.lifemagazine.scrapper.util.Utility;

@RestController
@RequestMapping("api/p2pschedulesub")
public class P2pScheduleSubRestController {
	
	@Value("${spring.dbinsert.p2pschedulesub.scrappertype}")
	private String scrapperType;
	
	@Autowired
	private P2pScheduleSubService service;
	
	@Autowired
    private MessageSender checkSchedLogSender;
	
	@Autowired
	private CheckSchedLogService checkSchedLogService;
	
	@Autowired
	private ScrapperInfoService scrapperInfoService;

	
	@RequestMapping(method=RequestMethod.POST)
	public P2pScheduleSub create(@RequestBody P2pScheduleSub p2pScheduleSub) {
		P2pScheduleSub ps = service.save(p2pScheduleSub);
		if (ps != null) {
			CheckSchedLog checkSchedLog = new CheckSchedLog();
			checkSchedLog.setErrorMsg(null);
			checkSchedLog.setResultYn("Y");
			checkSchedLog.setModifyUser(CheckSchedLogRestController.MODIFY_USER);
			checkSchedLog.setModifyDate(Utility.getCurrentTime(null));
			Utility.saveCheckSchedLogNsendMsg(checkSchedLog, p2pScheduleSub.getShprCd(), scrapperType,
					checkSchedLogService, checkSchedLogSender, scrapperInfoService);
		}
		
		return ps;
	}
}
