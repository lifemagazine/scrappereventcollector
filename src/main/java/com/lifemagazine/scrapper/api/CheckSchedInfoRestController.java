package com.lifemagazine.scrapper.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifemagazine.scrapper.domain.CheckSchedInfo;
import com.lifemagazine.scrapper.service.CheckSchedInfoService;

@RestController
@RequestMapping("api/checkschedinfo")
public class CheckSchedInfoRestController {

	@Autowired
	private CheckSchedInfoService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public Page<CheckSchedInfo> list(@PageableDefault Pageable pageable) {
		// TODO Auto-generated method stub
		PageRequest pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), new Sort(new Order(Direction.DESC, "modifyUser")));
		return (Page<CheckSchedInfo>) service.findAll(pageRequest);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	CheckSchedInfo getCheckSchedInfo(@PathVariable Integer id) {
		CheckSchedInfo checkSchedInfo = service.findOne(id);
        return checkSchedInfo;
    }
	
	@RequestMapping(method=RequestMethod.POST)
	public CheckSchedInfo create(@RequestBody CheckSchedInfo checkSchedInfo) {
		return service.save(checkSchedInfo);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="{check_sched_seq}")
	public void delete(@PathVariable Integer alarmGrpSeq) {
		service.delete(alarmGrpSeq);
	}

	@RequestMapping(method=RequestMethod.PUT, value="{check_sched_seq}")
	public CheckSchedInfo update(@PathVariable Integer checkSchedSeq, @RequestBody CheckSchedInfo checkSchedInfo) {
		return service.update(checkSchedSeq, checkSchedInfo);
	}
}
