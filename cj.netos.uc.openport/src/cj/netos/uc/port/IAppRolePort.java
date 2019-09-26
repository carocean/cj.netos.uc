package cj.netos.uc.port;

import cj.netos.uc.domain.AppRole;
import cj.netos.uc.domain.UcUser;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "app的角色")
public interface IAppRolePort extends IOpenportService {
    @CjOpenport(usage = "添加角色", command = "post", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    String addRole(@CjOpenportParameter(usage = "角色标识", name = "roleid") String roleId, @CjOpenportParameter(usage = "要继承的租户角色编号", name = "extend") String extend, @CjOpenportParameter(usage = "应用标识", name = "appId") String appId, @CjOpenportParameter(usage = "角色名", name = "roleName") String roleName) throws CircuitException;

    @CjOpenport(usage = "移除角色", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void removeRole(@CjOpenportParameter(usage = "角色标识", name = "roleid") String roleid) throws CircuitException;

    @CjOpenport(usage = "获取角色", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    AppRole getRole(@CjOpenportParameter(usage = "角色标识", name = "roleid") String roleid) throws CircuitException;

    @CjOpenport(usage = "分页角色", elementType = AppRole.class, acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<AppRole> pageRole(@CjOpenportParameter(usage = "应用标识", name = "appid") String appid, @CjOpenportParameter(usage = "当前页", name = "currPage") int currPage, @CjOpenportParameter(usage = "页大小", name = "pageSize") int pageSize) throws CircuitException;

    @CjOpenport(usage = "分页角色包含的用户", elementType = UcUser.class, acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<UcUser> pageUserInRole(@CjOpenportParameter(usage = "角色标识", name = "roleid") String roleid, @CjOpenportParameter(usage = "当前页", name = "currPage") int currPage, @CjOpenportParameter(usage = "页大小", name = "pageSize") int pageSize) throws CircuitException;

    @CjOpenport(usage = "分页用户拥有的角色", elementType = UcUser.class, acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<AppRole> pageRoleOfUser(@CjOpenportParameter(usage = "用户标识", name = "uid") String uid, @CjOpenportParameter(usage = "当前页", name = "currPage") int currPage, @CjOpenportParameter(usage = "页大小", name = "pageSize") int pageSize) throws CircuitException;

    @CjOpenport(usage = "移除角色", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void addUserToRole(@CjOpenportParameter(usage = "用户标识", name = "uid") String uid, @CjOpenportParameter(usage = "角色标识", name = "roleid") String roleid) throws CircuitException;

    @CjOpenport(usage = "移除角色", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void removeUserFromRole(@CjOpenportParameter(usage = "用户标识", name = "uid") String uid, @CjOpenportParameter(usage = "角色标识", name = "roleid") String roleid) throws CircuitException;
}
