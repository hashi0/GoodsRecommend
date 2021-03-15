package top.cyanide.GRMS.utils;

import java.util.Objects;
import java.util.Random;

/**
 * @author Bai
 */
public class NumUtils {
    public static Integer newRandomInt() {
        return Math.abs(Objects.hash(UuidUtils.simpleUUID(), new Random().nextInt(Integer.MAX_VALUE)));
    }
}
