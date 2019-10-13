package cj.netos.uc.plugin.service;

import cj.netos.uc.model.*;
import cj.netos.uc.plugin.mapper.TenantAppMapper;
import cj.netos.uc.service.*;
import cj.netos.uc.util.Encript;
import cj.netos.uc.util.JwtUtil;
import cj.netos.uc.util.NumberGen;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.util.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String addApp(String appid, String appName, String tenantId, long tokenExpire, String appLogo, String website, String loginCBUrl, String logoutCBUrl) throws CircuitException {
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
        TenantApp app = new TenantApp();
        app.setAppId(StringUtil.isEmpty(appid) ? NumberGen.gen() : appid);
        app.setAppName(appName);
        app.setTenantId(tenantId);
        app.setSecretKey(NumberGen.gen());
        app.setTokenExpire(tokenExpire);
        app.setAppLogo(appLogo);
        app.setWebsite(website);
        app.setLoginCbUrl(loginCBUrl);
        app.setLogoutCbUrl(logoutCBUrl);

        tenantAppMapper.insertSelective(app);
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
    public List<TenantApp> pageApp(String tenantid, int currPage, int pageSize) throws CircuitException {
        return tenantAppMapper.pageApp(tenantid, currPage, pageSize);
    }
    @CjTransaction
    @Override
    public void updateWebsite(String appid, String website, String loginCBUrl, String logoutCBUrl) throws CircuitException {
        tenantAppMapper.updateWebsite(appid,website,loginCBUrl,logoutCBUrl);
    }
    @CjTransaction
    @Override
    public void updateAppName(String appid, String newAppName) throws CircuitException {
        tenantAppMapper.updateAppName(appid,newAppName);
    }
    @CjTransaction
    @Override
    public String issueDevelopToken(String appid, String accountName, String password) throws CircuitException {
        AppAccount account = appAccountService.getAccountByName(appid, accountName);
        if (account == null) {
            UcUser user = ucUserService.getUserById(accountName);//accountName可能是用户编号
            if (user == null) {
                throw new CircuitException("404", "账户不存在:" + accountName);
            }
            List<AppAccount> list = appAccountService.listAccountByAppidAndUid(appid, user.getUserId());
            for (AppAccount appAccount : list) {
                if (appAccount.getAccountPwd().equals(Encript.md5(password))) {
                    account = appAccount;
                    break;
                }
            }
            if (account == null) {
                throw new CircuitException("404", "账户不存在:" + accountName);
            }
            if (!account.getAccountPwd().equals(Encript.md5(password))) {
                throw new CircuitException("404", String.format("账户:%s 密码不正确.", accountName));
            }
        } else {
            if (!account.getAccountPwd().equals(Encript.md5(password))) {
                throw new CircuitException("404", String.format("账户:%s 密码不正确.", accountName));
            }
        }
        TenantApp app = getApp(appid);
        if (app == null) {
            throw new CircuitException("404", "应用不存在:" + appid);
        }

        List<UcRole> ucroles = ucRoleService.pageRoleOfUser(account.getUserId(), 0, Integer.MAX_VALUE);
        List<TenantRole> taroles = tenantRoleService.pageRoleOfUser(account.getUserId(), app.getTenantId(), 0, Integer.MAX_VALUE);
        List<AppRole> approles = appRoleService.pageRoleOfUser(account.getUserId(), appid, 0, Integer.MAX_VALUE);

        Map<String, Object> claims = new HashMap<>();
        claims.put("uc-roles", ucroles);
        claims.put("tenant-roles", taroles);
        claims.put("app-roles", approles);
        claims.put("accountid", account.getAccountId());
        claims.put("accountName", account.getAccountName());
        claims.put("appid", account.getAppId());

        String sysappid=(String) site.getService("#.app.id");
        TenantApp sysapp=getApp(sysappid);
        String appaccessToken = JwtUtil.createJWT(sysapp.getSecretKey(), account.getUserId(),app.getTenantId(), app.getTokenExpire(), claims);
        return appaccessToken;
    }
}
