package database;

import org.apache.log4j.Logger;
import java.sql.SQLException;

public class User {
    private static final Logger LOGGER = Logger.getLogger(UsersData.class.getName());
    private int id;
    private String username;
    private String password;
    private String email;

    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String sql = "UPDATE users SET password=\'" + password + "\' where id=\'" + this.id + "\'";
        try {
            this.password = password;
            Connector.execute(sql);
        } catch (SQLException e) {
            LOGGER.info("Password set error occured: " + e);
        }
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        String sql = "UPDATE users SET email=\'" + email + "\' where id=\'" + this.id + "\'";
        try {
            this.email = email;
            Connector.execute(sql);
        } catch (SQLException e) {
            LOGGER.info("Email set error occured: " + e);
        }
    }
}
