package Servlets;

import database.Connector;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/download")
public class Downloader extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = (Integer) req.getSession().getAttribute("id");
        if (id != null) {
            String filePath = "webapps/" + req.getParameter("link");
            String fileName = req.getParameter("filename");
            String sql = "SELECT filepath FROM files where id=\"" + id + '"';
            try {
                ResultSet set = Connector.getSet(sql);
                boolean isFound = false;
                while (set.next()) {
                    if (set.getString("filepath").equals(req.getParameter("link"))) {
                        File file = new File(filePath);
                        FileInputStream fis = new FileInputStream(file);
                        resp.setContentType("application/octet-stream");
                        resp.setContentLength((int) file.length());
                        resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + '"');
                        OutputStream outStream = resp.getOutputStream();
                        while (fis.available() > 0) {
                            outStream.write(fis.read());
                        }
                        fis.close();
                        outStream.close();
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    resp.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = resp.getWriter();
                    out.write("You haven't access for other user's files");
                }
            } catch (SQLException exc) {
                Logger.getLogger(exc.getMessage());
            }
        } else {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.write("You haven't logged");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
