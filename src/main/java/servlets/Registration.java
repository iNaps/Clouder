package servlets;

import database.Connector;
import database.Registrator;
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
        String login = StringEscapeUtils.unescapeHtml4(req.getParameter("login"));
        String email = StringEscapeUtils.unescapeHtml4(req.getParameter("email"));
        String pass = StringEscapeUtils.unescapeHtml4(req.getParameter("password"));
        String pass2 = StringEscapeUtils.unescapeHtml4(req.getParameter("password2"));
        req.setAttribute("login", login);
        req.setAttribute("email", email);
        req.setAttribute("pass", pass);
        req.setAttribute("pass2", pass2);
        boolean isLogin, isMail, isPass;
        Registrator reg = Registrator.getInst();
        if (!login.equals("") && !reg.isLoginExist(login)) {
            isLogin = true;
            req.setAttribute("loginError", "true");
        } else {
            isLogin = false;
            req.setAttribute("loginError", "false");
        }
        if (MAIL.matcher(email).matches()) {
            if (!reg.isMailExist(email)) {
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

        if (PASS.matcher(pass).matches()) {
            req.setAttribute("passError", "true");
        } else {
            req.setAttribute("passError", "false");
        }

        if (!pass.equals("") && pass.equals(pass2)) {
            req.setAttribute("passcError", "true");
            isPass = true;
        } else {
            isPass = false;
            req.setAttribute("passcError", "false");
        }
        if (isLogin && isMail && isPass) {
            int id = reg.reg(login, pass, email);
            HttpSession ss = req.getSession();
            ss.setAttribute("username", login);
            ss.setAttribute("id", id);
            LOGGER.info("New user registered");
            resp.sendRedirect("/cabinet.jsp");
        } else {
            LOGGER.info("Invalid registration fields");
            getServletContext().getRequestDispatcher("/registration.jsp").forward(req,resp);
        }
    }
}
