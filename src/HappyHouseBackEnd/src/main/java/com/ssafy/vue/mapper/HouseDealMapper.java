package com.ssafy.vue.mapper;

import java.io.IOException;
import java.util.List;

import com.ssafy.vue.dto.HouseDealDto;

public interface HouseDealMapper {

	List<HouseDealDto> getAptInSearch(String apartName, String sidoCode) throws Exception;
	String swap(String sido) throws IOException;
}
