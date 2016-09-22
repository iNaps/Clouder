package servlets;

import database.Connector;
import database.Remover;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/remove")
public class Remove extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Connector.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getParameter("path");
        if (Remover.getInst().remove(path)) {
            File file = new File("webapps/" + path);
            file.delete();
            resp.sendRedirect("/cabinet.jsp");
        } else {
            LOGGER.info("Error occured when file removing");
        }
    }
}