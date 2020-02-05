package cj.netos.uc.port;

import cj.netos.uc.model.AppInfo;
import cj.netos.uc.model.PersonInfo;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.PKeyInRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

/**
 * 除了该开放口，其它的开放口均是提供管理员的服务，本口是为访问者(accessToken)提供的自助服务
 */
@CjOpenports(usage = "公众自助服务")
public interface IPersonSelfServicePorts extends IOpenportService {
    @CjOpenport(usage = "修改密码")
    void updatePassword(ISecuritySession securitySession,
                        @CjOpenportParameter(usage = "旧密码", name = "oldpwd") String oldpwd,
                        @CjOpenportParameter(usage = "新密码", name = "newpwd") String newpwd) throws CircuitException;

    @CjOpenport(usage = "更新头像")
    void updatePersonAvatar(ISecuritySession securitySession,
                            @CjOpenportParameter(usage = "头像地址", name = "avatar") String avatar) throws CircuitException;

    @CjOpenport(usage = "更新个人签名")
    void updatePersonSignature(ISecuritySession securitySession,
                               @CjOpenportParameter(usage = "个人签名", name = "signature") String signature) throws CircuitException;

    @CjOpenport(usage = "更新昵称")
    void updatePersonNickName(ISecuritySession securitySession,
                              @CjOpenportParameter(usage = "昵称", name = "nickName") String nickName) throws CircuitException;

    @CjOpenport(usage = "获取公众信息")
    PersonInfo getPersonInfo(ISecuritySession securitySession) throws CircuitException;

    @CjOpenport(usage = "使用账号密码添加新登录账户", command = "post")
    void addByPassword(ISecuritySession securitySession,
                       @CjOpenportParameter(name = "accountCode", usage = "登录名") String accountCode,
                       @CjOpenportParameter(name = "password", usage = "密码") String password,
                       @CjOpenportParameter(name = "nickName", usage = "昵称") String nickName,
                       @CjOpenportParameter(name = "avatar", usage = "头像") String avatar,
                       @CjOpenportParameter(name = "signature", usage = "个人签名", in = PKeyInRequest.content) String signature) throws CircuitException;

    @CjOpenport(usage = "使用手机号添加新登录账户", command = "post")
    void addByIphone(ISecuritySession securitySession,
                     @CjOpenportParameter(name = "phone", usage = "手机号") String phone,
                     @CjOpenportParameter(name = "password", usage = "密码") String password,
                     @CjOpenportParameter(name = "nickName", usage = "昵称") String nickName,
                     @CjOpenportParameter(name = "avatar", usage = "头像") String avatar,
                     @CjOpenportParameter(name = "signature", usage = "个人签名", in = PKeyInRequest.content) String signature) throws CircuitException;

    @CjOpenport(usage = "使用邮箱添加新登录账户", command = "post")
    void addByEmail(ISecuritySession securitySession,
                    @CjOpenportParameter(name = "email", usage = "邮箱") String email,
                    @CjOpenportParameter(name = "password", usage = "密码") String password,
                    @CjOpenportParameter(name = "nickName", usage = "昵称") String nickName,
                    @CjOpenportParameter(name = "avatar", usage = "头像") String avatar,
                    @CjOpenportParameter(name = "signature", usage = "个人签名", in = PKeyInRequest.content) String signature) throws CircuitException;

    @CjOpenport(usage = "普通用户可以申请创建一个应用")
    void requestCreateApp(ISecuritySession securitySession,
                          @CjOpenportParameter(name = "appCode", usage = "应用编号，英文") String appCode,
                          @CjOpenportParameter(name = "appName", usage = "应用名，一般为中文") String appName,
                          @CjOpenportParameter(name = "tenantId", usage = "租户标识") String tenantId,
                          @CjOpenportParameter(name = "tokenExpire", usage = "应用访问令牌的过期时间间隔") long tokenExpire,
                          @CjOpenportParameter(name = "appLogo", usage = "应用logo") String appLogo,
                          @CjOpenportParameter(name = "website", usage = "应用站点地址，如果有") String website,
                          @CjOpenportParameter(name = "loginCBUrl", usage = "uc中心发现应用登录回调通知地址") String loginCBUrl,
                          @CjOpenportParameter(name = "logoutCBUrl", usage = "uc中心发现应用会话过期回调通知地址") String logoutCBUrl
    ) throws CircuitException;

    AppInfo getAppInfo(ISecuritySession securitySession) throws CircuitException;
}
