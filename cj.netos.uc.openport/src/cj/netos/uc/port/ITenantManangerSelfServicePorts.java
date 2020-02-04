package cj.netos.uc.port;

import cj.netos.uc.model.*;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

/***
 *
 * - 应用管理
 * - 租户角色管理
 *
 */
@CjOpenports(usage = "租户管理者自助服务")
public interface ITenantManangerSelfServicePorts extends IOpenportService {


    UcTenant getTenant(ISecuritySession securitySession);

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
