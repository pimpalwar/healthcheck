package com.codility.tasks.spring.healthcheck.Service;

import com.codility.tasks.spring.healthcheck.model.view.HealthStatus;


public interface HealthCheckService {
	
	
	HealthStatus prepareresponse (String format);
	
}
