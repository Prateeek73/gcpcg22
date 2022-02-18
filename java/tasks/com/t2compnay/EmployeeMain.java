package com.t2compnay;

public class EmployeeMain {
    public static void main(String[] args){
        Employee[] employees = new Employee[3];
        employees[0] = new Developer(1, "Jessie Pinkman", "Methanphetamine");
        employees[1] = new Tester(3, "Hank Schrader", "DEA");
        employees[2] = new Developer(1, "Walter White", "Methanphetamine");

        for(Employee employee : employees){
            if(employee instanceof Developer){
                Developer developer = (Developer) employee;
                System.out.println("Class : Developer");
                System.out.println(developer.getId());
                System.out.println(developer.getName());
                System.out.println(developer.getCreatedSoftware());
            }
            else if(employee instanceof Tester){
                Tester tester = (Tester) employee;
                System.out.println("Class : Developer");
                System.out.println(tester.getId());
                System.out.println(tester.getName());
                System.out.println(tester.getTestedSoftware());
            }
        }
    }
}
