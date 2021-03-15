package top.cyanide.GRMS.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Bai
 * @description .配置文件读取工具
 **/
public class PropUtils {
    private static Properties prop;

    static {
        try {
            PropUtils.prop = new Properties();
            PropUtils.prop.load(PropUtils.class.getResourceAsStream("/application.properties"));
            // 获取配置文件中配置的是哪个配置文件
            String activeProfileName = "application-" + PropUtils.getString("spring.profiles.active") + ".properties";
            // 获取当前jar包位置
            String confDir = (new File(new File(new File(PropUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent()).getParent()).getParent() + "/config").split(":")[1];
            File propFile = new File(confDir, activeProfileName);
            if (propFile.exists()) {
                PropUtils.prop.load(new FileInputStream(propFile));
            } else {
                InputStream is = PropUtils.class.getResourceAsStream("/" + activeProfileName);
                if (is != null) {
                    PropUtils.prop.load(is);
                } else {
                    propFile = new File(confDir, "/application.properties");
                    if (propFile.exists()) {
                        PropUtils.prop.load(new FileInputStream(propFile));
                    } else {
                        PropUtils.prop.load(PropUtils.class.getResourceAsStream("/application.properties"));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getInt(String key) {
        return Integer.parseInt(PropUtils.prop.getProperty(key));
    }

    public static int getInt(String key, int defaultValue) {
        if (PropUtils.prop.getProperty(key) == null) {
            return defaultValue;
        }
        return Integer.parseInt(PropUtils.prop.getProperty(key));
    }

    public static long getLong(String key) {
        return Long.parseLong(PropUtils.prop.getProperty(key));
    }

    public static long getLong(String key, long defaultValue) {
        if (PropUtils.prop.getProperty(key) == null) {
            return defaultValue;
        }
        return Long.parseLong(PropUtils.prop.getProperty(key));
    }

    public static String getString(String key, String defaultValue) {
        if (PropUtils.prop.getProperty(key) == null) {
            return defaultValue;
        }
        return PropUtils.prop.getProperty(key);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        if (PropUtils.prop.getProperty(key) == null) {
            return defaultValue;
        }
        return "true".equals(PropUtils.getString(key));
    }

    public static String getString(String key) {
        return PropUtils.prop.getProperty(key);
    }

    public static boolean getBoolean(String key) {
        if (PropUtils.prop.getProperty(key) == null) {
            return false;
        }
        return "true".equals(PropUtils.getString(key));
    }
}
