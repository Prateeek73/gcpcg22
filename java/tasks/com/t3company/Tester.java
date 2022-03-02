package com.t3company;

public class Tester extends Employee{
    
    private String testedSoftware;

    Tester(long id, String name, String testedSoftware){
        super(id, name);
        this.testedSoftware = testedSoftware;
    }

    public void setTestedSoftware(String testedSoftware){
        this.testedSoftware = testedSoftware;
    }

    public String getTestedSoftware(){
        return this.testedSoftware;
    }
}