
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;


/*
            www.CuoBieZi.net

            我们正在考虑推出基于 Kotlin 的测试代码！

            欢迎关注作者微博： http://weibo.com/tianchunfeng


 */
public class JcJcPoster {

    public static void main(String[] argv) throws Exception {
        String url_str = "";
        url_str = "http://api.cuobiezi.net/spellcheck/json_check/json_phrase";
        String json_data = "{    \"username\":\"tester\"   ,             \"content\": \"腾讯今年中国人民共和国下半年上世纪将在微信账户钱包帐户的“九宫格”中开设快速的笑着保险入口，并上线保险产品。台万第二大金融控股公司富邦金控已与腾讯谈成合作，上述保险产品将由富邦金控旗下内地子公司富邦财险开发或引进。\",                    \"mode\": \"advanced\",                    \"biz_type\": \"show\"        }";
        String result = sendPost2(url_str, json_data);
        System.out.println(result);
    }


    private static String sendPost2(String urlStr, String dataJSON) throws Exception {


        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");

        OutputStream os = conn.getOutputStream();
        os.write(dataJSON.getBytes("UTF-8"));
        os.close();

        // read the response
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = new BufferedReader(new InputStreamReader(in)).lines().collect(Collectors.joining("\n"));

        in.close();
        conn.disconnect();

        return result;

    }


}


/**
 * try {
 * <p>
 * <p>
 * <p>
 * HttpPost request = new HttpPost();
 * HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead
 * <p>
 * <p>
 * StringEntity params =new StringEntity(  json_data );
 * request.addHeader("content-type", "application/json;charset=UTF-8");
 * request.setEntity(params);
 * <p>
 * //application/x-www-form-urlencoded
 * //"application/json;charset=UTF-8"
 * <p>
 * <p>
 * //"application/json;charset=UTF-8"
 * <p>
 * <p>
 * HttpResponse response = httpClient.execute(request);
 * <p>
 * // String body = IOUtils.toString(in, encoding);
 * // System.out.println(body);
 * //handle response here...
 * <p>
 * HttpEntity entity = response.getEntity();
 * String responseString = EntityUtils.toString(entity, "UTF-8");
 * System.out.println(responseString);
 * <p>
 * <p>
 * }catch (Exception ex) {
 * <p>
 * //handle exception here
 * <p>
 * } finally {
 * //Deprecated
 * //httpClient.getConnectionManager().shutdown();
 * }
 * import org.apache.http.Consts;
 * import org.apache.http.HttpEntity;
 * import org.apache.http.NameValuePair;
 * import org.apache.http.client.ClientProtocolException;
 * import org.apache.http.client.ResponseHandler;
 * import org.apache.http.client.entity.UrlEncodedFormEntity;
 * import org.apache.http.client.methods.HttpPost;
 * import org.apache.http.impl.client.CloseableHttpClient;
 * import org.apache.http.impl.client.HttpClients;
 * import org.apache.http.message.BasicNameValuePair;
 * import org.apache.http.util.EntityUtils;
 * <p>
 * import java.io.IOException;
 * import java.util.ArrayList;
 * import java.util.List;
 * <p>
 * public class JcJcPoster {
 * <p>
 * <p>
 * <p>
 * public static void main(String... args) throws IOException {
 * <p>
 * <p>
 * <p>
 * <p>
 * HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead
 * <p>
 * try {
 * <p>
 * HttpPost request = new HttpPost("http://117.121.10.43:8234/spellcheck/json_check/json_phrase");
 * StringEntity params =new StringEntity(  "{
 * \"content\": \"腾讯今年中国人民共和国下半年上世纪将在微信账户钱包帐户的“九宫格”中开设快速的笑着保险入口，并上线保险产品。台万第二大金融控股公司富邦金控已与腾讯谈成合作，上述保险产品将由富邦金控旗下内地子公司富邦财险开发或引进。\",
 * \"mode\": \"advanced\",
 * \"biz_type\": \"show\"
 * }"     );
 * request.addHeader("content-type", "application/x-www-form-urlencoded");
 * request.setEntity(params);
 * HttpResponse response = httpClient.execute(request);
 * <p>
 * //handle response here...
 * <p>
 * }catch (Exception ex) {
 * <p>
 * //handle exception here
 * <p>
 * } finally {
 * //Deprecated
 * //httpClient.getConnectionManager().shutdown();
 * }
 * <p>
 * <p>
 * <p>
 * <p>
 * if (true){
 * // 下面的代码失效，请使用上面的代码。
 * return ;
 * }
 * <p>
 * try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
 * <p>
 * List<NameValuePair> form = new ArrayList<>();
 * form.add(new BasicNameValuePair("content", "我最喜欢的就是元霄节吃汤圆，中国人民共和国。"));
 * form.add(new BasicNameValuePair("check_mode", "advanced"));
 * form.add(new BasicNameValuePair("action", "show"));
 * form.add(new BasicNameValuePair("username", "tester"));
 * UrlEncodedFormEntity entity = new UrlEncodedFormEntity(form, Consts.UTF_8);
 * <p>
 * String strUrl = "http://www.cuobiezi.net/api/v1/zh_spellcheck/json";
 * <p>
 * HttpPost httpPost = new HttpPost(strUrl);
 * httpPost.setEntity(entity);
 * System.out.println("Executing request " + httpPost.getRequestLine());
 * <p>
 * // Create a custom response handler
 * ResponseHandler<String> responseHandler = response -> {
 * int status = response.getStatusLine().getStatusCode();
 * if (status >= 200 && status < 300) {
 * HttpEntity responseEntity = response.getEntity();
 * return responseEntity != null ? EntityUtils.toString(responseEntity) : null;
 * } else {
 * throw new ClientProtocolException("Unexpected response status: " + status);
 * }
 * };
 * String responseBody = httpclient.execute(httpPost, responseHandler);
 * System.out.println("----------------------------------------");
 * System.out.println(responseBody);
 * }
 * }
 * }
 **/
