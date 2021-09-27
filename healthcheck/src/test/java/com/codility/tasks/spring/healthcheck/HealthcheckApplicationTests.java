package com.codility.tasks.spring.healthcheck;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.codility.tasks.spring.healthcheck.model.view.impl.HealthStatusShort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class HealthcheckApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getShortStatus() {
		HealthStatusShort healthStatusShort = new HealthStatusShort("OK");
		HttpEntity<String> requestEntity = new HttpEntity<>(new HttpHeaders());
		Map<String, String> params = new HashMap<String, String>();
		params.put("format", "short");
		ResponseEntity<HealthStatusShort> response = this.restTemplate.exchange("/healthcheck?format={format}",
				HttpMethod.GET, requestEntity, HealthStatusShort.class, params);
		assertEquals(response.getBody().getStatus(), healthStatusShort.getStatus());
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
	
	@Test
	public void getShortStatusWrongParameter() {
		HealthStatusShort healthStatusShort = new HealthStatusShort("OK");
		HttpEntity<String> requestEntity = new HttpEntity<>(new HttpHeaders());
		Map<String, String> params = new HashMap<String, String>();
		params.put("format", "shorts");
		ResponseEntity<HealthStatusShort> response = this.restTemplate.exchange("/healthcheck?format={format}",
				HttpMethod.GET, requestEntity, HealthStatusShort.class, params);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

	}
	
	
	@Test
	public void post() {
		HttpEntity<String> requestEntity = new HttpEntity<>(new HttpHeaders());
		Map<String, String> params = new HashMap<String, String>();
		params.put("format", "shorts");
		ResponseEntity<Object> response = this.restTemplate.exchange("/healthcheck",
				HttpMethod.POST, requestEntity, Object.class, params);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.METHOD_NOT_ALLOWED);

	}
	
	
	@Test
	public void put() {
		HttpEntity<String> requestEntity = new HttpEntity<>(new HttpHeaders());
		Map<String, String> params = new HashMap<String, String>();
		params.put("format", "shorts");
		ResponseEntity<Object> response = this.restTemplate.exchange("/healthcheck",
				HttpMethod.PUT, requestEntity, Object.class, params);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.METHOD_NOT_ALLOWED);

	}
	
	
	@Test
	public void delete() {
		HttpEntity<String> requestEntity = new HttpEntity<>(new HttpHeaders());
		Map<String, String> params = new HashMap<String, String>();
		params.put("format", "shorts");
		ResponseEntity<Object> response = this.restTemplate.exchange("/healthcheck",
				HttpMethod.DELETE, requestEntity, Object.class, params);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.METHOD_NOT_ALLOWED);

	}

}
