package jdk_8_sample;

import com.alibaba.fastjson.JSONObject;

public class AddNewWords {
    public static void main(String[] args) {
        String url = "http://api.CuoBieZi.net/spellcheck/add_new_words";

        String sentence = "毛泽东";
        JSONObject json = new JSONObject();
        json.put("content",sentence);
        json.put("username","ctesterd");
        json.put("biz_type","show");
        json.put("mode","advanced");

        String str = HttpUtils.doPostJson(url, json.toJSONString());
        System.out.println(str);
    }

}
