package com.ssafy.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.dto.HouseDealDto;
import com.ssafy.vue.mapper.HouseDealMapper;

@Service
public class HouseDealServiceImpl implements HouseDealService {
	
	@Autowired
	private HouseDealMapper houseDealMapper;

	@Override
	public List<HouseDealDto> getAptInSearch(String apartName, String sido) throws Exception {
		return houseDealMapper.getAptInSearch("%"+apartName+"%", houseDealMapper.swap("%"+sido+"%"));
	}
}
