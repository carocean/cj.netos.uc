package cj.netos.uc.plugin.service;

import cj.netos.uc.service.IUcProperties;
import cj.netos.uc.service.IUcpaasSMSService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.util.StringUtil;
import com.ucpaas.restDemo.client.AbsRestClient;
import com.ucpaas.restDemo.client.JsonReqClient;

import java.util.HashMap;
import java.util.Map;

@CjService(name = "ucpaasSMSService")
public class UcpaasSMSService implements IUcpaasSMSService {
    @CjServiceRef(refByName = "ucProperties")
    IUcProperties ucProperties;

    AbsRestClient InstantiationRestAPI() {
        return new JsonReqClient();
    }

    @Override
    public String addSmsTemplate(String template_name, String autograph, String content) throws CircuitException {
        String appid = ucProperties.get("@.prop.sms.ucpaas.appid");
        if (StringUtil.isEmpty(appid)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.appid");
        }
        String token =
                ucProperties.get("@.prop.sms.ucpaas.token");
        if (StringUtil.isEmpty(token)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.token");
        }
        String sid =
                ucProperties.get("@.prop.sms.ucpaas.sid");
        if (StringUtil.isEmpty(sid)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.sid");
        }
        String rest_server =
                ucProperties.get("@.prop.sms.ucpaas.rest_server");
        if (StringUtil.isEmpty(rest_server)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.rest_server");
        }
        try {
            String result = InstantiationRestAPI().addSmsTemplate(rest_server, sid, token, appid, "4", template_name, autograph, content);
            return result;
        } catch (Exception e) {
            throw new CircuitException("500", e);
        }
    }

    @Override
    public String deleterSmsTemplate(String templateid) throws CircuitException {
        String appid = ucProperties.get("@.prop.sms.ucpaas.appid");
        if (StringUtil.isEmpty(appid)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.appid");
        }
        String token =
                ucProperties.get("@.prop.sms.ucpaas.token");
        if (StringUtil.isEmpty(token)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.token");
        }
        String sid =
                ucProperties.get("@.prop.sms.ucpaas.sid");
        if (StringUtil.isEmpty(sid)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.sid");
        }
        String rest_server =
                ucProperties.get("@.prop.sms.ucpaas.rest_server");
        if (StringUtil.isEmpty(rest_server)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.rest_server");
        }
        try {
            String result = InstantiationRestAPI().deleterSmsTemplate(rest_server, sid, token, appid, templateid);
            return result;
        } catch (Exception e) {
            throw new CircuitException("500", e);
        }
    }

    @Override
    public String getSmsTemplate(String templateid, String page_num, String page_size) throws CircuitException {
        String appid = ucProperties.get("@.prop.sms.ucpaas.appid");
        if (StringUtil.isEmpty(appid)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.appid");
        }
        String token =
                ucProperties.get("@.prop.sms.ucpaas.token");
        if (StringUtil.isEmpty(token)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.token");
        }
        String sid =
                ucProperties.get("@.prop.sms.ucpaas.sid");
        if (StringUtil.isEmpty(sid)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.sid");
        }
        String rest_server =
                ucProperties.get("@.prop.sms.ucpaas.rest_server");
        if (StringUtil.isEmpty(rest_server)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.rest_server");
        }
        try {
            String result = InstantiationRestAPI().getSmsTemplate(rest_server, sid, token, appid, templateid, page_num, page_size);
            return result;
        } catch (Exception e) {
            throw new CircuitException("500", e);
        }
    }

    @Override
    public void sendSms(String param, String mobile, String uid) throws CircuitException {
        String appid = ucProperties.get("@.prop.sms.ucpaas.appid");
        if (StringUtil.isEmpty(appid)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.appid");
        }
        String token =
                ucProperties.get("@.prop.sms.ucpaas.token");
        if (StringUtil.isEmpty(token)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.token");
        }
        String sid =
                ucProperties.get("@.prop.sms.ucpaas.sid");
        if (StringUtil.isEmpty(sid)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.sid");
        }
        String rest_server =
                ucProperties.get("@.prop.sms.ucpaas.rest_server");
        if (StringUtil.isEmpty(rest_server)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.rest_server");
        }
        String templateid =
                ucProperties.get("@.prop.sms.ucpaas.apply.templateid");
        if (StringUtil.isEmpty(templateid)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.apply.templateid。该属性是应用生效的短信验证码模板");
        }
        try {
            String result = InstantiationRestAPI().sendSms(rest_server, sid, token, appid, templateid, param, mobile, uid);
            Map<String, Object> map = new Gson().fromJson(result, HashMap.class);
            int code=Integer.valueOf((String)map.get("code"));
            if (code != 0) {
                throw new CircuitException(code+"",map.get("msg")+"");
            }
        } catch (Exception e) {
            throw new CircuitException("500", e);
        }
    }

    @Override
    public void sendSmsInviteNotify(String param, String mobile, String uid) throws CircuitException {
        String appid = ucProperties.get("@.prop.sms.ucpaas.appid");
        if (StringUtil.isEmpty(appid)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.appid");
        }
        String token =
                ucProperties.get("@.prop.sms.ucpaas.token");
        if (StringUtil.isEmpty(token)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.token");
        }
        String sid =
                ucProperties.get("@.prop.sms.ucpaas.sid");
        if (StringUtil.isEmpty(sid)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.sid");
        }
        String rest_server =
                ucProperties.get("@.prop.sms.ucpaas.rest_server");
        if (StringUtil.isEmpty(rest_server)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.rest_server");
        }
        String templateid =
                ucProperties.get("@.prop.sms.ucpaas.notify.templateid");
        if (StringUtil.isEmpty(templateid)) {
            throw new CircuitException("404", "没有配置云之讯短信平台的:@.prop.sms.ucpaas.notify.templateid。该属性是应用生效的短信通知模板");
        }
        try {
            String result = InstantiationRestAPI().sendSms(rest_server, sid, token, appid, templateid, param, mobile, uid);
            Map<String, Object> map = new Gson().fromJson(result, HashMap.class);
            int code=Integer.valueOf((String)map.get("code"));
            if (code != 0) {
                throw new CircuitException(code+"",map.get("msg")+"");
            }
        } catch (Exception e) {
            throw new CircuitException("500", e);
        }
    }
}
