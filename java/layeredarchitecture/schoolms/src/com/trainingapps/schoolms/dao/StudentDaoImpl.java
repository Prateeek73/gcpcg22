package com.trainingapps.schoolms.dao;

import com.trainingapps.schoolms.entity.Student;

import java.util.*;

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

    @Override
    public List<Student> findAll() {
      Collection<Student> values=  store.values();
       List<Student>list=new ArrayList<>();
       list.addAll(values);
       return list;
    }
}
