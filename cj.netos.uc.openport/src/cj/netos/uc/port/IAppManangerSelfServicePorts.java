package cj.netos.uc.port;

import cj.netos.uc.model.*;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

/*******
 * - 账户管理
 * - 应用角色管理
 *
 */
@CjOpenports(usage = "应用管理者自助服务")
public interface IAppManangerSelfServicePorts extends IOpenportService {
    @CjOpenport(usage = "直接创建一个应用，必须是租户管理员权限")
    String createApp(ISecuritySession securitySession,
                     @CjOpenportParameter(name = "appCode", usage = "应用编号，英文") String appCode,
                     @CjOpenportParameter(name = "appName", usage = "应用名，一般为中文") String appName,
                     @CjOpenportParameter(name = "portal", usage = "终端支持的渲染框架名，默认为gbera") String portal,
                     @CjOpenportParameter(name = "tokenExpire", usage = "应用访问令牌的过期时间间隔,单位毫秒") long tokenExpire,
                     @CjOpenportParameter(name = "appLogo", usage = "应用logo") String appLogo,
                     @CjOpenportParameter(name = "website", usage = "应用站点地址，如果有") String website,
                     @CjOpenportParameter(name = "loginCBUrl", usage = "uc中心发现应用登录回调通知地址") String loginCBUrl,
                     @CjOpenportParameter(name = "logoutCBUrl", usage = "uc中心发现应用会话过期回调通知地址") String logoutCBUrl
    ) throws CircuitException;

    @CjOpenport(usage = "应用管理员冻结指定账号")
    void freezenAccount(ISecuritySession securitySession,
                        @CjOpenportParameter(name = "accountCode", usage = "为用户登录名") String accountCode) throws CircuitException;

    @CjOpenport(usage = "应用管理员解冻指定账号")
    void unfreezenAccount(ISecuritySession securitySession,
                          @CjOpenportParameter(name = "accountCode", usage = "为用户登录名") String accountCode) throws CircuitException;

    @CjOpenport(usage = "应用管理员重置应用键对，重置后应用客户端必须更新appKey和appSecret")
    void resetAppKeyPair(ISecuritySession securitySession,
                         @CjOpenportParameter(name = "tokenExpire", usage = "应用访问令牌的过期时间间隔") long tokenExpire) throws CircuitException;

    @CjOpenport(usage = "应用管理员查看app信息")
    TenantApp getApp(ISecuritySession securitySession) throws CircuitException;

    @CjOpenport(usage = "查看应用账户列表。当前访问者仅能查看其应用中的账号")
    List<AppAccount> pageAccount(ISecuritySession securitySession,
                                 @CjOpenportParameter(name = "limit", usage = "页大小") int limit,
                                 @CjOpenportParameter(name = "offset", usage = "页偏移") long offset) throws CircuitException;

    @CjOpenport(usage = "应用管理员查看账户信息")
    AppAccount getAccount(ISecuritySession securitySession,
                          @CjOpenportParameter(name = "accountCode", usage = "为登录名") String accountCode) throws CircuitException;

    @CjOpenport(usage = "应用管理员添加应用角色")
    String addRole(ISecuritySession securitySession,
                   @CjOpenportParameter(name = "roleCode", usage = "角色编号") String roleCode,
                   @CjOpenportParameter(name = "roleName", usage = "角色名") String roleName,
                   @CjOpenportParameter(name = "extendTenantRole", usage = "从租户扩展的角色") String extendTenantRole) throws CircuitException;

    @CjOpenport(usage = "应用管理员移除应用角色")
    void removeRole(ISecuritySession securitySession,
                    @CjOpenportParameter(name = "roleid", usage = "角色标识") String roleid) throws CircuitException;

    @CjOpenport(usage = "应用管理员获取应用角色")
    AppRole getRole(ISecuritySession securitySession,
                    @CjOpenportParameter(name = "roleid", usage = "角色标识") String roleid) throws CircuitException;

    @CjOpenport(usage = "应用管理员获取应用角色列表", elementType = AppRole.class)
    List<AppRole> listRole(ISecuritySession securitySession) throws CircuitException;

    @CjOpenport(usage = "应用管理员授予角色给指定的应用公众")
    void grantRoleToPerson(ISecuritySession securitySession,
                           @CjOpenportParameter(name = "roleid", usage = "角色标识") String roleid,
                           @CjOpenportParameter(name = "accountid", usage = "账号标识即accountid") String accountid) throws CircuitException;

    @CjOpenport(usage = "应用管理员取消角色给指定的应用公众")
    void ungrantRoleToPerson(ISecuritySession securitySession,
                             @CjOpenportParameter(name = "roleid", usage = "角色标识") String roleid,
                             @CjOpenportParameter(name = "accountid", usage = "账号标识即accountid") String accountid) throws CircuitException;

    @CjOpenport(usage = "应用管理员获取指定账户的应用角色列表", elementType = AppRole.class)
    List<AppRole> getRoleOfAccount(ISecuritySession securitySession,
                                   @CjOpenportParameter(name = "accountid", usage = "账号标识即accountid") String accountid) throws CircuitException;

    @CjOpenport(usage = "应用管理员获取指定角色的应用账户列表", elementType = PersonInfo.class)
    List<AppAccount> getAccountInRole(ISecuritySession securitySession,
                                      @CjOpenportParameter(name = "roleid", usage = "角色标识") String roleid) throws CircuitException;

    @CjOpenport(usage = "获取当前租户信息")
    UcTenant getTenant(ISecuritySession securitySession) throws CircuitException;
}
