package cj.netos.uc.service;

import cj.netos.uc.model.AppAccount;
import cj.netos.uc.model.AppRole;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IAppRoleService {
    String addRole(String rolecode, String extend, String appId, String roleName) throws CircuitException;

    void removeRole(String appId, String rolecode) throws CircuitException;

    AppRole getRole(String appId, String rolecode) throws CircuitException;

    List<AppRole> pageRole(String appid, int currPage, int pageSize) throws CircuitException;

    List<AppAccount> pageAccountInRole(String appId, String rolecode, int currPage, int pageSize) throws CircuitException;

    List<AppRole> pageRoleOfAccount(String accountid, String appId, int currPage, int pageSize) throws CircuitException;


    void addAccountToRole(String appId, String accountid, String rolecode, String tenantid, String uid) throws CircuitException;

    void removeAccountFromRole(String uid, String appId, String rolecode) throws CircuitException;
}
