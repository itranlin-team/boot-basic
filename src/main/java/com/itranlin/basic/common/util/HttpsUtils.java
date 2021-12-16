package com.itranlin.basic.common.util;


import com.itranlin.basic.common.exception.RequestException;
import com.itranlin.basic.core.bean.StatusEnum;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * HttpsUtils HTTPS连接工具类
 *
 * @author itranlin
 * @date 2020-01-09
 */
public class HttpsUtils {

    /**
     * 发起https请求并获取结果
     *
     * @param url      请求地址
     * @param paramMap 请求参数 key:参数名；value:参数值；
     * @return String 完整含参数地址
     */
    public static String urlAppend(String url, Map<String, String> paramMap) {
        StringBuilder toUrl = new StringBuilder();
        toUrl.append(url).append("?");
        if (null != paramMap) {
            paramMap.forEach((key, value) -> toUrl.append(key).append("=").append(value).append("&"));
        }
        toUrl.deleteCharAt(toUrl.length() - 1);
        return toUrl.toString();
    }

    /**
     * Get请求三方接口地址
     *
     * @param url 请求url
     * @return 接口返回JSON数据
     */
    public static <T> T getHttpClient(String url, Class<T> clazz) {
        URI uri = URI.create(url);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(uri);
        HttpResponse response;
        try {
            response = client.execute(get);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return JacksonUtil.fromString(HttpsUtils.getRespData(response).trim(), clazz);
            } else {
                throw new RequestException(StatusEnum.FAIL, "请求失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Post请求三方接口地址
     *
     * @param url 请求url
     * @return 接口返回JSON数据
     */
    public static <T> T postHttpClient(String url, StringEntity stringEntity, Class<T> clazz) {
        URI uri = URI.create(url);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(uri);
        HttpResponse response;
        try {
            post.setEntity(stringEntity);
            response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return JacksonUtil.fromString(HttpsUtils.getRespData(response).trim(), clazz);
            } else {
                throw new RequestException(StatusEnum.FAIL, "请求失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getRespData(HttpResponse response) {
        try {
            HttpEntity entity = response.getEntity();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(entity.getContent(), StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (String temp = reader.readLine(); temp != null; temp = reader.readLine()) {
                sb.append(temp);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
