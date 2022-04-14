package com.trainingapps.schoolms.service;

import com.trainingapps.schoolms.constants.CourseType;
import com.trainingapps.schoolms.dao.IStudentDao;
import com.trainingapps.schoolms.dto.RegisterStudentRequest;
import com.trainingapps.schoolms.dto.StudentDetails;
import com.trainingapps.schoolms.entity.Student;
import com.trainingapps.schoolms.exceptions.StudentNotFoundException;
import com.trainingapps.schoolms.util.StudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao studentDao;

    @Autowired
    private StudentUtil studentUtil;
    
  

    @Override
    public StudentDetails add(RegisterStudentRequest request) throws SQLException{
        Student student = new Student();
        student.setName(request.getName());
        student.setAge(request.getAge());
        student=studentDao.insert(student);
        System.out.println("student="+student);
        System.out.println("util="+studentUtil);
        StudentDetails desired = studentUtil.toStudentDetails(student);
        return desired;
    }


    @Override
    public Student findById(int id) throws StudentNotFoundException , SQLException {
        Student student = studentDao.findById(id);
        if (student==null) {
            throw new StudentNotFoundException("student not found for id=" + id);
        }
       return student;
    }

    @Override
    public StudentDetails findStudentDetailsById(int id) throws StudentNotFoundException , SQLException{
        Student student = findById(id);
        StudentDetails desired = studentUtil.toStudentDetails(student);
        return desired;
    }

    @Override
    public List<StudentDetails> findAll() throws SQLException{
        List<Student> students = studentDao.findAll();
        List<StudentDetails> desired = studentUtil.toListStudentDetails(students);
        return desired;
    }


}