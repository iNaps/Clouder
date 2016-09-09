import database.LoginChecker;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        HttpSession session = req.getSession();
        if (req.getParameter("exit") != null) {
            session.invalidate();
            return;
        }
        int id = LoginChecker.check(login, pass);
        if (id > 0) {
            session.setAttribute("username", login);
            session.setAttribute("id", id);
            resp.sendRedirect("/cabinet.jsp");
        } else {
            out.print("false");
        }
    }
}
