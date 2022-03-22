package com.trainingapps.schoolms.util;

import com.trainingapps.schoolms.constants.CourseType;
import com.trainingapps.schoolms.dto.StudentDetails;
import com.trainingapps.schoolms.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Component
public class StudentUtil {

    public StudentDetails toStudentDetails(Student student){
        CourseType courseType=student.getCourseType();
        String courseText=courseType.toString();
        StudentDetails desired=new StudentDetails(student.getId(),student.getName(), student.getAge(), courseText);
        return desired;
    }

    public List<StudentDetails> toListStudentDetails(Collection<Student>students){
        List<StudentDetails>desired=new ArrayList<>();
        for (Student student:students){
           StudentDetails response= toStudentDetails(student);
            desired.add(response);
        }
        return desired;
    }

}
