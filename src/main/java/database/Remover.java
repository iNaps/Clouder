package database;
import org.apache.log4j.Logger;

import java.sql.SQLException;

public class Remover {
    private static final Logger LOGGER = Logger.getLogger(Remover.class.getName());

    private static Remover inst;
    private Remover(){}
    public static Remover getInst() {
        if (inst == null) {
            inst = new Remover();
        }
        return inst;
    }

    public boolean remove(String path) {
        String sql = "DELETE FROM files where filepath=\"" + path + '"';
        try {
            Connector.execute(sql);
            LOGGER.info("Deleted successful");
            return true;
        } catch (SQLException exc) {
            LOGGER.info("DB error:" + exc);
            return false;
        }
    }
}
