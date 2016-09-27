package servlets;

import database.mysql.DataPuller;
import database.mysql.UserFactory;
import database.mysql.Connector;
import database.mysql.User;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet("/registration")
public class Registration extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Connector.class.getName());
    private static final Pattern MAIL = Pattern.compile("^[А-Яа-яA-Za-z0-9]+@[А-Яа-яA-Za-z0-9]+\\.[А-Яа-яA-Za-z0-9]+$", Pattern.CASE_INSENSITIVE);
    private static final Pattern PASS = Pattern.compile("^[А-Яа-яA-Za-z0-9]+$", Pattern.CASE_INSENSITIVE);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = StringEscapeUtils.unescapeHtml4(req.getParameter("username"));
        String email = StringEscapeUtils.unescapeHtml4(req.getParameter("email"));
        String password = StringEscapeUtils.unescapeHtml4(req.getParameter("password"));
        String pass2 = StringEscapeUtils.unescapeHtml4(req.getParameter("password2"));
        req.setAttribute("username", username);
        req.setAttribute("email", email);
        req.setAttribute("password", password);
        req.setAttribute("password2", pass2);
        boolean isLogin, isMail, isPass;
        if (!username.equals("") && !DataPuller.getInst().isLoginExist(username)) {
            isLogin = true;
            req.setAttribute("loginError", "true");
        } else {
            isLogin = false;
            req.setAttribute("loginError", "false");
        }
        if (MAIL.matcher(email).matches()) {
            if (!DataPuller.getInst().isMailExist(email)) {
                req.setAttribute("emailError", "true");
                isMail = true;
            } else {
                isMail = false;
                req.setAttribute("emailError", "false");
            }
        } else {
            isMail = false;
            req.setAttribute("emailError", "false");
        }

        if (PASS.matcher(password).matches()) {
            req.setAttribute("passError", "true");
        } else {
            req.setAttribute("passError", "false");
        }

        if (!password.equals("") && password.equals(pass2)) {
            req.setAttribute("passcError", "true");
            isPass = true;
        } else {
            isPass = false;
            req.setAttribute("passcError", "false");
        }
        if (isLogin && isMail && isPass) {
            User user = UserFactory.getInst().create(username, password, email);
            req.getSession().setAttribute("user", user);
            LOGGER.info("New user registered");
            resp.sendRedirect("/cabinet.jsp");
        } else {
            LOGGER.info("Invalid registration fields");
            getServletContext().getRequestDispatcher("/registration.jsp").forward(req,resp);
        }
    }
}
