package com.main.controller;

import java.util.List;

import org.apache.catalina.ssi.ResponseIncludeWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.main.model.Student;
import com.main.service.StudentService;

@RestController
public class WelcomeController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public ModelAndView loginView() {
		ModelAndView loginView = new ModelAndView("test");
		return loginView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView  find() {
		List<Student> list = studentService.getAllStudentDetails();
		ModelAndView loginview = new ModelAndView("index");
		return  loginview;
		}
	
	

}