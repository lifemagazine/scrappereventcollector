package com.lifemagazine.scrapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifemagazine.scrapper.domain.AlarmMsg;

public interface AlarmMsgRepository extends JpaRepository<AlarmMsg, Integer> {

}
