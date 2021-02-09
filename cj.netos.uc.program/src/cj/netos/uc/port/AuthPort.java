package cj.netos.uc.port;

import cj.netos.uc.model.*;
import cj.netos.uc.service.*;
import cj.netos.uc.util.Encript;
import cj.netos.uc.util.NumberGen;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.gson2.com.google.gson.reflect.TypeToken;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    @CjServiceRef(refByName = "ucplugin.phoneVerifycodeService")
    IPhoneVerifycodeService phoneVerifycodeService;
    @CjServiceRef(refByName = "ucplugin.ucUserService")
    IUcUserService ucUserService;
    @Override
    public Map<String, Object> sendVerifyCode(ISecuritySession securitySession, String phone) throws CircuitException {
        return appAccountService.sendVerifyCode(securitySession.principal(), phone);
    }

    @Override
    public boolean verifyCode(ISecuritySession securitySession, String phone, String verifyCode) throws CircuitException {
        return appAccountService.verifyCode(securitySession.principal(), phone, verifyCode);
    }

    private boolean _isPhoneNo(String text) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(text);
        return m.matches();
    }

    @Override
    public void updateDevice(ISecuritySession securitySession, String oldDevice, String newDevice) throws CircuitException {
        appAccessTokenService.updateDevice(securitySession.principal(),oldDevice,newDevice);
        appRefreshTokenService.updateDevice(securitySession.principal(),oldDevice,newDevice);
    }

    @Override
    public Map<String, Object> auth(ISecuritySession securitySession, String device, String accountCode, String password) throws CircuitException {
        TenantApp app = appService.getApp(securitySession.principal());
        if (app == null) {
            throw new CircuitException("1031", "登录失败，原因：非法应用");
        }
        AppAccount appAccount = null;
        if ("#_anonymous".equals(accountCode)) {
            appAccount = new AppAccount();
            appAccount.setAccountCode("#_anonymous");
            appAccount.setNickName("匿名用户");
            appAccount.setAccountId(UUID.randomUUID().toString());
            appAccount.setAccountPwd(Encript.md5("*_anonymous"));
            appAccount.setAppId(securitySession.principal());
            appAccount.setIsEnable((byte) 1);
            appAccount.setCreateTime(new Date());
            appAccount.setUserId(NumberGen.gen());
        } else {
            appAccount = appAccountService.getAccountByCode(securitySession.principal(), accountCode);
        }
        if (appAccount == null) {
            throw new CircuitException("1032", "登录失败，原因：账号不存在");
        }
        if(appAccount.getIsEnable()!=null&&appAccount.getIsEnable()==0){
            throw new CircuitException("1035", "登录失败，原因：账号已注销");
        }
        if (!Encript.md5(password).equals(appAccount.getAccountPwd())) {
            if (!_isPhoneNo(accountCode)) {
                throw new CircuitException("1033", "登录失败，原因：密码不正确");
            }
            String verifycode = phoneVerifycodeService.get(appAccount.getAccountId());
            if (!password.equals(verifycode)) {
                throw new CircuitException("1033", "登录失败，原因：验证码或密码不正确");
            }

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
        String accessToken = Encript.md5(String.format("%s%s%s%s", person, device, UUID.randomUUID(), app.getAppSecret()));
        AppAccessToken appAccessToken = new AppAccessToken();
        appAccessToken.setAccessToken(accessToken);
        appAccessToken.setExpireTime(app.getTokenExpire());
        appAccessToken.setPerson(person);
        appAccessToken.setDevice(device);
        appAccessToken.setPubTime(System.currentTimeMillis());
        appAccessToken.setRoles(new Gson().toJson(roles));
        appAccessTokenService.updateAccessToken(person, device, appAccessToken);

        Map<String, Object> response = new HashMap<>();

        Map<String, Object> appToken = new HashMap<>();
        appToken.put("accessToken", accessToken);
        appToken.put("device", appAccessToken.getDevice());
        appToken.put("pubTime", appAccessToken.getPubTime());
        String refreshToken = appRefreshTokenService.updateRefreshToken(person, device).getRefreshToken();
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
        //渲染框架
        response.put("portal", app.getPortal());
        return response;
    }

    @Override
    public Map<String, Object> authByWeChat(ISecuritySession securitySession,String deviceType,String device, String state, String code) throws CircuitException {
        AppAccount appAccount =ucUserService.registerByWeChat(securitySession.principal(),state,code,deviceType);

        if (appAccount == null) {
            throw new CircuitException("1032", "登录失败，原因：账号不存在");
        }
        if(appAccount.getIsEnable()!=null&&appAccount.getIsEnable()==0){
            throw new CircuitException("1035", "登录失败，原因：账号已注销");
        }

        TenantApp app = appService.getApp(securitySession.principal());
        if (app == null) {
            throw new CircuitException("1031", "登录失败，原因：非法应用");
        }
       UcUser ucUser= ucUserService.getUserById(appAccount.getUserId());
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
        String accessToken = Encript.md5(String.format("%s%s%s%s", person, device, UUID.randomUUID(), app.getAppSecret()));
        AppAccessToken appAccessToken = new AppAccessToken();
        appAccessToken.setAccessToken(accessToken);
        appAccessToken.setExpireTime(app.getTokenExpire());
        appAccessToken.setPerson(person);
        appAccessToken.setDevice(device);
        appAccessToken.setPubTime(System.currentTimeMillis());
        appAccessToken.setRoles(new Gson().toJson(roles));
        appAccessTokenService.updateAccessToken(person, device, appAccessToken);

        Map<String, Object> response = new HashMap<>();

        Map<String, Object> appToken = new HashMap<>();
        appToken.put("accessToken", accessToken);
        appToken.put("device", appAccessToken.getDevice());
        appToken.put("pubTime", appAccessToken.getPubTime());
        String refreshToken = appRefreshTokenService.updateRefreshToken(person, device).getRefreshToken();
        appToken.put("refreshToken", refreshToken);
        appToken.put("expireTime", app.getTokenExpire());
        response.put("token", appToken);

        PersonInfo info = new PersonInfo(appAccount.getAccountCode(), appAccount.getAppId());
        info.getRoles().addAll(roles);
        info.setAvatar(appAccount.getAvatar());
        info.setNickName(appAccount.getNickName());
        info.setSignature(appAccount.getSignature());
        info.setUid(appAccount.getUserId());
        info.setSex(ucUser.getSex());
        response.put("subject", info);
        //渲染框架
        response.put("portal", app.getPortal());
        return response;
    }

    @Override
    public Map<String, Object> refreshToken(ISecuritySession securitySession, String refreshToken) throws CircuitException {
        AppRefreshToken appRefreshToken = appRefreshTokenService.getRefreshToken(refreshToken);
        if (appRefreshToken == null) {
            CJSystem.logging().error(getClass(), "刷新令牌不存在");
            throw new CircuitException("1021", "刷新令牌验证失败");
        }
        String appid = appRefreshToken.getPerson().substring(appRefreshToken.getPerson().indexOf("@") + 1, appRefreshToken.getPerson().length());
        if (!appid.equals(securitySession.principal())) {
            CJSystem.logging().error(getClass(), "刷新令牌不是同一验证的app");
            throw new CircuitException("1022", "刷新令牌验证失败");
        }
        appRefreshToken = appRefreshTokenService.updateRefreshToken(appRefreshToken.getPerson(), appRefreshToken.getDevice());
        //accessToken仅仅只是生成一个标识串
        TenantApp app = appService.getApp(appid);
        if (app == null) {
            throw new CircuitException("1031", "验证失败，原因：非法应用");
        }
        String accountCode = appRefreshToken.getPerson().substring(0, appRefreshToken.getPerson().indexOf("@"));
        AppAccount appAccount = appAccountService.getAccountByCode(securitySession.principal(), accountCode);
        if (appAccount == null) {
            throw new CircuitException("1032", "验证失败，原因：账号不存在");
        }
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
        String accessToken = Encript.md5(String.format("%s%s%s%s", appRefreshToken.getPerson(), appRefreshToken.getDevice(), UUID.randomUUID(), app.getAppSecret()));
        AppAccessToken appAccessToken = new AppAccessToken();
        appAccessToken.setAccessToken(accessToken);
        appAccessToken.setExpireTime(app.getTokenExpire());
        appAccessToken.setPerson(appRefreshToken.getPerson());
        appAccessToken.setDevice(appRefreshToken.getDevice());
        appAccessToken.setPubTime(System.currentTimeMillis());
        appAccessToken.setRoles(new Gson().toJson(roles));
        appAccessTokenService.updateAccessToken(appRefreshToken.getPerson(), appRefreshToken.getDevice(), appAccessToken);

        Map<String, Object> map = new HashMap<>();
        map.put("person", appRefreshToken.getPerson());
        map.put("device", appRefreshToken.getDevice());
        map.put("portal", app.getPortal());
        map.put("accessToken", accessToken);
        map.put("refreshToken", appRefreshToken.getRefreshToken());
        map.put("pubTime", appRefreshToken.getPubTime());
        map.put("expireTime", app.getTokenExpire());
        return map;
    }

    @Override
    public Map<String, Object> verification(ISecuritySession securitySession, String token) throws CircuitException {
        TenantApp app = appService.getApp(securitySession.principal());
        if (app == null) {
            throw new CircuitException("1010", "验证失败，原因：非法应用");
        }
//        CJSystem.logging().info(getClass(),String.format("token:%s",token));
        AppAccessToken appAccessToken = appAccessTokenService.getAccessToken(token);
        if (appAccessToken == null) {
            throw new CircuitException("1012", "验证失败，原因：令牌无效");
        }
        String person = appAccessToken.getPerson();
        AppAccount appAccount = appAccountService.getAccount(person);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("person", person);
        map.put("nickName", appAccount != null ? appAccount.getNickName() : null);
        map.put("device", appAccessToken.getDevice());
        map.put("portal", app.getPortal());
        map.put("pubTime", appAccessToken.getPubTime());
        map.put("expireTime", appAccessToken.getExpireTime());
        map.put("isExpired", System.currentTimeMillis() > appAccessToken.getPubTime() + appAccessToken.getExpireTime());
        List<String> roles = new Gson().fromJson(appAccessToken.getRoles(), new TypeToken<ArrayList<String>>() {
        }.getType());
        map.put("roles", roles);
        return map;
    }
}
