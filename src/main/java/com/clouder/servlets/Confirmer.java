package com.clouder.servlets;

import com.clouder.database.mysql.Confirmator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/confirmer")
public final class Confirmer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String md5 = req.getParameter("md5");
        Confirmator.getInst().getNewEmail(md5);
        resp.sendRedirect("/cabinet.jsp");
    }
}
