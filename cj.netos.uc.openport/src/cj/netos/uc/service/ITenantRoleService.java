package cj.netos.uc.service;

import cj.netos.uc.model.TenantRole;
import cj.netos.uc.model.UcUser;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface ITenantRoleService {
    String addRole(String roleCode,String extend,String tenantId,String roleName ,boolean isInheritable) throws CircuitException;

    void removeRole(String roleCode,String tenantid) throws CircuitException;

    TenantRole getRole(String roleCode,String tenantid) throws CircuitException;

    List<TenantRole> pageRole(String tenantid, int currPage, int pageSize) throws CircuitException;



    void addUserToRole(String uid, String roleCode,String tenantid) throws CircuitException;

    void removeUserFromRole(String uid, String roleCode,String tenantid) throws CircuitException;

    List<UcUser> pageUserInRole(String roleid, int currPage, int pageSize) throws CircuitException;

    List<TenantRole> pageRoleOfUser(String uid, String tenantid, int currPage, int pageSize);

}
