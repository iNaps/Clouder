package database;

import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Uploader {
    private static final Logger LOGGER = Logger.getLogger(Uploader.class.getName());

    public static boolean upload(String fileName, String filePath, int id) {
        try {
            if (!isExist(fileName, filePath, id)) {
                String sql = "insert into files values(" +
                        '\'' + fileName + "'," +
                        '\'' + filePath + "'," +
                        '\'' + id + "')";
                Connector.execute(sql);
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
     * @return true - if absolutely similar file, else - false
     */
    private static boolean isExist(String fileName, String filePath, int id) {
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
