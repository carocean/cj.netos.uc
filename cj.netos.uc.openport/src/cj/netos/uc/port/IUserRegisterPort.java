package cj.netos.uc.port;

import cj.netos.uc.model.UcUser;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.InRequest;
import cj.studio.openport.TokenIn;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

@CjOpenports(usage = "用户注册")
public interface IUserRegisterPort extends IOpenportService {

    @CjOpenport(usage = "通过账户密码注册", tokenIn = TokenIn.nope,command = "post")
    UcUser registerByPassword(@CjOpenportParameter(name = "appid", usage = "应用标识") String appid, @CjOpenportParameter(name = "accountName", usage = "帐号名") String accountName, @CjOpenportParameter(name = "password", usage = "密码") String password, @CjOpenportParameter(name = "nickName", usage = "昵称") String nickName, @CjOpenportParameter(name = "avatar", usage = "头像") String avatar, @CjOpenportParameter(name = "signature", usage = "个人签名", in = InRequest.content) String signature) throws CircuitException;

    @CjOpenport(usage = "通过电话号码注册", tokenIn = TokenIn.nope,command = "post")
    UcUser registerByIphone(@CjOpenportParameter(name = "appid", usage = "应用标识") String appid, @CjOpenportParameter(name = "phone", usage = "电话号码") String phone, @CjOpenportParameter(name = "password", usage = "密码") String password, @CjOpenportParameter(name = "nickName", usage = "昵称") String nickName, @CjOpenportParameter(name = "avatar", usage = "头像") String avatar, @CjOpenportParameter(name = "signature", usage = "个人签名", in = InRequest.content) String signature) throws CircuitException;

    @CjOpenport(usage = "通过邮箱注册", tokenIn = TokenIn.nope,command = "post")
    UcUser registerByEmail(@CjOpenportParameter(name = "appid", usage = "应用标识") String appid, @CjOpenportParameter(name = "email", usage = "电话号码") String email, @CjOpenportParameter(name = "password", usage = "密码") String password, @CjOpenportParameter(name = "nickName", usage = "昵称") String nickName, @CjOpenportParameter(name = "avatar", usage = "头像") String avatar, @CjOpenportParameter(name = "signature", usage = "个人签名", in = InRequest.content) String signature) throws CircuitException;

}
