package com.trainingapps.schoolms.dao;

import com.trainingapps.schoolms.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class StudentDaoImpl implements IStudentDao {

    @PersistenceContext
    //   @Autowired
    private EntityManager entityManager;

    @Override
    public void add(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }

    @Override
    public void deleteById(int id) {
        Student student = findById(id);
        entityManager.remove(student);
    }

    @Override
    public List<Student> findAll() {
        String queryText = "from Student";
        TypedQuery<Student> query = entityManager.createQuery(queryText, Student.class);
        List<Student> values = query.getResultList();
        return values;
    }
}
