package com.ssafy.vue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.vue.dto.HouseDealDto;
import com.ssafy.vue.service.HouseDealService;

@SpringBootTest
public class aptTest {
	
	@Autowired
	HouseDealService hdService;
	
	@Test
	public void selectTest() throws Exception {
		List<HouseDealDto> deals = hdService.getAptInSearch("경희궁자이", "서울특별시");
		for (HouseDealDto deal: deals) {
			System.out.println(deal);
		}
		assertEquals(deals.size(), 257);
		
		deals = hdService.getAptInSearch("경희궁자이", " 인천");
		assertEquals(deals.size(), 0);
	}
}
