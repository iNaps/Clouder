package database;

import database.mysql.User;

public interface UserFactoryDAO {
    User create(String login, String pass, String email);
    User read(String username, String password);
    boolean update();
    boolean delete(int id);
}
