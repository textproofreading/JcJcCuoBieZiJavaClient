package jdk_8_sample;

import com.alibaba.fastjson.JSONObject;

/**
 *      添加行业词语
 *      /jcjc/dict/index
 */
public class AddNewDomainWords {
    public static void main(String[] args) {
        String url = "http://"+comm_consts.APIHost+"/spellcheck/add_new_words";

        String sentence = "客户侧";




        sentence = "客户侧";




        JSONObject json = new JSONObject();
        json.put("content",sentence);
        json.put("username","ctesterd");
        json.put("biz_type","show");
        json.put("mode","advanced");
        json.put("content2","n");     // 词性 ，词语的性质，名词、动词、等
        json.put("content3","dztx");  // 行业, 词语的行业性质 ， 比如： dztx ,是 电子通信 第一个拼音字母的所写
        //
        String str = HttpUtils.doPostJson(url, json.toJSONString());
        System.out.println(str);
    }

}
