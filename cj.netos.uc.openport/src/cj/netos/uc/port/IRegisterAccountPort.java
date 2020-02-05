package cj.netos.uc.port;

import cj.netos.uc.model.UcUser;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.AccessTokenIn;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.PKeyInRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportAppSecurity;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

@CjOpenports(usage = "账号注册服务")
public interface IRegisterAccountPort extends IOpenportService {

    @CjOpenportAppSecurity(usage = "sign生成方法：md5(appKey+nonce+appSecret).toHexString();注：顺序不能变")
    @CjOpenport(usage = "通过账户密码注册", tokenIn = AccessTokenIn.nope, command = "post")
    UcUser registerByPassword(ISecuritySession securitySession,
                              @CjOpenportParameter(name = "accountCode", usage = "帐号名") String accountCode,
                              @CjOpenportParameter(name = "password", usage = "密码") String password,
                              @CjOpenportParameter(name = "nickName", usage = "昵称") String nickName,
                              @CjOpenportParameter(name = "avatar", usage = "头像") String avatar,
                              @CjOpenportParameter(name = "signature", usage = "个人签名", in = PKeyInRequest.content) String signature) throws CircuitException;

    @CjOpenportAppSecurity(usage = "sign生成方法：md5(appKey+nonce+appSecret).toHexString();注：顺序不能变")
    @CjOpenport(usage = "通过电话号码注册", tokenIn = AccessTokenIn.nope, command = "post")
    UcUser registerByIphone(ISecuritySession securitySession,
                            @CjOpenportParameter(name = "phone", usage = "电话号码") String phone,
                            @CjOpenportParameter(name = "password", usage = "密码") String password,
                            @CjOpenportParameter(name = "nickName", usage = "昵称") String nickName,
                            @CjOpenportParameter(name = "avatar", usage = "头像") String avatar,
                            @CjOpenportParameter(name = "signature", usage = "个人签名", in = PKeyInRequest.content) String signature) throws CircuitException;

    @CjOpenportAppSecurity(usage = "sign生成方法：md5(appKey+nonce+appSecret).toHexString();注：顺序不能变")
    @CjOpenport(usage = "通过邮箱注册", tokenIn = AccessTokenIn.nope, command = "post")
    UcUser registerByEmail(ISecuritySession securitySession,
                           @CjOpenportParameter(name = "email", usage = "电话号码") String email,
                           @CjOpenportParameter(name = "password", usage = "密码") String password,
                           @CjOpenportParameter(name = "nickName", usage = "昵称") String nickName,
                           @CjOpenportParameter(name = "avatar", usage = "头像") String avatar,
                           @CjOpenportParameter(name = "signature", usage = "个人签名", in = PKeyInRequest.content) String signature) throws CircuitException;
}
