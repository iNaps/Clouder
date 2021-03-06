package com.clouder.servlets;

import com.clouder.database.mysql.DataPuller;
import com.clouder.database.mysql.User;
import org.apache.log4j.Logger;
import com.clouder.tools.Encoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/download")
public final class Download extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Download.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null && user.getId() != 0) {
            String filePath = "webapps/" + req.getParameter("link");
            String fileName = Encoder.encode((req.getParameter("filename")));
            if (DataPuller.getInst().isLinkCorrect(req.getParameter("link"), user.getId())) {
                File file = new File(filePath);
                FileInputStream fis = new FileInputStream(file);
                resp.setContentType("application/octet-stream");
                resp.setContentLength((int) file.length());
                resp.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + fileName);
                OutputStream outStream = resp.getOutputStream();
                while (fis.available() > 0) {
                    outStream.write(fis.read());
                }
                fis.close();
                outStream.close();
                LOGGER.info("Download successful");
            } else {
                LOGGER.info("Another user has tried to get access for file");
                resp.setContentType("text/html;charset=UTF-8");
                PrintWriter out = resp.getWriter();
                out.write("You haven't access for other user's files");
            }
        } else {
            LOGGER.info("Unlogged client has tried to get access for file");
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.write("You haven't logged");
        }
    }
}
