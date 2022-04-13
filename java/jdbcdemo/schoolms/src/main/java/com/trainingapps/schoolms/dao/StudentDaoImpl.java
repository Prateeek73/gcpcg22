package com.trainingapps.schoolms.dao;

import com.trainingapps.schoolms.entity.Student;
import com.trainingapps.schoolms.exceptions.StudentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoImpl implements IStudentDao {

    private static final Logger Log = LoggerFactory.getLogger(StudentDaoImpl.class);

    private final String user = "postgres";

    private final String password = "scooby";

    private Connection connection;

    public StudentDaoImpl() {
        createConnection();
    }

    int generatedId;

    public int generateId() {
        return ++generatedId;
    }


    void createConnection() {
        try {
            //  Driver driver=new Driver();
            //     DriverManager.registerDriver(driver);
            //step1 register driver
            Class.forName("org.postgresql.Driver");

            //step2 open connection
            String url = "jdbc:postgresql://localhost:5432/training";

            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            Log.error("exception", e);
        } catch (ClassNotFoundException e) {
            Log.error("error", e);
        }

    }

    @Override
    public Student insert(Student student) throws SQLException {
        String insertQueryText = "insert into students(id, name,age) values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(insertQueryText);
        int id = generateId();
        student.setId(id);
        statement.setInt(1, id);
        statement.setString(2, student.getName());
        statement.setInt(3, student.getAge());
        int rowsUpdated = statement.executeUpdate();
        System.out.println("rows updated=" + rowsUpdated);
        return student;
    }


    @Override
    public Student findById(int id) throws SQLException, StudentNotFoundException {
        String fetchQueryText = "select * from students where id=?";
        PreparedStatement statement = connection.prepareStatement(fetchQueryText);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Student student = new Student();
        if (!resultSet.next()) {
            throw new StudentNotFoundException("student not found for id=" + id);
        }
        String username = resultSet.getString("name");
        int age = resultSet.getInt("age");
        student.setId(id);
        student.setAge(age);
        student.setName(username);
        return student;

    }


    @Override
    public List<Student> findAll() throws SQLException {
        String fetchQueryText = "select * from students";
        PreparedStatement statement = connection.prepareStatement(fetchQueryText);
        ResultSet resultSet = statement.executeQuery();
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println("id=" + id + " name=" + name + " age=" + age);
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setAge(age);
            students.add(student);
        }
        return students;

    }

}
