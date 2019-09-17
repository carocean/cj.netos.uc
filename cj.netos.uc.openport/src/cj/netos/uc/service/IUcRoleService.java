package cj.netos.uc.service;

import cj.netos.uc.domain.UcRole;
import cj.netos.uc.domain.UcUser;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IUcRoleService {
    String addRole(String name, boolean isInheritable) throws CircuitException;

    void removeRole(String roleid) throws CircuitException;

    UcRole getRole(String roleid) throws CircuitException;

    List<UcRole> pageRole(int currPage, int pageSize) throws CircuitException;

    List<UcUser> pageUserInRole(String roleid, int currPage, int pageSize) throws CircuitException;

    void addUserToRole(String uid, String roleid) throws CircuitException;

    void removeUserFromRole(String uid, String roleid) throws CircuitException;
}
