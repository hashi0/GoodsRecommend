package top.cyanide.GRMS.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializeConfig;

/**
 * @author Bai
 **/
public class StringUtils {
    public static boolean equals(String aStr, String bStr) {
        if (aStr != null) return aStr.equals(bStr);
        else return false;
    }

    public static boolean equalsIgnoreCase(String aStr, String bStr) {
        if (aStr != null) {
            return aStr.toLowerCase().equals(bStr.toLowerCase()) && aStr.toUpperCase().equals(bStr.toUpperCase());
        } else {
            return false;
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equalsIgnoreCase(str);
    }

    public static boolean isNotEmpty(String str) {
        return str != null && !"".equals(str);
    }

    public static String toString(Object o) {
        SerializeConfig config = new SerializeConfig();
        config.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
        return JSON.toJSONString(o, config);
    }
}
