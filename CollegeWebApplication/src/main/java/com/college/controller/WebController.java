package com.college.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.college.model.Professor;
import com.college.model.Student;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class WebController {

	public static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

	@Autowired
	private DiscoveryClient discoveryClient;

	private static RestTemplate restTemplate = new RestTemplate();

	@HystrixCommand(fallbackMethod = "StudentDetailsServiceFailed", commandKey = "StudentDetails-Service", groupKey = "StudentDetails-Service")
	@GetMapping("/studentServiceDetails")
	public ModelAndView getAllStudentDetails() {
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances("please provied zuul id");
		ServiceInstance instance = serviceInstances.get(0);
		String serviceURL = instance.getUri().toString();
		ModelAndView view = new ModelAndView("StudentDetails");
		Student student = restTemplate.getForObject(serviceURL, Student.class);
		LOGGER.info(student.getFirstname() + " :: " + student.getLastname() + " :: " + student.getId() + " :: "
				+ student.getAddress());
		view.addObject("student", student);
		return view;
	}

	public ModelAndView StudentDetailsServiceFailed() {
		ModelAndView view = new ModelAndView("StudentDetailsFailed");
		String defaultOutput = "CIRCUIT BREAKER ENABLED!!! No Response From Student Details Service At This Moment. "
				+ "Service Will Be Back Shortly - " + new Date();
		view.addObject("message", defaultOutput);
		return view;
	}

	@HystrixCommand(fallbackMethod = "ProfessorDetailsServiceFailed", commandKey = "ProfessorDetails-Service", groupKey = "ProfessorDetails-Service")
	@GetMapping("/studentServiceDetails")
	public ModelAndView getAllProfessorDetails() {
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances("please provied zuul id");
		ServiceInstance instance = serviceInstances.get(0);
		String serviceURL = instance.getUri().toString();
		ModelAndView view = new ModelAndView("ProfessorDetails");
		Professor professor = restTemplate.getForObject(serviceURL, Professor.class);
		LOGGER.info(professor.getFirstname() + " :: " + professor.getLastname() + " :: " + professor.getId() + " :: "
				+ professor.getAddress());
		view.addObject("professordata", professor);
		return view;
	}

	public ModelAndView ProfessorDetailsServiceFailed() {
		ModelAndView view = new ModelAndView("ProfessorDetailsFailed");
		String defaultOutput = "CIRCUIT BREAKER ENABLED!!! No Response From Professor Details Service At This Moment. "
				+ "Service Will Be Back Shortly - " + new Date();
		view.addObject("message", defaultOutput);
		return view;
	}
}
