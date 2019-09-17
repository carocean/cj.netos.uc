package cj.netos.uc.port;

import cj.netos.uc.domain.TenantAccount;
import cj.netos.uc.domain.TenantApp;
import cj.netos.uc.domain.TenantRole;
import cj.netos.uc.domain.UcTenant;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "租户")
public interface ITenantPort extends IOpenportService {
    @CjOpenport(usage = "添加租户")
    String addTenant(@CjOpenportParameter(usage = "租户名", name = "name") String name, @CjOpenportParameter(usage = "租户官方网站", name = "website") String website, @CjOpenportParameter(usage = "租户创建者", name = "creator") String creator, @CjOpenportParameter(usage = "租户通用密钥，可以为空", name = "secret_key") String secret_key) throws CircuitException;

    @CjOpenport(usage = "移除租户")
    void removeTenant(@CjOpenportParameter(usage = "租户标识", name = "tenantid") String tenantid) throws CircuitException;

    @CjOpenport(usage = "分页租户")
    List<UcTenant> pageTenant(@CjOpenportParameter(usage = "当前页", name = "currPage") int currPage, @CjOpenportParameter(usage = "页大小", name = "pageSize") int pageSize) throws CircuitException;

    @CjOpenport(usage = "获取租户")
    UcTenant getTenantById(@CjOpenportParameter(usage = "租户标识", name = "tenantid") String tenantid) throws CircuitException;

    @CjOpenport(usage = "获取租户")
    List<UcTenant> getTenantsByUser(@CjOpenportParameter(usage = "用户标识", name = "uid") String uid) throws CircuitException;

    @CjOpenport(usage = "分页app")
    List<TenantApp> pageApp(@CjOpenportParameter(usage = "当前页", name = "currPage") int currPage, @CjOpenportParameter(usage = "页大小", name = "pageSize") int pageSize) throws CircuitException;

    @CjOpenport(usage = "分页角色")
    List<TenantRole> pageRole(@CjOpenportParameter(usage = "当前页", name = "currPage") int currPage, @CjOpenportParameter(usage = "页大小", name = "pageSize") int pageSize) throws CircuitException;

    @CjOpenport(usage = "分页账户")
    List<TenantAccount> pageAccount(@CjOpenportParameter(usage = "当前页", name = "currPage") int currPage, @CjOpenportParameter(usage = "页大小", name = "pageSize") int pageSize) throws CircuitException;

    @CjOpenport(usage = "添加app")
    void addApp(@CjOpenportParameter(usage = "租户标识", name = "tenantid") String tenantid, @CjOpenportParameter(usage = "应用标识", name = "appid") String appid) throws CircuitException;

    @CjOpenport(usage = "移除app")
    void removeApp(@CjOpenportParameter(usage = "租户标识", name = "tenantid") String tenantid, @CjOpenportParameter(usage = "应用标识", name = "appid") String appid) throws CircuitException;

    @CjOpenport(usage = "添加角色")
    void addRole(@CjOpenportParameter(usage = "租户标识", name = "tenantid") String tenantid, @CjOpenportParameter(usage = "角色标识", name = "roleid") String roleid) throws CircuitException;

    @CjOpenport(usage = "移除角色")
    void removeRole(@CjOpenportParameter(usage = "租户标识", name = "tenantid") String tenantid, @CjOpenportParameter(usage = "角色标识", name = "roleid") String roleid) throws CircuitException;
}
