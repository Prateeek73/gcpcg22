package com.trainingapps.schoolms.departmentms.service;

import com.trainingapps.schoolms.departmentms.dto.ChangeDepartmentNameRequest;
import com.trainingapps.schoolms.departmentms.dto.CreateDepartmentRequest;
import com.trainingapps.schoolms.departmentms.dto.DepartmentDetails;
import com.trainingapps.schoolms.departmentms.entity.Department;
import com.trainingapps.schoolms.departmentms.exceptions.DepartmentNotFoundException;

public interface IDepartmentService {

    DepartmentDetails create(CreateDepartmentRequest createRequest);

    Department findById(int id) throws DepartmentNotFoundException;

    DepartmentDetails findDepartmentDetailsById(int id) throws DepartmentNotFoundException;

    DepartmentDetails changeName(ChangeDepartmentNameRequest request)  throws DepartmentNotFoundException;
}
