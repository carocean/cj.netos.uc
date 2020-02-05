package cj.netos.uc.port;

import cj.netos.uc.model.*;
import cj.netos.uc.service.IAppAccountService;
import cj.netos.uc.service.IAppService;
import cj.netos.uc.service.ITenantService;
import cj.netos.uc.util.Encript;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

@CjService(name = "/person/self.service")
public class PersonSelfServicePorts implements IPersonSelfServicePorts {
    @CjServiceRef(refByName = "ucplugin.appAccountService")
    IAppAccountService appAccountService;
    @CjServiceRef(refByName = "ucplugin.tenantAppService")
    IAppService appService;
    @CjServiceRef(refByName = "ucplugin.tenantService")
    ITenantService tenantService;

    @Override
    public void updatePassword(ISecuritySession securitySession, String oldpwd, String newpwd) throws CircuitException {
        String accountid = securitySession.principal();
        AppAccount account = appAccountService.getAccount(accountid);
        if (!Encript.md5(oldpwd).equals(account.getAccountPwd())) {
            throw new CircuitException("505", "原密码不正确");
        }
        appAccountService.updatePwd(accountid, newpwd);
    }

    @Override
    public void requestCreateApp(ISecuritySession securitySession, String appCode, String appName, String tenantId, long tokenExpire, String appLogo, String website, String loginCBUrl, String logoutCBUrl) throws CircuitException {
        //暂不实现
    }

    @Override
    public void updatePersonAvatar(ISecuritySession securitySession, String avatar) throws CircuitException {
        this.appAccountService.updateAvatar(securitySession.principal(), avatar);
    }

    @Override
    public void updatePersonSignature(ISecuritySession securitySession, String signature) throws CircuitException {
        this.appAccountService.updateSignature(securitySession.principal(), signature);
    }

    @Override
    public void updatePersonNickName(ISecuritySession securitySession, String nickName) throws CircuitException {
        this.appAccountService.updateNickName(securitySession.principal(), nickName);
    }


    @Override
    public void addByPassword(ISecuritySession securitySession, String accountCode, String password, String nickName, String avatar, String signature) throws CircuitException {
        AppAccount account = appAccountService.getAccount(securitySession.principal());
        this.appAccountService.addByPassword(account.getUserId(), account.getAppId(), accountCode, password, nickName, avatar, signature);
    }

    @Override
    public void addByIphone(ISecuritySession securitySession, String phone, String password, String nickName, String avatar, String signature) throws CircuitException {
        AppAccount account = appAccountService.getAccount(securitySession.principal());
        this.appAccountService.addByPassword(account.getUserId(), account.getAppId(), phone, password, nickName, avatar, signature);
    }

    @Override
    public void addByEmail(ISecuritySession securitySession, String email, String password, String nickName, String avatar, String signature) throws CircuitException {
        AppAccount account = appAccountService.getAccount(securitySession.principal());
        this.appAccountService.addByPassword(account.getUserId(), account.getAppId(), email, password, nickName, avatar, signature);
    }

    @Override
    public PersonInfo getPersonInfo(ISecuritySession securitySession) throws CircuitException {
        AppAccount account = appAccountService.getAccount(securitySession.principal());
        PersonInfo info = new PersonInfo(account.getAccountCode(), account.getAppId());
        info.setSignature(account.getSignature());
        info.setNickName(account.getNickName());
        info.setAvatar(account.getAvatar());
        info.setUid(account.getUserId());
        return info;
    }

    @Override
    public AppInfo getAppInfo(ISecuritySession securitySession) throws CircuitException {
        String principal = securitySession.principal();
        String appid = principal.substring(principal.indexOf("@") + 1, principal.length());
        String tenantid = appid.substring(appid.lastIndexOf(".") + 1, appid.length());
        UcTenant tenant = tenantService.getTenantById(tenantid);
        TenantApp app = appService.getApp(appid);
        AppInfo appinfo = new AppInfo();
        appinfo.setAppCode(app.getAppCode());
        appinfo.setAppid(app.getAppId());
        appinfo.setAppCTime(app.getCtime());
        appinfo.setAppLogo(app.getAppLogo());
        appinfo.setAppName(app.getAppName());
        appinfo.setLoginCbUrl(app.getLoginCbUrl());
        appinfo.setLogoutCbUrl(app.getLogoutCbUrl());
        appinfo.setWebsite(app.getWebsite());
        appinfo.setTenantId(app.getTenantId());
        appinfo.setTenantName(tenant.getTenantName());
        appinfo.setTenantCTime(tenant.getCreateTime() != null ? tenant.getCreateTime().getTime() : 0);
        return appinfo;
    }
}
