package cj.netos.uc.plugin.service;

import cj.netos.uc.model.*;
import cj.netos.uc.plugin.mapper.TenantAppMapper;
import cj.netos.uc.service.*;
import cj.netos.uc.util.Encript;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.util.StringUtil;

import java.util.List;
import java.util.UUID;

@CjBridge(aspects = "@transaction")
@CjService(name = "tenantAppService")
public class TenantAppService implements IAppService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.TenantAppMapper")
    TenantAppMapper tenantAppMapper;

    @CjServiceRef
    IAppAccountService appAccountService;
    @CjServiceRef
    IUcRoleService ucRoleService;
    @CjServiceRef
    ITenantRoleService tenantRoleService;
    @CjServiceRef(refByName = "tenantAppRoleService")
    IAppRoleService appRoleService;
    @CjServiceRef
    IUcUserService ucUserService;
    @CjServiceSite
    IServiceSite site;

    @CjTransaction
    @Override
    public String addApp(String appCode, String appName, String tenantId, long tokenExpire, String appLogo, String website, String loginCBUrl, String logoutCBUrl) throws CircuitException {
        if (StringUtil.isEmpty(tenantId)) {
            throw new CircuitException("404", "租户标识为空");
        }
        if (StringUtil.isEmpty(appName)) {
            throw new CircuitException("404", "应用名为空");
        }
        if (existsAppName(appName, tenantId)) {
            throw new CircuitException("500", String.format("租户%s下已存在应用:%s", tenantId, appName));
        }
        if (tokenExpire < 1) {
            tokenExpire = 24 * 60 * 60 * 1000L;
        }
        String appid=String.format("%s.%s",appCode,tenantId);
        String appKey = Encript.md5(appid);
        String appSecret = Encript.md5(String.format("%s.%s.%s", appid,appKey, UUID.randomUUID().toString()));

        TenantApp app = new TenantApp();
        app.setAppId(appid);
        app.setAppCode(appCode);
        app.setAppName(appName);
        app.setTenantId(tenantId);
        app.setAppKey(appKey);
        app.setAppSecret(appSecret);
        app.setTokenExpire(tokenExpire);
        app.setAppLogo(appLogo);
        app.setWebsite(website);
        app.setLoginCbUrl(loginCBUrl);
        app.setLogoutCbUrl(logoutCBUrl);

        tenantAppMapper.insertSelective(app);
        //同时为app添加固定角色
        if (appRoleService.getRole(appid,"administrators") == null) {
            appRoleService.addRole("administrators", "appAdministrators", appid, "管理员");
        }
        if (appRoleService.getRole(appid,"tests") == null) {
            appRoleService.addRole("tests", "appTests", appid, "测试员");
        }
        if (appRoleService.getRole(appid,"develops") == null) {
            appRoleService.addRole("develops", "appDevelops", appid, "开发者");
        }
        if (appRoleService.getRole(appid,"users") == null) {
            appRoleService.addRole("users", "appUsers", appid, "普通用户");
        }
        return app.getAppId();
    }

    @CjTransaction
    @Override
    public boolean existsAppName(String appName, String tenantId) {
        TenantAppExample example = new TenantAppExample();
        example.createCriteria().andTenantIdEqualTo(tenantId).andAppNameEqualTo(appName);
        return tenantAppMapper.countByExample(example) > 0;
    }
    @CjTransaction
    @Override
    public void reissueAppSecret(String appid, long tokenExpire) {
        String appKey = Encript.md5(appid);
        String appSecret = Encript.md5(String.format("%s.%s.%s", appid,appKey, UUID.randomUUID().toString()));
        tenantAppMapper.updateAppSecret(appid, appSecret, tokenExpire);
    }

    @CjTransaction
    @Override
    public TenantApp getAppByName(String tenantid, String appName) {
        TenantAppExample example = new TenantAppExample();
        example.createCriteria().andTenantIdEqualTo(tenantid).andAppNameEqualTo(appName);
        List<TenantApp> list = tenantAppMapper.selectByExample(example);
        if (list.isEmpty()) return null;
        return list.get(0);
    }

    @CjTransaction
    @Override
    public void removeApp(String appid) throws CircuitException {
        tenantAppMapper.deleteByPrimaryKey(appid);
    }

    @CjTransaction
    @Override
    public TenantApp getApp(String appid) throws CircuitException {
        return tenantAppMapper.selectByPrimaryKey(appid);
    }

    @CjTransaction
    @Override
    public List<TenantApp> pageApp(String tenantid, long currPage, int pageSize) throws CircuitException {
        return tenantAppMapper.pageApp(tenantid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public void updateWebsite(String appid, String website, String loginCBUrl, String logoutCBUrl) throws CircuitException {
        tenantAppMapper.updateWebsite(appid, website, loginCBUrl, logoutCBUrl);
    }

    @CjTransaction
    @Override
    public void updateAppName(String appid, String newAppName) throws CircuitException {
        tenantAppMapper.updateAppName(appid, newAppName);
    }

    @CjTransaction
    @Override
    public void upgradeBecomeDeveloper(String appid, String accountCode) throws CircuitException {
        TenantApp app = getApp(appid);
        if (app == null) {
            throw new CircuitException("404", "应用不存在:" + appid);
        }
        AppAccount account = appAccountService.getAccountByCode(appid, accountCode);
        if (account == null) {
            throw new CircuitException("404", "账户不存在:" + accountCode);
        }

        String uid = account.getUserId();
        if (!ucRoleService.hasRoleOfUser("tenantDevelops", uid)) {
            ucRoleService.addRoleToUser("tenantDevelops", uid);
        }
    }

}
