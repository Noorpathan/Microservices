package com.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentConsumerClient {

	// @Autowired
	// private DiscoveryClient discoveryClient;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/getallstudentlist")
	public String getStudentListData() {

		// List<ServiceInstance> instances = discoveryClient.getInstances("");
		// ServiceInstance serviceInstance = instances.get(0);

		//ServiceInstance serviceInstance = loadBalancerClient.choose("StudentDetails-Service");
		ServiceInstance serviceInstance = loadBalancerClient.choose("RoutingAPI-Zuul");
		String baseURL = serviceInstance.getUri().toString() +"/studentDetails"+ "/studentDetails";

		System.out.println("Instance URl : " + baseURL);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = null;

		try {
			responseEntity = restTemplate.exchange(baseURL, HttpMethod.GET, getheader(), String.class);
		} catch (Exception e) {
			System.out.println(e);
		}

		return "Client Consume URL is : " + baseURL + " Response => " + responseEntity.getBody().toString();

	}

	private static HttpEntity<?> getheader() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}

}
