package cj.netos.uc.port;

import cj.netos.uc.domain.UcRole;
import cj.netos.uc.domain.UcUser;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "统一角色")
public interface IUcRolePort extends IOpenportService {
    @CjOpenport(usage = "添加角色", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    String addRole(@CjOpenportParameter(name = "roleid", usage = "角色编码") String roleid, @CjOpenportParameter(name = "roleName", usage = "角色名") String name, @CjOpenportParameter(name = "isInheritable", usage = "是否可被继承") boolean isInheritable) throws CircuitException;

    @CjOpenport(usage = "移除角色", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void removeRole(@CjOpenportParameter(name = "roleid", usage = "角色标识") String roleid) throws CircuitException;

    @CjOpenport(usage = "获取角色", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    UcRole getRole(@CjOpenportParameter(name = "roleid", usage = "角色标识") String roleid) throws CircuitException;

    @CjOpenport(usage = "分页角色", elementType = UcRole.class, acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<UcRole> pageRole(@CjOpenportParameter(name = "currPage", usage = "当前页号") int currPage, @CjOpenportParameter(name = "pageSize", usage = "页大小") int pageSize) throws CircuitException;

    @CjOpenport(usage = "分页角色的归属用户", elementType = UcUser.class, acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<UcUser> pageUserInRole(@CjOpenportParameter(name = "roleid", usage = "角色标识") String roleid, @CjOpenportParameter(name = "currPage", usage = "当前页号") int currPage, @CjOpenportParameter(name = "pageSize", usage = "页大小") int pageSize) throws CircuitException;

    @CjOpenport(usage = "列出一页用户的角色", elementType = UcRole.class, acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<UcRole> pageRoleInUser(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid, @CjOpenportParameter(name = "currPage", usage = "当前页号") int currPage, @CjOpenportParameter(name = "pageSize", usage = "页大小") int pageSize) throws CircuitException;

    @CjOpenport(usage = "添加角色到用户", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void addRoleToUser(@CjOpenportParameter(name = "roleid", usage = "角色标识") String roleid, @CjOpenportParameter(name = "uid", usage = "用户标识") String uid) throws CircuitException;

    @CjOpenport(usage = "移除角色从用户", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void removeRoleFromUser(@CjOpenportParameter(name = "roleid", usage = "角色标识") String roleid, @CjOpenportParameter(name = "uid", usage = "用户标识") String uid) throws CircuitException;

}
