package Servlets;

import database.Registrator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet("/reg")
public class Registration extends HttpServlet {
    private static final Pattern MAIL = Pattern.compile("^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+$", Pattern.CASE_INSENSITIVE);
    private static final Pattern PASS = Pattern.compile("^[A-Za-z0-9]+$", Pattern.CASE_INSENSITIVE);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        String pass2 = req.getParameter("password2");
        String response = "/reg.jsp?login="+login+"&email="+email+"&pass="+pass+"&pass2="+pass2;
        String loginCheck, emailCheck, passCheck, pass2Check;
        boolean isLogin, isMail, isPass;
        Registrator reg = Registrator.getInst();
        if (!reg.isLoginExist(login)) {
            isLogin = true;
            loginCheck = "&loginError=<img src=\"images/yep.png\">";
        } else {
            isLogin = false;
            loginCheck = "&loginError=<img src=\"images/nope.png\">";
        }
        if (MAIL.matcher(email).find()) {
            if (!reg.isMailExist(email)) {
                emailCheck = "&emailError=<img src=\"images/yep.png\">";
                isMail = true;
            } else {
                isMail = false;
                emailCheck = "&emailError=<img src=\"images/nope.png\">";
            }
        } else {
            isMail = false;
            emailCheck = "&emailError=<img src=\"images/nope.png\">";
        }

        if (!PASS.matcher(pass).find()) {
            passCheck = "&passError=<img src=\"images/nope.png\">";
        } else {
            passCheck = "&passError=<img src=\"images/yep.png\">";
        }

        if (pass.equals(pass2)) {
            pass2Check = "&passcError=<img src=\"images/yep.png\">";
            isPass = true;
        } else {
            isPass = false;
            pass2Check = "&passcError=<img src=\"images/nope.png\">";
        }
        if (isLogin && isMail && isPass) {
            reg.reg(login, pass, email);
            HttpSession ss = req.getSession();
            ss.setAttribute("username", login);
            ss.setAttribute("id", reg.getId());
            resp.sendRedirect("/cabinet.jsp");
        } else {
            resp.sendRedirect(response+loginCheck+emailCheck+passCheck+pass2Check);
        }
    }
}
