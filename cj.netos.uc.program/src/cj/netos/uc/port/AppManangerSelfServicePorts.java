package cj.netos.uc.port;

import cj.netos.uc.model.AppAccount;
import cj.netos.uc.model.AppRole;
import cj.netos.uc.model.TenantApp;
import cj.netos.uc.model.UcTenant;
import cj.netos.uc.service.IAppAccountService;
import cj.netos.uc.service.IAppRoleService;
import cj.netos.uc.service.IAppService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

import java.util.List;

@CjService(name = "/app/self.ports")
public class AppManangerSelfServicePorts implements IAppManangerSelfServicePorts {
    @CjServiceRef(refByName = "ucplugin.tenantAppService")
    IAppService appService;
    @CjServiceRef(refByName = "ucplugin.appAccountService")
    IAppAccountService appAccountService;
    @CjServiceRef(refByName = "ucplugin.tenantAppRoleService")
    IAppRoleService appRoleService;

    @Override
    public String createApp(ISecuritySession securitySession, String appCode, String appName, String portal, long tokenExpire, String appLogo, String website, String loginCBUrl, String logoutCBUrl) throws CircuitException {
        //必须是平台超级管理员、租户管理员或租户开发者权限
        String tenantId = checkRighs(securitySession);
        return appService.addApp(appCode, appName, portal, tenantId, tokenExpire, appLogo, website, loginCBUrl, logoutCBUrl);
    }

    private String checkRighs(ISecuritySession securitySession) throws CircuitException {
        String principal = securitySession.principal();
        String tenantId = principal.substring(principal.lastIndexOf(".") + 1, principal.length());
        if (!securitySession.roleIn("platform:administrators") && !securitySession.roleIn(String.format("tenant:appAdministrators@%s", tenantId)) && !securitySession.roleIn(String.format("tenant:appDevelops@%s", tenantId))) {
            throw new CircuitException("801", "无权限。");
        }
        return tenantId;
    }

    @Override
    public void freezenAccount(ISecuritySession securitySession, String accountCode) throws CircuitException {
        checkRighs(securitySession);
        String principal = securitySession.principal();
        String appid = principal.substring(principal.indexOf("@") + 1, principal.length());
        String accountid = String.format("%s@%s", accountCode, appid);
        appAccountService.setAccountEnable(accountid, false);
    }

    @Override
    public void unfreezenAccount(ISecuritySession securitySession, String accountCode) throws CircuitException {
        checkRighs(securitySession);
        String principal = securitySession.principal();
        String appid = principal.substring(principal.indexOf("@") + 1, principal.length());
        String accountid = String.format("%s@%s", accountCode, appid);
        appAccountService.setAccountEnable(accountid, true);
    }

    @Override
    public void resetAppKeyPair(ISecuritySession securitySession, long tokenExpire) throws CircuitException {
        checkRighs(securitySession);
        String principal = securitySession.principal();
        String appid = principal.substring(principal.indexOf("@") + 1, principal.length());
        appService.reissueAppSecret(appid, tokenExpire);
    }

    @Override
    public TenantApp getApp(ISecuritySession securitySession) throws CircuitException {
        checkRighs(securitySession);
        String principal = securitySession.principal();
        String appid = principal.substring(principal.indexOf("@") + 1, principal.length());
        return appService.getApp(appid);
    }

    @Override
    public List<AppAccount> pageAccount(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
//        checkRighs(securitySession);
        String principal = securitySession.principal();
        String appid = principal.substring(principal.indexOf("@") + 1, principal.length());
        return appAccountService.pageAccount(appid, offset, limit);
    }

    @Override
    public AppAccount getAccount(ISecuritySession securitySession, String accountCode) throws CircuitException {
        checkRighs(securitySession);
        String principal = securitySession.principal();
        String appid = principal.substring(principal.indexOf("@") + 1, principal.length());
        String person = String.format("%s@%s", accountCode, appid);
        return appAccountService.getAccount(person);
    }

    @Override
    public String addRole(ISecuritySession securitySession, String roleCode, String roleName, String extendTenantRole) throws CircuitException {
        checkRighs(securitySession);
        String principal = securitySession.principal();
        String appid = principal.substring(principal.indexOf("@") + 1, principal.length());
        return appRoleService.addRole(roleCode, roleName, appid, extendTenantRole);
    }

    @Override
    public void removeRole(ISecuritySession securitySession, String roleid) throws CircuitException {
        checkRighs(securitySession);
        appRoleService.removeRoleBy(roleid);
    }

    @Override
    public AppRole getRole(ISecuritySession securitySession, String roleid) throws CircuitException {
        checkRighs(securitySession);
        return appRoleService.getRoleBy(roleid);
    }

    @Override
    public List<AppRole> listRole(ISecuritySession securitySession) throws CircuitException {
        checkRighs(securitySession);
        String principal = securitySession.principal();
        String appid = principal.substring(principal.indexOf("@") + 1, principal.length());
        return appRoleService.pageRole(appid, 0, Integer.MAX_VALUE);
    }

    @Override
    public void grantRoleToPerson(ISecuritySession securitySession, String roleid, String accountid) throws CircuitException {
        checkRighs(securitySession);
        appRoleService.addRoleToAccount(roleid, accountid);
    }

    @Override
    public void ungrantRoleToPerson(ISecuritySession securitySession, String roleid, String accountid) throws CircuitException {
        checkRighs(securitySession);
        appRoleService.removeRoleFromAccount(roleid, accountid);
    }

    @Override
    public List<AppRole> getRoleOfAccount(ISecuritySession securitySession, String accountid) throws CircuitException {
        checkRighs(securitySession);
        String principal = securitySession.principal();
        String appid = principal.substring(principal.indexOf("@") + 1, principal.length());
        return appRoleService.pageRoleOfAccount(accountid, appid, 0, Long.MAX_VALUE);
    }

    @Override
    public List<AppAccount> getAccountInRole(ISecuritySession securitySession, String roleId) throws CircuitException {
        checkRighs(securitySession);
        String principal = securitySession.principal();
        String appid = principal.substring(principal.indexOf("@") + 1, principal.length());
        return appRoleService.pageAccountInRole(appid, roleId, 0, Long.MAX_VALUE);
    }

    @Override
    public UcTenant getTenant(ISecuritySession securitySession) throws CircuitException {
        return null;
    }
}
