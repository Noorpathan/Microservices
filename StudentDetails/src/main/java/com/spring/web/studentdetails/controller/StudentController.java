package com.spring.web.studentdetails.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.web.studentdetails.model.Student;
import com.spring.web.studentdetails.service.StudentService;
import com.spring.web.studentdetails.util.CustomErrorType;

@RestController
public class StudentController {

	public static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService studentService;

	// -------------------Retrieve All
	// Student---------------------------------------------

	@RequestMapping(value = "/studentDetails", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Student>> listAllUsers() {
		List<Student> studentAll = studentService.findAllStudent();
		return new ResponseEntity<List<Student>>(studentAll, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// Student------------------------------------------

	@RequestMapping(value = "/studentDetails/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Student> getUser(@PathVariable("id") long id) {
		logger.info("Fetching User with id {}", id);
		Student singleStudent = studentService.findById(id);
		if (singleStudent == null) {
			logger.error("User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("User with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(singleStudent, HttpStatus.OK);
	}

	// -------------------Create new
	// Student-------------------------------------------

	@RequestMapping(value = "/studentDetails/newUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody Student student, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Student : {}", student);

		if (studentService.isUserExist(student)) {
			logger.error("Unable to create. A User with name {} already exist", student.getFirstname());
			return new ResponseEntity(
					new CustomErrorType(
							"Unable to create. A User with name " + student.getFirstname() + " already exist."),
					HttpStatus.CONFLICT);
		}
		studentService.saveUser(student);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/studentDetails/{id}").buildAndExpand(student.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update Student
	// ------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Student> updateUser(@PathVariable("id") long id, @RequestBody Student student) {
		logger.info("Updating User with id {}", id);

		Student currentUser = studentService.findById(id);

		if (currentUser == null) {
			logger.error("Unable to update. User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentUser.setFirstname(student.getFirstname());
		currentUser.setLastname(student.getLastname());
		currentUser.setAddress(student.getAddress());

		studentService.updateUser(currentUser);
		return new ResponseEntity<Student>(currentUser, HttpStatus.OK);
	}

	// ------------------- Delete Student-----------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Student with id {}", id);

		Student student = studentService.findById(id);
		if (student == null) {
			logger.error("Unable to delete. User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Student with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		studentService.deleteUserById(id);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}

	// ------------------- Delete All Student-----------------------------

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.DELETE)
	public ResponseEntity<Student> deleteAllUsers() {
		logger.info("Deleting All Student");

		studentService.deleteAllStudents();
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
}