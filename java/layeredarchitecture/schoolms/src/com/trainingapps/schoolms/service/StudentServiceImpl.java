package com.trainingapps.schoolms.service;

import com.trainingapps.schoolms.dao.IStudentDao;
import com.trainingapps.schoolms.dao.StudentDaoImpl;
import com.trainingapps.schoolms.entity.Student;

public class StudentServiceImpl implements IStudentService{
    private IStudentDao dao=new StudentDaoImpl();

    private int generatedId;

    int generateId(){
        return ++generatedId;
    }

    @Override
    public Student add(String name, int age) {
        int id=generateId();
        Student student=new Student(id,name,age);
        dao.add(student);
        return student;
    }

    @Override
    public Student findById(int id) {
        Student student=dao.findById(id);
        return student;
    }

    @Override
    public void deleteById(int id) {
           dao.deleteById(id);
    }
}
