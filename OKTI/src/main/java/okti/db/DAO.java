package okti.db;

import java.sql.*;
import java.util.*;

/**
 * Class provides an interface to database persistence mechanism.
 * @param <T> Type of the saved data
 * @param <K> Type of the primary key, usually an integer
 */
public interface DAO<T, K> {
    /**
     * Find object from database by key.
     * @param key Key of the object
     * @return Object that was found or null
     * @throws SQLException 
     */
    T findOne(K key) throws SQLException;
    
    /**
     * Find all objects in the table.
     * @return All objects in the table
     * @throws SQLException 
     */
    List<T> findAll() throws SQLException;
    
    /**
     * Inserts a new objcet to the table or updates an old row if it exists.
     * @param object Object that is wanted to be saved
     * @throws SQLException 
     */
    void saveOrUpdate(T object) throws SQLException;
    
    /**
     * Deletes an object by key.
     * @param key Key of the element
     * @throws SQLException 
     */
    void delete(K key) throws SQLException;
    
    /**
     * Finds the object that was inserted last.
     * @return Object that was inserted last
     * @throws SQLException 
     */
    T findLast() throws SQLException;
}