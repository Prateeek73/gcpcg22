package com.trainingapps.schoolms.service;

import com.trainingapps.schoolms.constants.CourseType;
import com.trainingapps.schoolms.dao.IStudentDao;
import com.trainingapps.schoolms.dao.StudentDaoImpl;
import com.trainingapps.schoolms.dto.RegisterStudentRequest;
import com.trainingapps.schoolms.dto.StudentDetails;
import com.trainingapps.schoolms.entity.Student;
import com.trainingapps.schoolms.exceptions.InvalidStudentAgeException;
import com.trainingapps.schoolms.exceptions.InvalidStudentIdException;
import com.trainingapps.schoolms.exceptions.InvalidStudentNameException;
import com.trainingapps.schoolms.exceptions.StudentNotFoundException;
import com.trainingapps.schoolms.util.StudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao dao;

    @Autowired
    private StudentUtil studentUtil;

    private int generatedId;

    int generateId() {
        return ++generatedId;
    }

    @Override
    public StudentDetails add(RegisterStudentRequest requestData) {
        int id = generateId();
        String courseText = requestData.getCourse();
        CourseType course = studentUtil.toEnum(courseText);
        Student student = new Student(id, requestData.getName(), requestData.getAge(), course);
        dao.add(student);
        StudentDetails response = studentUtil.toStudentDetails(student);
        return response;
    }

    @Override
    public Student findById(int id) throws StudentNotFoundException {
        Student student = dao.findById(id);
        if (student == null) {
            throw new StudentNotFoundException("student not found for id=" + id);
        }
        return student;
    }

    @Override
    public StudentDetails findStudentDetailsById(int id) throws StudentNotFoundException {
        Student student = findById(id);
        StudentDetails response = studentUtil.toStudentDetails(student);
        return response;
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public List<StudentDetails> findAll() {
        List<Student> list = dao.findAll();
        List<StudentDetails>desired=studentUtil.toListStudentDetails(list);
        return desired;
    }

}
