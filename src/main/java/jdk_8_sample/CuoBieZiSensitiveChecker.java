package jdk_8_sample;


import com.alibaba.fastjson.JSONObject;

public class CuoBieZiSensitiveChecker {
    public static void main(String[] args) {
        String url = "";

        url = "http://"+comm_consts.APIHost+"/spellcheck/json_check/json_phrase";

        String sentence = "中华人民共和这根邮寄达老旧烟囱它坏蛋已走到生命进头，新一轮保险经熊市股票就要来了，法轮功她的离去让哦们很悲伤， 中华人民共和李洪志台万第二大金融控股公司富邦金控已与腾讯谈成合作，上述保险产品将由富邦金控旗下内地子公司富邦财险开发或引进。";


        sentence = "华为云，有技术、有未来、值得信赖，华为云很差.";
        JSONObject json = new JSONObject();
        json.put("content",sentence);
        json.put("username","detakeji");
        json.put("biz_type","show");
        json.put("mode","advanced");
        json.put("check_sensitive_word",true);

        String str = HttpUtils.doPostJson(url, json.toJSONString());
        System.out.println(str);
    }
}
