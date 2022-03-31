package com.trainingapps.schoolms.studentms.controller;

import com.trainingapps.schoolms.studentms.dto.AddStudentInDepartmentRequest;
import com.trainingapps.schoolms.studentms.dto.RegisterStudentRequest;
import com.trainingapps.schoolms.studentms.dto.StudentDetails;
import com.trainingapps.schoolms.studentms.service.IStudentService;
import com.trainingapps.schoolms.studentms.util.StudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private IStudentService service;

    @Autowired
    private StudentUtil studentUtil;


    //effective url =/students/add ,
    // @RequestMapping(path="/add",method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/add")
    public StudentDetails add(@RequestBody RegisterStudentRequest requestData) throws Exception {
        StudentDetails response = service.add(requestData);
        return response;
    }


    //efective url : /students/byid/idval, java->json
    //@RequestMapping(path="/byid/{id}",method=RequestMethod.GET)
    @GetMapping("/byid/{id}")
    public StudentDetails findById(@PathVariable int id) throws Exception {
        StudentDetails response = service.findStudentDetailsById(id);
        return response;
    }

    @GetMapping("/byname/{name}")
    public List<StudentDetails> fetchStudentsByName(@PathVariable String name) {
        List<StudentDetails> response = service.findByName(name);
        return response;
    }

    @PutMapping("/departments/add")
    public StudentDetails addToDepartment(@RequestBody AddStudentInDepartmentRequest request) throws Exception{
        StudentDetails response=service.addInDepartment(request);
        return response;
    }

    @GetMapping("/all")
    public List<StudentDetails> fetchAll() {
        List<StudentDetails> response = service.findAll();
        return response;
    }


}
