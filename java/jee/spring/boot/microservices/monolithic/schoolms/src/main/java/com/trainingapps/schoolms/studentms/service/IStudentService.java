package com.trainingapps.schoolms.studentms.service;

import com.trainingapps.schoolms.departmentms.exceptions.DepartmentNotFoundException;
import com.trainingapps.schoolms.studentms.dto.AddStudentInDepartmentRequest;
import com.trainingapps.schoolms.studentms.dto.RegisterStudentRequest;
import com.trainingapps.schoolms.studentms.dto.StudentDetails;
import com.trainingapps.schoolms.studentms.entity.Student;
import com.trainingapps.schoolms.studentms.exceptions.StudentNotFoundException;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
public interface IStudentService {
    StudentDetails add(@Valid RegisterStudentRequest requestData);

    Student findById(@Min(1)int id) throws StudentNotFoundException;

    StudentDetails findStudentDetailsById(@Min(1)int id) throws StudentNotFoundException;

    void deleteById(@Min(1) int id) ;

    List<StudentDetails>findAll();

    List<StudentDetails>findByName(@Length(min = 2, max=10)String name);

    StudentDetails addInDepartment(AddStudentInDepartmentRequest request) throws StudentNotFoundException, DepartmentNotFoundException;
}
