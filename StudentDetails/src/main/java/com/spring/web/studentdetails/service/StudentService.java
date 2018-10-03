package com.spring.web.studentdetails.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.studentdetails.model.Student;
import com.spring.web.studentdetails.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	private static List<Student> getStudents;

	private static final AtomicLong counter = new AtomicLong();

	public List<Student> findAllStudent() {
		return getStudents;
	}

	public Student findById(long id) {
		List<Student> getStudents = findAllStudent();
		for (Student student : getStudents) {
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}

	public boolean isUserExist(Student student) {
		return findByName(student.getFirstname()) != null;
	}

	public Student findByName(String name) {
		List<Student> getStudents = findAllStudent();
		for (Student student : getStudents) {
			if (student.getFirstname().equalsIgnoreCase(name)) {
				return student;
			}
		}
		return null;
	}

	public void saveUser(Student student) {
		List<Student> getStudents = findAllStudent();
		student.setId(counter.incrementAndGet());
		getStudents.add(student);
	}

	public void updateUser(Student user) {
		int index = getStudents.indexOf(user);
		getStudents.set(index, user);
	}

	public void deleteUserById(long id) {
		for (Iterator<Student> iterator = getStudents.iterator(); iterator.hasNext();) {
			Student user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
			}
		}
	}

	public void deleteAllStudents() {
		getStudents.clear();
	}

}
