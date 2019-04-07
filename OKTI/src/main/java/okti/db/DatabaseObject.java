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
}
