package cj.netos.uc.service;

import cj.netos.uc.model.TenantRole;
import cj.netos.uc.model.UcUser;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface ITenantRoleService {
    String addRole(String roleid,String extend,String tenantId,String roleName ,boolean isInheritable) throws CircuitException;

    void removeRole(String roleid,String tenantid) throws CircuitException;

    TenantRole getRole(String roleid,String tenantid) throws CircuitException;

    List<TenantRole> pageRole(String tenantid, int currPage, int pageSize) throws CircuitException;

    List<UcUser> pageUserInRole(String roleid,String tenantid, int currPage, int pageSize) throws CircuitException;


    void addUserToRole(String uid, String roleid,String tenantid) throws CircuitException;

    void removeUserFromRole(String uid, String roleid,String tenantid) throws CircuitException;

    List<TenantRole> pageRoleOfUser(String uid,String tenantid, int currPage, int pageSize);

}
