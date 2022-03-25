package com.trainingapps.schoolms.service;

import com.trainingapps.schoolms.constants.CourseType;
import com.trainingapps.schoolms.repository.IStudentRepository;
import com.trainingapps.schoolms.dto.RegisterStudentRequest;
import com.trainingapps.schoolms.dto.StudentDetails;
import com.trainingapps.schoolms.entity.Student;
import com.trainingapps.schoolms.exceptions.StudentNotFoundException;
import com.trainingapps.schoolms.util.StudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository repository;

    @Autowired
    private StudentUtil studentUtil;

    @Override
    public StudentDetails add(RegisterStudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setAge(request.getAge());
        String courseText = request.getCourse();
        CourseType courseType = studentUtil.toEnum(courseText);
        student.setCourseType(courseType);
        student = repository.save(student);
        StudentDetails desired = studentUtil.toStudentDetails(student);
        return desired;
    }


    @Override
    public Student findById(int id) throws StudentNotFoundException {
        Optional<Student> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new StudentNotFoundException("student not found for id=" + id);
        }
        Student desired = optional.get();
        return desired;
    }

    @Override
    public StudentDetails findStudentDetailsById(int id) throws StudentNotFoundException {
        Student student = findById(id);
        StudentDetails desired = studentUtil.toStudentDetails(student);
        return desired;
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<StudentDetails> findAll() {
        List<Student> students = repository.findAll();
        List<StudentDetails> desired = studentUtil.toListStudentDetails(students);
        return desired;
    }


    @Override
    public List<StudentDetails> findByName(String name) {
        List<Student> students = repository.findByName(name);
        List<StudentDetails> desired = studentUtil.toListStudentDetails(students);
        return desired;
    }
}