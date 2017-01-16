package com.lifemagazine.scrapper.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifemagazine.scrapper.amqp.MessageSender;
import com.lifemagazine.scrapper.domain.CheckSchedLog;
import com.lifemagazine.scrapper.logstash.CheckSchedLogstash;
import com.lifemagazine.scrapper.service.CheckSchedLogService;
import com.lifemagazine.scrapper.service.ScrapperInfoService;
import com.lifemagazine.scrapper.util.Utility;

@RestController
@RequestMapping("api/checkschedlog")
public class CheckSchedLogRestController {

	public static String MODIFY_USER;
	
	@Value("${spring.dbinsert.modifyUser}")
	public void setMODIFY_USER(String user) {
		MODIFY_USER = user;
	}
	
	@Autowired
    private MessageSender checkSchedLogSender;
	
	@Autowired
	private CheckSchedLogService service;
	
	@Autowired
	private ScrapperInfoService scrapperInfoService;
	
	@RequestMapping(method=RequestMethod.POST)
	public CheckSchedLog create(@RequestBody CheckSchedLogstash checkSchedLogstash) {
		return Utility.saveCheckSchedLogstashNsendMsg(checkSchedLogstash, MODIFY_USER, service, checkSchedLogSender, scrapperInfoService);
	}
	
}
