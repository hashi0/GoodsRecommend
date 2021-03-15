package top.cyanide.GRMS.logger;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bai
 * 日志记录器，采用log4j记录日志
 */
public class Logger {
    private static Map<String, org.slf4j.Logger> loggerMap = new HashMap<>();

    private static org.slf4j.Logger getLogger() {
        Throwable th = new Throwable();
        StackTraceElement[] stes = th.getStackTrace();
        StackTraceElement ste = stes[2];
        String className = ste.getClassName();
        org.slf4j.Logger log = null;
        if (loggerMap.containsKey(className)) {
            log = loggerMap.get(className);
        } else {
            try {
                log = LoggerFactory.getLogger(Class.forName(className));
                loggerMap.put(className, log);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return log;
    }

    public static void debug(String message) {
        Logger.getLogger().debug(message);
    }

    public static void info(String message) {
        Logger.getLogger().info(message);
    }

    public static void warn(String message) {
        Logger.getLogger().warn(message);
    }

    public static void error(String message) {
        Logger.getLogger().error(message);
    }
}
