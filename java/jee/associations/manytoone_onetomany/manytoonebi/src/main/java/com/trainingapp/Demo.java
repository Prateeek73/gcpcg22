package com.trainingapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Demo {
    EntityManager entityManager;
    EntityManagerFactory emf;


    public static void main(String[] args) {
        Demo demo=new Demo();
        demo.execute();
    }

    public void execute() {
        emf = Persistence.createEntityManagerFactory("traineems");
        entityManager = emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Department department = new Department();
        department.setName("dev");
        entityManager.persist(department);

        Employee employee1 = new Employee("vedant", department);
        entityManager.persist(employee1);
        Employee employee2 = new Employee("vibhor", department);
        entityManager.persist(employee2);
        transaction.commit();

        Set<Employee> employees=department.getEmployees();
        if(employees==null){
           employees=new HashSet<>();
           department.setEmployees(employees);
        }
        employees.add(employee1);
        employees.add(employee2);

        System.out.println("*** found emnployee and his department");

        long emp1Id=employee1.getId();
        Employee foundEmployee=findEmployeeById(emp1Id);
        display(foundEmployee);

        Department deptFromEmployee=foundEmployee.getDepartment();
        display(deptFromEmployee);

        System.out.println("***found department and all its employees");
        int deptId=department.getId();

       Department foundDepartment= findDepartmentById(deptId);
       Set<Employee>deptEmployees= foundDepartment.getEmployees();
       displayAll(deptEmployees);


        entityManager.close();
        emf.close();
    }

    void display(Department department){
        System.out.println("department-"+department.getId()+" "+department.getName());
    }

    void display(Employee employee){
        System.out.println("employee--"+employee.getId()+" "+employee.getName());
    }

    void displayAll(Collection<Employee> employees){
        for (Employee employee:employees){
            display(employee);
        }
    }

    Employee findEmployeeById(long empId) {
        Employee employee = entityManager.find(Employee.class, empId);
        return employee;
    }

    Department findDepartmentById(int deptId){
        Department department=entityManager.find(Department.class,deptId);
        return department;
    }

}
