package com.t3ccompany;

public class EmployeeServiceImpl implements IEmployeeService {

    public Employee[] store;
    private int idx;

    public EmployeeServiceImpl(){
        this.store = new Employee[3];
        idx = 0;
    }

    @Override
    public Employee findById(long id) {
        for(Employee employee : store){
            if(employee.getId() == id)
                return employee;
        }
        return null;
    }

    @Override
    public Developer addDeveloper(long id, String name, String createdSoftware) {
        Developer temp_developer = new Developer(1, "Jessie Pinkman", "Methanphetamine");
        store[this.idx++] = temp_developer;
        return null;
    }

    @Override
    public Tester addTester(long id, String name, String createdSoftware) {
        Tester temp_Tester = new Tester(3, "Hank Schrader", "DEA");
        store[this.idx++] = temp_Tester;
        return null;
    }
}