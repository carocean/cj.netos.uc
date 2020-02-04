package cj.netos.uc.service;

import cj.netos.uc.model.PersonInfo;
import cj.studio.ecm.net.CircuitException;

import java.util.Map;

public interface IAuthService {
    PersonInfo auth(String appid, String accountName, String password) throws CircuitException;

    Map<String,Object> verification(String appid, String token) throws CircuitException;
}
