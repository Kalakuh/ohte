package okti.domain;

import okti.db.DatabaseObject;

/**
 * This class implements the functionality of users.
 */
public class User extends DatabaseObject {
    private final String username;
    private final String password;
    
    /**
     * Constructor for a user object which are used for managing accounts and their decks.
     * @param username Username of the user
     * @param password (Hashed) password of the user
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * Check if a given password equals to the user's password.
     * @param pass Password to compare with user's password
     * @return True if passwords match
     */
    public boolean checkPassword(String pass) {
        return this.password.equals(pass);
    }
    
    /**
     * Getter for the username.
     * @return The username of the user
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     * Getter for the user's password.
     * @return The password of the user
     */
    public String getPassword() {
        return this.password;
    }
}
