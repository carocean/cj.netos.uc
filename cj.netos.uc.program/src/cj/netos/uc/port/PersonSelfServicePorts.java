package cj.netos.uc.port;

import cj.netos.uc.model.*;
import cj.netos.uc.service.*;
import cj.netos.uc.util.Encript;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.ultimate.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CjService(name = "/person/self.service")
public class PersonSelfServicePorts implements IPersonSelfServicePorts {
    @CjServiceRef(refByName = "ucplugin.appAccountService")
    IAppAccountService appAccountService;
    @CjServiceRef(refByName = "ucplugin.tenantAppService")
    IAppService appService;
    @CjServiceRef(refByName = "ucplugin.tenantService")
    ITenantService tenantService;
    @CjServiceRef(refByName = "ucplugin.ucUserService")
    IUcUserService ucUserService;
    @CjServiceRef(refByName = "ucplugin.domainService")
    IDomainService domainService;

    @Override
    public List<Map<String, Object>> listMyAccount(ISecuritySession securitySession, String appid) throws CircuitException {
        if (StringUtil.isEmpty(appid)) {
            appid = securitySession.principal();
            appid = appid.substring(appid.indexOf("@") + 1);
        }
        AppAccount account = appAccountService.getAccount(securitySession.principal());
        List<AppAccount> list = appService.listMyAccount(account.getUserId(), appid);
        List<Map<String, Object>> ret = new ArrayList<>();
        for (AppAccount a : list) {
            Map<String, Object> obj = new HashMap<>();
            obj.put("signature", a.getSignature());
            obj.put("avatar", a.getAvatar());
            obj.put("nickName", a.getNickName());
            obj.put("person", a.getAccountId());
            obj.put("uid", a.getUserId());
            obj.put("accountCode", a.getAccountCode());
            obj.put("appId", a.getAppId());
            obj.put("createTime", a.getCreateTime());
            obj.put("nameKind", a.getNameKind());
            ret.add(obj);
        }
        return ret;
    }

    @Override
    public List<AppInfo> listAppInfo(ISecuritySession securitySession, long offset, int limit) throws CircuitException {
        String tenantid = securitySession.principal();
        tenantid = tenantid.substring(tenantid.lastIndexOf(".") + 1);
        UcTenant tenant = tenantService.getTenantById(tenantid);
        List<TenantApp> list = appService.pageApp(tenantid, offset, limit);
        List<AppInfo> ret = new ArrayList<>();
        for (TenantApp app : list) {
            AppInfo appinfo = new AppInfo();
            appinfo.setAppCode(app.getAppCode());
            appinfo.setAppid(app.getAppId());
            if (app.getCtime() != null) {
                appinfo.setAppCTime(app.getCtime());
            }
            appinfo.setAppLogo(app.getAppLogo());
            appinfo.setAppName(app.getAppName());
            appinfo.setLoginCbUrl(app.getLoginCbUrl());
            appinfo.setLogoutCbUrl(app.getLogoutCbUrl());
            appinfo.setWebsite(app.getWebsite());
            appinfo.setTenantId(app.getTenantId());
            appinfo.setTenantName(tenant.getTenantName());
            appinfo.setTenantCTime(tenant.getCreateTime() != null ? tenant.getCreateTime().getTime() : 0);
            ret.add(appinfo);
        }
        return ret;
    }

    @Override
    public void requestCreateApp(ISecuritySession securitySession, String appCode, String appName, String tenantId, long tokenExpire, String appLogo, String website, String loginCBUrl, String logoutCBUrl) throws CircuitException {
        //暂不实现
    }

    @Override
    public void updatePersonPassword(ISecuritySession securitySession, String oldpwd, String newpwd) throws CircuitException {
        String accountid = securitySession.principal();
        AppAccount account = appAccountService.getAccount(accountid);
        if (!Encript.md5(oldpwd).equals(account.getAccountPwd())) {
            throw new CircuitException("505", "原密码不正确");
        }
        appAccountService.updatePwd(accountid, newpwd);
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
    public void updatePersonRealName(ISecuritySession securitySession, String realName) throws CircuitException {
        AppAccount account = this.appAccountService.getAccount(securitySession.principal());
        this.ucUserService.updateRealName(account.getUserId(), realName);
    }

    @Override
    public void updatePersonSex(ISecuritySession securitySession, String sex) throws CircuitException {
        AppAccount account = this.appAccountService.getAccount(securitySession.principal());
        this.ucUserService.updateSex(account.getUserId(), sex);
    }

    @Override
    public void removePerson(ISecuritySession securitySession) throws CircuitException {
        this.appAccountService.removeAccount(securitySession.principal());
    }

    @Override
    public void addByPassword(ISecuritySession securitySession, String appid, String accountCode, String password, String nickName, String avatar, String signature) throws CircuitException {
        AppAccount account = appAccountService.getAccount(securitySession.principal());
        if (StringUtil.isEmpty(appid)) {
            appid = account.getAppId();
        }
        this.appAccountService.addByPassword(account.getUserId(), appid, accountCode, password, nickName, avatar, signature);
    }

    @Override
    public void addByIphone(ISecuritySession securitySession, String appid, String phone, String password, String nickName, String avatar, String signature) throws CircuitException {
        AppAccount account = appAccountService.getAccount(securitySession.principal());
        if (StringUtil.isEmpty(appid)) {
            appid = account.getAppId();
        }
        this.appAccountService.addByIphone(account.getUserId(), appid, phone, password, nickName, avatar, signature);
    }

    @Override
    public void addByEmail(ISecuritySession securitySession, String appid, String email, String password, String nickName, String avatar, String signature) throws CircuitException {
        AppAccount account = appAccountService.getAccount(securitySession.principal());
        if (StringUtil.isEmpty(appid)) {
            appid = account.getAppId();
        }
        this.appAccountService.addByEmail(account.getUserId(), appid, email, password, nickName, avatar, signature);
    }

    @Override
    public PersonInfo getPersonInfo(ISecuritySession securitySession) throws CircuitException {
        AppAccount account = appAccountService.getAccount(securitySession.principal());
        UcUser user = ucUserService.getUserById(account.getUserId());
        PersonInfo info = new PersonInfo(account.getAccountCode(), account.getAppId());
        info.setSignature(account.getSignature());
        info.setNickName(account.getNickName());
        info.setAvatar(account.getAvatar());
        info.setUid(account.getUserId());
        info.setRealName(user.getRealName());
        info.setSex(user.getSex());

        List<DomainValue> values = domainService.listAllDomainValue(user.getUserId());
        Map<String, DomainGroup> groups = new HashMap<>();
        Map<String, DomainField> fields = new HashMap<>();
        for (DomainValue value : values) {
            DomainGroup group = groups.get(value.getGroupId());
            if (group == null) {
                group = domainService.getDomainGroup(value.getGroupId());
                if (group == null) {
                    continue;
                }
                groups.put(value.getGroupId(), group);
            }
            DomainField field = fields.get(value.getFieldId());
            if (field == null) {
                field = domainService.getDomainField(value.getFieldId());
                if (field == null) {
                    continue;
                }
                fields.put(value.getFieldId(), field);
            }
        }
        Map<String, Object> domains = new HashMap<>();
        domains.put("groups", groups);
        domains.put("fields", fields);
        domains.put("values", values);
        info.setDomains(domains);
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
        if (app.getCtime() != null) {
            appinfo.setAppCTime(app.getCtime());
        }
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

    @Override
    public void setDomainValue(ISecuritySession securitySession, String fieldId, String content) throws CircuitException {
        int pos=fieldId.lastIndexOf(".");
        if (pos < 0) {
            throw new CircuitException("500","fieldId缺少.分隔，前为字段代码，后为组代码");
        }
        String groupId=fieldId.substring(pos+1);
        AppAccount account = appAccountService.getAccount(securitySession.principal());
        this.domainService.setDomainValue(account.getUserId(), groupId, fieldId, content);
    }

    @Override
    public DomainValue getDomainValue(ISecuritySession securitySession, String fieldId) throws CircuitException {
        int pos=fieldId.lastIndexOf(".");
        if (pos < 0) {
            throw new CircuitException("500","fieldId缺少.分隔，前为字段代码，后为组代码");
        }
        AppAccount account = appAccountService.getAccount(securitySession.principal());
        return domainService.getDomainValue(account.getUserId(),fieldId);
    }

    @Override
    public void emptyDomainValue(ISecuritySession securitySession, String fieldId) throws CircuitException {
        AppAccount account = appAccountService.getAccount(securitySession.principal());
        this.domainService.emptyDomainValue(account.getUserId(), fieldId);
    }

    @Override
    public List<DomainValue> listDomainValueOfGroup(ISecuritySession securitySession, String groupId) throws CircuitException {
        AppAccount account = appAccountService.getAccount(securitySession.principal());
        return this.domainService.listDomainValueOfGroup(account.getUserId(), groupId);
    }

    @Override
    public List<DomainValue> listAllDomainValue(ISecuritySession securitySession) throws CircuitException {
        AppAccount account = appAccountService.getAccount(securitySession.principal());
        return this.domainService.listAllDomainValue(account.getUserId());
    }
}
