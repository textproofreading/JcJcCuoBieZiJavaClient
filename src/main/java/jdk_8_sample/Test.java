package jdk_8_sample;


import com.alibaba.fastjson.JSONObject;
import com.pythe.common.utils.HttpClientUtil;
import com.pythe.common.utils.JsonUtils;

public class Test {
	public static void main(String[] args) {
        String url = "http://api.CuoBieZi.net/spellcheck/json_check/json_phrase";

        String sentence = "中华人民共和这根邮寄达老旧烟囱已走到生命进头，她的离去让哦们很悲伤， 中华人民共和台万第二大金融控股公司富邦金控已与腾讯谈成合作，上述保险产品将由富邦金控旗下内地子公司富邦财险开发或引进。";
        JSONObject json = new JSONObject();
        json.put("content",sentence);
        json.put("username","username");
        json.put("biz_type","show");
        json.put("mode","advanced");
        
        String str = HttpClientUtil.doPostJson(url, JsonUtils.objectToJson(json));
        System.out.println(str);
	}
}
