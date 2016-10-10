package com.clouder.database;

public interface UserDAO {
    int getId();
    String getUsername();
    boolean setUsername(String username);
    String getPassword();
    boolean setPassword(String password);
    String getEmail();
    boolean setEmail(String email);
}