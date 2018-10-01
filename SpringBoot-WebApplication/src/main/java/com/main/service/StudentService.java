package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Student;
import com.main.repository.StudentRepository;


@Service
public class StudentService {

	
	@Autowired
	StudentRepository studentRepository;
	
	
	public List<Student> getAllStudentDetails() {
		return  studentRepository.findAll();
		
	}
	
	
	
	
	
}
