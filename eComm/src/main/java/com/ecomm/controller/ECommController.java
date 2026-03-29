package com.ecomm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class ECommController {

	@GetMapping("/getStatus")
	public String getStatus() throws InterruptedException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ;i <5;i++) {
			Thread.sleep(2000);
			LocalDateTime now = LocalDateTime.now();
			String formatted = now.format(formatter);
			System.out.println(formatted);
			sb.append(" - "+formatted);
		}

		return sb.toString();
	}
}
