package com.lifemagazine.scrapper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.lifemagazine.scrapper.domain.CheckSchedInfo;
import com.lifemagazine.scrapper.repository.CheckSchedInfoRepository;
import com.lifemagazine.scrapper.util.Utility;

@Component
public class CheckSchedInfoService {
	
	@Autowired(required=true)
	CheckSchedInfoRepository service;
	
	public List<CheckSchedInfo> findAll() {
		// TODO Auto-generated method stub
		return (List<CheckSchedInfo>) service.findAll();
	}
	
	public Page<CheckSchedInfo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return service.findAll(pageable);
	}
	
	public CheckSchedInfo findOne(Integer id) {
        return service.findOne(id);
    }
	
	public CheckSchedInfo save(CheckSchedInfo checkSchedInfo) {
		return service.save(checkSchedInfo);
	}
	
	public void delete(Integer checkSchedSeq) {
		service.delete(checkSchedSeq);
	}
	
	public CheckSchedInfo update(Integer checkSchedSeq, CheckSchedInfo checkSchedInfo) {
		CheckSchedInfo update = service.findOne(checkSchedSeq);
		update.setCheckSchedName(checkSchedInfo.getCheckSchedName());
		update.setCheckSchedDesc(checkSchedInfo.getCheckSchedDesc());
		update.setScrapperId(checkSchedInfo.getScrapperId());
		update.setCheckCycle(checkSchedInfo.getCheckCycle());
		update.setValidYn(checkSchedInfo.getValidYn());
		update.setModifyUser(checkSchedInfo.getModifyUser());
		update.setModifyDate(Utility.getCurrentTime(null));
		return service.save(update);
	}
}
