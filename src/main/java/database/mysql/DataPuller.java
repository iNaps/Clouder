package database.mysql;

import database.DataPullerDAO;
import tools.Element;
import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataPuller implements DataPullerDAO {
    private static final Logger LOGGER = Logger.getLogger(DataPuller.class.getName());

    private static DataPuller inst;
    private DataPuller(){}
    public static DataPuller getInst() {
        if (inst == null) {
            inst = new DataPuller();
        }
        return inst;
    }

    public boolean isLoginExist(String login) {
        try {
            String sql = "SELECT id FROM users where login=\"" + login + '"';
            ResultSet set = Connector.getSet(sql);
            return close(set);
        } catch (Exception exc){
            LOGGER.info("DB error:" + exc);
            return false;
        }
    }

    public boolean isMailExist(String email) {
        try {
            String sql = "SELECT id FROM users where email=\"" + email + '"';
            ResultSet set = Connector.getSet(sql);
            return close(set);
        } catch (Exception exc){
            LOGGER.info("DB error:" + exc);
            return false;
        }
    }

    public boolean isLinkCorrect(String link, int id) {
        String sql = "SELECT filepath FROM files where id=\"" + id + '"';
        try {
            ResultSet set = Connector.getSet(sql);
            while (set.next()) {
                if (set.getString("filepath").equals(link)) {
                    LOGGER.info("Filepath OK");
                    close(set);
                    return true;
                }
            }
            close(set);
        } catch (Exception exc) {
            LOGGER.info("DB select error:" + exc);
        }
        return false;
    }

    public String getPassword(String email) {
        try {
            String sql = "SELECT password FROM users where email=\"" + email + '"';
            ResultSet set = Connector.getSet(sql);
            String password = "";
            if (set.next()) {
                LOGGER.info("Email is exist");
                password = set.getString("password");
            }
            close(set);
            return password;
        } catch (SQLException exc) {
            LOGGER.info("DB error:" + exc);
        }
        return null;
    }

    public boolean removeFile(String path, int id) {
        String sql = "SELECT filepath FROM files where filepath=\"" + path + "\" AND id=\"" + id + '"';
        try {
            ResultSet set = Connector.getSet(sql);
            if (set.next()) {
                sql = "DELETE FROM files where filepath=\"" + path + "\" AND id=\"" + id + '"';
                Connector.execute(sql);
                LOGGER.info("Deleted successful");
                sql = "SELECT filepath FROM files where filepath=\"" + path + '"';
                set = Connector.getSet(sql);
                return !close(set);
            }
            close(set);
        } catch (SQLException exc) {
            LOGGER.info("DB error:" + exc.toString());
        }
        return false;
    }

    public boolean uploadFile(String fileName, String filePath, int id) {
        try {
            if (!DataPuller.getInst().isFileExist(fileName, filePath, id)) {
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

    public ArrayList<Element> getFileList(int id) {
        try {
            String filename, path;
            String sql = "SELECT filename,filepath FROM files where id=\"" + id + '"';
            ResultSet set = Connector.getSet(sql);
            ArrayList<Element> list = new ArrayList<Element>();
            while (set.next()) {
                filename = set.getString("filename");
                path = set.getString("filepath");
                list.add(new Element(filename, path));
            }
            close(set);
            LOGGER.info("List was formed");
            return list;
        } catch (SQLException exc){
            LOGGER.info("DB error:" + exc);
            return null;
        }
    }

    /**
     * Checks file uniqueness. Some files can have equals path or names, but files are different.
     * @return true - if absolutely similar file, else - false
     */
    public boolean isFileExist(String fileName, String filePath, int id) {
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
            close(set);
            return isPathExist && isNameExist;
        } catch (Exception exc){
            LOGGER.info("DB error:" + exc);
            return false;
        }
    }

    private boolean close(ResultSet set) throws SQLException {
        if (set.next()) {
            Connector.close();
            LOGGER.info("DB connection was closed");
            return true;
        } else {
            Connector.close();
            return false;
        }
    }
}