package com.trainingapps.schoolms.departmentms.controllers;

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

    @PostMapping("/create")
    public DepartmentDetails createDepartment(@RequestBody CreateDepartmentRequest request) {
          return service.create(request);
    }

    @GetMapping("/byid/{id}")
    public DepartmentDetails findById(@PathVariable int id) throws Exception{
        return service.findDepartmentDetailsById(id);
    }


}
