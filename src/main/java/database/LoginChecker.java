package database;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginChecker {
    public static int check(String login, String pass) {
        try {
            String sql = "SELECT id,password FROM users where login=\"" + login + '"';
            ResultSet set = Connector.getSet(sql);
            while (set.next()) {
                if (set.getString("password").equals(pass)) {
                    return set.getInt("id");
                }
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return -1;
    }
}
