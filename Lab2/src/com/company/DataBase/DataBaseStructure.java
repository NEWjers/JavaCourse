package com.company.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataBaseStructure {

    private static final String CREATE_ENROLLEE = "CREATE TABLE enrollee (id VARCHAR(10) NOT NULL PRIMARY KEY,name VARCHAR(20),surname VARCHAR(50),birthday VARCHAR(20),subject1 VARCHAR(50),mark1 VARCHAR(3), subject2 VARCHAR(50),mark2 VARCHAR(3),subject3 VARCHAR(50),mark3 VARCHAR(3),speciality_id VARCHAR(10))";
    private static final String DROP_ENROLLEE = "DROP TABLE enrollee";

    private static final String CREATE_SPECIALITY = "CREATE TABLE speciality (id VARCHAR(10) NOT NULL PRIMARY KEY,name VARCHAR(30),subject1 VARCHAR(50),mark1 VARCHAR(3), subject2 VARCHAR(50),mark2 VARCHAR(3),subject3 VARCHAR(50),mark3 VARCHAR(3))";
    private static final String DROP_SPECIALITY = "DROP TABLE speciality";

    private static void createTable(String sqlString) throws Exception{
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlString)){
            statement.executeUpdate();
        }
    }

    private static void dropTable(String sqlString) throws Exception{
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlString)) {
            statement.execute();
        }
    }

    public static void createEnrolleeTable() throws Exception {
        createTable(CREATE_ENROLLEE);
    }

    public static void createSpecialityTable() throws Exception {
        createTable(CREATE_SPECIALITY);
    }

    public static void dropEnrolleeTable() throws Exception {
        dropTable(DROP_ENROLLEE);
    }

    public static void dropSpecialityTable() throws Exception {
        dropTable(DROP_SPECIALITY);
    }

}
