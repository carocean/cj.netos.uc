package cj.netos.uc.service;

import cj.netos.uc.model.AppRole;
import cj.netos.uc.model.UcUser;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IAppRoleService {
    String addRole(String roleId,String extend,String appId,String roleName ) throws CircuitException;

    void removeRole(String appId,String roleid) throws CircuitException;

    AppRole getRole(String appId,String roleid) throws CircuitException;

    List<AppRole> pageRole(String appid, int currPage, int pageSize) throws CircuitException;

    List<UcUser> pageUserInRole(String appId,String roleid, int currPage, int pageSize) throws CircuitException;

    List<AppRole> pageRoleOfUser(String uid, String appId,int currPage, int pageSize) throws CircuitException;

    void addUserToRole(String uid, String appId,String roleid) throws CircuitException;

    void removeUserFromRole(String uid, String appId,String roleid) throws CircuitException;
}
