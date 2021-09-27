package com.codility.tasks.spring.healthcheck;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codility.tasks.spring.healthcheck.controller.HealthcheckController;

@SpringBootTest
public class SmokeTest {
	
	@Autowired
	private HealthcheckController healthcheckController;
	
	@Test
	public void contextLoads() {
		assertThat(healthcheckController).isNull();
		
		
	}


}
