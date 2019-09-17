package cj.netos.uc.port;

import cj.netos.uc.domain.AppRole;
import cj.netos.uc.domain.TenantApp;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.InRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "app")
public interface IAppPort extends IOpenportService {
    @CjOpenport(command = "post", usage = "app")
    String addApp(@CjOpenportParameter(in = InRequest.content, usage = "app", name = "app") TenantApp app) throws CircuitException;

    @CjOpenport(usage = "移除app")
    void removeApp(String appid) throws CircuitException;

    @CjOpenport(usage = "获取app")
    TenantApp getApp(String appid) throws CircuitException;

    @CjOpenport(usage = "分页app的角色")
    List<AppRole> pageRoleOfApp(String appid, int currPage, int pageSize) throws CircuitException;

    @CjOpenport(usage = "添加角色到app")
    void addRoleToApp(String roleid, String appid) throws CircuitException;

    @CjOpenport(usage = "移除角色从app")
    void removeRoleFromApp(String roleid, String appid) throws CircuitException;

    @CjOpenport(usage = "清空app的角色")
    void emptyRoleOfApp(String appid) throws CircuitException;
}
