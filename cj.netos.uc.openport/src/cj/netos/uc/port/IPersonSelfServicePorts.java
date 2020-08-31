package cj.netos.uc.port;

import cj.netos.uc.model.AppInfo;
import cj.netos.uc.model.DomainValue;
import cj.netos.uc.model.PersonInfo;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.AccessTokenIn;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.PKeyInRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportAppSecurity;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 除了该开放口，其它的开放口均是提供管理员的服务，本口是为访问者(accessToken)提供的自助服务
 */
@CjOpenports(usage = "公众自助服务")
public interface IPersonSelfServicePorts extends IOpenportService {
    @CjOpenport(usage = "修改密码")
    void updatePersonPassword(ISecuritySession securitySession,
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

    @CjOpenport(usage = "更新真实姓名")
    void updatePersonRealName(ISecuritySession securitySession,
                              @CjOpenportParameter(usage = "真实姓名", name = "realName") String realName) throws CircuitException;

    @CjOpenport(usage = "更新性别")
    void updatePersonSex(ISecuritySession securitySession,
                         @CjOpenportParameter(usage = "性别:男（male)；女(female)，空为未设置", name = "sex") String sex) throws CircuitException;

    @CjOpenport(usage = "获取访问者的信息")
    PersonInfo getPersonInfo(ISecuritySession securitySession) throws CircuitException;

    @CjOpenport(usage = "查看任何人的公开信息")
    PersonInfo findPerson(ISecuritySession securitySession,
                          @CjOpenportParameter(name = "person", usage = "公号") String person) throws CircuitException;

    @CjOpenportAppSecurity
    @CjOpenport(usage = "查看任何人的公开信息在安全模式下", tokenIn = AccessTokenIn.nope)
    PersonInfo findPersonOnSecurity(ISecuritySession securitySession,
                                    @CjOpenportParameter(name = "person", usage = "公号") String person) throws CircuitException;

    @CjOpenport(usage = "获取当前用户号下所有的账号")
    List<Map<String, Object>> listMyAccount(ISecuritySession securitySession,
                                            @CjOpenportParameter(usage = "如果appid为空则按令牌中的应用号获取", name = "appid") String appid) throws CircuitException;

    @CjOpenport(usage = "获取指定用户号下所有的账号")
    List<Map<String, Object>> listAccountOfPerson(ISecuritySession securitySession,
                                                  @CjOpenportParameter(usage = "公号", name = "person") String person,
                                                  @CjOpenportParameter(usage = "如果appid为空则按令牌中的应用号获取", name = "appid") String appid) throws CircuitException;

    @CjOpenport(usage = "删除当前访问者账号")
    void removePerson(ISecuritySession securitySession) throws CircuitException;

    @CjOpenport(usage = "使用账号密码添加新登录账户", command = "post")
    void addByPassword(ISecuritySession securitySession,
                       @CjOpenportParameter(name = "appid", usage = "应用号，可以为空，如果为空则采用访问者的应用号") String appid,
                       @CjOpenportParameter(name = "accountCode", usage = "登录名") String accountCode,
                       @CjOpenportParameter(name = "password", usage = "密码") String password,
                       @CjOpenportParameter(name = "nickName", usage = "昵称") String nickName,
                       @CjOpenportParameter(name = "avatar", usage = "头像") String avatar,
                       @CjOpenportParameter(name = "signature", usage = "个人签名", in = PKeyInRequest.content) String signature) throws CircuitException;

    @CjOpenport(usage = "使用手机号添加新登录账户", command = "post")
    void addByIphone(ISecuritySession securitySession,
                     @CjOpenportParameter(name = "appid", usage = "应用号，可以为空，如果为空则采用访问者的应用号") String appid,
                     @CjOpenportParameter(name = "phone", usage = "手机号") String phone,
                     @CjOpenportParameter(name = "password", usage = "密码") String password,
                     @CjOpenportParameter(name = "nickName", usage = "昵称") String nickName,
                     @CjOpenportParameter(name = "avatar", usage = "头像") String avatar,
                     @CjOpenportParameter(name = "signature", usage = "个人签名", in = PKeyInRequest.content) String signature) throws CircuitException;

    @CjOpenport(usage = "使用邮箱添加新登录账户", command = "post")
    void addByEmail(ISecuritySession securitySession,
                    @CjOpenportParameter(name = "appid", usage = "应用号，可以为空，如果为空则采用访问者的应用号") String appid,
                    @CjOpenportParameter(name = "email", usage = "邮箱") String email,
                    @CjOpenportParameter(name = "password", usage = "密码") String password,
                    @CjOpenportParameter(name = "nickName", usage = "昵称") String nickName,
                    @CjOpenportParameter(name = "avatar", usage = "头像") String avatar,
                    @CjOpenportParameter(name = "signature", usage = "个人签名", in = PKeyInRequest.content) String signature) throws CircuitException;

    @CjOpenport(usage = "列出访问者所在租户的应用信息", type = HashMap.class, elementType = AppInfo.class)
    List<AppInfo> listAppInfo(ISecuritySession securitySession,
                              @CjOpenportParameter(usage = "页号", name = "offset") long offset,
                              @CjOpenportParameter(usage = "页大小", name = "limit") int limit) throws CircuitException;

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

    @CjOpenport(usage = "列出访问者所属的应用信息")
    AppInfo getAppInfo(ISecuritySession securitySession) throws CircuitException;

    @CjOpenport(usage = "设置用户信息扩展域的值")
    void setDomainValue(ISecuritySession securitySession,
                        @CjOpenportParameter(name = "fieldId", usage = "字段编号") String fieldId,
                        @CjOpenportParameter(name = "content", usage = "字段内容") String content) throws CircuitException;

    @CjOpenport(usage = "获取用户信息扩展域的值")
    DomainValue getDomainValue(ISecuritySession securitySession,
                               @CjOpenportParameter(name = "fieldId", usage = "字段编号") String fieldId) throws CircuitException;

    @CjOpenport(usage = "清除用户信息扩展域的值")
    void emptyDomainValue(ISecuritySession securitySession,
                          @CjOpenportParameter(name = "fieldId", usage = "字段标识") String fieldId) throws CircuitException;

    @CjOpenport(usage = "列表用户信息扩展域的值")
    List<DomainValue> listDomainValueOfGroup(ISecuritySession securitySession,
                                             @CjOpenportParameter(name = "groupId", usage = "组标识") String groupId) throws CircuitException;

    @CjOpenport(usage = "列表用户信息扩展域的值")
    List<DomainValue> listDomainValueOfPerson(ISecuritySession securitySession,
                                              @CjOpenportParameter(name = "person", usage = "公号") String person,
                                             @CjOpenportParameter(name = "groupId", usage = "组标识") String groupId) throws CircuitException;

    @CjOpenport(usage = "列表用户信息扩展域的值")
    List<DomainValue> listAllDomainValue(ISecuritySession securitySession) throws CircuitException;

    @CjOpenport(usage = "按关键字搜索公众")
    List<PersonInfo> searchPersons(
            ISecuritySession securitySession,
            @CjOpenportParameter(name = "keywords", usage = "公号/统一号/手机号/邮箱等") String keywords
    ) throws CircuitException;


    @CjOpenport(usage = "按关键字搜索公众在当前app中搜")
    List<PersonInfo> searchPersonsInMyApp(
            ISecuritySession securitySession,
            @CjOpenportParameter(name = "keywords", usage = "公号/统一号/手机号/邮箱等") String keywords
    ) throws CircuitException;
}
