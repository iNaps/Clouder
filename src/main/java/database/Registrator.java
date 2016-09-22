package database;
import org.apache.log4j.Logger;
import java.sql.*;

public class Registrator {
    private static final Logger LOGGER = Logger.getLogger(Registrator.class.getName());
    private static Registrator inst;
    private Registrator(){}

    public static Registrator getInst() {
        if (inst == null) {
            inst = new Registrator();
            LOGGER.info("Registrator class initialized");
        }
        return inst;
    }

    public boolean isLoginExist(String login) {
        try {
            String sql = "SELECT id FROM users where login=\"" + login + '"';
            ResultSet set = Connector.getSet(sql);
            return set.next();
        } catch (Exception exc){
            LOGGER.info("DB error:" + exc);
            return false;
        }
    }
    public boolean isMailExist(String email) {
        try {
            String sql = "SELECT id FROM users where email=\"" + email + '"';
            ResultSet set = Connector.getSet(sql);
            return set.next();
        } catch (Exception exc){
            LOGGER.info("DB error:" + exc);
            return false;
        }
    }
    public int reg(String login, String pass, String email) {
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
}
