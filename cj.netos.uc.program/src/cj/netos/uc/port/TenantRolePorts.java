package cj.netos.uc.port;

import cj.netos.uc.model.TenantRole;
import cj.netos.uc.model.UcUser;
import cj.netos.uc.service.ITenantRoleService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

@CjService(name = "/tenant/role")
public class TenantRolePorts implements ITenantRolePort {
    @CjServiceRef(refByName = "ucplugin.tenantRoleService")
    ITenantRoleService tenantRoleService;

    @Override
    public String addRole(String roleid, String extend, String tenantId, String roleName, boolean isInheritable) throws CircuitException {
        return tenantRoleService.addRole(roleid,extend,tenantId,roleName,isInheritable);
    }

    @Override
    public void removeRole(String roleid,String tenantid) throws CircuitException {
        tenantRoleService.removeRole(roleid,tenantid);
    }

    @Override
    public TenantRole getRole(String roleid,String tenantid) throws CircuitException {
        return tenantRoleService.getRole(roleid,tenantid);
    }

    @Override
    public List<TenantRole> pageRole(String tenantid, int currPage, int pageSize) throws CircuitException {
        return tenantRoleService.pageRole(tenantid, currPage, pageSize);
    }

    @Override
    public List<TenantRole> pageRoleOfUser(String uid,String tenantid, int currPage, int pageSize) throws CircuitException {
        return tenantRoleService.pageRoleOfUser(uid,tenantid,currPage,pageSize);
    }

    @Override
    public List<UcUser> pageUserInRole( String roleid, String tenantid,int currPage, int pageSize) throws CircuitException {
        return tenantRoleService.pageUserInRole(roleid, tenantid,currPage, pageSize);
    }

    @Override
    public void addUserToRole(String uid, String roleid,String tenantid) throws CircuitException {
        tenantRoleService.addUserToRole(uid, roleid,tenantid);
    }

    @Override
    public void removeUserFromRole(String uid, String roleid,String tenantid) throws CircuitException {
        tenantRoleService.removeUserFromRole(uid, roleid,tenantid);
    }
}
