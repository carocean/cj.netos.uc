package cj.netos.uc.port;

import cj.netos.uc.model.UcTenant;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "租户")
public interface ITenantPort extends IOpenportService {
    @CjOpenport(usage = "添加租户", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    String addTenant(@CjOpenportParameter(usage = "租户标识,如果为空则自动编号", name = "tenantid") String tenantid,
                     @CjOpenportParameter(usage = "租户名", name = "name") String name, @CjOpenportParameter(usage = "租户官方网站", name = "website") String website, @CjOpenportParameter(usage = "租户创建者", name = "creator") String creator) throws CircuitException;

    @CjOpenport(usage = "移除租户", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void removeTenant(@CjOpenportParameter(usage = "租户标识", name = "tenantid") String tenantid) throws CircuitException;

    @CjOpenport(usage = "分页租户", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<UcTenant> pageTenant(@CjOpenportParameter(usage = "当前页", name = "currPage") int currPage, @CjOpenportParameter(usage = "页大小", name = "pageSize") int pageSize) throws CircuitException;

    @CjOpenport(usage = "获取租户", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    UcTenant getTenantById(@CjOpenportParameter(usage = "租户标识", name = "tenantid") String tenantid) throws CircuitException;

    @CjOpenport(usage = "获取租户", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<UcTenant> getTenantsByUser(@CjOpenportParameter(usage = "用户标识", name = "uid") String uid) throws CircuitException;
}
