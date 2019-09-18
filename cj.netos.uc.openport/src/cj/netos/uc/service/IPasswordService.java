package cj.netos.uc.service;

import cj.studio.ecm.net.CircuitException;

public interface IPasswordService {
    void updatePassword(String tenantid, String accountName, String oldpwd, String newpwd) throws CircuitException;
}
