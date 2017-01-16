package com.lifemagazine.scrapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifemagazine.scrapper.domain.AlarmGroup;


public interface AlarmGroupRepository extends JpaRepository<AlarmGroup, Integer> {

}
