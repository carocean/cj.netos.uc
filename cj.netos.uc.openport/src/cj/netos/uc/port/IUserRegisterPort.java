package cj.netos.uc.port;

import cj.netos.uc.domain.UcUser;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.TokenIn;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

@CjOpenports(usage = "用户注册")
public interface IUserRegisterPort extends IOpenportService {

    @CjOpenport(usage = "通过账户密码注册",tokenIn = TokenIn.nope)
    UcUser registerByPassword(@CjOpenportParameter(name = "tenant", usage = "租户标识") String tenant, @CjOpenportParameter(name = "accountName", usage = "帐号名") String accountName, @CjOpenportParameter(name = "password", usage = "密码") String password) throws CircuitException;

    @CjOpenport(usage = "通过电话号码注册",tokenIn = TokenIn.nope)
    UcUser registerByIphone(@CjOpenportParameter(name = "tenant", usage = "租户标识") String tenant, @CjOpenportParameter(name = "phone", usage = "电话号码") String phone, @CjOpenportParameter(name = "password", usage = "密码") String password) throws CircuitException;

    @CjOpenport(usage = "通过邮箱注册",tokenIn = TokenIn.nope)
    UcUser registerByEmail(@CjOpenportParameter(name = "tenant", usage = "租户标识") String tenant, @CjOpenportParameter(name = "email", usage = "电话号码") String email, @CjOpenportParameter(name = "password", usage = "密码") String password) throws CircuitException;

}
