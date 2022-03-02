package com.trainingapps.schoolps.frontend;

import com.trainingapps.schoolps.entity.Student;
import com.trainingapps.schoolps.service.IStudentService;
import com.trainingapps.schoolps.service.StudentServiceImpl;
import com.trainingapps.schoolps.exceptions.InvalidStudentIdException;
import com.trainingapps.schoolps.exceptions.InvalidStudentNameException;
import com.trainingapps.schoolps.exceptions.InvalidStudentAgeException;
import com.trainingapps.schoolps.exceptions.StudentNotFoundException;
import java.util.List;

public class FrontEnd{
	private IStudentService service = new StudentServiceImpl();
	public void runUI(){
		try{
			System.out.println("***Adding students***");
			Student student1 = service.add("Prateek", 21);
			Student student2 = service.add("Amit", 22);
			display(student1);
			display(student2);
			System.out.println("***Displaying students by id***");
			int student1Id = student1.getId();
			Student found = service.findById(student1Id);
			display(found);
			System.out.println("***Delete student by id***");
			service.deleteById(student1Id);
			System.out.println("***Displaying all elements in store***");
			List<Student> all = service.findAll();
			displayAll(all);
		} catch(InvalidStudentIdException e){
			//e.printStackTrace();
			System.err.println(e.getMessage());
		} catch(InvalidStudentAgeException e){
			//e.printStackTrace();
			System.err.println(e.getMessage());
		} catch(InvalidStudentNameException e){
			//e.printStackTrace();
			System.err.println(e.getMessage());
		} catch(StudentNotFoundException e){
			//e.printStackTrace();
			System.err.println(e.getMessage());
		} catch(Exception e){
			//e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
	void display(Student student){
		System.out.println(student.getId() + "-" + student.getName() + "-" + student.getAge());
	}
	void displayAll(List<Student> students){
		for(Student student:students){
			display(student);
		}
	}
}