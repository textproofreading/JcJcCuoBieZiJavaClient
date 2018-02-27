package jdk_8_sample;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

//public class HttpUtils {
//}

//package com.beihang.common.utils;

import java.io.File;
        import java.io.FileInputStream;
        import java.io.IOException;
        import java.net.URI;
        import java.security.KeyStore;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Map;

        import javax.net.ssl.SSLContext;

        import org.apache.http.NameValuePair;
        import org.apache.http.client.entity.UrlEncodedFormEntity;
        import org.apache.http.client.methods.CloseableHttpResponse;
        import org.apache.http.client.methods.HttpGet;
        import org.apache.http.client.methods.HttpPost;
        import org.apache.http.client.utils.URIBuilder;
        import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
        import org.apache.http.conn.ssl.SSLContexts;
        import org.apache.http.entity.ContentType;
        import org.apache.http.entity.StringEntity;
        import org.apache.http.impl.client.CloseableHttpClient;
        import org.apache.http.impl.client.HttpClients;
        import org.apache.http.message.BasicNameValuePair;
        import org.apache.http.util.EntityUtils;

public class HttpUtils  {


    public static String doPostJson(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {

            System.out.println("post to:"+  url);

            System.out.println("json content:" + json);
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return resultString;
    }


}
