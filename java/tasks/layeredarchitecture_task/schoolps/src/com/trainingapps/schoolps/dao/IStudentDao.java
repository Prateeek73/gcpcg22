package com.trainingapps.schoolps.dao;

import com.trainingapps.schoolps.entity.Student;
import java.util.List;

public interface IStudentDao {
    void add(Student student);
    Student findById(int id);
    List<Student> findAll();
    // void updateName(int id, String name);
    // void updateAge(int id, int age);
    // void updateNameAndAge(int id, String name, int age); 
    void deleteById(int id);
}
