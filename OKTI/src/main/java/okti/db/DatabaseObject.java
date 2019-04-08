package okti.db;

public abstract class DatabaseObject {
    private int id;
    
    /**
     * Getter for the DatabaseObject's id.
     * @return Id of the object
     */
    public int getId() {
        return id;
    }
    
    /**
     * Setter for the DatabaseObject's id.
     * @param id Id of the object
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * A function that's called when the object is deleted from the database.
     * @param db Database object where the object is located
     */
    public void onDeletion(Database db) {
        
    }
}
