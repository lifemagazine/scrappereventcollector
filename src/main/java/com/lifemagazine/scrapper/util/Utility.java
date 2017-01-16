package com.lifemagazine.scrapper.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lifemagazine.scrapper.amqp.MessageSender;
import com.lifemagazine.scrapper.api.CheckSchedLogRestController;
import com.lifemagazine.scrapper.domain.CheckSchedLog;
import com.lifemagazine.scrapper.domain.ScrapperInfo;
import com.lifemagazine.scrapper.logstash.CheckSchedLogstash;
import com.lifemagazine.scrapper.service.CheckSchedLogService;
import com.lifemagazine.scrapper.service.ScrapperInfoService;

public class Utility {
	
	private static final Logger LOG = LoggerFactory.getLogger(Utility.class);

	public static String getCurrentTime(Calendar calendar) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if (calendar == null) calendar = Calendar.getInstance(java.util.Locale.KOREA);
		
		return format.format(calendar.getTime());
	}
	
	public static CheckSchedLog saveCheckSchedLogstashNsendMsg(CheckSchedLogstash checkSchedLogstash, String MODIFY_USER,
			CheckSchedLogService service,
			MessageSender checkSchedLogSender, ScrapperInfoService scrapperInfoService) {
		LOG.debug("@@@@@@@@@@@@@ received CheckSchedLogstash msg => " + checkSchedLogstash.toString());
		CheckSchedLog checkSchedLog = new CheckSchedLog();
		checkSchedLog.setResultYn("Y");
		checkSchedLog.setModifyUser(CheckSchedLogRestController.MODIFY_USER);
		checkSchedLog.setModifyDate(checkSchedLogstash.getModifyDate());
		
		List<ScrapperInfo> list = scrapperInfoService.findAll();
		LOG.debug("@@@@@@@@@@@@@ list count => " + list.size());
		int scrapperId = -1;
		for (ScrapperInfo scrapperInfo: list) {
			if (scrapperInfo.getScrapperName().equals(checkSchedLogstash.getShprCd()) 
					&& scrapperInfo.getScrapperType().equals(checkSchedLogstash.getScrapperType())) {
				scrapperId = scrapperInfo.getScrapperId(); 
				break;
			}
		}
		checkSchedLog.setScrapperId(scrapperId);
		LOG.debug("@@@@@@@@@@@@@ save msg => " + checkSchedLog.toString());
		CheckSchedLog cs = service.save(checkSchedLog);
		if (cs != null) {
			checkSchedLogSender.sendMessage(checkSchedLog);
			LOG.debug("@@@@@@@@@@@@@ send msg => " + cs.toString());
		}
		
		return cs;
	}
	
	public static CheckSchedLog saveCheckSchedLogNsendMsg(CheckSchedLog checkSchedLog, 
			String scrapperName, String scrapperType, 
			CheckSchedLogService service,
			MessageSender checkSchedLogSender, ScrapperInfoService scrapperInfoService) {
		LOG.debug("@@@@@@@@@@@@@ save0 msg => " + checkSchedLog.toString());
		List<ScrapperInfo> list = scrapperInfoService.findAll();
		int scrapperId = -1;
		for (ScrapperInfo scrapperInfo: list) {
			if (scrapperInfo.getScrapperName().equals(scrapperName) && scrapperInfo.getScrapperType().equals(scrapperType)) {
				scrapperId = scrapperInfo.getScrapperId(); 
				break;
			}
		}
		checkSchedLog.setScrapperId(scrapperId);
		LOG.debug("@@@@@@@@@@@@@ save msg => " + checkSchedLog.toString());
		CheckSchedLog cs = service.save(checkSchedLog);
		if (cs != null) {
			checkSchedLogSender.sendMessage(checkSchedLog);
			LOG.debug("@@@@@@@@@@@@@ send msg => " + cs.toString());
		}
		
		return cs;
	}
}
