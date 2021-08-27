package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface Mysql {
    public void insert(String sql) throws SQLException, ClassNotFoundException;
    public void delete(String sql) throws SQLException, ClassNotFoundException;
    public void update(String sql) throws SQLException, ClassNotFoundException;
    public ArrayList search(String sql) throws SQLException, ClassNotFoundException;
}