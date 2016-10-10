package com.clouder.database.mysql;

import com.clouder.database.UserDAO;
import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class User implements UserDAO {
    private static final Logger LOGGER = Logger.getLogger(User.class.getName());
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
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return password;
    }

    public boolean setUsername(String username) {
        try {
            String sql = "SELECT login FROM users where login=\'" + username + "\'";
            ResultSet set = Connector.getSet(sql);
            if (!set.next()) {
                sql = "UPDATE users SET login=\'" + username + "\' where id=\'" + this.id + "\'";
                Connector.execute(sql);
                this.username = username;
                return true;
            }
        } catch (SQLException e) {
            LOGGER.info("Password set error occured: " + e);
        }
        return false;
    }

    public boolean setEmail(String email) {
        try {
            String sql = "SELECT email FROM users where email=\'" + email + "\'";
            ResultSet set = Connector.getSet(sql);
            if (!set.next()) {
                sql = "UPDATE users SET email=\'" + email + "\' where id=\'" + this.id + "\'";
                Connector.execute(sql);
                this.email = email;
                return true;
            }
        } catch (SQLException e) {
            LOGGER.info("Email set error occured: " + e);
        }
        return false;
    }

    public boolean setPassword(String password) {
        if (password == null) {
            return false;
        }
        try {
            String sql = "UPDATE users SET password=\'" + password + "\' where id=\'" + this.id + "\'";
            Connector.execute(sql);
            this.password = password;
            return true;
        } catch (SQLException e) {
            LOGGER.info("Password set error occured: " + e);
        }
        return false;
    }
}
