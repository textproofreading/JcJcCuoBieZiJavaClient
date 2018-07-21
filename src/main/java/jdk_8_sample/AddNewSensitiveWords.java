package jdk_8_sample;

import com.alibaba.fastjson.JSONObject;



public class AddNewSensitiveWords {
    public static void main(String[] args) {
        AddNewSensitiveWords obj = new AddNewSensitiveWords();

        obj.add_new_sensitive_words();

        //obj.del_sensitive_words();

    }



    public static void add_new_sensitive_words(){
        String url = "http://"+comm_consts.APIHost+"/spellcheck/add_sensitive_words";


        String sentence = "它坏蛋";
        JSONObject json = new JSONObject();
        json.put("content",sentence);
        json.put("username","ctesterd");
        json.put("biz_type","show");
        json.put("mode","advanced");
        String str = HttpUtils.doPostJson(url, json.toJSONString());
        System.out.println(str);
    }



    public static void del_sensitive_words(){
        String url = "http://"+comm_consts.APIHost+"/spellcheck/del_sensitive_words";
        String sentence = "手枪";
        JSONObject json = new JSONObject();
        json.put("content",sentence);
        json.put("username","ctesterd");
        json.put("biz_type","show");
        json.put("mode","advanced");
        String str = HttpUtils.doPostJson(url, json.toJSONString());
        System.out.println(str);
    }






}




