package com.spring.web.professordetails.controller;

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
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.web.professordetails.model.Professor;
import com.spring.web.professordetails.service.ProfessorService;
import com.spring.web.professordetails.util.CustomErrorType;

@RestController
public class ProfessorController {

	public static final Logger logger = LoggerFactory.getLogger(ProfessorController.class);

	@Autowired
	ProfessorService    professorService;

	// -------------------Retrieve All
	// Professor---------------------------------------------

	@RequestMapping(value = "/professorDetails", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Professor>> listAllUsers() {
		List<Professor> professorAll = professorService.findAllProfessor();
		return new ResponseEntity<List<Professor>>(professorAll, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// professor------------------------------------------

	@RequestMapping(value = "/professorDetails/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Professor> getUser(@PathVariable("id") long id) {
		logger.info("Fetching User with id {}", id);
		Professor singleProfessor = professorService.findById(id);
		if (singleProfessor == null) {
			logger.error("User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("User with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Professor>(singleProfessor, HttpStatus.OK);
	}

	// -------------------Create new
	// Student-------------------------------------------

	@RequestMapping(value = "/professorDetails/newUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Professor> createNewProfessor(@RequestBody Professor professor, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Professor : {}", professor);

		if (professorService.isUserExist(professor)) {
			logger.error("Unable to create. A User with name {} already exist", professor.getFirstname());
			return new ResponseEntity(
					new CustomErrorType(
							"Unable to create. A professor details with name " + professor.getFirstname() + " already exist."),
					HttpStatus.CONFLICT);
		}
		professorService.saveProfessor(professor);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/professorDetails/{id}").buildAndExpand(professor.getId()).toUri());
		return new ResponseEntity<Professor>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update Student
	// ------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Professor> updateUser(@PathVariable("id") long id, @RequestBody Professor professor) {
		logger.info("Updating professor with id {}", id);

		Professor currentUser = professorService.findById(id);

		if (currentUser == null) {
			logger.error("Unable to professor. User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. professor with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentUser.setFirstname(professor.getFirstname());
		currentUser.setLastname(professor.getLastname());
		currentUser.setAddress(professor.getAddress());

		professorService.updateProfessor(currentUser);
		return new ResponseEntity<Professor>(currentUser, HttpStatus.OK);
	}

	// ------------------- Delete Student-----------------------------------------

	@RequestMapping(value = "/professor/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Professor> deleteProfessor(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting professor with id {}", id);

		Professor professor = professorService.findById(id);
		if (professor == null) {
			logger.error("Unable to delete. professor with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. professor with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		professorService.deleteProfessorById(id);
		return new ResponseEntity<Professor>(HttpStatus.OK);
	}

	// ------------------- Delete All Student-----------------------------

	@RequestMapping(value = "/deleteProfessor", method = RequestMethod.DELETE)
	public ResponseEntity<Professor> deleteAllProfessor() {
		logger.info("Deleting All Professor Data");

		professorService.deleteAllProfessor();
		return new ResponseEntity<Professor>(HttpStatus.NO_CONTENT);
	}
}