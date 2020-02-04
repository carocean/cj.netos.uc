package cj.netos.uc.port;

import cj.netos.uc.model.TenantRole;
import cj.netos.uc.model.UcRole;
import cj.netos.uc.model.UcTenant;
import cj.netos.uc.model.UcUser;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

/***
 *
 * - 租户管理
 * - 用户管理
 * - 平台角色管理
 * - 企业及其部门管理（之后再实现）
 * -
 */
@CjOpenports(usage = "平台管理者自助服务")
public interface IPlatformManangerSelfServicePorts extends IOpenportService {
    void addTenant(ISecuritySession securitySession);

    void removeTenant(ISecuritySession securitySession);

    List<UcTenant> pageTenant(ISecuritySession securitySession, int limit, long offset);

    void addRole(ISecuritySession securitySession, String roleid, String roleName, String extendUcRole);

    void removeRole(ISecuritySession securitySession, String roleId);

    UcRole getRole(ISecuritySession securitySession, String roleId);

    List<UcRole> listRole(ISecuritySession securitySession);

    void grantRoleToUser(ISecuritySession securitySession, String roleid, String uid);

    void ungrantRoleToUser(ISecuritySession securitySession, String roleid, String uid);

    List<UcRole> getRoleOfUser(ISecuritySession securitySession, String uid);

    List<UcUser> getUserInRole(ISecuritySession securitySession, String roleid);
}
