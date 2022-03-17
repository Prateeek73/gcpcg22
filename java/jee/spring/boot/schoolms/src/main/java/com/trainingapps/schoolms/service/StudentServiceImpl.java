package com.trainingapps.schoolms.service;

import com.trainingapps.schoolms.dao.IStudentDao;
import com.trainingapps.schoolms.dao.StudentDaoImpl;
import com.trainingapps.schoolms.entity.Student;
import com.trainingapps.schoolms.exceptions.InvalidStudentAgeException;
import com.trainingapps.schoolms.exceptions.InvalidStudentIdException;
import com.trainingapps.schoolms.exceptions.InvalidStudentNameException;
import com.trainingapps.schoolms.exceptions.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao dao;

	private int generatedId;

	int generateId() {
		return ++generatedId;
	}

	@Override
	public Student add(String name, int age) 
			throws InvalidStudentNameException, InvalidStudentAgeException {
		validateName(name);
		validateAge(age);
		int id = generateId();
		Student student = new Student(id, name, age);
		dao.add(student);
		return student;
	}

	@Override
	public Student findById(int id)throws InvalidStudentIdException,StudentNotFoundException {
		validateId(id);
		Student student = dao.findById(id);
		if(student==null) {
			throw new StudentNotFoundException("student not found for id="+id);
		}
		return student;
	}

	@Override
	public void deleteById(int id) throws InvalidStudentIdException {
		validateId(id);
		dao.deleteById(id);
	}

	@Override
	public List<Student> findAll() {
		List<Student> result = dao.findAll();
		return result;
	}

	void validateName(String name) throws InvalidStudentNameException {
		if (name == null || name.isEmpty() || name.length() < 2 || name.length() > 10) {
			throw new InvalidStudentNameException("invalid name argument " + name);
		}
	}

	void validateAge(int age) throws InvalidStudentAgeException {
		if (age < 5 || age > 50) {
			throw new InvalidStudentAgeException("invalid age argument " + age);
		}
	}
	
	void validateId(int id) throws InvalidStudentIdException {
		if(id<=0) {
			throw new InvalidStudentIdException("invalid student id argument "+id);
		}
	}
}
