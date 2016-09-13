package database;
import org.apache.log4j.Logger;

import java.sql.*;

public class Registrator {

    private static Registrator inst;
    private Registrator(){}
    private String login;
    private int id;
    private String pass;
    private String email;

    public static Registrator getInst() {
        if (inst == null) {
            inst = new Registrator();
        }
        return inst;
    }

    public boolean reg(String login, String pass, String email) {
        try {
            this.login = login;
            this.pass = pass;
            this.email = email;
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
                this.id = set.getInt("id");
                return true;
            } else {
                return false;
            }
        } catch (Exception exc){
            Logger.getLogger(exc.getMessage());
            return false;
        }
    }

    public int getId() {
        return this.id;
    }
}
