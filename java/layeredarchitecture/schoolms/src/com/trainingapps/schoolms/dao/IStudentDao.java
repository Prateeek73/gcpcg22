package com.trainingapps.schoolms.dao;

import com.trainingapps.schoolms.entity.Student;

import java.util.List;

public interface IStudentDao {

    void add(Student student);

    Student findById(int id);

    void deleteById(int id);

    List<Student>findAll();


}
