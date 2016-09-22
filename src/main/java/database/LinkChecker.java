package database;

import org.apache.log4j.Logger;
import java.sql.ResultSet;

public class LinkChecker {
    private static final Logger LOGGER = Logger.getLogger(LinkChecker.class.getName());

    public static boolean check(String link, int id) {
        String sql = "SELECT filepath FROM files where id=\"" + id + '"';
        try {
            ResultSet set = Connector.getSet(sql);
            while (set.next()) {
                if (set.getString("filepath").equals(link)) {
                    LOGGER.info("Filepath OK");
                    return true;
                }
            }
        } catch (Exception exc) {
            LOGGER.info("DB select error:" + exc);
        }
        return false;
    }
}
