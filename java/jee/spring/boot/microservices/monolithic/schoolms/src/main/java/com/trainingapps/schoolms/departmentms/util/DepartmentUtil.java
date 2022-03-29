package com.trainingapps.schoolms.departmentms.util;

import com.trainingapps.schoolms.departmentms.dto.DepartmentDetails;
import com.trainingapps.schoolms.departmentms.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentUtil {

    public DepartmentDetails toDepartmentDetails(Department department){
        DepartmentDetails details=new DepartmentDetails();
        details.setId(department.getId());
        details.setName(department.getName());
        return details;
    }

}
