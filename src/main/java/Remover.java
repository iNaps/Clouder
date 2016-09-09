import database.Connector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/remove")
public class Remover extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getParameter("path");
        String sql = "DELETE FROM files where path=\"" + path + '"';
        try {
            Connector.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        File file = new File("webapps/" + path);
        file.delete();
    }
}
