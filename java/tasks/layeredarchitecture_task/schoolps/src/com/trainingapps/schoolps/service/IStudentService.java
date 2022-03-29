package com.trainingapps.schoolps.service;

import com.trainingapps.schoolps.entity.Student;
import com.trainingapps.schoolps.exceptions.InvalidStudentIdException;
import com.trainingapps.schoolps.exceptions.InvalidStudentNameException;
import com.trainingapps.schoolps.exceptions.InvalidStudentAgeException;
import com.trainingapps.schoolps.exceptions.StudentNotFoundException;
import java.util.List;

public interface IStudentService{
	Student add(String name, int age) throws InvalidStudentNameException, InvalidStudentAgeException;
	Student findById(int id) throws InvalidStudentIdException, StudentNotFoundException;
	void deleteById(int id) throws InvalidStudentIdException;
	List<Student> findAll();
}