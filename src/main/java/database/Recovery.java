package database;

import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Recovery {
    private static final Logger LOGGER = Logger.getLogger(Recovery.class.getName());
    public static String check(String email) {
        try {
            String sql = "SELECT password FROM users where email=\"" + email + '"';
            ResultSet set = Connector.getSet(sql);
            if (set.next()) {
                LOGGER.info("Email is exist");
                return set.getString("password");
            }
        } catch (SQLException exc) {
            LOGGER.info("DB error:" + exc);
        }
        return null;
    }
}