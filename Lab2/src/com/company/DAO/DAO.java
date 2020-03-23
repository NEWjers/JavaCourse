package com.company.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DAO <T,Key>{
    boolean create(T model)throws SQLException;
    T read(Key key) throws SQLException;
    boolean update(T model) throws SQLException;
    boolean delete(T model) throws SQLException;

    T resultSetToObj(ResultSet rs) throws SQLException;
}
