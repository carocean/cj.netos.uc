package cj.netos.uc.port;

import cj.netos.uc.model.TenantApp;
import cj.netos.uc.model.TenantRole;
import cj.netos.uc.model.UcTenant;
import cj.netos.uc.model.UcUser;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

/***
 *
 * - 租户管理
 * - 租户角色管理
 *
 */
@CjOpenports(usage = "租户管理者自助服务")
public interface ITenantManangerSelfServicePorts  {


    @CjOpenport(usage = "获取租户")
    UcTenant getTenant(ISecuritySession securitySession,
                       @CjOpenportParameter(name = "tenantId", usage = "租户标识") String tenantId) throws CircuitException;

    void addApp(ISecuritySession securitySession, String appid, String appName, String applogo, String website, String loginCallbackUrl, String logoutCallbackUrl);

    List<TenantApp> pageApp(ISecuritySession securitySession, int limit, long offset);

    void addRole(ISecuritySession securitySession, String roleid, String roleName, String extendUcRole);

    void removeRole(ISecuritySession securitySession, String roleId);

    TenantRole getRole(ISecuritySession securitySession, String roleId);

    List<TenantRole> listRole(ISecuritySession securitySession);


    void grantRoleToUser(ISecuritySession securitySession, String roleid, String uid);

    void ungrantRoleToUser(ISecuritySession securitySession, String roleid, String uid);

    List<TenantRole> getRoleOfUser(ISecuritySession securitySession, String uid);

    List<UcUser> getUserInRole(ISecuritySession securitySession, String roleid);
}
