package jdk_8_sample;

import com.alibaba.fastjson.JSONObject;



public class AddNewSensitiveWords {
    public static void main(String[] args) {
        String url = "http://api.CuoBieZi.net/spellcheck/add_sensitive_words";


        String sentence = "股票";



        JSONObject json = new JSONObject();
        json.put("content",sentence);
        json.put("username","ctesterd");
        json.put("biz_type","show");
        json.put("mode","advanced");

        String str = HttpUtils.doPostJson(url, json.toJSONString());
        System.out.println(str);
    }

}
