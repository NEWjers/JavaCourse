package com.company.Test;

import com.company.DAO.EnrolleeDAO;
import com.company.DataBase.DataBaseConnection;
import com.company.Model.Enrollee;
import com.company.Model.Exam;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

public class EnrolleeDAOTest {

    @Test public void createTest() throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        EnrolleeDAO io = new EnrolleeDAO(connection);
        Enrollee Student3 = new Enrollee.Builder()
                .withId("3")
                .withName("Margarita")
                .withSurname("Boiko")
                .withBirthDay("23.03.2000")
                .withZNO(new Exam(195,"Ukrainian"),new Exam(177,"Math"),new Exam(169,"English"))
                .build();
        io.create(Student3);
    }

    @Test public void updateTest() throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        EnrolleeDAO io = new EnrolleeDAO(connection);
        Enrollee Student3 = new Enrollee.Builder()
                .withId("3")
                .withName("Margarita")
                .withSurname("Boiko")
                .withBirthDay("23.03.2000")
                .withZNO(new Exam(190,"Ukrainian"),new Exam(170,"Math"),new Exam(170,"English"))
                .build();
        io.update(Student3);
    }

    @Test public void deleteTest() throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        EnrolleeDAO io = new EnrolleeDAO(connection);
        Enrollee Student3 = new Enrollee.Builder()
                .withId("3")
                .withName("Margarita")
                .withSurname("Boiko")
                .withBirthDay("23.03.2000")
                .withZNO(new Exam(195,"Ukrainian"),new Exam(177,"Math"),new Exam(169,"English"))
                .build();
        io.delete(Student3);
    }
}
