package tools;

import org.apache.log4j.Logger;
import java.util.regex.Pattern;

public final class Encoder {
    private static final Logger LOGGER = Logger.getLogger(Encoder.class.getName());
    private static final Pattern CHARS = Pattern.compile("^[A-Za-z0-9!#$&+-.~|]?$", Pattern.CASE_INSENSITIVE);
    public static String encode(String s) {
        try {
            final byte[] s_bytes = s.getBytes("UTF-8");
            final int len = s_bytes.length;
            final StringBuilder sb = new StringBuilder(len << 1);
            final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            for (byte b : s_bytes) {
                if (CHARS.matcher(String.valueOf(b)).find())
                    sb.append((char) b);
                else {
                    sb.append('%');
                    sb.append(digits[0x0f & (b >>> 4)]);
                    sb.append(digits[b & 0x0f]);
                }
            }
            return sb.toString();
        } catch (Exception exc){
            LOGGER.info("Encoder error: " + exc.toString());
            return null;
        }
    }
}
