package cj.netos.uc.port;

import cj.netos.uc.domain.IdentityInfo;
import cj.netos.uc.service.IAuthService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.TokenInfo;
import io.jsonwebtoken.Claims;

import java.util.Map;

@CjService(name = "/auth")
public class AuthPorts implements IAuthPort {
    @CjServiceRef(refByName = "ucplugin.authService")
    IAuthService authService;

    @Override
    public IdentityInfo auth(String appid, String accountName, String password) throws CircuitException {
        return authService.auth(appid, accountName, password);
    }

    @Override
    public Map<String, Object> verification(String appid, String token) throws CircuitException {
        return authService.verification(appid, token);
    }
}
