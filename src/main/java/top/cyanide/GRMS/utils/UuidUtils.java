package top.cyanide.GRMS.utils;

import cn.hutool.core.util.IdUtil;

/**
 * @author Bai
 */
public class UuidUtils{
    public static String simpleUUID(){
        return IdUtil.fastSimpleUUID();
    }
}
