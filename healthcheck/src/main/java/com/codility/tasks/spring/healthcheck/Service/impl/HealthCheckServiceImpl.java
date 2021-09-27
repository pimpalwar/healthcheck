package com.codility.tasks.spring.healthcheck.Service.impl;

import org.springframework.stereotype.Service;
import com.codility.tasks.spring.healthcheck.Service.HealthCheckService;
import com.codility.tasks.spring.healthcheck.model.view.HealthStatus;
import com.codility.tasks.spring.healthcheck.model.view.impl.HealthStatusFull;
import com.codility.tasks.spring.healthcheck.model.view.impl.HealthStatusShort;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service("HealthCheckServiceImpl")
public class HealthCheckServiceImpl implements HealthCheckService {

	@Override
	public HealthStatus prepareresponse(String format) {

		if (format.equalsIgnoreCase("short")) {

			return new HealthStatusShort("OK");

		}

		else if (format.equalsIgnoreCase("full")) {

			TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			df.setTimeZone(tz);
			String nowAsISO = df.format(new Date());

			return new HealthStatusFull("OK", nowAsISO);
		}

		else {
			return null;
		}

	}

}
