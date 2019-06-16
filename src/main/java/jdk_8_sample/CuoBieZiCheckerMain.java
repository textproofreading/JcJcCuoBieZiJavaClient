package jdk_8_sample;


import com.alibaba.fastjson.JSONObject;

/**
 *  我们的  api 测试接口  和  www.CuoBieZi.net 是部署在　字根云　上的两套系统
 *  所以不要 api 和 www 页面 混合测试
 *  谢谢
 *
 *
 *
 *
 *
 */
public class CuoBieZiCheckerMain {
    public static void main(String[] args) {
        String url = "";
        url = "http://"+comm_consts.APIHost+"/spellcheck/json_check/json_phrase";

        System.out.println("测试的时候，不要只是输入一个词语。没有上下文比较难判断。 要输入一段话，放到真实的文章上下文中测试， 谢谢！");
        System.out.println("测试前，请先向管理员申请测试账号 , 管理员 QQ 在JCJC错别字检测首页有 www.CuoBieZi.net  .测试的时候，不要只是输入一个词语。没有上下文比较难判断。 要输入一段话，放到真实的文章上下文中测试， 谢谢！");
        System.out.println("测试前，请先向管理员申请测试账号 , 管理员 QQ 在JCJC错别字检测首页有 www.CuoBieZi.net  .");



        String sentence = "测试文本中国人民共和国2018年23月35号习近平国家主席十九精神李克强总理这根邮寄达老旧烟囱已走到生命进头，中国人民解军雷落科技中国特色会社主义马少黄股票她的离去让哦们很悲伤， 客户侧中华人民共和李洪志台万第二大金融控股公司富邦金控已与腾讯谈成合作，上述保险产品将由富邦金控旗下内地子公司富邦财险开发或引进。";


        //sentence = "感冒药并不能根治感冒，感冒药存在的意义是什么呢？";

        /**
         * 我们产品的优势：
         *　１）　支持离线部署　，　基于　Docker
         *  2）　引擎测试速度：１万字三秒内返回
         *  ３）　支持自定义词汇：　付费版本　最大支持１０个自定义词汇，不影响系统技术响应指标
         *  ４）　技术接口开放，我们愿意为合作伙伴尽最大可能开放系统API参数
         */


        /**
         * 为什么华为云，浪潮，招商证券等公司会选择：JCJC错别字检测引擎：
         *　１）　JCJC错别字检测引擎提供大量　OpenAPI
         *  2）　不只是一个错别字检测工具，更是一个　NLP 自然语言二次开发平台
         *  ３）　为程序员定制，贴身打造
         */


        /**
         *  测试前，请先向管理员申请测试账号 , 管理员 QQ 在JCJC错别字检测首页有 www.CuoBieZi.net  .
         */
        //sentence = "感冒药不能根治感冒，感冒药的价值是什么呢？";

        //        sentence= "“反腐倡廉”错写成“友腐倡廉”\n" +
        //                "“财政局长”错写成“败政局长”\n" +
        //                "“十八大”错写成“十八人”、“十八太”\n" +
        //                "“信息公开”错写成“信臭公开”\n" +
        //                "“扶贫工作”错写成“扶贪工作”\n" +
        //                "“财政局长”错写成“败政局长”\n" +
        //                "“全国人大”写成“全国大人；\n" +
        //                "省人大”写成省大人” 、\n" +
        //                "“人大常委会”写成“大人常委会”\n" +
        //                "“领导小组”写成“领导小姐”；\n" +
        //                "“组长”错写成“姐长”\n" +
        //                "“共产党”写成“共产常”，\n" +
        //                "“中国共产党”写成“中华共产党”";
        //

        //sentence = "华为云的测试：专业名词测试:对像存储服务是稳定、安全、高效、易用的云存储服务，具备标准Restful API接口，可存储任意数量和形式的非结构化数据，提供99.999999999%的数据可靠性。";

        JSONObject json = new JSONObject();
        json.put("content",sentence);//固定 参数
        /**
         *  请在此处填写您的注册用户名和密码
         */
        json.put("username","YourRegisteredUserName");// 可替换参数  --> 请注册账号后，向管理员申请权限， :-)
        json.put("password","YourVerySecuryPassword");//固定测试参数
        json.put("biz_type","show");//固定参数
        json.put("mode","advanced");//固定参数
        //json.put("is_return_sentence",true);//  是否返回句子 ， 具体说明，可以参考文档。


        json.put("user_channel","api.cuobiezi.net");   //固定参数
        //json.put("check_sensitive_word",true);  // 敏感词检测

        String str = HttpUtils.doPostJson(url, json.toJSONString());
        System.out.println(str);

        System.out.println("测试前，请先向管理员申请测试账号 , 管理员 QQ 在JCJC错别字检测首页有 www.CuoBieZi.net 测试的时候，不要只是输入一个词语。没有上下文比较难判断。 要输入一段话，放到真实的文章上下文中测试， 谢谢！");
        System.out.println("测试前，请先向管理员申请测试账号 , 管理员 QQ 在JCJC错别字检测首页有 www.CuoBieZi.net  测试的时候，不要只是输入一个词语。没有上下文比较难判断。 要输入一段话，放到真实的文章上下文中测试， 谢谢！");

    }
}
