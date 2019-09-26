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
    @CjServiceSite
    IServiceSite serviceSite;

    @Override
    public IdentityInfo auth(String tenantid, String accountName, String password) throws CircuitException {
        AppAccount account = appAccountService.getAccountByName(tenantid, accountName);
        if (account == null) {
            throw new CircuitException("404", "用户不存在:" + accountName);
        }

        if (!account.getAccountPwd().equals(Encript.md5(password))) {
            throw new CircuitException("404", String.format("用户:%s 密码不正确.", account));
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
        String key = serviceSite.getProperty("uc.auth.key");
        String ttlMillis = serviceSite.getProperty("uc.auth.ttlMillis");

        String accessToken = JwtUtil.createJWT(key, account.getUserId(), Long.valueOf(ttlMillis), claims);
        identityInfo.setAccessToken(accessToken);
        return identityInfo;
    }
}
