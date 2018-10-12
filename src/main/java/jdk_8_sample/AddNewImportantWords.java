package jdk_8_sample;

import com.alibaba.fastjson.JSONObject;

import java.io.*;

public class AddNewImportantWords {
    public static void main(String[] args) {




        String name = "";


        name = "对象存储服务";  // 华为云测试
        name = "十九大精神";  //


        add_one_important_word(name);
        //add_from_file();
    }


    /**
     * zhong_yao_important_renming.txt
     */
    public static void add_from_file() {


        String file_name = "";
        try {
            File fileDir = new File(file_name);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"));

            String str;

            while ((str = in.readLine()) != null) {
                str = str.trim();
                if (str.startsWith("#")) {
                    continue;
                }
                add_one_important_word(str);
                System.out.println(str);
            }

            in.close();
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public static void add_one_important_word(String one_word) {
        String url = "";


        url = "http://"+comm_consts.APIHost+"/spellcheck/add_important_words";



        String sentence;


        sentence = one_word;

        sentence = sentence.trim();
        if (0 == sentence.length()) {
            return;
        }


        JSONObject json = new JSONObject();
        json.put("content", sentence);
        json.put("username", "ctesterd");
        json.put("biz_type", "show");
        json.put("mode", "advanced");

        String str = HttpUtils.doPostJson(url, json.toJSONString());
        System.out.println(str);
    }

}
