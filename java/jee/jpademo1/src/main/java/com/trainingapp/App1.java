package com.trainingapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App1 {


    public static void main(String[] args) {
        App1 app = new App1();
        app.execute();
    }

    public void execute() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("traineems");
        EntityManager entityManager = emf.createEntityManager();
        Trainee trainee1 = new Trainee("prakhar", 21);
        Trainee trainee2 = new Trainee("harsh", 22);
        Trainee trainee3 = new Trainee("sneha", 23);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(trainee1);
        entityManager.persist(trainee2);
        entityManager.persist(trainee3);
        transaction.commit();
        int trainee1Id=trainee1.getId() ;
        int trainee2Id=trainee2.getId();
        System.out.println("***diplaying inserted trainee");
        display(trainee1);
        display(trainee2);
        display(trainee3);

        Trainee fetched=entityManager.find(Trainee.class,trainee1Id);
        System.out.println("***diplaying fetched trainee details with id "+trainee1Id);
        display(fetched);


        EntityTransaction transaction2=entityManager.getTransaction();
        transaction2.begin();
        Trainee traineeUpdate=new Trainee("hash khuashwaha",21);
        traineeUpdate.setId(trainee2Id);
        entityManager.merge(traineeUpdate);

        Trainee trainee4=new Trainee("nancy",21);
        trainee4=entityManager.merge(trainee4);

        transaction2.commit();
        System.out.println("****trainee updated ");
        display(traineeUpdate);

        System.out.println("****trainee updated ");
        System.out.println("inserted trainee");
        display(trainee4);

        entityManager.close();
        emf.close();
    }

    void display(Trainee trainee) {
        System.out.println("trainee inserted " + trainee.getId() + "-" + trainee.getName() + "-" + trainee.getAge());

    }

}
