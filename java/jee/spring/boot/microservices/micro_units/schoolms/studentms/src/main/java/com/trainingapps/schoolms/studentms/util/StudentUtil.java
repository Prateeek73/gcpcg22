package com.trainingapps.schoolms.studentms.util;

import com.trainingapps.schoolms.studentms.constants.CourseType;
import com.trainingapps.schoolms.studentms.dto.DepartmentDetails;
import com.trainingapps.schoolms.studentms.dto.StudentDetails;
import com.trainingapps.schoolms.studentms.entity.Student;
import com.trainingapps.schoolms.studentms.exceptions.InvalidCourseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Component
public class StudentUtil {

    @Value("${department.baseUrl}")
    private String baseDepartmentUrl;

    @Autowired
    private RestTemplate restTemplate;

    public StudentDetails toStudentDetails(Student student){
        Integer departmentId= student.getDepartmentId();
        CourseType courseType=student.getCourseType();
        String courseText=courseType.toString();

        StudentDetails desired=new StudentDetails(student.getId(),student.getName(), student.getAge(), courseText);
          if(departmentId!=null){
            DepartmentDetails department=fetchByDepartmentId(departmentId);
            desired.setDepartmentId(departmentId);
            desired.setDepartmentName(department.getName());
        }
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

    public CourseType toEnum(String courseText){
        CourseType values[]=CourseType.values();
        for (CourseType iterated:values){
            String iteratedText=iterated.toString();
            if(iteratedText.equalsIgnoreCase(courseText)){
                return iterated;
            }
        }
        throw new InvalidCourseException("invalid course");
    }

    public DepartmentDetails fetchByDepartmentId(int deptId){
        String url=baseDepartmentUrl+"/byid/"+deptId;
        DepartmentDetails details=restTemplate.getForObject(url,DepartmentDetails.class);
         return details;
    }

}
