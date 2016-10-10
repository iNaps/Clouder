package com.clouder.servlets;

import com.clouder.database.mysql.User;
import org.apache.log4j.Logger;
import com.clouder.tools.EmailChecker;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.regex.Pattern;

@WebServlet("/edit")
public final class Edit extends HttpServlet {
    private static final Pattern MAIL = Pattern.compile("^[А-Яа-яA-Za-z0-9]+@[А-Яа-яA-Za-z0-9]+\\.[А-Яа-яA-Za-z0-9]+$", Pattern.CASE_INSENSITIVE);
    private static final Logger LOGGER = Logger.getLogger(Edit.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            LOGGER.info("Didn't login client");
            return;
        }
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (email != null) {
            if (MAIL.matcher(email).matches()) {
                EmailChecker.send(user.getEmail(), email);
            }
            resp.sendRedirect("/cabinet.jsp");
        } else {
            user.setPassword(password);
            resp.sendRedirect("/cabinet.jsp");
        }
    }
}
