package cj.netos.uc.port;

import cj.netos.uc.domain.IdentityInfo;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

@CjOpenports(usage = "认证")
public interface IAuthPort extends IOpenportService {
    @CjOpenport(usage = "认证")
    IdentityInfo auth(@CjOpenportParameter(usage = "租户标识", name = "tenantid") String tenantid, @CjOpenportParameter(usage = "账户名", name = "accountName") String accountName, @CjOpenportParameter(usage = "密码", name = "password") String password) throws CircuitException;
}
