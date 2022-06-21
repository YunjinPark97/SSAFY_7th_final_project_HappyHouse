package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.HouseDealDto;

public interface HouseDealService {
	List<HouseDealDto> getAptInSearch(String apartName, String sido) throws Exception;	
}
