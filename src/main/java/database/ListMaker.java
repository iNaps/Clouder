package database;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListMaker {
    public static String get(int id) {
        StringBuilder sb = new StringBuilder();
        try {
            String filename, path;
            String sql = "SELECT filename,filepath FROM files where id=\"" + id + '"';
            ResultSet set = Connector.getSet(sql);
            sb.append("<table>");
            while (set.next()) {
                filename = set.getString("filename");
                path = set.getString("filepath");
                sb.append("<tr><td>").append(filename).append("</td>")
                        .append("<td><a href=\"").append(path).append("\" download=\"").append(filename).append("\">")
                        .append("<buttonD>Скачать</buttonD></a></td>")
                        .append("<td><a href=\"/remove?path=").append(path).append("\">")
                        .append("<buttonD>Удалить</buttonD></a></td></tr>");
            }
            sb.append("</table>");
        } catch (SQLException exc){
            Logger.getLogger(exc.getMessage());
        }
        return sb.toString();
    }
}
