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
    public String addRole(String roleid,String name, boolean isInheritable) throws CircuitException {
        return ucRoleService.addRole(roleid,name, isInheritable);
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
    public List<UcRole> pageRoleInUser(String uid, int currPage, int pageSize) throws CircuitException {
        return ucRoleService.pageRoleInUser(uid, currPage, pageSize);
    }

    @Override
    public void addRoleToUser(String roleid, String uid) throws CircuitException {
        ucRoleService.addRoleToUser(roleid, uid);
    }

    @Override
    public void removeRoleFromUser(String roleid, String uid) throws CircuitException {
        ucRoleService.removeRoleFromUser(roleid, uid);
    }

}
