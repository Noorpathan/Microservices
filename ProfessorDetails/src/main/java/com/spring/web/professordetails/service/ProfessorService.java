package com.spring.web.professordetails.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.professordetails.model.Professor;
import com.spring.web.professordetails.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	private static final AtomicLong counter = new AtomicLong();

	public List<Professor> findAllProfessor() {
		List<Professor> getProfessor = professorRepository.findAll();
		return getProfessor;
	}

	public Professor findById(long id) {
		List<Professor> professors = findAllProfessor();
		for (Professor professor : professors) {
			if (professor.getId() == id) {
				return professor;
			}
		}
		return null;
	}

	public boolean isUserExist(Professor professor) {
		return findByName(professor.getFirstname()) != null;
	}

	public Professor findByName(String name) {
		List<Professor> professors = findAllProfessor();
		for (Professor professor : professors) {
			if (professor.getFirstname().equalsIgnoreCase(name)) {
				return professor;
			}
		}
		return null;
	}

	public void saveProfessor(Professor professor) {
		List<Professor> professors = findAllProfessor();
		professor.setId(counter.incrementAndGet());
		professors.add(professor);
	}

	public void updateProfessor(Professor user) {
		List<Professor> getProfessor = professorRepository.findAll();
		int index = getProfessor.indexOf(user);
		getProfessor.set(index, user);
	}

	public void deleteProfessorById(long id) {
		List<Professor> getProfessor = professorRepository.findAll();
		for (Iterator<Professor> iterator = getProfessor.iterator(); iterator.hasNext();) {
			Professor user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
			}
		}
	}

	public void deleteAllProfessor() {
		List<Professor> getProfessor = professorRepository.findAll();
		getProfessor.clear();
	}

}
