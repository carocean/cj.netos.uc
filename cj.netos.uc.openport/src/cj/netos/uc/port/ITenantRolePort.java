package cj.netos.uc.port;

import cj.netos.uc.domain.TenantRole;
import cj.netos.uc.domain.UcUser;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.InRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "租户角色")
public interface ITenantRolePort extends IOpenportService {
    @CjOpenport(command = "post", usage = "添加租户角色", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    String addRole(@CjOpenportParameter(name = "role", in = InRequest.content, usage = "角色") TenantRole role) throws CircuitException;

    @CjOpenport(usage = "移除租户角色", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void removeRole(@CjOpenportParameter(usage = "角色标识", name = "roleid") String roleid) throws CircuitException;

    @CjOpenport(usage = "获取租户角色", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    TenantRole getRole(@CjOpenportParameter(usage = "角色标识", name = "roleid") String roleid) throws CircuitException;

    @CjOpenport(usage = "分页租户角色", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<TenantRole> pageRole(@CjOpenportParameter(usage = "租户标识", name = "tenantid") String tenantid, @CjOpenportParameter(usage = "当前页", name = "currPage") int currPage, @CjOpenportParameter(usage = "页大小", name = "pageSize") int pageSize) throws CircuitException;

    @CjOpenport(usage = "列出用户的角色", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<TenantRole> pageRoleOfUser(@CjOpenportParameter(usage = "用户标识", name = "uid") String uid,@CjOpenportParameter(usage = "当前页", name = "currPage") int currPage, @CjOpenportParameter(usage = "页大小", name = "pageSize") int pageSize) throws CircuitException;

    @CjOpenport(usage = "分页租户角色下的用户", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<UcUser> pageUserInRole(@CjOpenportParameter(usage = "角色标识", name = "roleid") String roleid, @CjOpenportParameter(usage = "当前页", name = "currPage") int currPage, @CjOpenportParameter(usage = "页大小", name = "pageSize") int pageSize) throws CircuitException;

    @CjOpenport(usage = "添加用户到租户角色", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void addUserToRole(@CjOpenportParameter(usage = "用户标识", name = "uid") String uid, @CjOpenportParameter(usage = "角色标识", name = "roleid") String roleid) throws CircuitException;

    @CjOpenport(usage = "移除用户从租户角色", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void removeUserFromRole(@CjOpenportParameter(usage = "用户标识", name = "uid") String uid, @CjOpenportParameter(usage = "角色标识", name = "roleid") String roleid) throws CircuitException;
}
