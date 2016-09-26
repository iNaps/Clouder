package database;
import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersData {
    private static final Logger LOGGER = Logger.getLogger(UsersData.class.getName());
    public static int getId(String login, String pass) {
        try {
            String sql = "SELECT id,password FROM users where login=\"" + login + '"';
            ResultSet set = Connector.getSet(sql);
            while (set.next()) {
                if (set.getString("password").equals(pass)) {
                    LOGGER.info("User is exist");
                    return set.getInt("id");
                }
            }
        } catch (SQLException exc) {
            LOGGER.info("DB error:" + exc);
        }
        return -1;
    }
    public static String getEmail(int id) {
        try {
            String sql = "SELECT email FROM users where id=\"" + id + '"';
            ResultSet set = Connector.getSet(sql);
            if (set.next()) {
                LOGGER.info("Email exist");
                return set.getString("email");
            }
        } catch (SQLException exc) {
            LOGGER.info("DB error:" + exc);
        }
        return "";
    }
    public static boolean isLoginExist(String login) {
        try {
            String sql = "SELECT id FROM users where login=\"" + login + '"';
            ResultSet set = Connector.getSet(sql);
            return set.next();
        } catch (Exception exc){
            LOGGER.info("DB error:" + exc);
            return false;
        }
    }
    public static boolean isMailExist(String email) {
        try {
            String sql = "SELECT id FROM users where email=\"" + email + '"';
            ResultSet set = Connector.getSet(sql);
            return set.next();
        } catch (Exception exc){
            LOGGER.info("DB error:" + exc);
            return false;
        }
    }

    public static int registration(String login, String pass, String email) {
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
                return set.getInt("id");
            }
        } catch (Exception exc){
            LOGGER.info("DB error:" + exc);
        }
        return -1;
    }

    public static boolean updateMail(String oldEmail, String newEmail) {
        String sql = "UPDATE users SET email=\'" + newEmail + "\' where email=\'" + oldEmail + "\'";
        try {
            Connector.execute(sql);
            sql = "DELETE FROM users where email=\"" + newEmail + '"';
            Connector.execute(sql);
            LOGGER.info("Deleted successful");
            return true;
        } catch (SQLException e) {
            LOGGER.info("Email set error occured: " + e);
            return false;
        }
    }
}