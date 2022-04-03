package com.trainingapps.schoolms.frontend;

import java.util.*;

import com.trainingapps.schoolms.studentms.dto.RegisterStudentRequest;
import com.trainingapps.schoolms.studentms.dto.StudentDetails;
import com.trainingapps.schoolms.studentms.exceptions.StudentNotFoundException;
import com.trainingapps.schoolms.studentms.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FrontEnd {

    @Autowired
    private IStudentService service;

    public void runUI() {
        try {
            System.out.println("***adding students");
            RegisterStudentRequest requestData1 = new RegisterStudentRequest();
            requestData1.setAge(21);
            requestData1.setCourse("cse");
            requestData1.setName("vedant");
            StudentDetails student1 = service.add(requestData1);
            RegisterStudentRequest requestData2 = new RegisterStudentRequest();
            requestData2.setAge(21);
            requestData2.setCourse("ece");
            requestData2.setName("vibhor");

            StudentDetails student2 = service.add(requestData2);
            display(student1);
            display(student2);
            System.out.println("***displaying student by id");
            int student1Id = student1.getId();
            StudentDetails found = service.findStudentDetailsById(student1Id);
            display(found);
            System.out.println("****delete student by id");
            service.deleteById(student1Id);
            System.out.println("****displaying all elements in store");
            List<StudentDetails> all = service.findAll();
            displayAll(all);
        }  catch (StudentNotFoundException e) {
            //e.printStackTrace();
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    void displayAll(Collection<StudentDetails> students) {
        for (StudentDetails student : students) {
            display(student);
        }
    }

    void display(StudentDetails student) {
        System.out.println(student.getId() + "-" + student.getName() + "-" + student.getAge());
    }

}
