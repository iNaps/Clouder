package database;

import org.apache.log4j.Logger;
import java.sql.SQLException;

public class Uploader {
    private static Uploader inst;
    private Uploader(){}
    public static Uploader getInst() {
        if (inst == null) {
            inst = new Uploader();
        }
        return inst;
    }

    public boolean upload(String fileName, String filePath, int id) {
        try {
            StringBuilder sb = new StringBuilder("insert into files values(");
            sb.append('\'').append(fileName).append("',");
            sb.append('\'').append(filePath).append("',");
            sb.append('\'').append(id).append("')");
            Connector.execute(sb.toString());
            return true;
        } catch (SQLException exc) {
            Logger.getLogger(exc.getMessage());
            return false;
        }
    }
}
