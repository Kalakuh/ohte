package okti.domain;

import okti.db.DatabaseObject;

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
     * Check if a given password equals to the user's password. The implementation is done this way instead of getters to add a bit of security.
     * @param pass Password to compare with user's password
     * @return True if passwords match
     */
    public boolean checkPassword(String pass) {
        return this.password.equals(pass);
    }
}
