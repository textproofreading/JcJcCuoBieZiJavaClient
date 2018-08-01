package jdk_8_sample;


import com.alibaba.fastjson.JSONObject;


public class CuoBieZiCheckerMain {
    public static void main(String[] args) {


        String url = "http://api.CuoBieZi.net/spellcheck/json_check/json_phrase";

        url = "http://"+comm_consts.APIHost+"/spellcheck/json_check/json_phrase";


        /**
         *
         *
         */

        System.out.println("测试的时候，不要只是输入一个词语。 要输入一段话，放到真实的文章上下文中测试， 谢谢！");

        String sentence = "测试文本中国人民共和国张可诺雷非科技2018年23月35号习近平国家主席李克强总理这根邮寄达老旧烟囱已走到生命进头，中国人民解军雷落科技中国特色会社主义马少黄股票她的离去让哦们很悲伤， 客户侧中华人民共和李洪志台万第二大金融控股公司富邦金控已与腾讯谈成合作，上述保险产品将由富邦金控旗下内地子公司富邦财险开发或引进。";

        JSONObject json = new JSONObject();
        json.put("content",sentence);//固定 参数
        json.put("username","tester");// 可替换参数  --> 请注册账号后，向管理员申请权限， :-)
        json.put("password","test_password");//固定测试参数
        json.put("biz_type","show");//固定参数
        json.put("mode","advanced");//固定参数

        //json.put("is_return_sentence",true);//  是否返回句子 ， 具体说明，可以参考文档。


        json.put("user_channel","api.cuobiezi.net");   //固定参数

        //json.put("check_sensitive_word",true);  // 敏感词检测


        String str = HttpUtils.doPostJson(url, json.toJSONString());
        System.out.println(str);
    }
}
