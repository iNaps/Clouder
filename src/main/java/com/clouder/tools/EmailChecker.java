package com.clouder.tools;

import com.clouder.database.mysql.Confirmator;
import org.apache.log4j.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Properties;

public final class EmailChecker {
    private static final Logger LOGGER = Logger.getLogger(EmailChecker.class.getName());
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
    public static void send(String oldEmail, String newEmail) {
        try {
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("smtp.clouder.server@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(newEmail, false));
            msg.setSubject("Email change");

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(oldEmail.getBytes());
            byte[] b = md.digest();
            BigInteger bigInt = new BigInteger(1, b);
            String md5 = bigInt.toString(16);

            Confirmator.getInst().addLink(oldEmail, newEmail, md5);
            msg.setText("Press link to confirm new e-mail: localhost:8080/confirmer?md5=" + md5);
            msg.setSentDate(new Date());
            Transport.send(msg);
        } catch (MessagingException exc) {
            LOGGER.info("Error in sender occured:" + exc);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
