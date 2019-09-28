package cj.netos.uc.service;

import cj.netos.uc.domain.IdentityInfo;
import cj.studio.ecm.net.CircuitException;
import io.jsonwebtoken.Claims;

public interface IAuthService {
    IdentityInfo auth(String appid, String accountName, String password) throws CircuitException;

    Claims verification(String appid, String token) throws CircuitException;
}
