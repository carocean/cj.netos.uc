package cj.netos.uc.port;

import cj.netos.uc.domain.IdentityInfo;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.TokenIn;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

@CjOpenports(usage = "认证")
public interface IAuthPort extends IOpenportService {
    @CjOpenport(usage = "认证",tokenIn = TokenIn.nope)
    IdentityInfo auth(@CjOpenportParameter(usage = "应用标识", name = "appid") String appid, @CjOpenportParameter(usage = "账户名", name = "accountName") String accountName, @CjOpenportParameter(usage = "密码", name = "password") String password) throws CircuitException;
}
