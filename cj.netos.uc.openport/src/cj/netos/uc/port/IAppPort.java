package cj.netos.uc.port;

import cj.netos.uc.model.TenantApp;
import cj.studio.ecm.net.Circuit;
import cj.studio.ecm.net.CircuitException;
import cj.studio.ecm.net.Frame;
import cj.studio.openport.*;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "app")
public interface IAppPort extends IOpenportService {
    @CjOpenport(command = "post", usage = "app", acl = {"allow administrators.role", "allow tests.role", "allow developers.role"})
    String addApp(@CjOpenportParameter(name = "appid", usage = "应用标识") String appid,
                  @CjOpenportParameter(name = "appName", usage = "应用名") String appName,
                  @CjOpenportParameter(name = "tenantId", usage = "租户编号") String tenantId,
                  @CjOpenportParameter(name = "tokenExpire", usage = "令牌过期时间间隔") long tokenExpire,
                  @CjOpenportParameter(name = "appLogo", usage = "应用logo") String appLogo,
                  @CjOpenportParameter(name = "website", usage = "应用的网站地址") String website,
                  @CjOpenportParameter(name = "loginCBUrl", usage = "登录相对website的回调地址。验证成功后uc通过回调应用的应用地址发出通知") String callbackUrl,
                  @CjOpenportParameter(name = "logoutCBUrl", usage = "注销相对website的回调地址，注销成功后uc回调应用发出注销通知的应用地址") String logoutUrl
    ) throws CircuitException;

    @CjOpenport(usage = "移除app", acl = {"allow administrators.role", "allow tests.role", "allow developers.role"})
    void removeApp(@CjOpenportParameter(name = "appid", usage = "应用标识") String appid) throws CircuitException;

    @CjOpenport(usage = "获取app", acl = {"allow administrators.role", "allow tests.role", "allow developers.role", "allow tenantDevelops.role"},beforeInvoker = BeforeUpdateWebsite.class)
    TenantApp getApp(@CjOpenportParameter(name = "appid", usage = "应用标识") String appid) throws CircuitException;

    @CjOpenport(usage = "分页app", elementType = TenantApp.class, acl = {"allow administrators.role", "allow tests.role", "allow developers.role"})
    List<TenantApp> pageApp(@CjOpenportParameter(name = "tenantid", usage = "租户标识") String tenantid, @CjOpenportParameter(name = "currPage", usage = "当前页") int currPage, @CjOpenportParameter(name = "pageSize", usage = "页大小") int pageSize) throws CircuitException;


    @CjOpenport(usage = "更新网站地址", acl = {"allow administrators.role", "allow tests.role", "allow developers.role", "allow tenantDevelops.role"},beforeInvoker =BeforeUpdateWebsite.class )
    void updateWebsite(@CjOpenportParameter(name = "appid", usage = "应用标识") String appid,
                       @CjOpenportParameter(name = "website", usage = "应用的网站地址") String website,
                       @CjOpenportParameter(name = "loginCBUrl", usage = "登录相对website的回调地址。验证成功后uc通过回调应用的应用地址发出通知") String loginCBUrl,
                       @CjOpenportParameter(name = "logoutCBUrl", usage = "注销相对website的回调地址，注销成功后uc回调应用发出注销通知的应用地址") String logoutCBUrl) throws CircuitException;

    @CjOpenport(usage = "重命名应用", acl = {"allow administrators.role", "allow tests.role", "allow developers.role"})
    void renameAppName(@CjOpenportParameter(name = "appid", usage = "应用标识") String appid,
                       @CjOpenportParameter(name = "newAppName", usage = "新应用名") String newAppName) throws CircuitException;

    @CjOpenport(usage = "为应用开发者颁发开发者令牌",tokenIn = TokenIn.nope)
    String issueDevelopToken(@CjOpenportParameter(name = "appid", usage = "应用标识") String appid,
                             @CjOpenportParameter(name = "accountName", usage = "账户名，或统一用户名。可以是手机号、邮箱等") String accountName,
                             @CjOpenportParameter(name = "password", usage = "密码") String password) throws CircuitException;

    @CjOpenport(usage = "升级账号使之成为应用的开发者", acl = {"allow administrators.role", "allow tests.role", "allow developers.role"})
    void upgradeBecomeDeveloper(@CjOpenportParameter(name = "appid", usage = "应用标识") String appid,
                                @CjOpenportParameter(name = "accountName", usage = "账户名，或统一用户名。可以是手机号、邮箱等") String accountName)throws CircuitException;

    class BeforeUpdateWebsite implements IOpenportBeforeInvoker {
        @Override
        public void doBefore(String methodName, CjOpenport openport, TokenInfo tokenInfo, Frame frame, Circuit circuit) throws CircuitException{
            String appid=frame.parameter("appid");
            String appidInToken=(String)tokenInfo.getProps().get("appid");
            if(!appidInToken.equals(appid)){
                throw new CircuitException("801",String.format("不是应用:%s的令牌，拒绝执行该方法:%s",appid,methodName));
            }
        }
    }

}
