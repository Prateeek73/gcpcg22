package com.trainingapps.schoolms.service;

import com.trainingapps.schoolms.entity.Student;

public interface IStudentService {
    Student add(String name, int age);

    Student findById(int id);

    void deleteById(int id);

}
