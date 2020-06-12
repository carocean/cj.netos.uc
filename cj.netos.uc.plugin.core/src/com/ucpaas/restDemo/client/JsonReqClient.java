
package com.ucpaas.restDemo.client;


import com.alibaba.fastjson.JSONObject;
import com.ucpaas.restDemo.HttpClientUtil;

import java.io.IOException;

public class JsonReqClient extends AbsRestClient {

    @Override
    public String sendSms(String server, String sid, String token, String appid, String templateid, String param, String mobile,
                          String uid) throws IOException {

        String result = "";

        String url = getStringBuffer(server).append("/sendsms").toString();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sid", sid);
        jsonObject.put("token", token);
        jsonObject.put("appid", appid);
        jsonObject.put("templateid", templateid);
        jsonObject.put("param", param);
        jsonObject.put("mobile", mobile);
        jsonObject.put("uid", uid);

        String body = jsonObject.toJSONString();

        System.out.println("body = " + body);

        result = HttpClientUtil.postJson(url, body, null);

        return result;
    }

    @Override
    public String sendSmsBatch(String server, String sid, String token, String appid, String templateid, String param, String mobile,
                               String uid) throws IOException {

        String result = "";

        String url = getStringBuffer(server).append("/sendsms_batch").toString();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sid", sid);
        jsonObject.put("token", token);
        jsonObject.put("appid", appid);
        jsonObject.put("templateid", templateid);
        jsonObject.put("param", param);
        jsonObject.put("mobile", mobile);
        jsonObject.put("uid", uid);

        String body = jsonObject.toJSONString();

        System.out.println("body = " + body);

        result = HttpClientUtil.postJson(url, body, null);

        return result;
    }

    @Override
    public String addSmsTemplate(String server, String sid, String token, String appid, String type, String template_name,
                                 String autograph, String content) throws IOException {

        String result = "";

        String url = getStringBuffer(server).append("/addsmstemplate").toString();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sid", sid);
        jsonObject.put("token", token);
        jsonObject.put("appid", appid);
        jsonObject.put("type", type);
        jsonObject.put("template_name", template_name);
        jsonObject.put("autograph", autograph);
        jsonObject.put("content", content);

        String body = jsonObject.toJSONString();

        System.out.println("body = " + body);

        result = HttpClientUtil.postJson(url, body, null);

        return result;
    }

    @Override
    public String getSmsTemplate(String server, String sid, String token, String appid, String templateid, String page_num,
                                 String page_size) {

        String result = "";

        try {
            String url = getStringBuffer(server).append("/getsmstemplate").toString();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("sid", sid);
            jsonObject.put("token", token);
            jsonObject.put("appid", appid);
            jsonObject.put("templateid", templateid);
            jsonObject.put("page_num", page_num);
            jsonObject.put("page_size", page_size);

            String body = jsonObject.toJSONString();

            System.out.println("body = " + body);

            result = HttpClientUtil.postJson(url, body, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String editSmsTemplate(String server, String sid, String token, String appid, String templateid, String type,
                                  String template_name, String autograph, String content) throws IOException {

        String result = "";

        String url = getStringBuffer(server).append("/editsmstemplate").toString();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sid", sid);
        jsonObject.put("token", token);
        jsonObject.put("appid", appid);
        jsonObject.put("templateid", templateid);
        jsonObject.put("type", type);
        jsonObject.put("template_name", template_name);
        jsonObject.put("autograph", autograph);
        jsonObject.put("content", content);

        String body = jsonObject.toJSONString();

        System.out.println("body = " + body);

        result = HttpClientUtil.postJson(url, body, null);

        return result;
    }

    @Override
    public String deleterSmsTemplate(String server, String sid, String token, String appid, String templateid) throws IOException {

        String result = "";

        String url = getStringBuffer(server).append("/deletesmstemplate").toString();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sid", sid);
        jsonObject.put("token", token);
        jsonObject.put("appid", appid);
        jsonObject.put("templateid", templateid);

        String body = jsonObject.toJSONString();

        System.out.println("body = " + body);

        result = HttpClientUtil.postJson(url, body, null);

        return result;
    }

}
