package com.trainingapps.schoolms.departmentms.service;

import com.trainingapps.schoolms.departmentms.dto.ChangeDepartmentNameRequest;
import com.trainingapps.schoolms.departmentms.dto.CreateDepartmentRequest;
import com.trainingapps.schoolms.departmentms.dto.DepartmentDetails;
import com.trainingapps.schoolms.departmentms.entity.Department;
import com.trainingapps.schoolms.departmentms.exceptions.DepartmentNotFoundException;
import com.trainingapps.schoolms.departmentms.repository.IDepartmentRepository;
import com.trainingapps.schoolms.departmentms.util.DepartmentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl  implements IDepartmentService{
    @Autowired
    private IDepartmentRepository repository;

    @Autowired
    private DepartmentUtil departmentUtil;

    @Override
    public DepartmentDetails create(CreateDepartmentRequest request) {
        Department dept=new Department();
        dept.setName(request.getName());
        dept=repository.save(dept);
        DepartmentDetails desired= departmentUtil.toDepartmentDetails(dept);
        return desired;
    }

    @Override
    public Department findById(int id) throws DepartmentNotFoundException {
        Optional<Department> optional=repository.findById(id);
        if(!optional.isPresent()){
            throw new DepartmentNotFoundException("department nt found");
        }
        return optional.get();
    }

    @Override
    public DepartmentDetails findDepartmentDetailsById(int id) throws DepartmentNotFoundException {
        Department department=findById(id);
        DepartmentDetails desired=departmentUtil.toDepartmentDetails(department);
        return desired;
    }

    @Override
    public DepartmentDetails changeName(ChangeDepartmentNameRequest request) throws DepartmentNotFoundException {
        Department dept=findById(request.getDepartmentId());
        dept.setName(request.getNewName()) ;
        repository.save(dept);
        DepartmentDetails desired=departmentUtil.toDepartmentDetails(dept);
        return desired;
    }
}
