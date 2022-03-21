package com.trainingapps.schoolms.controller;

import com.trainingapps.schoolms.entity.Student;
import com.trainingapps.schoolms.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private IStudentService service;

    //effective url =/students/add
    @PostMapping("/add")
    public Student add(@RequestBody Student requestData) throws Exception {
        Student student = service.add(requestData.getName(), requestData.getAge());
        return student;
    }

    //efective url : /students/byid/idval
    @GetMapping("/byid/{id}")
    public Student findById(@PathVariable int id) throws Exception {
        Student student = service.findById(id);
        return student;
    }

    @GetMapping("/all")
    public List<Student> fetchAll() {
        List<Student> all = service.findAll();
        return all;
    }


}
