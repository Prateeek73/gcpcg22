package com.trainingapps.schoolms.frontend;

import com.trainingapps.schoolms.entity.Student;
import com.trainingapps.schoolms.service.IStudentService;
import com.trainingapps.schoolms.service.StudentServiceImpl;

public class FrontEnd {
    private IStudentService service = new StudentServiceImpl();

    public void runUI(){
        System.out.println("***adding students");
        Student student1 =service.add("prateek",21);
        Student student2 =service.add("amit",22);
        display(student1);
        display(student2);
        System.out.println("***displaying student by id");
        int student1Id=student1.getId();
        Student found=service.findById(student1Id);
        display(found);
        System.out.println("delete student by id");
        service.deleteById(student1Id);

    }

    void display(Student student){
        System.out.println(student.getId()+"-"+student.getName()+"-"+student.getAge());
    }

}
