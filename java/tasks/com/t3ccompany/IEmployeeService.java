package com.t3ccompany;

public interface IEmployeeService {

    Employee findById(long id);

    Developer addDeveloper(long id, String name, String createdSoftware);

    Tester addTester(long id, String name, String createdSoftware);

}
