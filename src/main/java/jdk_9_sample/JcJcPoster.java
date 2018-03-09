package jdk_9_sample;

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
import org.apache.commons.codec.binary.Base64;


/*
            www.CuoBieZi.net

            我们正在考虑推出基于 Kotlin 的测试代码！

            欢迎关注作者微博： http://weibo.com/tianchunfeng


            Java API 接口的演示代码使用 JDK 最新版本 1.9 。

            如果出现错误，请查看你的JDK版本是否最新。


            也可以考虑使用纯JavaScript版本的 API 例子：

            源代码参考下面的页面：

            http://cuobiezi.net/public/static/ckeditor4/


 */
public class JcJcPoster {

    public static void main(String[] argv) throws Exception {

        //plain_test();
        //base64_test();

        url_test();
    }

    public static void plain_test(){
        String url_str = "";
        url_str = "http://api.cuobiezi.net/spellcheck/json_check/json_phrase";
        String json_data = "{    \"username\":\"tester\"   ,             \"content\": \"腾讯今年中国人民共和国下半年上世纪将在微信账户钱包帐户的“九宫格”中开设快速的笑着保险入口，并上线保险产品。台万第二大金融控股公司富邦金控已与腾讯谈成合作，上述保险产品将由富邦金控旗下内地子公司富邦财险开发或引进。\",                    \"mode\": \"advanced\",                    \"biz_type\": \"show\"        }";
        String result = null;
        try {
            result = sendPost2(url_str, json_data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    public static void url_test(){
        String url_str = "";
        url_str = "http://api.cuobiezi.net/spellcheck/url_check/json_phrase";


        String web_page_url = "http://blog.csdn.net/accesine960/article/details/79154861";



        String json_data = "{    \"username\":\"tester\"   , \"url\": \""+web_page_url+"\",\"content\":\"placeholder\" ,  \"mode\": \"advanced\",    \"biz_type\": \"show\"   }";
        String result = null;

        System.out.println(json_data);
        try {
            result = sendPost2(url_str, json_data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }




    public static void base64_test(){
        String url_str = "";
        url_str = "http://api.cuobiezi.net/spellcheck/json_check/json_phrase";




        String content = "腾讯今年中国人民共和国下半年上世纪将在微信账户钱包帐户的“九宫格”中开设快速的笑着保险入口，并上线保险产品。台万第二大金融控股公司富邦金控已与腾讯谈成合作，上述保险产品将由富邦金控旗下内地子公司富邦财险开发或引进。";

        //import org.apache.commons.codec.binary.Base64;
        byte[] encodedBytes = Base64.encodeBase64(content.getBytes());
        System.out.println("encodedBytes " + new String(encodedBytes));
        String content_base64 = new String(encodedBytes);
        String json_data = "{    \"username\":\"tester\"   ,   \"is_base64_content\":true,          \"content\":  \""+content_base64+"\"         ,          \"mode\": \"advanced\",                    \"biz_type\": \"show\"        }";
        String result = null;
        try {
            System.out.println("json raw content:"+ json_data);
            result = sendPost2(url_str, json_data);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static String encode_base64(byte abyte0[])
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0);
        String s = null;
        try
        {
            //encode(((InputStream) (bytearrayinputstream)), ((OutputStream) (bytearrayoutputstream)));
            //s = bytearrayoutputstream.toString("8859_1");
        }
        catch(Exception exception)
        {
            throw new Error("CharacterEncoder.encode internal error");
        }
        return s;
    }
}
