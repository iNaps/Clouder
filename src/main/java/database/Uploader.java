package database;

import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Uploader {
    private static final Logger LOGGER = Logger.getLogger(Uploader.class.getName());
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
            if (!isExist(fileName, filePath, id)) {
                StringBuilder sb = new StringBuilder("insert into files values(");
                sb.append('\'').append(fileName).append("',");
                sb.append('\'').append(filePath).append("',");
                sb.append('\'').append(id).append("')");
                Connector.execute(sb.toString());
                LOGGER.info("Upload OK");
                return true;
            } else {
                LOGGER.info("Upload FAIL");
                return false;
            }
        } catch (SQLException exc) {
            LOGGER.info("DB error:" + exc);
            return false;
        }
    }

    /**
     * Checks file uniqueness. Some files can have equals path or names, but files are different.
     * @return true if absolutely similar file, else false
     */
    public boolean isExist(String fileName, String filePath, int id) {
        try {
            String sql = "SELECT filepath FROM files WHERE filepath=\"" +filePath+ "\" AND id=\"" + id + '"';
            ResultSet set = Connector.getSet(sql);
            boolean isPathExist = set.next();
            sql = "SELECT filename FROM files WHERE filename=\"" +fileName+ "\" AND id=\"" + id + '"';
            set = Connector.getSet(sql);
            boolean isNameExist = false;
            if (set.next()) {
                isNameExist = set.getString("filename").equals(fileName);
            }
            return isPathExist && isNameExist;
        } catch (Exception exc){
            LOGGER.info("DB error:" + exc);
            return false;
        }
    }
}
