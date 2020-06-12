/**
 * @author Glan.duanyj
 * @date 2014-05-12
 * @project rest_demo
 */
package com.ucpaas.restDemo.client;

import java.io.IOException;

public abstract class AbsRestClient {

    /**
     * @param sid
     * @param token
     * @param appid
     * @param templateid
     * @param param
     * @param mobile
     * @param uid
     * @return
     */
    public abstract String sendSms(String server,String sid, String token, String appid, String templateid, String param, String mobile, String uid) throws IOException;

    /**
     * @param sid
     * @param token
     * @param appid
     * @param templateid
     * @param param
     * @param mobile
     * @param uid
     * @return
     */
    public abstract String sendSmsBatch(String server,String sid, String token, String appid, String templateid, String param, String mobile, String uid) throws IOException;

    /**
     * @param sid
     * @param token
     * @param appid
     * @param type
     * @param template_name
     * @param autograph
     * @param content
     * @return
     */
    public abstract String addSmsTemplate(String server,String sid, String token, String appid, String type, String template_name, String autograph, String content) throws IOException;

    /**
     * @param sid
     * @param token
     * @param appid
     * @param templateid
     * @param page_num
     * @param page_size
     * @return
     */
    public abstract String getSmsTemplate(String server,String sid, String token, String appid, String templateid, String page_num, String page_size);

    /**
     * @param sid
     * @param token
     * @param appid
     * @param templateid
     * @param type
     * @param template_name
     * @param autograph
     * @param content
     * @return
     */
    public abstract String editSmsTemplate(String server,String sid, String token, String appid, String templateid, String type, String template_name, String autograph, String content) throws IOException;

    /**
     * @param sid
     * @param token
     * @param appid
     * @param templateid
     * @return
     */
    public abstract String deleterSmsTemplate(String server,String sid, String token, String appid, String templateid) throws IOException;


    public StringBuffer getStringBuffer(String server) {
        StringBuffer sb = new StringBuffer("https://");
        sb.append(server).append("/ol/sms");
        return sb;
    }
}
