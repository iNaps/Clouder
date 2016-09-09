import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold=1024*1024,
                maxFileSize=(long)5*1024*1024*1024,
                maxRequestSize=(long)5*1024*1024*1024)
public class Uploader extends HttpServlet {

    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:8081/clouderdb";
    private final String USER = "admin";
    private final String PASS = "1234";
    private Connection connection;
    private Statement statement;
    private String sql;

    public Uploader() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part file = req.getPart("file");
        byte[] stream = getStream(file);
        String fileName = getFileName(file);
        String md5 = getMD5(fileName);
        String dirPath = getDirPath(md5);
        FileOutputStream fos = new FileOutputStream(dirPath);
        for (int value : stream) {
            fos.write(value);
        }
        fos.close();
        String filePath = getUrlPath(md5);
        int id = (Integer) req.getSession().getAttribute("id");
        try {
            sql = "insert into files (md5,filename,path,ownerid) values("+
                    '"'+md5+"\"," +
                    '"'+fileName+"\"," +
                    '"'+filePath+"\"," +
                    '"'+id+"\")";
            statement.execute(sql);
        } catch (SQLException exc){
            exc.printStackTrace();
        }
    }

    private String getUrlPath(String md5) {
        return  "userfiles/" + md5.charAt(0) + "/" + md5.charAt(1) + "/" + md5.charAt(2) + "/" + md5;
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
            exc.printStackTrace();
        }
        return null;
    }
    private String getFileName(Part file) {
        Pattern regex = Pattern.compile("(?<=filename=\").*?(?=\")");
        Matcher matcher = regex.matcher(file.getHeader("content-disposition"));
        return matcher.find() ? matcher.group() : "unknown";
    }
    private String getMD5(String fileName) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(fileName.getBytes());
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
