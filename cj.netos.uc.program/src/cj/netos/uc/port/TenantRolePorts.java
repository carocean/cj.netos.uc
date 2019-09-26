package cj.netos.uc.port;

import cj.netos.uc.domain.TenantRole;
import cj.netos.uc.domain.UcUser;
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
    public void removeRole(String roleid) throws CircuitException {
        tenantRoleService.removeRole(roleid);
    }

    @Override
    public TenantRole getRole(String roleid) throws CircuitException {
        return tenantRoleService.getRole(roleid);
    }

    @Override
    public List<TenantRole> pageRole(String tenantid, int currPage, int pageSize) throws CircuitException {
        return tenantRoleService.pageRole(tenantid, currPage, pageSize);
    }

    @Override
    public List<TenantRole> pageRoleOfUser(String uid, int currPage, int pageSize) throws CircuitException {
        return tenantRoleService.pageRoleOfUser(uid,currPage,pageSize);
    }

    @Override
    public List<UcUser> pageUserInRole(String roleid, int currPage, int pageSize) throws CircuitException {
        return tenantRoleService.pageUserInRole(roleid, currPage, pageSize);
    }

    @Override
    public void addUserToRole(String uid, String roleid) throws CircuitException {
        tenantRoleService.addUserToRole(uid, roleid);
    }

    @Override
    public void removeUserFromRole(String uid, String roleid) throws CircuitException {
        tenantRoleService.removeUserFromRole(uid, roleid);
    }
}
