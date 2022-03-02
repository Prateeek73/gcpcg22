package com.t3company;

public interface IEmployeeService {

    public Employee findById(long id);

    public Developer addDeveloper(long id, String name, String createdSoftware);

    public Tester addTester(long id, String name, String createdSoftware);

}
