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
    @CjOpenport(usage = "添加角色", command = "post")
    String addRole(AppRole role) throws CircuitException;

    @CjOpenport(usage = "移除角色")
    void removeRole(@CjOpenportParameter(usage = "角色标识", name = "roleid") String roleid) throws CircuitException;

    @CjOpenport(usage = "获取角色")
    AppRole getRole(@CjOpenportParameter(usage = "角色标识", name = "roleid") String roleid) throws CircuitException;

    @CjOpenport(usage = "分页角色", elementType = AppRole.class)
    List<AppRole> pageRole(@CjOpenportParameter(usage = "应用标识", name = "appid") String appid,@CjOpenportParameter(usage = "当前页", name = "currPage") int currPage, @CjOpenportParameter(usage = "页大小", name = "pageSize") int pageSize) throws CircuitException;

    @CjOpenport(usage = "移除角色", elementType = UcUser.class)
    List<UcUser> pageUserInRole(@CjOpenportParameter(usage = "角色标识", name = "roleid") String roleid, int currPage, int pageSize) throws CircuitException;

    @CjOpenport(usage = "移除角色")
    void addUserToRole(@CjOpenportParameter(usage = "用户标识", name = "uid") String uid, @CjOpenportParameter(usage = "角色标识", name = "roleid") String roleid) throws CircuitException;

    @CjOpenport(usage = "移除角色")
    void removeUserFromRole(@CjOpenportParameter(usage = "用户标识", name = "uid") String uid, @CjOpenportParameter(usage = "角色标识", name = "roleid") String roleid) throws CircuitException;
}
