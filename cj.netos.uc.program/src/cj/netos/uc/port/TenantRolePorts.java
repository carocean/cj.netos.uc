package cj.netos.uc.port;

import cj.netos.uc.domain.TenantRole;
import cj.netos.uc.service.ITenantAccountService;
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
    public String addRole(TenantRole role) throws CircuitException {
        return tenantRoleService.addRole(role);
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
    public List<TenantRole> pageRole(int currPage, int pageSize) throws CircuitException {
        return tenantRoleService.pageRole(currPage, pageSize);
    }

    @Override
    public List<TenantRole> pageUserInRole(String roleid, int currPage, int pageSize) throws CircuitException {
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
