package com.codility.tasks.spring.healthcheck.model.view.impl;

import com.codility.tasks.spring.healthcheck.model.view.HealthStatus;

public class HealthStatusFull implements HealthStatus{

	
	String status;
	
	String currentTime;

	public HealthStatusFull() {}
	
	public HealthStatusFull(String status, String currentTime) {
		super();
		this.status = status;
		this.currentTime = currentTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
	
}
