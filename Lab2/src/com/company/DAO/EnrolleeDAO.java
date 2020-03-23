package com.company.DAO;

import com.company.Model.Enrollee;

import javax.validation.constraints.NotNull;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnrolleeDAO implements DAO<Enrollee,String> {

    enum EnrolleeSQL {
        GET("SELECT * FROM enrollee  WHERE enrollee.id = (?)"),
        INSERT("INSERT INTO enrollee (id, name, surname, birthday, subject1, mark1, subject2, mark2, subject3, mark3) VALUES ((?), (?), (?), (?), (?),(?), (?), (?), (?), (?)) RETURNING id"),
        DELETE("DELETE FROM enrollee WHERE id = (?) RETURNING id"),
        UPDATE("UPDATE enrollee SET mark1 = (?), mark2 = (?), mark3 = (?) WHERE id = (?) RETURNING id");

        String QUERY;

        EnrolleeSQL(String QUERY){
            this.QUERY = QUERY;
        }
    }

    private final Connection connection;

    public EnrolleeDAO(@NotNull final Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean create(Enrollee enrollee) throws SQLException {
        boolean result = false;
        try (PreparedStatement statement = connection.prepareStatement(EnrolleeSQL.INSERT.QUERY)) {
            statement.setString(1, enrollee.getId());
            statement.setString(2, enrollee.getName());
            statement.setString(3, enrollee.getSurname());
            statement.setString(4, enrollee.getBirthday());
            statement.setString(5,enrollee.getZNO1().getSubject());
            statement.setString(6,Integer.toString(enrollee.getZNO1().getMark()));
            statement.setString(7,enrollee.getZNO2().getSubject());
            statement.setString(8,Integer.toString(enrollee.getZNO2().getMark()));
            statement.setString(9,enrollee.getZNO3().getSubject());
            statement.setString(10,Integer.toString(enrollee.getZNO3().getMark()));
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Enrollee read(String id) throws SQLException {
        Enrollee result = new Enrollee();
        result.setId("A");

        try (PreparedStatement statement = connection.prepareStatement(EnrolleeSQL.GET.QUERY)) {
            statement.setString(1, id);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result.setId(String.valueOf(resultSet.getString("id")));
                result.setName(resultSet.getString("name"));
                result.setSurname(resultSet.getString("surname"));
                result.setBirthday(resultSet.getString("birthday"));
                result.setZNO(resultSet.getString("subject1"),Integer.parseInt(resultSet.getString("mark1")),1);
                result.setZNO(resultSet.getString("subject2"),Integer.parseInt(resultSet.getString("mark2")),2);
                result.setZNO(resultSet.getString("subject3"),Integer.parseInt(resultSet.getString("mark3")),3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Enrollee enrollee) throws SQLException {
        boolean result = false;

        try(PreparedStatement statement = connection.prepareStatement(EnrolleeSQL.UPDATE.QUERY)) {
            statement.setString(1, Integer.toString(enrollee.getZNO1().getMark()));
            statement.setString(2, Integer.toString(enrollee.getZNO2().getMark()));
            statement.setString(3, Integer.toString(enrollee.getZNO3().getMark()));
            statement.setString(4, enrollee.getId());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Enrollee enrollee) throws SQLException {
        boolean result = false;

        try(PreparedStatement statement = connection.prepareStatement(EnrolleeSQL.DELETE.QUERY)) {
            statement.setString(1, enrollee.getId());
            result = statement.executeQuery().next();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Enrollee resultSetToObj(ResultSet rs) throws SQLException {
        Enrollee enrollee = new Enrollee();

        if(rs.next()) {
            enrollee.setId(rs.getString("id"));
            enrollee.setName(rs.getString("name"));
            enrollee.setSurname(rs.getString("surname"));
            enrollee.setBirthday(rs.getString("wage"));
            enrollee.setZNO(rs.getString("subject1"),Integer.parseInt(rs.getString("mark1")),1);
            enrollee.setZNO(rs.getString("subject2"),Integer.parseInt(rs.getString("mark2")),2);
            enrollee.setZNO(rs.getString("subject3"),Integer.parseInt(rs.getString("mark3")),3);
        }

        return enrollee;
    }
}
