package com.trainingapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App2 {
    private EntityManagerFactory emf;
    private EntityManager entityManager;

    public static void main(String[] args) {
        App2 app = new App2();
        app.execute();
    }

    public void execute() {
        emf = Persistence.createEntityManagerFactory("traineems");
        entityManager = emf.createEntityManager();
        Trainee trainee1 = insert("kajal", 21);
        Trainee trainee2 = insert("ananya", 22);
        Trainee trainee3 = insert("harshit", 23);
        int trainee1Id = trainee1.getId();
        int trainee2Id = trainee2.getId();
        System.out.println("***diplaying inserted trainee");
        display(trainee1);
        display(trainee2);
        display(trainee3);

        Trainee fetched = findById(trainee1Id);
        System.out.println("***diplaying fetched trainee details with id " + trainee1Id);
        display(trainee1);


        Trainee traineeUpdate = update(trainee2Id,"hash khuashwaha", 21);
        System.out.println("****trainee updated ");
        display(traineeUpdate);

        entityManager.close();
        emf.close();
    }

    Trainee update(int id, String name, int age) {
        Trainee trainee=new Trainee(name,age);
        trainee.setId(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        trainee=entityManager.merge(trainee);
        transaction.commit();
        return trainee;
    }

    Trainee findById(int id) {
        Trainee trainee = entityManager.find(Trainee.class, id);
        return trainee;
    }

    Trainee insert(String name, int age) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Trainee trainee = new Trainee(name, age);
        entityManager.persist(trainee);
        transaction.commit();
        return trainee;
    }


    void display(Trainee trainee) {
        System.out.println("trainee inserted " + trainee.getId() + "-" + trainee.getName() + "-" + trainee.getAge());

    }

}
