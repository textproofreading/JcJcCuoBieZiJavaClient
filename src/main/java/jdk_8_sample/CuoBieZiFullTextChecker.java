package jdk_8_sample;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//import com.pythe.common.utils.HttpClientUtil;
//import com.pythe.common.utils.JsonUtils;

public class CuoBieZiFullTextChecker {
    public static void main(String[] args) {
        CuoBieZiFullTextChecker one_obj = new CuoBieZiFullTextChecker();
        String url = "http://api.CuoBieZi.net/spellcheck/chinese/html_result";


        String sentence = "中华人民共和这根邮寄达老旧烟囱已走到生命进头，法轮功她的离去让哦们很悲伤， 中华人民共和李洪志台万第二大金融控股公司富邦金控已与腾讯谈成合作，上述保险产品将由富邦金控旗下内地子公司富邦财险开发或引进。";
        JSONObject json = new JSONObject();
        json.put("content",sentence);
        json.put("username","ctesterd");
        json.put("biz_type","show");
        json.put("mode","advanced");
        json.put("check_sensitive_word",true);


        one_obj.makePostCall(url, sentence);
        //System.out.println(str);
    }


    private String makePostCall(String url,String content){

        if (true){

            try {
                try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

                    List<NameValuePair> form = new ArrayList<>();
                    form.add(new BasicNameValuePair("foo", "bar"));
                    form.add(new BasicNameValuePair("content", content));
                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(form, Consts.UTF_8);

                    HttpPost httpPost = new HttpPost(url);
                    httpPost.setEntity(entity);
                    System.out.println("Executing request " + httpPost.getRequestLine());

                    // Create a custom response handler
                    ResponseHandler<String> responseHandler = response -> {
                        int status = response.getStatusLine().getStatusCode();
                        if (status >= 200 && status < 300) {
                            HttpEntity responseEntity = response.getEntity();
                            return responseEntity != null ? EntityUtils.toString(responseEntity) : null;
                        } else {
                            throw new ClientProtocolException("Unexpected response status: " + status);
                        }
                    };
                    String responseBody = null;
                    try {
                        responseBody = httpclient.execute(httpPost, responseHandler);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("----------------------------------------");
                    System.out.println(responseBody);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            return "";
        }
        return "";
    }

}

