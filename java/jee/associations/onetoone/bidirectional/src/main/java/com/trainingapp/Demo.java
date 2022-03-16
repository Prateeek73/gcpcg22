package com.trainingapp;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class Demo {
    private EntityManagerFactory emf;
    private EntityManager entityManager;

    public static void main(String[] args) {
        Demo app = new Demo();
        app.execute();
    }

    public void execute() {
        emf = Persistence.createEntityManagerFactory("traineems");
        entityManager = emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Address address = new Address("a-32", "noida");
        entityManager.persist(address);
        Trainee trainee = new Trainee("amit", 21, address);
        entityManager.persist(trainee);

        transaction.commit();
        address.setTrainee(trainee);
        int traineeId = trainee.getId();
        int addressId = address.getId();

        Trainee found = findTraineeById(traineeId);
        System.out.println("***found trainee details");
        display(trainee);
        Address traineeAddress = found.getAddress();
        display(traineeAddress);

        System.out.println("****found address details");
        Address foundAddress = findAddressById(addressId);
        display(foundAddress);
        Trainee traineeFromAddress=address.getTrainee();
        display(traineeFromAddress);


        entityManager.close();
        emf.close();
    }

    Trainee findTraineeById(int traineeId) {
        Trainee trainee = entityManager.find(Trainee.class, traineeId);
        return trainee;
    }

    Address findAddressById(int addressId) {
        Address address = entityManager.find(Address.class, addressId);
        return address;
    }

    void displayAll(Collection<Trainee> trainees) {
        for (Trainee trainee : trainees) {
            display(trainee);
        }
    }

    void display(Address address) {
        System.out.println("address=" + address.getId() + " " + address.getCity() + " " + address.getHouseNumber());
    }

    void display(Trainee trainee) {
        System.out.println("trainee inserted " + trainee.getId() + "-" + trainee.getTraineeName() + "-" + trainee.getTraineeAge());

    }

}
