package cj.netos.uc.port;

import cj.netos.uc.model.*;
import cj.netos.uc.service.*;
import cj.netos.uc.util.Encript;
import cj.netos.uc.util.JwtUtil;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.gson2.com.google.gson.reflect.TypeToken;

import java.util.*;

@CjService(name = "/auth.service")
public class AuthPort implements IAuthPort {
    @CjServiceRef(refByName = "ucplugin.appAccountService")
    IAppAccountService appAccountService;
    @CjServiceRef(refByName = "ucplugin.tenantAppService")
    IAppService appService;
    @CjServiceRef(refByName = "ucplugin.ucRoleService")
    IUcRoleService ucRoleService;
    @CjServiceRef(refByName = "ucplugin.tenantRoleService")
    ITenantRoleService tenantRoleService;
    @CjServiceRef(refByName = "ucplugin.tenantAppRoleService")
    IAppRoleService appRoleService;
    @CjServiceRef(refByName = "ucplugin.appRefreshTokenService")
    IAppRefreshTokenService appRefreshTokenService;
    @CjServiceRef(refByName = "ucplugin.appAccessTokenService")
    IAppAccessTokenService appAccessTokenService;

    @Override
    public Map<String, Object> auth(ISecuritySession securitySession, String accountCode, String password) throws CircuitException {
        TenantApp app = appService.getApp(securitySession.principal());
        if (app == null) {
            throw new CircuitException("1002", "登录失败，原因：非法应用");
        }
        AppAccount appAccount = appAccountService.getAccountByCode(securitySession.principal(), accountCode);
        if (appAccount == null) {
            throw new CircuitException("1002", "登录失败，原因：账号不存在");
        }
        if (!Encript.md5(password).equals(appAccount.getAccountPwd())) {
            throw new CircuitException("1002", "登录失败，原因：密码不正确");
        }
        //填充角色
        List<UcRole> ucroles = ucRoleService.pageRoleOfUser(appAccount.getUserId(), 0, Integer.MAX_VALUE);
        List<TenantRole> taroles = tenantRoleService.pageRoleOfUser(appAccount.getUserId(), app.getTenantId(), 0, Integer.MAX_VALUE);
        List<AppRole> approles = appRoleService.pageRoleOfAccount(appAccount.getAccountId(), app.getAppId(), 0, Integer.MAX_VALUE);
        List<String> roles = new ArrayList<>();
        for (UcRole r : ucroles) {
            roles.add(String.format("platform:%s", r.getRoleId()));
        }
        for (TenantRole r : taroles) {
            roles.add(String.format("tenant:%s", r.getRoleId()));
        }
        for (AppRole r : approles) {
            roles.add(String.format("app:%s", r.getRoleId()));
        }
        String person = appAccount.getAccountId();
        //accessToken仅仅只是生成一个标识串
        String accessToken = Encript.md5(String.format("%s%s%s", person, UUID.randomUUID(), app.getAppSecret()));
        AppAccessToken appAccessToken = new AppAccessToken();
        appAccessToken.setAccessToken(accessToken);
        appAccessToken.setExpireTime(app.getTokenExpire());
        appAccessToken.setPerson(person);
        appAccessToken.setPubTime(System.currentTimeMillis());
        appAccessToken.setRoles(new Gson().toJson(roles));
        appAccessTokenService.updateAccessToken(person, appAccessToken);

        Map<String, Object> response = new HashMap<>();

        Map<String, Object> appToken = new HashMap<>();
        appToken.put("accessToken", accessToken);
        appToken.put("pubTime", appAccessToken.getPubTime());
        String refreshToken = appRefreshTokenService.updateRefreshToken(person).getRefreshToken();
        appToken.put("refreshToken", refreshToken);
        appToken.put("expireTime", app.getTokenExpire());
        response.put("token", appToken);

        PersonInfo info = new PersonInfo(appAccount.getAccountCode(), appAccount.getAppId());
        info.getRoles().addAll(roles);
        info.setAvatar(appAccount.getAvatar());
        info.setNickName(appAccount.getNickName());
        info.setSignature(appAccount.getSignature());
        info.setUid(appAccount.getUserId());
        response.put("subject", info);
        return response;
    }

    @Override
    public AppRefreshToken refreshToken(ISecuritySession securitySession, String refreshToken) throws CircuitException {
        AppRefreshToken appRefreshToken = appRefreshTokenService.getRefreshToken(refreshToken);
        if (appRefreshToken == null) {
            CJSystem.logging().error(getClass(), "刷新令牌不存在");
            throw new CircuitException("1003", "刷新令牌验证失败");
        }
        String appid = appRefreshToken.getPerson().substring(appRefreshToken.getPerson().indexOf("@") + 1, appRefreshToken.getPerson().length());
        if (!appid.equals(securitySession.principal())) {
            CJSystem.logging().error(getClass(), "刷新令牌不是同一验证的app");
            throw new CircuitException("1003", "刷新令牌验证失败");
        }
        appRefreshToken = appRefreshTokenService.updateRefreshToken(appRefreshToken.getPerson());
        return appRefreshToken;
    }

    @Override
    public Map<String, Object> verification(ISecuritySession securitySession, String token) throws CircuitException {
        TenantApp app = appService.getApp(securitySession.principal());
        if (app == null) {
            throw new CircuitException("1002", "登录失败，原因：非法应用");
        }
        AppAccessToken appAccessToken = appAccessTokenService.getAccessToken(token);
        if (appAccessToken == null) {
            throw new CircuitException("1002", "登录失败，原因：令牌无效");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("person", appAccessToken.getPerson());
        map.put("pubTime", appAccessToken.getPubTime());
        map.put("expireTime", appAccessToken.getExpireTime());
        map.put("isExpired",System.currentTimeMillis()>appAccessToken.getPubTime()+appAccessToken.getExpireTime());
        List<String> roles = new Gson().fromJson(appAccessToken.getRoles(), new TypeToken<ArrayList<String>>() {
        }.getType());
        map.put("roles", roles);
        return map;
    }
}
