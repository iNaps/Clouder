package com.clouder.database.mysql;

import com.clouder.database.ConfirmatorDAO;
import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class Confirmator implements ConfirmatorDAO {
    private static final Logger LOGGER = Logger.getLogger(Confirmator.class.getName());

    private static Confirmator inst;
    private Confirmator(){}
    public static Confirmator getInst() {
        if (inst == null) {
            inst = new Confirmator();
        }
        return inst;
    }

    public void addLink(String oldEmail, String newEmail, String md5) {
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
    public void getNewEmail(String md5) {
        try {
            String sql = "SELECT oldmail,newmail FROM emailconfirm where md5=\"" + md5 + '"';
            ResultSet set = Connector.getSet(sql);
            String oldmail, newmail;
            while (set.next()) {
                oldmail = set.getString("oldmail");
                newmail = set.getString("newmail");
                Connector.close();
                updateMail(oldmail, newmail);
            }
            LOGGER.info("Added new rec");
        } catch (SQLException exc) {
            LOGGER.info("DB error:" + exc);
        }
    }
    private boolean updateMail(String oldEmail, String newEmail) {
        String sql = "UPDATE users SET email=\'" + newEmail + "\' where email=\'" + oldEmail + "\'";
        try {
            Connector.execute(sql);
            sql = "DELETE FROM emailconfirm where newmail=\"" + newEmail + '"';
            Connector.execute(sql);
            LOGGER.info("Deleted successful");
            return true;
        } catch (SQLException e) {
            LOGGER.info("Email set error occured: " + e);
            return false;
        }
    }
}
