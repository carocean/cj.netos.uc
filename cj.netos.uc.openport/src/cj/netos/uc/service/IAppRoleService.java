package cj.netos.uc.service;

import cj.netos.uc.domain.AppRole;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IAppRoleService {
    String addRole(AppRole role) throws CircuitException;

    void removeRole(String roleid) throws CircuitException;

    AppRole getRole(String roleid) throws CircuitException;

    List<AppRole> pageRole(int currPage, int pageSize) throws CircuitException;

    List<AppRole> pageUserInRole(String roleid, int currPage, int pageSize) throws CircuitException;

    void addUserToRole(String uid, String roleid) throws CircuitException;

    void removeUserFromRole(String uid, String roleid) throws CircuitException;
}
