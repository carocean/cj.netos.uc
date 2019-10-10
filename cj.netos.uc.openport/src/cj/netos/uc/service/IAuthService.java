package cj.netos.uc.service;

import cj.netos.uc.domain.IdentityInfo;
import cj.studio.ecm.net.CircuitException;

import java.util.Map;

public interface IAuthService {
    IdentityInfo auth(String appid, String accountName, String password) throws CircuitException;

    Map<String,Object> verification(String appid, String token) throws CircuitException;
}
