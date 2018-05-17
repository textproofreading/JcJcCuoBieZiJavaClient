package jdk_8_sample;


import com.alibaba.fastjson.JSONObject;
//import com.pythe.common.utils.HttpClientUtil;
//import com.pythe.common.utils.JsonUtils;

public class CuoBieZiChecker {
    public static void main(String[] args) {
        String url = "http://api.CuoBieZi.net/spellcheck/json_check/json_phrase";

        String sentence = "测试文本中国人民共和国这根邮寄达老旧烟囱已走到生命进头，法轮功中国特色会社主义股票她的离去让哦们很悲伤， 客户侧中华人民共和李洪志台万第二大金融控股公司富邦金控已与腾讯谈成合作，上述保险产品将由富邦金控旗下内地子公司富邦财险开发或引进。";

        JSONObject json = new JSONObject();
        json.put("content",sentence);//固定测试参数
        json.put("username","ctesterd");//固定测试参数
        json.put("password","test_password");//固定测试参数
        json.put("biz_type","show");//固定测试参数
        json.put("mode","advanced");//固定测试参数
        json.put("user_channel","api.cuobiezi.net");   //固定测试参数

        //json.put("check_sensitive_word",true);  // 敏感词检测


        String str = HttpUtils.doPostJson(url, json.toJSONString());
        System.out.println(str);
    }
}
