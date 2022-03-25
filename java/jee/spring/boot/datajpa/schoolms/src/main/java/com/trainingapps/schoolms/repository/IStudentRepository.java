package com.trainingapps.schoolms.repository;

import com.trainingapps.schoolms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findByName(String name);

    List<Student>findByAge(int age);

    List<Student>findByNameAndAge(String name, int age);

    boolean existsByName(String name);

    @Query("from Student where name=:nameParam and age=:ageParam")
    List<Student>byNameAndAge(@Param("nameParam") String name,@Param("ageParam") int age);

}
