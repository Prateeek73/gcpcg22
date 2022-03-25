package com.trainingapps.schoolms.studentms.service;

import com.trainingapps.schoolms.departmentms.entity.Department;
import com.trainingapps.schoolms.departmentms.exceptions.DepartmentNotFoundException;
import com.trainingapps.schoolms.departmentms.service.IDepartmentService;
import com.trainingapps.schoolms.studentms.constants.CourseType;
import com.trainingapps.schoolms.studentms.dto.AddStudentInDepartmentRequest;
import com.trainingapps.schoolms.studentms.repository.IStudentRepository;
import com.trainingapps.schoolms.studentms.dto.RegisterStudentRequest;
import com.trainingapps.schoolms.studentms.dto.StudentDetails;
import com.trainingapps.schoolms.studentms.entity.Student;
import com.trainingapps.schoolms.studentms.exceptions.StudentNotFoundException;
import com.trainingapps.schoolms.studentms.util.StudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository repository;

    @Autowired
    private StudentUtil studentUtil;

    @Autowired
    private IDepartmentService departmentService;

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

    @Override
    public StudentDetails addInDepartment(AddStudentInDepartmentRequest request) throws StudentNotFoundException, DepartmentNotFoundException {
        Student student = findById(request.getStudentId());
        Department department = departmentService.findById(request.getDepartmentId());
        student.setDepartment(department);
        repository.save(student);

        List<Student> list = department.getStudents();
        if (list == null) {
            list = new ArrayList<>();
            department.setStudents(list);
        }
        list.add(student);
        StudentDetails desired = studentUtil.toStudentDetails(student);
        return desired;

    }
}