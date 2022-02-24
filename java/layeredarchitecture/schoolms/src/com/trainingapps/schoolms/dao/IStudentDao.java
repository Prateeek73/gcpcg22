package com.trainingapps.schoolms.dao;

import com.trainingapps.schoolms.entity.Student;

public interface IStudentDao {

    void add(Student student);

    Student findById(int id);

    void deleteById(int id);

}
