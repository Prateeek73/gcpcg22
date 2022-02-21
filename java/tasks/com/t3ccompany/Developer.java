package com.t3ccompany;

public class Developer extends Employee{
    
    private String createdSoftware;

    public Developer(long id, String name, String createdSoftware){
        super(id, name);
        this.createdSoftware = createdSoftware;
    }

    public void setCreatedSoftware(String createdSoftware){
        this.createdSoftware = createdSoftware;
    }

    public String getCreatedSoftware(){
        return this.createdSoftware;
    }
}