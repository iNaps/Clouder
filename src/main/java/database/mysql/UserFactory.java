package database.mysql;

import database.UserFactoryDAO;
import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class UserFactory implements UserFactoryDAO {
    private static final Logger LOGGER = Logger.getLogger(UserFactory.class.getName());
    private static UserFactory inst;
    private UserFactory(){}

    public static UserFactory getInst() {
        if (inst == null) {
            inst = new UserFactory();
        }
        return inst;
    }

    public User create(String login, String pass, String email) {
        try {
            String sql = "SELECT id FROM users where login=\"" + login + '"';
            ResultSet set = Connector.getSet(sql);
            if (!set.next()) {
                sql = "insert into users (login,email,password) values(\"" + login +
                        "\",\"" + email +
                        "\",\"" + pass + "\")";
                Connector.execute(sql);
                sql = "SELECT id,password FROM users where login=\"" + login + '"';
                set = Connector.getSet(sql);
                set.next();
                return new User(set.getInt("id"), login, email, pass);
            }
        } catch (Exception exc){
            LOGGER.info("DB error:" + exc);
        }
        return null;
    }

    public User read(String username, String passsword) {
        try {
            String sql = "SELECT id,email,password FROM users WHERE login=\"" + username + '"';
            ResultSet set = Connector.getSet(sql);
            while (set.next()) {
                if (set.getString("password").equals(passsword)) {
                    LOGGER.info("User is exist");
                    return new User(set.getInt("id"), username, set.getString("email"), passsword);
                }
            }
        } catch (SQLException exc) {
            LOGGER.info("DB error:" + exc);
        }
        return null;
    }

    public boolean update() {
        return false;
    }

    public boolean delete(int id) {
        try {
            String sql = "DELETE FROM users WHERE id=\"" + id + '"';
            Connector.execute(sql);
            return true;
        } catch (SQLException exc) {
            LOGGER.info("Id doesn't exist" + exc);
            return false;
        }
    }
}
