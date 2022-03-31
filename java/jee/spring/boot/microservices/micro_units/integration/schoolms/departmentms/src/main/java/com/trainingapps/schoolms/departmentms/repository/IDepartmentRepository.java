package com.trainingapps.schoolms.departmentms.repository;

import com.trainingapps.schoolms.departmentms.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department,Integer> {
}
