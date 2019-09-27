package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.*;
import cj.netos.uc.util.Encript;
import cj.netos.uc.util.JwtUtil;
import cj.netos.uc.service.*;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.ecm.net.CircuitException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CjService(name = "authService")
public class AuthService implements IAuthService {
    @CjServiceRef
    IAppAccountService appAccountService;
    @CjServiceRef
    IUcRoleService ucRoleService;
    @CjServiceRef
    ITenantRoleService tenantRoleService;
    @CjServiceRef(refByName = "tenantAppRoleService")
    IAppRoleService appRoleService;
    @CjServiceRef(refByName = "tenantAppService")
    IAppService appService;

    @Override
    public IdentityInfo auth(String appid, String accountName, String password) throws CircuitException {
        AppAccount account = appAccountService.getAccountByName(appid, accountName);
        if (account == null) {
            throw new CircuitException("404", "账户不存在:" + accountName);
        }

        if (!account.getAccountPwd().equals(Encript.md5(password))) {
            throw new CircuitException("404", String.format("账户:%s 密码不正确.", accountName));
        }

        IdentityInfo identityInfo = new IdentityInfo();
        identityInfo.setAccountid(account.getAccountId());
        identityInfo.setAccountName(account.getAccountName());
        identityInfo.setAppid(account.getAppId());
        identityInfo.setUid(account.getUserId());

        List<UcRole> ucroles = ucRoleService.pageRoleOfUser(account.getUserId(), 0, Integer.MAX_VALUE);
        List<TenantRole> taroles = tenantRoleService.pageRoleOfUser(account.getUserId(), 0, Integer.MAX_VALUE);
        List<AppRole> approles = appRoleService.pageRoleOfUser(account.getUserId(), 0, Integer.MAX_VALUE);

        identityInfo.setUcRoles(ucroles);
        identityInfo.setTenantRoles(taroles);
        identityInfo.setAppRoles(approles);
        Map<String, Object> claims = new HashMap<>();
        claims.put("uc-roles", ucroles);
        claims.put("tenant-roles", taroles);
        claims.put("app-roles", approles);
        claims.put("accountid", account.getAccountId());
        claims.put("accountName", account.getAccountName());
        claims.put("appid", account.getAppId());

        TenantApp app = appService.getApp(account.getAppId());
        String key = app.getSecretKey();
        long ttlMillis = app.getTokenExpire();

        String accessToken = JwtUtil.createJWT(key, account.getUserId(), ttlMillis, claims);
        identityInfo.setAccessToken(accessToken);
        return identityInfo;
    }
}
