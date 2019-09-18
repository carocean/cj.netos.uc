package cj.netos.uc.port;

import cj.netos.uc.domain.AppRole;
import cj.netos.uc.domain.UcUser;
import cj.netos.uc.service.IAppRoleService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

@CjService(name = "/app/role")
public class AppRolePorts implements IAppRolePort {
    @CjServiceRef(refByName = "ucplugin.appRoleService")
    IAppRoleService appRoleService;

    @Override
    public String addRole(AppRole role) throws CircuitException {
        return appRoleService.addRole(role);
    }

    @Override
    public void removeRole(String roleid) throws CircuitException {
        appRoleService.removeRole(roleid);
    }

    @Override
    public AppRole getRole(String roleid) throws CircuitException {
        return appRoleService.getRole(roleid);
    }

    @Override
    public List<AppRole> pageRole(String appid, int currPage, int pageSize) throws CircuitException {
        return appRoleService.pageRole(appid, currPage, pageSize);
    }

    @Override
    public List<UcUser> pageUserInRole(String roleid, int currPage, int pageSize) throws CircuitException {
        return appRoleService.pageUserInRole(roleid, currPage, pageSize);
    }

    @Override
    public void addUserToRole(String uid, String roleid) throws CircuitException {
        appRoleService.addUserToRole(uid, roleid);
    }

    @Override
    public void removeUserFromRole(String uid, String roleid) throws CircuitException {
        appRoleService.removeUserFromRole(uid, roleid);
    }
}
