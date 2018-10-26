package com.client.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.client.controller.StudentConsumerClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentDetailsConsumerApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(StudentDetailsConsumerApplication.class, args);
		
		StudentConsumerClient studentConsumerClient =applicationContext.getBean(StudentConsumerClient.class);
		studentConsumerClient.getStudentListData();
		
	}
	
	
	@Bean
	public StudentConsumerClient studentConsumerClient() {
		return new StudentConsumerClient();
	}
}
