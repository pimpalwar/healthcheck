package com.codility.tasks.spring.healthcheck.model.view.impl;

import com.codility.tasks.spring.healthcheck.model.view.HealthStatus;

public class HealthStatusShort implements HealthStatus{

	
	String status;
	
	public HealthStatusShort() {}
	
	public HealthStatusShort(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
