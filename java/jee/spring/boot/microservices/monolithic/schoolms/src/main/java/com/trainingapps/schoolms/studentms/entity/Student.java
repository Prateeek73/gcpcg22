package com.trainingapps.schoolms.studentms.entity;

import com.trainingapps.schoolms.departmentms.entity.Department;
import com.trainingapps.schoolms.studentms.constants.CourseType;

import javax.persistence.*;
import java.util.Objects;

@Table(name="students")
@Entity
public class Student {

    @GeneratedValue
    @Id
    private Integer id;

    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private CourseType courseType;

    @ManyToOne
    private Department department;


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

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}