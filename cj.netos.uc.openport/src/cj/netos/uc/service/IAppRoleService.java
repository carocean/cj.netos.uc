package cj.netos.uc.service;

import cj.netos.uc.model.AppAccount;
import cj.netos.uc.model.AppRole;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IAppRoleService {
    String addRole(String rolecode, String extend, String appId, String roleName) throws CircuitException;

    void removeRole(String appId, String rolecode) throws CircuitException;

    AppRole getRole(String appId, String rolecode) throws CircuitException;


    List<AppRole> pageRoleOfAccount(String accountid, String appId, long offset, long limit) throws CircuitException;


    List<AppRole> pageRole(String appid, long currPage, long pageSize) throws CircuitException;

    List<AppAccount> pageAccountInRole(String appId, String roleid, long offset, long limit) throws CircuitException;

    void addAccountToRole(String appId, String accountid, String roleid, String tenantid, String uid) throws CircuitException;

    void removeAccountFromRole(String uid,  String roleid) throws CircuitException;

    void removeRoleBy(String roleid);

    AppRole getRoleBy(String roleid);

    void addRoleToAccount(String roleid, String accountid);

    void removeRoleFromAccount(String roleid, String accountid);

}
