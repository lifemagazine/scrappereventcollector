package com.lifemagazine.scrapper.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifemagazine.scrapper.TradlinxScrapperEventCollectorApplication;
import com.lifemagazine.scrapper.amqp.MessageSender;
import com.lifemagazine.scrapper.domain.CheckSchedLog;
import com.lifemagazine.scrapper.domain.P2pSchedule;
import com.lifemagazine.scrapper.service.CheckSchedLogService;
import com.lifemagazine.scrapper.service.P2pScheduleService;
import com.lifemagazine.scrapper.service.ScrapperInfoService;
import com.lifemagazine.scrapper.util.Utility;

@RestController
@RequestMapping("api/p2pschedule")
public class P2pScheduleRestController {
	
	private static final Logger LOG = LoggerFactory.getLogger(P2pScheduleRestController.class);
	
	@Value("${spring.dbinsert.p2pschedule.scrappertype}")
	private String scrapperType;
	
	@Autowired
	private P2pScheduleService service;
	
	@Autowired
    private MessageSender checkSchedLogSender;
	
	@Autowired
	private CheckSchedLogService checkSchedLogService;
	
	@Autowired
	private ScrapperInfoService scrapperInfoService;
	
	@RequestMapping(method=RequestMethod.POST)
	public P2pSchedule create(@RequestBody P2pSchedule p2pSchedule) {
		LOG.debug("@@@@@@@@@@@@@ save P2pSchedule => " + p2pSchedule.toString());
		P2pSchedule ps = service.save(p2pSchedule);
		if (ps != null) {
			CheckSchedLog checkSchedLog = new CheckSchedLog();
			checkSchedLog.setErrorMsg(null);
			checkSchedLog.setResultYn("Y");
			checkSchedLog.setModifyUser(CheckSchedLogRestController.MODIFY_USER);
			checkSchedLog.setModifyDate(Utility.getCurrentTime(null));
			Utility.saveCheckSchedLogNsendMsg(checkSchedLog, p2pSchedule.getShprCd(), scrapperType,
					checkSchedLogService, checkSchedLogSender, scrapperInfoService);
		}
		return ps;
	}
}
