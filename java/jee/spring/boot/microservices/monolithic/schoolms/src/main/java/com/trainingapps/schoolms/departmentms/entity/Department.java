package com.trainingapps.schoolms.departmentms.entity;

import com.trainingapps.schoolms.studentms.entity.Student;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table(name="departments")
@Entity
public class Department {
    @GeneratedValue
    @Id
    private Integer id;
    private String name;
    @OneToMany(mappedBy="department")
    private List<Student>students;

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
