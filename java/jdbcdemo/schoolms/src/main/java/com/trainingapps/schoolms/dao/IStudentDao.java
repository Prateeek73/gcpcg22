package com.trainingapps.schoolms.dao;

import com.trainingapps.schoolms.entity.Student;
import com.trainingapps.schoolms.exceptions.StudentNotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDao {

    Student findById(int id) throws StudentNotFoundException,SQLException;

    Student insert(Student student) throws SQLException;

    List<Student> findAll() throws SQLException;

}
