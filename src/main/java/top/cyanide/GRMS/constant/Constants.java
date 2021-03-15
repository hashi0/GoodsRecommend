package top.cyanide.GRMS.constant;

/**
 * 存储常量的类
 * @author "Bai"
 */
public class Constants{
    // 图像数据的最大大小，单位字节
    public static final Integer IMAGE_MAXEST_SIZE=1024*1024*1024;

    // 一天的毫秒数
    public static final Long MILLISECOND_OF_ONE_DAY=24*60*60*1000L;

    // 认证超时
    public static final String AUTH_TIMEOUT="AUTH_TIMEOUT";

    // 结果查询标识
    public static final String QUERY_RESULT="result";

    // 图像查询标识
    public static final String QUERY_IMAGE="image";

    // 模型文件后缀
    public static final String MODEL_FILE_SUFFIX=".h5";
}
