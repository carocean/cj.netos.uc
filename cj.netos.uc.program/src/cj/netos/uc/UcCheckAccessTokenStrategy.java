package cj.netos.uc;

import cj.netos.uc.model.AppAccessToken;
import cj.netos.uc.service.IAppAccessTokenService;
import cj.studio.ecm.IServiceSite;
import cj.studio.openport.CheckAccessTokenException;
import cj.studio.openport.DefaultSecuritySession;
import cj.studio.openport.ICheckAccessTokenStrategy;
import cj.studio.openport.ISecuritySession;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.gson2.com.google.gson.reflect.TypeToken;

import java.util.List;

public class UcCheckAccessTokenStrategy implements ICheckAccessTokenStrategy {
    IAppAccessTokenService appAccessTokenService;
    @Override
    public void init(IServiceSite site) {
        appAccessTokenService=(IAppAccessTokenService) site.getService("ucplugin.appAccessTokenService");
    }

    @Override
    public ISecuritySession checkAccessToken(ISecuritySession _securitySession,String portsurl, String methodName, String accessToken) throws CheckAccessTokenException {
        AppAccessToken appAccessToken= appAccessTokenService.getAccessToken(accessToken);
        if (appAccessToken == null) {
            throw new CheckAccessTokenException("10001","验证访问令牌失败，原因：非法的令牌");
        }
        //过期逻辑
        long lasttime=appAccessToken.getPubTime()+appAccessToken.getExpireTime();
        if (System.currentTimeMillis() > lasttime) {
            throw new CheckAccessTokenException("1002","验证访问令牌失败，原因：已过期");
        }
        ISecuritySession securitySession = new DefaultSecuritySession(appAccessToken.getPerson());
        String json=appAccessToken.getRoles();
        List<String> roles = new Gson().fromJson(json,new TypeToken<List<String>>(){}.getType());
        for (String r : roles) {
            securitySession.addRole(r);
        }
        securitySession.property("device", appAccessToken.getDevice());
        return securitySession;
    }
}
