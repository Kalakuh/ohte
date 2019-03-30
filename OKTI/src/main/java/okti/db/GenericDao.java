package okti.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDao<T extends DatabaseObject> implements DAO<T, Integer>{
    private final Database database;
    private final String tableName;
    
    public GenericDao(Database database, String tableName) {
        this.database = database;
        this.tableName = tableName;
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
        if (findOne(object.getId()) != null) { // delete old and insert new one
            delete(object.getId());
        }
        
        // insert object into the table
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO " + tableName + " " + generateInsertionStatement(object));
        stmt.execute();
    }

    @Override
    public void delete(Integer key) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM " + tableName + " WHERE id = ?");
        stmt.setInt(1, key);
        stmt.execute();
    }

    protected abstract T buildFromResultSet(ResultSet rs);

    /**
     * Generates part of the Insert SQL query. Return value must be of form "(column1, column2, ..) VALUES (value1, value2, ..)".
     * @param object Object we are inserting into the table
     * @return String representing the SQL querys (..) VALUES (..) part
     */
    protected abstract String generateInsertionStatement(T object);
}
