package database;

import org.apache.log4j.Logger;
import java.sql.ResultSet;

public class LinkChecker {
    public static boolean check(String link, int id) {
        String sql = "SELECT filepath FROM files where id=\"" + id + '"';
        try {
            ResultSet set = Connector.getSet(sql);
            while (set.next()) {
                if (set.getString("filepath").equals(link)) {
                    return true;
                }
            }
        } catch (Exception exc) {
            Logger.getLogger(exc.getMessage());
        }
        return false;
    }
}
