package cj.netos.uc.service;

import cj.netos.uc.domain.IdentityInfo;
import cj.studio.ecm.net.CircuitException;

public interface IAuthService {
    IdentityInfo auth( String appid, String accountName, String password) throws CircuitException;
}
