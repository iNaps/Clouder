package servlets;

import database.Connector;
import database.Uploader;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold=1024*1024,
                maxFileSize=(long)5*1024*1024*1024,
                maxRequestSize=(long)5*1024*1024*1024)
public class Upload extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Connector.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part file = req.getPart("file");
        byte[] stream = getStream(file);
        String fileName = getFileName(file);
        if (fileName.equals("")) {
            LOGGER.info("Attempt to empty upload");
            resp.sendRedirect("/cabinet.jsp");
            return;
        }
        String md5 = getMD5(stream);
        String dirPath = getDirPath(md5);
        FileOutputStream fos = new FileOutputStream(dirPath);
        for (int value : stream) {
            fos.write(value);
        }
        fos.close();
        String filePath = getUrlPath(md5);
        int id = (Integer) req.getSession().getAttribute("id");
        if (Uploader.getInst().upload(fileName, filePath, id)) {
            resp.sendRedirect("/cabinet.jsp");
        } else {
            resp.sendRedirect("/cabinet.jsp");
            LOGGER.info("Attempt to empty upload");
        }
    }

    private String getUrlPath(String md5) {
        return "userfiles/" + md5.charAt(0) + "/" + md5.charAt(1) + "/" + md5.charAt(2) + "/" + md5;
    }
    private byte[] getStream(Part file) {
        try {
            byte[] fileStream = new byte[(int) file.getSize()];
            InputStream bis = file.getInputStream();
            int i = 0;
            while (bis.available() > 0) {
                fileStream[i++] = (byte) bis.read();
            }
            bis.close();
            return fileStream;
        } catch (Exception exc) {
            Logger.getLogger(exc.getMessage());
        }
        return null;
    }

    private String getFileName(Part file) {
        Pattern regex = Pattern.compile("(?<=filename=\").*?(?=\")");
        Matcher matcher = regex.matcher(file.getHeader("content-disposition"));
        matcher.find();
        String s = matcher.group();
        return StringEscapeUtils.unescapeHtml4(s);
    }

    private String getMD5(byte[] file) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            Logger.getLogger(e.getMessage());
        }
        md.update(file);
        byte[] b = md.digest();
        BigInteger bigInt = new BigInteger(1, b);
        return bigInt.toString(16);
    }

    private String getDirPath(String md5) {
        String dirPath = "webapps/userfiles/" + md5.charAt(0) + "/" + md5.charAt(1) + "/" + md5.charAt(2) + "/";
        File theDir = new File(dirPath);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        return dirPath + md5;
    }
}
