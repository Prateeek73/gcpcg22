package com.trainingapps.schoolms.service;

import com.trainingapps.schoolms.entity.Student;

import java.util.List;

public interface IStudentService {
    Student add(String name, int age);

    Student findById(int id);

    void deleteById(int id);

    List<Student>findAll();

}
