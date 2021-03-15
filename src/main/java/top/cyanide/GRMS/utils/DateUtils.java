package top.cyanide.GRMS.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Bai
 */
public class DateUtils {
    public static String date() {
        return DateUtils.date("yyyy-MM-dd HH:mm:ss.SSS");
    }

    public static String date(String pattern) {
        return new SimpleDateFormat(pattern).format(new Date());
    }

    public static String date(Date date) {
        return DateUtils.date(date, "yyyy-MM-dd HH:mm:ss.SSS");
    }

    public static String date(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }
}
