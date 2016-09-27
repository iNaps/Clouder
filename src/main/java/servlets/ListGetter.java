package servlets;

import database.mysql.Connector;
import database.mysql.DataPuller;
import database.mysql.User;
import tools.Element;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

@WebServlet("/list")
public class ListGetter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        User user = (User) req.getSession().getAttribute("user");
        ArrayList<Element> list = DataPuller.getInst().getFileList(user.getId());
        StringBuilder sb = new StringBuilder().append("<table>");
        String filename, path;
        for (Element element : list) {
            filename = element.getName();
            path = element.getPath();
            sb.append("<tr><td>").append(filename).append("</td>")
                    .append("<td><a href=\"/download?link=").append(path).append("&filename=").append(filename).append("\">")
                    .append("<buttonD>Скачать</buttonD></a></td>")
                    .append("<td><a href=\"/remove?path=").append(path).append("\">")
                    .append("<buttonD>Удалить</buttonD></a></td></tr>");
        }
        sb.append("</table>");
        out.print(sb);
    }
}

