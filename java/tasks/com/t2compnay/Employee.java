package com.t2compnay;

class Employee{
    private long id;
    private String name;

    Employee(long id, String name){
        this.id = id;
        this.name = name;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
}