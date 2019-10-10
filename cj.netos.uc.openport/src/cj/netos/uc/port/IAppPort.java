package cj.netos.uc.port;

import cj.netos.uc.model.TenantApp;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "app")
public interface IAppPort extends IOpenportService {
    @CjOpenport(command = "post", usage = "app", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    String addApp(@CjOpenportParameter(name = "appid", usage = "应用标识") String appid,
                  @CjOpenportParameter(name = "appName", usage = "应用名") String appName,
                  @CjOpenportParameter(name = "tenantId", usage = "租户编号") String tenantId,
                  @CjOpenportParameter(name = "tokenExpire", usage = "令牌过期时间间隔") long tokenExpire,
                  @CjOpenportParameter(name = "appLogo", usage = "应用logo") String appLogo,
                  @CjOpenportParameter(name = "callbackUrl", usage = "登录验证回调地址") String callbackUrl,
                  @CjOpenportParameter(name = "logoutUrl", usage = "登录地址") String logoutUrl,
                  @CjOpenportParameter(name = "homeUrl", usage = "主页地址，验证成功跳转目标地址") String homeUrl) throws CircuitException;

    @CjOpenport(usage = "移除app", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void removeApp(@CjOpenportParameter(name = "appid", usage = "应用标识") String appid) throws CircuitException;

    @CjOpenport(usage = "获取app", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    TenantApp getApp(@CjOpenportParameter(name = "appid", usage = "应用标识") String appid) throws CircuitException;

    @CjOpenport(usage = "分页app", elementType = TenantApp.class, acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<TenantApp> pageApp(@CjOpenportParameter(name = "tenantid", usage = "租户标识") String tenantid, @CjOpenportParameter(name = "currPage", usage = "当前页") int currPage, @CjOpenportParameter(name = "pageSize", usage = "页大小") int pageSize) throws CircuitException;


}
