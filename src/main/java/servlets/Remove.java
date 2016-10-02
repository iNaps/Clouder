package servlets;

import database.mysql.Connector;
import database.mysql.DataPuller;
import database.mysql.User;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/remove")
public class Remove extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Connector.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getParameter("path");
        User user = (User)req.getSession().getAttribute("user");
        int id = 0;
        if (user != null) {
            id = user.getId();
        }
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write("id: " + id + "path: " + path);
        if (id != 0 && DataPuller.getInst().removeFile(path, id)) {
            File file = new File("webapps/" + path);
            file.delete();
            resp.sendRedirect("/cabinet.jsp");
        } else {
            resp.sendRedirect("/cabinet.jsp");
            LOGGER.info("Error occured when file removing");
        }
    }
}
