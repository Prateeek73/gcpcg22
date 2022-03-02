package com.t3company;

public class EmployeeMain extends EmployeeServiceImpl{
    public static void main(String[] args){
        EmployeeServiceImpl serviceImpl = new EmployeeServiceImpl();
       
        serviceImpl.addDeveloper(1, "Jessie Pinkman", "Methanphetamine");
        serviceImpl.addTester(2, "Hank Schrader", "Methanphetamine");
       

        for(Employee employee : serviceImpl.store){
            if(employee instanceof Developer){
                Developer developer = (Developer) employee;
                System.out.println("Class : Developer");
                System.out.println("Id: " + developer.getId());
                System.out.println("Name: " + developer.getName());
                System.out.println("Software Created: " + developer.getCreatedSoftware());
            }
            else if(employee instanceof Tester){
                Tester tester = (Tester) employee;
                System.out.println("Class : Developer");
                System.out.println("Id: " + tester.getId());
                System.out.println("Name: " + tester.getName());
                System.out.println("Tested Software: " + tester.getTestedSoftware());
            }
        }
    }
}
