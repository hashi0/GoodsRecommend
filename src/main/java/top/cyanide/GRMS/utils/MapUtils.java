package top.cyanide.GRMS.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bai
 */
public class MapUtils {
    private static final MapUtils MAP_UTILS = new MapUtils();
    private Map map = new HashMap<>();

    public static MapUtils newMap() {
        return MAP_UTILS;
    }

    public MapUtils add(Object k, Object v) {
        map.put(k, v);
        return MAP_UTILS;
    }

    public Map get() {
        return map;
    }
}
