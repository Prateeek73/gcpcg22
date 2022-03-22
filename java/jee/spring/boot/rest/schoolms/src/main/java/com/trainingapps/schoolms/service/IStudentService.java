package com.trainingapps.schoolms.service;

import com.trainingapps.schoolms.constants.CourseType;
import com.trainingapps.schoolms.entity.Student;
import com.trainingapps.schoolms.exceptions.InvalidStudentAgeException;
import com.trainingapps.schoolms.exceptions.InvalidStudentIdException;
import com.trainingapps.schoolms.exceptions.InvalidStudentNameException;
import com.trainingapps.schoolms.exceptions.StudentNotFoundException;

import java.util.List;

public interface IStudentService {
    Student add(String name, int age, CourseType course)
    		throws InvalidStudentNameException, InvalidStudentAgeException;

    Student findById(int id) throws InvalidStudentIdException,StudentNotFoundException;

    void deleteById(int id)throws InvalidStudentIdException ;

    List<Student>findAll();

}
