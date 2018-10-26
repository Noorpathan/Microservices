package com.externa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentExternalController {

	public static final Logger logger = LoggerFactory.getLogger(StudentExternalController.class);

	@GetMapping("/getAllStudentDetails")
	public String getStudentDetailsExternally() {

		String baseURl = "http://localhost:port/StudentDetails" + "/StudentDetails";

		logger.info("Zull URL : " + baseURl);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = null;
		try {
			responseEntity = restTemplate.exchange(baseURl, HttpMethod.GET, getheader(), String.class);
		} catch (Exception e) {
			logger.info("Exception " + e);
		}

		logger.info(responseEntity.getBody());
		return "Zuul URl : " + baseURl + " URL Response => " + responseEntity.getBody().toString();
	}

	private static HttpEntity<?> getheader() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}

}
