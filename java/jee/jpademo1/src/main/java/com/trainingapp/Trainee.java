package com.trainingapp;

import javax.persistence.*;
import java.util.Objects;

@Table(name="trainees_data")
@Entity
public class Trainee {
    @GeneratedValue
    @Id
    private Integer id;

    @Column(name="tname")
    private String name;
    @Column(name="tage")
    private int age;

    public Trainee(){

    }

    public Trainee(String name, int age){
        this.name = name;
        this.age=age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainee trainee = (Trainee) o;
        return Objects.equals(id, trainee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
