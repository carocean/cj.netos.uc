package cj.netos.uc.port;

import cj.netos.uc.domain.IdentityInfo;
import cj.netos.uc.service.IAuthService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

@CjService(name = "/auth")
public class AuthPorts implements IAuthPort {
    @CjServiceRef(refByName = "ucplugin.authService")
    IAuthService authService;

    @Override
    public IdentityInfo auth(String tenantid, String accountName, String password) throws CircuitException {
        return authService.auth(tenantid, accountName, password);
    }
}
