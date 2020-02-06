package cj.netos.uc.port;

import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.AccessTokenIn;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportAppSecurity;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.HashMap;
import java.util.Map;

@CjOpenports(usage = "认证服务")
public interface IAuthPort extends IOpenportService {
    @CjOpenportAppSecurity(usage = "sign生成方法：md5(appKey+nonce+appSecret).toHexString();注：顺序不能变")
    @CjOpenport(usage = "认证,返回：{'accessToken':'xxx','refreshToken':'zzz',expireTime:'2222323'}。注：异常表：1002为非法令牌；1003为过期；", tokenIn = AccessTokenIn.nope)
    Map<String,Object> auth(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "设备号", name = "device") String device,
            @CjOpenportParameter(usage = "账户名，或统一用户名。可以是手机号、邮箱等", name = "accountCode") String accountCode,
            @CjOpenportParameter(usage = "密码", name = "password") String password) throws CircuitException;

    @CjOpenportAppSecurity(usage = "sign生成方法：md5(appKey+nonce+appSecret).toHexString();注：顺序不能变")
    @CjOpenport(usage = "根据refreshToken生成新的accessToken", tokenIn = AccessTokenIn.nope)
    Map<String, Object> refreshToken(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "刷新令牌", name = "refreshToken") String refreshToken) throws CircuitException;

    @CjOpenportAppSecurity(usage = "sign生成方法：md5(appKey+nonce+appSecret).toHexString();注：顺序不能变")
    @CjOpenport(usage = "验证", tokenIn = AccessTokenIn.nope, type = HashMap.class, elementType = {String.class, Object.class})
    Map<String, Object> verification(ISecuritySession securitySession,
                                     @CjOpenportParameter(usage = "令牌", name = "token") String token) throws CircuitException;
}
