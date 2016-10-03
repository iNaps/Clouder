package servlets;

import database.mysql.DataPuller;
import org.apache.log4j.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

@WebServlet("/sender")
public final class Sender extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Sender.class.getName());
    private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    private static final String username = "smtp.clouder.server@gmail.com";//
    private static final String password = "justcat04";
    private static Properties props;
    static {
        props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        if (email != null && !DataPuller.getInst().isMailExist(email)) {
            try {
                Session session = Session.getDefaultInstance(props, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
                String pass = DataPuller.getInst().getPassword(email);
                if (pass != null) {
                    Message msg = new MimeMessage(session);
                    msg.setFrom(new InternetAddress("smtp.clouder.server@gmail.com"));
                    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
                    msg.setSubject("Password recovery");
                    msg.setText("Your pass is: " + pass);
                    msg.setSentDate(new Date());
                    Transport.send(msg);
                    resp.sendRedirect("/login.jsp");
                } else {
                    resp.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = resp.getWriter();
                    out.write("No user exist");
                }
            } catch (MessagingException exc) {
                LOGGER.info("Error in sender occured:" + exc);
            }
        }
    }
}

