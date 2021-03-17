package top.cyanide.GRMS.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import top.cyanide.GRMS.common.constant.Constants;

import java.io.IOException;

/**
 * @author Bai
 */
public class HttpUtils {
    public static String doPost(String url, String token) throws IOException {
        try {
            HttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);
            post.addHeader("Authorization", token);
            JSONObject params = new JSONObject();
            params.put("token", token);
            StringEntity entity = new StringEntity(params.toJSONString());
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            post.setEntity(entity);
            return EntityUtils.toString(client.execute(post).getEntity());
        } catch (HttpHostConnectException e) {
            return Constants.AUTH_TIMEOUT;
        }
    }

    public static String doGet(String url, String token) throws IOException {
        try {
            HttpClient client = HttpClients.createDefault();
            HttpGet get = new HttpGet(url);
            get.addHeader("Authorization", token);
            JSONObject params = new JSONObject();
            params.put("token", token);
            StringEntity entity = new StringEntity(params.toJSONString());
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            return EntityUtils.toString(client.execute(get).getEntity());
        } catch (HttpHostConnectException e) {
            return Constants.AUTH_TIMEOUT;
        }
    }
}
