package com.feign.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.feign.client.service.FeignClientService;

@RestController
public class FeignclientController {

	@Autowired
	private FeignClientService feignClientService;

	public static final Logger logger = LoggerFactory.getLogger(FeignclientController.class);

	public void getStudentdetails() {
		try {
			String feignServiceResponse = feignClientService.getstudent();
			logger.info("Feign Service Response" + feignServiceResponse);
		} catch (Exception e) {
			logger.error("Exception : " + e);
		}
	}

}
