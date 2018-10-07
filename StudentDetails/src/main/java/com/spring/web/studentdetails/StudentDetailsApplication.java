package com.spring.web.studentdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDetailsApplication.class, args);
	}
}
