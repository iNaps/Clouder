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
            String sql = "insert into files (filename,filepath,id) values(" +
                    '"' + fileName + "\"," +
                    '"' + filePath + "\"," +
                    '"' + id + "\")";
            Connector.execute(sql);
            return true;
        } catch (SQLException exc) {
            Logger.getLogger(exc.getMessage());
            return false;
        }
    }
}
