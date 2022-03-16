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
    private String traineeName;
    @Column(name="tage")
    private int traineeAge;

    @JoinColumn(name="address_id_fk")
    @OneToOne
    private Address address;

    public Trainee(){

    }

    public Trainee(String name, int age,Address address){
        this.traineeName = name;
        this.traineeAge =age;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    public int getTraineeAge() {
        return traineeAge;
    }

    public void setTraineeAge(int traineeAge) {
        this.traineeAge = traineeAge;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
