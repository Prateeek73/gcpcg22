package com.trainingapps.schoolms.frontend;

import java.util.*;
import com.trainingapps.schoolms.entity.Student;
import com.trainingapps.schoolms.exceptions.InvalidStudentAgeException;
import com.trainingapps.schoolms.exceptions.InvalidStudentIdException;
import com.trainingapps.schoolms.exceptions.InvalidStudentNameException;
import com.trainingapps.schoolms.exceptions.StudentNotFoundException;
import com.trainingapps.schoolms.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FrontEnd {

    @Autowired
    private IStudentService service ;

    public void runUI(){
    	try {
        System.out.println("***adding students");
        Student student1 =service.add("prateek",21);
        Student student2 =service.add("amit",22);
        display(student1);
        display(student2);
        System.out.println("***displaying student by id");
        int student1Id=student1.getId();
        Student found=service.findById(student1Id);
        display(found);
        System.out.println("****delete student by id");
        service.deleteById(student1Id);
        System.out.println("****displaying all elements in store");
        List<Student>all=service.findAll();
        displayAll(all);
    	}catch(InvalidStudentIdException e) {
    		//e.printStackTrace();
    		System.err.println(e.getMessage());
    	}
    	catch(InvalidStudentAgeException e) {
    		//e.printStackTrace();
    		System.err.println(e.getMessage());
        		
    	}
    	catch(InvalidStudentNameException e) {
    		//e.printStackTrace();
    		System.err.println(e.getMessage());
        	
    	}
    	catch(StudentNotFoundException e) {
    		//e.printStackTrace();
    		System.err.println(e.getMessage());
    	}
    	catch(Exception e){
    		System.err.println(e.getMessage());
    	}
    	
      }
    
    void  displayAll(Collection<Student>students){
      for(Student student:students){
          display(student);
      }
    }

    void display(Student student){
        System.out.println(student.getId()+"-"+student.getName()+"-"+student.getAge());
    }

}
