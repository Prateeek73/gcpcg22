package com.trainingapps.schoolms.departmentms.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trainingapps.schoolms.departmentms.dto.CreateDepartmentRequest;
import com.trainingapps.schoolms.departmentms.dto.DepartmentDetails;
import com.trainingapps.schoolms.departmentms.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/departments")
@RestController
public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    private DepartmentDetails bestDepartment;

    public DepartmentController(){
        bestDepartment=new DepartmentDetails();
        bestDepartment.setName("dev");
        bestDepartment.setId(1);
    }


    @PostMapping("/create")
    public DepartmentDetails createDepartment(@RequestBody CreateDepartmentRequest request) {
          return service.create(request);
    }


    @GetMapping("/byid/{id}")
    public DepartmentDetails findById(@PathVariable int id) throws Exception{
        return service.findDepartmentDetailsById(id);
    }

    @HystrixCommand(fallbackMethod = "fallbackDepartmentDetails")
    @GetMapping("/best")
    public DepartmentDetails bestDepartment(){
        System.out.println("****inside best department");
        throw  new RuntimeException();
    }


    public DepartmentDetails fallbackDepartmentDetails(){
        System.out.println("***inside fallbackDepartmentDetails");
        return bestDepartment;
    }



}
