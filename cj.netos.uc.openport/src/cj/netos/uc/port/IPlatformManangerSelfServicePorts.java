package cj.netos.uc.port;

import cj.netos.uc.model.*;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.AccessTokenIn;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportAppSecurity;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;
import java.util.Map;

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
    @CjOpenport(usage = "添加用户信息的扩展域组，类似于加一个表")
    void addDomainGroup(ISecuritySession securitySession,
                        @CjOpenportParameter(name = "groupId", usage = "组标识，类似于表名，要指定为英文") String groupId,
                        @CjOpenportParameter(name = "groupName", usage = "组名") String groupName) throws CircuitException;

    @CjOpenport(usage = "移除用户信息的扩展域组")
    void removeDomainGroup(ISecuritySession securitySession,
                           @CjOpenportParameter(name = "groupId", usage = "组标识") String groupId) throws CircuitException;

    @CjOpenport(usage = "列表用户信息的扩展域组")
    List<DomainGroup> listDomainGroup(ISecuritySession securitySession) throws CircuitException;

    @CjOpenport(usage = "添加用户信息扩展域字段")
    void addDomainField(ISecuritySession securitySession,
                        @CjOpenportParameter(name = "fieldCode", usage = "字段编号") String fieldCode,
                        @CjOpenportParameter(name = "groupId", usage = "域组标识") String groupId,
                        @CjOpenportParameter(name = "fieldName", usage = "字段中文名") String fieldName,
                        @CjOpenportParameter(name = "fieldDesc", usage = "字段描述") String fieldDesc) throws CircuitException;

    @CjOpenport(usage = "移除用户信息扩展域字段")
    void removeDomainField(ISecuritySession securitySession,
                           @CjOpenportParameter(name = "fieldId", usage = "字段标识") String fieldId) throws CircuitException;

    @CjOpenport(usage = "列表用户信息扩展域字段")
    List<DomainField> listDomainField(ISecuritySession securitySession,
                                      @CjOpenportParameter(name = "groupId", usage = "组标识") String groupId) throws CircuitException;

    @CjOpenport(usage = "清空用户信息扩展域字段")
    void emptyDomainField(ISecuritySession securitySession,
                          @CjOpenportParameter(name = "groupId", usage = "组标识") String groupId) throws CircuitException;

    @CjOpenportAppSecurity(usage = "需要超级权限")
    @CjOpenport(usage = "获取应用信息", responseStatus = {"200 OK", "404 应用号不存在", "801 拒绝访问"},tokenIn = AccessTokenIn.nope)
    Map<String, Object> getAppKeyStore(ISecuritySession securitySession,
                                       @CjOpenportParameter(name = "appid", usage = "应用号") String appid) throws CircuitException;

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
