package cj.netos.uc.port;

import cj.netos.uc.domain.TenantAccount;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.InRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "账户")
public interface ITenantAccountPort extends IOpenportService {
    @CjOpenport(usage = "添加账户", command = "post")
    String addAccount(@CjOpenportParameter(in = InRequest.content, name = "account", usage = "账户") TenantAccount account) throws CircuitException;

    @CjOpenport(usage = "移除账户")
    void removeAccount(@CjOpenportParameter(usage = "账户标识", name = "accountid") String accountid) throws CircuitException;

    @CjOpenport(usage = "分页租户下的账户")
    List<TenantAccount> pageAccount(@CjOpenportParameter(usage = "租户标识", name = "tenantid") String tenantid, @CjOpenportParameter(usage = "当前页", name = "currPage") int currPage, @CjOpenportParameter(usage = "页大小", name = "pageSize") int pageSize) throws CircuitException;

    @CjOpenport(usage = "列出用户的所有账户")
    List<TenantAccount> listAccount(@CjOpenportParameter(usage = "用户标识", name = "uid") String uid) throws CircuitException;

    @CjOpenport(usage = "获取账户")
    TenantAccount getAccount(@CjOpenportParameter(usage = "账户标识", name = "accountid") String accountid) throws CircuitException;

    @CjOpenport(usage = "使活账户")
    void setAccountEnable(@CjOpenportParameter(usage = "true是使活，false是停用账户", name = "enable") boolean enable) throws CircuitException;
}
