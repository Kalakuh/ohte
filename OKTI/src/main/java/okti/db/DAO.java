package okti.db;

import java.sql.*;
import java.util.*;

public interface DAO<T, K> {
    T findOne(K key) throws SQLException;
    List<T> findAll() throws SQLException;
    void saveOrUpdate(T object) throws SQLException;
    void delete(K key) throws SQLException;
    T findLast() throws SQLException;
}