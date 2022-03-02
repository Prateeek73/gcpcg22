package com.trainingapps.schoolps.service;

import com.trainingapps.schoolps.entity.Student;
import com.trainingapps.schoolps.dao.IStudentDao;
import com.trainingapps.schoolps.dao.StudentDaoImpl;
import com.trainingapps.schoolps.exceptions.InvalidStudentIdException;
import com.trainingapps.schoolps.exceptions.InvalidStudentNameException;
import com.trainingapps.schoolps.exceptions.InvalidStudentAgeException;
import com.trainingapps.schoolps.exceptions.StudentNotFoundException;
import java.util.List;

public class StudentServiceImpl implements IStudentService{
	private IStudentDao dao = new StudentDaoImpl();
	private int generateId;
	int generateId(){
		return ++generateId;
	}
	@Override
	public Student add(String name, int age) throws InvalidStudentNameException, InvalidStudentAgeException{
		validateName(name);
		validateAge(age);
		int id = generateId();
		Student student = new Student(id, name, age);
		dao.add(student);
		return student;
	}
	@Override
	public Student findById(int id) throws InvalidStudentIdException, StudentNotFoundException{
		validateId(id);
		Student student = dao.findById(id);
		if(student==null){
			throw new StudentNotFoundException("Student not found for id="+id);
		}
		return student;
	}
	@Override	
	public void deleteById(int id) throws InvalidStudentIdException{
		validateId(id);
		dao.deleteById(id);
	}
	@Override
	public List<Student> findAll(){
		List<Student> result = dao.findAll();
		return result;
	}
	public void validateName(String name) throws InvalidStudentNameException{
		if(name == null || name.isEmpty() || name.length() < 2 || name.length() > 10){
			throw new InvalidStudentNameException("Invalid name argument " + name);
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