package com.feign.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "RoutingAPI-Zuul")
public interface FeignClientService {

	@GetMapping(value = "/studentDetails/studentDetails")
	public String getstudent();
}
