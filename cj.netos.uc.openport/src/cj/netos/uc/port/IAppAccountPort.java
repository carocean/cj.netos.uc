package cj.netos.uc.port;

import cj.netos.uc.domain.AppAccount;
import cj.netos.uc.domain.UcUser;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.InRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "账户")
public interface IAppAccountPort extends IOpenportService {
    @CjOpenport(usage = "添加账户", command = "post", acl = {"allow administrators.role", "allow tests.role", "allow developer.role","invisible *.*"})
    String addAccount(@CjOpenportParameter(name = "accountName", usage = "账号名") String accountName,
                      @CjOpenportParameter(name = "nameKind", usage = "账号名类型：0是账号密码；1是手机号；2是邮箱；") byte nameKind,
                      @CjOpenportParameter(name = "userId", usage = "用户标识") String userId,
                      @CjOpenportParameter(name = "appId", usage = "应用标识") String appId,
                      @CjOpenportParameter(name = "accountPwd", usage = "账号密码") String accountPwd) throws CircuitException;
    @CjOpenport(usage = "为指定用户添加登录账户", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void addByPassword(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid, @CjOpenportParameter(name = "appid", usage = "租户标识") String appid, @CjOpenportParameter(name = "accountName", usage = "账号名") String accountName, @CjOpenportParameter(name = "password", usage = "密码") String password) throws CircuitException;

    @CjOpenport(usage = "为指定用户添加手机账户", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void addByIphone(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid, @CjOpenportParameter(name = "appid", usage = "租户标识") String appid, @CjOpenportParameter(name = "phone", usage = "电话号码") String phone, @CjOpenportParameter(name = "password", usage = "密码") String password) throws CircuitException;

    @CjOpenport(usage = "为指定用户添加邮箱账户", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void addByEmail(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid, @CjOpenportParameter(name = "appid", usage = "租户标识") String appid, @CjOpenportParameter(name = "email", usage = "电话号码") String email, @CjOpenportParameter(name = "password", usage = "密码") String password) throws CircuitException;

    @CjOpenport(usage = "获取统一用户", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    UcUser getUser(@CjOpenportParameter(name = "appid", usage = "应用标识") String appid, @CjOpenportParameter(name = "accountName", usage = "帐号名") String accountName) throws CircuitException;

    @CjOpenport(usage = "移除账户", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void removeAccountById(@CjOpenportParameter(usage = "账户标识", name = "accountid") String accountid) throws CircuitException;

    @CjOpenport(usage = "分页租户下的账户", elementType = AppAccount.class, acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<AppAccount> pageAccount(@CjOpenportParameter(usage = "租户标识", name = "appid") String appid, @CjOpenportParameter(usage = "当前页", name = "currPage") int currPage, @CjOpenportParameter(usage = "页大小", name = "pageSize") int pageSize) throws CircuitException;

    @CjOpenport(usage = "列出用户的所有账户", elementType = AppAccount.class, acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<AppAccount> listAccount(@CjOpenportParameter(usage = "用户标识", name = "uid") String uid) throws CircuitException;

    @CjOpenport(usage = "获取账户", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    AppAccount getAccount(@CjOpenportParameter(usage = "账户标识", name = "accountid") String accountid) throws CircuitException;

    @CjOpenport(usage = "使活账户", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void setAccountEnable(@CjOpenportParameter(usage = "账户标识", name = "accountid") String accountid, @CjOpenportParameter(usage = "true是使活，false是停用账户", name = "enable") boolean enable) throws CircuitException;
    @CjOpenport(usage = "移除账户", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void removeAccountByName(@CjOpenportParameter(name = "accountName", usage = "账号名") String accountName,
                       @CjOpenportParameter(name = "appid", usage = "应用标识") String appid);
}
