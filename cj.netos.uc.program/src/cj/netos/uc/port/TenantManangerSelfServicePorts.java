package cj.netos.uc.port;

import cj.netos.uc.model.TenantApp;
import cj.netos.uc.model.TenantRole;
import cj.netos.uc.model.UcTenant;
import cj.netos.uc.model.UcUser;
import cj.netos.uc.service.ITenantService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

import java.util.List;

@CjService(name = "/tenant/self.ports")
public class TenantManangerSelfServicePorts implements ITenantManangerSelfServicePorts {
    @CjServiceRef(refByName = "ucplugin.tenantService")
    ITenantService tenantService;

    @Override
    public UcTenant getTenant(ISecuritySession securitySession, String tenantId) throws CircuitException {
        return tenantService.getTenantById(tenantId);
    }

    @Override
    public void addApp(ISecuritySession securitySession, String appid, String appName, String applogo, String website, String loginCallbackUrl, String logoutCallbackUrl) {

    }

    @Override
    public List<TenantApp> pageApp(ISecuritySession securitySession, int limit, long offset) {
        return null;
    }

    @Override
    public void addRole(ISecuritySession securitySession, String roleid, String roleName, String extendUcRole) {

    }

    @Override
    public void removeRole(ISecuritySession securitySession, String roleId) {

    }

    @Override
    public TenantRole getRole(ISecuritySession securitySession, String roleId) {
        return null;
    }

    @Override
    public List<TenantRole> listRole(ISecuritySession securitySession) {
        return null;
    }

    @Override
    public void grantRoleToUser(ISecuritySession securitySession, String roleid, String uid) {

    }

    @Override
    public void ungrantRoleToUser(ISecuritySession securitySession, String roleid, String uid) {

    }

    @Override
    public List<TenantRole> getRoleOfUser(ISecuritySession securitySession, String uid) {
        return null;
    }

    @Override
    public List<UcUser> getUserInRole(ISecuritySession securitySession, String roleid) {
        return null;
    }
}
