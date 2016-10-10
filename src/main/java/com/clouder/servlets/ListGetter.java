package com.clouder.servlets;

import com.clouder.database.mysql.DataPuller;
import com.clouder.database.mysql.User;
import com.clouder.tools.Element;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

@WebServlet("/list")
public final class ListGetter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        ArrayList<Element> list = DataPuller.getInst().getFileList(user.getId());
        req.setAttribute("list", list);
    }
}

