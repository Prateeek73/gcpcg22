package com.trainingapp;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

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


        System.out.println("*****find trainee by name");
        List<Trainee> list = findByName("harshit");
        displayAll(list);

        System.out.println("********trainees with min age 22");
       List<Trainee>traineesWithMinAge =findTraineesWithAgeGreaterThan(22);
        displayAll(traineesWithMinAge);

        entityManager.close();
        emf.close();
    }

    Trainee update(int id, String name, int age) {
        Trainee trainee = new Trainee(name, age);
        trainee.setId(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        trainee = entityManager.merge(trainee);
        transaction.commit();
        return trainee;
    }

    Trainee findById(int id) {
        Trainee trainee = entityManager.find(Trainee.class, id);
        return trainee;
    }

    List<Trainee> findTraineesWithAgeGreaterThan(int ageArg){
        String ql="from Trainee where traineeAge >= :minAge";
        TypedQuery<Trainee>query=entityManager.createQuery(ql,Trainee.class);
        query.setParameter("minAge",ageArg);
        List<Trainee>list=query.getResultList();
       return list;
    }

    List<Trainee> findByName(String nameArg) {
        String queryText = "from Trainee where traineeName=:traineeName";
        TypedQuery<Trainee> query = entityManager.createQuery(queryText, Trainee.class);
        query.setParameter("traineeName", nameArg);
        List<Trainee> list = query.getResultList();
        return list;
    }

    Trainee insert(String name, int age) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Trainee trainee = new Trainee(name, age);
        entityManager.persist(trainee);
        transaction.commit();
        return trainee;
    }

    void deleteById(int id) {
        Trainee trainee = findById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(trainee);
        transaction.commit();

    }

    void displayAll(Collection<Trainee> trainees){
        for (Trainee trainee:trainees){
            display(trainee);
        }
    }

    void display(Trainee trainee) {
        System.out.println("trainee inserted " + trainee.getId() + "-" + trainee.getTraineeName() + "-" + trainee.getTraineeAge());

    }

}
