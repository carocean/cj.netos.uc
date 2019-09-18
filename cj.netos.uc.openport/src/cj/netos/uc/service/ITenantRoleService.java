package cj.netos.uc.service;

import cj.netos.uc.domain.TenantRole;
import cj.netos.uc.domain.UcUser;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface ITenantRoleService {
    String addRole(TenantRole role) throws CircuitException;

    void removeRole(String roleid) throws CircuitException;

    TenantRole getRole(String roleid) throws CircuitException;

    List<TenantRole> pageRole(String tenantid, int currPage, int pageSize) throws CircuitException;

    List<UcUser> pageUserInRole(String roleid, int currPage, int pageSize) throws CircuitException;

    List<TenantRole> listRoleOfUser(String uid) throws CircuitException;

    void addUserToRole(String uid, String roleid) throws CircuitException;

    void removeUserFromRole(String uid, String roleid) throws CircuitException;

}
