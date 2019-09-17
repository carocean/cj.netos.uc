package cj.netos.uc.port;

import cj.netos.uc.domain.*;
import cj.netos.uc.service.IUcRoleService;
import cj.netos.uc.service.IUcUserService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

@CjService(name = "/role")
public class UcRolePorts implements IUcRolePort {
    @CjServiceRef(refByName = "ucplugin.ucRoleService")
    IUcRoleService ucRoleService;

    @Override
    public String addRole(String name, boolean isInheritable) throws CircuitException {
        return ucRoleService.addRole(name, isInheritable);
    }

    @Override
    public void removeRole(String roleid) throws CircuitException {
        ucRoleService.removeRole(roleid);
    }

    @Override
    public UcRole getRole(String roleid) throws CircuitException {
        return ucRoleService.getRole(roleid);
    }

    @Override
    public List<UcRole> pageRole(int currPage, int pageSize) throws CircuitException {
        return ucRoleService.pageRole(currPage, pageSize);
    }

    @Override
    public List<UcUser> pageUserInRole(String roleid, int currPage, int pageSize) throws CircuitException {
        return ucRoleService.pageUserInRole(roleid,
                currPage, pageSize);
    }

    @Override
    public void addUserToRole(String uid, String roleid) throws CircuitException {
        ucRoleService.addUserToRole(uid, roleid);
    }

    @Override
    public void removeUserFromRole(String uid, String roleid) throws CircuitException {
        ucRoleService.removeUserFromRole(uid, roleid);
    }
}
