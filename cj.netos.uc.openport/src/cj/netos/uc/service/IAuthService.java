package cj.netos.uc.service;

import cj.netos.uc.domain.IdentityInfo;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.TokenInfo;

public interface IAuthService {
    IdentityInfo auth(String appid, String accountName, String password) throws CircuitException;

    TokenInfo verification(String appid, String token) throws CircuitException;
}
