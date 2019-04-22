package com.csvconsumer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.csvconsumer.model.CSVBean;

@RestController
public class CSVConsumerController2 {

	RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/getdetails")
	public ModelAndView details() {
		ModelAndView view = new ModelAndView("field");
		String baseURL = "http://localhost:8011/csvServices";
		ResponseEntity<CSVBean[]> responseEntity = null;
		List<CSVBean> csvdatalist = new ArrayList<CSVBean>();
		try {
			responseEntity = restTemplate.exchange(baseURL, HttpMethod.GET, getheader(), CSVBean[].class);
			CSVBean[] topics = responseEntity.getBody();
			
			for (CSVBean topic : topics) {
				CSVBean csvBean = new  CSVBean();
				System.out.println("fname:" + topic.getFirstName() + ", lastname:" + topic.getLastName() + ", id : "
						+ topic.getId() + ", id2 : " + topic.getId2());
				csvBean.setFirstName(topic.getFirstName());
				csvBean.setLastName(topic.getLastName());
				csvBean.setId(topic.getId());
				csvBean.setId2(topic.getId2());
				csvdatalist.add(csvBean);
			}
			
			view.addObject("csvdatalist", csvdatalist);
		} catch (Exception e) {
			System.out.println(e);
		}
		return view;

	}

	private static HttpEntity<?> getheader() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}