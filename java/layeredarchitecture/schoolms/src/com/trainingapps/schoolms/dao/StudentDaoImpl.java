package com.trainingapps.schoolms.dao;

import com.trainingapps.schoolms.entity.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentDaoImpl implements IStudentDao{

    private Map<Integer, Student>store=new HashMap<>();

    @Override
    public void add(Student student) {
     store.put(student.getId(), student);
    }

    @Override
    public Student findById(int id) {
       Student student= store.get(id);
       return student;
    }

    @Override
    public void deleteById(int id) {
        store.remove(id);
    }
}
