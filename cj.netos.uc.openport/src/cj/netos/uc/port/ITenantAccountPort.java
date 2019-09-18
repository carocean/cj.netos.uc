package cj.netos.uc.port;

import cj.netos.uc.domain.TenantAccount;
import cj.netos.uc.domain.UcUser;
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

    @CjOpenport(usage = "为指定用户添加手机账户")
    void addByIphone(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid, @CjOpenportParameter(name = "tenant", usage = "租户标识") String tenant, @CjOpenportParameter(name = "phone", usage = "电话号码") String phone, @CjOpenportParameter(name = "password", usage = "密码") String password) throws CircuitException;

    @CjOpenport(usage = "为指定用户添加邮箱账户")
    void addByEmail(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid, @CjOpenportParameter(name = "tenant", usage = "租户标识") String tenant, @CjOpenportParameter(name = "email", usage = "电话号码") String email, @CjOpenportParameter(name = "password", usage = "密码") String password) throws CircuitException;

    @CjOpenport(usage = "获取统一用户")
    UcUser getUser(@CjOpenportParameter(name = "tenant", usage = "租户标识") String tenant, @CjOpenportParameter(name = "accountName", usage = "帐号名") String accountName) throws CircuitException;

    @CjOpenport(usage = "移除账户")
    void removeAccount(@CjOpenportParameter(usage = "账户标识", name = "accountid") String accountid) throws CircuitException;

    @CjOpenport(usage = "分页租户下的账户")
    List<TenantAccount> pageAccount(@CjOpenportParameter(usage = "租户标识", name = "tenantid") String tenantid, @CjOpenportParameter(usage = "当前页", name = "currPage") int currPage, @CjOpenportParameter(usage = "页大小", name = "pageSize") int pageSize) throws CircuitException;

    @CjOpenport(usage = "列出用户的所有账户")
    List<TenantAccount> listAccount(@CjOpenportParameter(usage = "用户标识", name = "uid") String uid) throws CircuitException;

    @CjOpenport(usage = "获取账户")
    TenantAccount getAccount(@CjOpenportParameter(usage = "账户标识", name = "accountid") String accountid) throws CircuitException;

    @CjOpenport(usage = "使活账户")
    void setAccountEnable(@CjOpenportParameter(usage = "账户标识", name = "accountid")String accountid,@CjOpenportParameter(usage = "true是使活，false是停用账户", name = "enable") boolean enable) throws CircuitException;
}
