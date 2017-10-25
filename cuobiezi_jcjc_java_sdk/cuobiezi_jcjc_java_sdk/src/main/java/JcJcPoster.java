import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JcJcPoster {



    public static void main(String... args) throws IOException {
        
        
        
        
        HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead 

        try {

            HttpPost request = new HttpPost("http://117.121.10.43:8234/spellcheck/json_check/json_phrase");
            StringEntity params =new StringEntity(  "{
\"content\": \"腾讯今年中国人民共和国下半年上世纪将在微信账户钱包帐户的“九宫格”中开设快速的笑着保险入口，并上线保险产品。台万第二大金融控股公司富邦金控已与腾讯谈成合作，上述保险产品将由富邦金控旗下内地子公司富邦财险开发或引进。\",
\"mode\": \"advanced\",
\"biz_type\": \"show\"
}"     );
            request.addHeader("content-type", "application/x-www-form-urlencoded");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);

            //handle response here...

        }catch (Exception ex) {

            //handle exception here

        } finally {
            //Deprecated
            //httpClient.getConnectionManager().shutdown(); 
        }
        
        
        
        
        if (true){
            // 下面的代码失效，请使用上面的代码。
            return ;
        }

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            List<NameValuePair> form = new ArrayList<>();
            form.add(new BasicNameValuePair("content", "我最喜欢的就是元霄节吃汤圆，中国人民共和国。"));
            form.add(new BasicNameValuePair("check_mode", "advanced"));
            form.add(new BasicNameValuePair("action", "show"));
            form.add(new BasicNameValuePair("username", "tester"));
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(form, Consts.UTF_8);

            String strUrl = "http://www.cuobiezi.net/api/v1/zh_spellcheck/json";

            HttpPost httpPost = new HttpPost(strUrl);
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
            String responseBody = httpclient.execute(httpPost, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
    }
}
