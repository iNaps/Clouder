package database;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Confirmator {
    private static final Logger LOGGER = Logger.getLogger(Confirmator.class.getName());

    public static void addLink(String oldEmail, String newEmail, String md5) {
        try {
            String sql = "insert into emailconfirm values(" +
                    '\'' + oldEmail + "'," +
                    '\'' + newEmail + "'," +
                    '\'' + md5 + "')";
            Connector.execute(sql);
            LOGGER.info("Added new rec");
        } catch (SQLException exc) {
            LOGGER.info("DB error:" + exc);
        }
    }
    public static void getNewEmail(String md5) {
        try {
            String sql = "SELECT oldmail,newmail FROM emailconfirm where md5=\"" + md5 + '"';
            ResultSet set = Connector.getSet(sql);
            String oldmail, newmail;
            while (set.next()) {
                oldmail = set.getString("oldmail");
                newmail = set.getString("newmail");
                UsersData.updateMail(oldmail, newmail);
            }
            LOGGER.info("Added new rec");
        } catch (SQLException exc) {
            LOGGER.info("DB error:" + exc);
        }
    }
}
