package com.spring.web.professordetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProfessorDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfessorDetailsApplication.class, args);
	}
}
