package com.lifemagazine.scrapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifemagazine.scrapper.domain.ScrapperInfo;

public interface ScrapperInfoRepository extends JpaRepository<ScrapperInfo, Integer> {

}
