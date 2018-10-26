package com.feign.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.feign.client.controller.FeignclientController;

@SpringBootApplication
@EnableFeignClients
public class FeignStudentDetailsClientApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(FeignStudentDetailsClientApplication.class, args);
		FeignclientController feignclientController = applicationContext.getBean(FeignclientController.class);
		try {
			feignclientController.getStudentdetails();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Bean
	public FeignclientController feignclientController() {
		return new FeignclientController();
	}
}
