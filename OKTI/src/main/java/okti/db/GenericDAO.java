package okti.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDAO<T extends DatabaseObject> implements DAO<T, Integer> {
    private final Database database;
    private final String tableName;
    
    /**
     * Constructor for GenericDAO object.
     * @param database Database object that will be used for database operations
     * @param tableName Name of the database table
     */
    public GenericDAO(Database database, String tableName) {
        this.database = database;
        this.tableName = tableName;
        
        createIfNotExists();
    }

    @Override
    public T findOne(Integer key) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE id = ?");
        stmt.setInt(1, key);
        
        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        T obj = buildFromResultSet(rs);
  
        stmt.close();
        rs.close();

        conn.close();

        return obj;
    }

    @Override
    public T findLast() throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + tableName + " ORDER BY id DESC LIMIT 1");
        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        T obj = buildFromResultSet(rs);
  
        stmt.close();
        rs.close();

        conn.close();

        return obj;
    }
    
    @Override
    public List<T> findAll() throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + tableName);
        
        ResultSet rs = stmt.executeQuery();
        List<T> all = new ArrayList<>();
        
        while (rs.next()) {
            all.add(buildFromResultSet(rs));
        }
  
        stmt.close();
        rs.close();

        conn.close();

        return all;
    }

    @Override
    public void saveOrUpdate(T object) throws SQLException {
        int objId = -1;
        if (findOne(object.getId()) != null) { // delete old and insert new one
            objId = object.getId();
            delete(object.getId());
        }
        // insert object into the table
        Connection conn = database.getConnection();
        PreparedStatement stmt = generateInsertionStatement(object, conn);
        stmt.execute();
        if (objId != -1) {
            int lastId = this.findLast().getId();
            stmt = conn.prepareStatement("UPDATE " + tableName + " SET id = ? WHERE id = ?");
            stmt.setInt(1, objId);
            stmt.setInt(2, lastId);
            stmt.execute();
        }
    }

    @Override
    public void delete(Integer key) throws SQLException {
        if (key == null) {
            return;
        }
        T object = findOne(key);
        if (object == null) {
            return;
        }
        object.onDeletion(database);
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM " + tableName + " WHERE id = ?");
        stmt.setInt(1, key);
        stmt.execute();
    }

    /**
     * Constructs an object from the result set.
     * @param rs Result set that will be used for construction
     * @return The constructed object
     */
    protected abstract T buildFromResultSet(ResultSet rs);

    /**
     * Generates the insertion SQL statement for inserting the object into the table.
     * @param object Object we are inserting into the table
     * @param conn Database connection
     * @return SQL statement
     */
    protected abstract PreparedStatement generateInsertionStatement(T object, Connection conn);

    /**
     * Creates the table if it does not already exist.
     */
    private void createIfNotExists() {
        try {
            Connection conn = database.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS " + tableName + " " + generateCreateTableParams());
        } catch (SQLException ex) {
            System.out.println("Database table creation failed");
        }
    }
    
    /**
     * Generates parameter part of the CREATE TABLE query for the DAO.
     * @return CREATE TABLE query's parameter part. Must be of the following form: "(param1 type1,\nparam2 type2,\n...,\nparam_n type_n)"
     */
    protected abstract String generateCreateTableParams();
    
    /**
     * Returns the database object
     * @return Database object of GenericDAO
     */
    protected Database getDatabase() {
        return this.database;
    }
}
