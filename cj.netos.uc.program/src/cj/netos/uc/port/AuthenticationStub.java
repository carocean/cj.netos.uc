package cj.netos.uc.port;

import cj.netos.uc.service.AuthenticationException;
import cj.netos.uc.service.AuthenticatorInfo;
import cj.netos.uc.service.IAuthenticator;
import cj.netos.uc.service.IAuthenticatorFactory;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;

@CjService(name = "/authentication.service")
public class AuthenticationStub implements IAuthenticationStub {
    @CjServiceRef(refByName = "ucplugin.authenticatorFactory")
    IAuthenticatorFactory facotry;

    @Override
    public String[] enumAuthenticatorNames() {
        return facotry.enumNames();
    }

    @Override
    public String authenticate(String authName, String tenant, String principals, String password, long ttlMillis) throws AuthenticationException{
        return facotry.authenticate(authName, tenant, principals, password, ttlMillis);
    }

    @Override
    public AuthenticatorInfo getAuthenticatorInfo(String authName) {
        IAuthenticator auth = facotry.get(authName);
        if (auth == null) {
            return null;
        }

        return auth.getInfo();
    }

}
