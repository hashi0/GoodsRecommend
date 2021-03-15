package top.cyanide.GRMS.utils;

/**
 * @author Bai
 */
public class LogUtils {
    public static boolean isLogEnabled() {
        return "true".equals(PropUtils.getString("product.logger.enabled"));
    }

    public static boolean isDebugLogEnabled() {
        return "true".equals(PropUtils.getString("product.logger.debug.enabled"));
    }

    public static boolean isInfoLogEnabled() {
        return "true".equals(PropUtils.getString("product.logger.info.enabled"));
    }

    public static boolean isWarnLogEnabled() {
        return "true".equals(PropUtils.getString("product.logger.warn.enabled"));
    }

    public static boolean isErrorLogEnabled() {
        return "true".equals(PropUtils.getString("product.logger.error.enabled"));
    }
}
