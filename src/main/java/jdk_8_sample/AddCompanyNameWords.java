package jdk_8_sample;

import com.alibaba.fastjson.JSONObject;

import java.io.*;

public class AddCompanyNameWords {


    /**
     *          添加重要名词的测试代码
     * @param args
     */
    public static void main(String[] args) {

        add_from_file();


    }


    /**
     *  zhong_yao_important_mingci.txt
     */
    public static void add_from_file(){
        String file_name = "zhong_yao_important_mingci.txt";
        try {
            File fileDir = new File(file_name);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"));

            String str;

            while ((str = in.readLine()) != null) {
                str = str.trim();
                if (str.startsWith("#")){
                    continue;
                }
                if(0 == str.length()){
                    continue;
                }
                add_one_mingci(str);
                System.out.println(str);
            }

            in.close();
        }
        catch (UnsupportedEncodingException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


    }

    public static void add_one_mingci(String one_word){
        String url = "http://"+comm_consts.APIHost+"/spellcheck/add_mingci_words";

        String sentence = "";

        sentence = one_word;

        JSONObject json = new JSONObject();
        json.put("content",sentence);
        json.put("username","ctesterd");
        json.put("biz_type","show");
        json.put("mode","advanced");

        String str = HttpUtils.doPostJson(url, json.toJSONString());
        System.out.println(str);
    }




}
