package servlets;

import database.Confirmator;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/confirmer")
public class Confirmer extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Confirmer.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String md5 = req.getParameter("md5");
        Confirmator.getNewEmail(md5);
        resp.sendRedirect("/cabinet.jsp");
    }
}
