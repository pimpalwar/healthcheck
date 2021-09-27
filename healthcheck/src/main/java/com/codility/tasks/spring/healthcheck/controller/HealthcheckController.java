package com.codility.tasks.spring.healthcheck.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.codility.tasks.spring.healthcheck.Service.HealthCheckService;
import com.codility.tasks.spring.healthcheck.model.view.HealthStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class HealthcheckController {

	@Autowired
	HealthCheckService checkService;

	@GetMapping(value = "/healthcheck", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HealthStatus> healthcheck(@RequestParam(value = "format", required = true) String format) {

		
		return checkService.prepareresponse(format)==null? new ResponseEntity<HealthStatus>(HttpStatus.BAD_REQUEST): 
			new ResponseEntity<HealthStatus>(checkService.prepareresponse(format), HttpStatus.OK);

	}

	@PutMapping(value = "/healthcheck")
	public ResponseEntity healthcheckPut() {

		return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);

	}

	@PostMapping(value = "/healthcheck")
	public ResponseEntity healthcheckPost() {

		return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);

	}

	@DeleteMapping(value = "/healthcheck")
	public ResponseEntity healthcheckDelete() {

		return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);

	}

}