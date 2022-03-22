package com.trainingapps.schoolms.service;

import com.trainingapps.schoolms.constants.CourseType;
import com.trainingapps.schoolms.dto.RegisterStudentRequest;
import com.trainingapps.schoolms.dto.StudentDetails;
import com.trainingapps.schoolms.entity.Student;
import com.trainingapps.schoolms.exceptions.InvalidStudentAgeException;
import com.trainingapps.schoolms.exceptions.InvalidStudentIdException;
import com.trainingapps.schoolms.exceptions.InvalidStudentNameException;
import com.trainingapps.schoolms.exceptions.StudentNotFoundException;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface IStudentService {
    StudentDetails add(@Valid RegisterStudentRequest requestData);

    Student findById(@Min(1)int id) throws StudentNotFoundException;

    StudentDetails findStudentDetailsById(@Min(1)int id) throws StudentNotFoundException;

    void deleteById(@Min(1) int id) ;

    List<StudentDetails>findAll();

}
