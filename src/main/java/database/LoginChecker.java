package database;
import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginChecker {
    private static final Logger LOGGER = Logger.getLogger(LoginChecker.class.getName());
    public static int check(String login, String pass) {
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
}