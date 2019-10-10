package cj.netos.uc.port;

import cj.netos.uc.model.AppRole;
import cj.netos.uc.model.UcUser;
import cj.netos.uc.service.IAppRoleService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

@CjService(name = "/app/role")
public class AppRolePorts implements IAppRolePort {
    @CjServiceRef(refByName = "ucplugin.tenantAppRoleService")
    IAppRoleService appRoleService;

    @Override
    public String addRole(String roleId, String extend, String appId, String roleName) throws CircuitException {
        return appRoleService.addRole(roleId, extend, appId, roleName);
    }

    @Override
    public void removeRole(String appid,String roleid) throws CircuitException {
        appRoleService.removeRole(appid,roleid);
    }

    @Override
    public AppRole getRole(String appid,String roleid) throws CircuitException {
        return appRoleService.getRole(appid,roleid);
    }

    @Override
    public List<AppRole> pageRole(String appid, int currPage, int pageSize) throws CircuitException {
        return appRoleService.pageRole(appid, currPage, pageSize);
    }

    @Override
    public List<UcUser> pageUserInRole(String appid,String roleid, int currPage, int pageSize) throws CircuitException {
        return appRoleService.pageUserInRole(appid,roleid, currPage, pageSize);
    }

    @Override
    public List<AppRole> pageRoleOfUser(String uid,String appid, int currPage, int pageSize) throws CircuitException {
        return appRoleService.pageRoleOfUser(uid,appid,currPage,pageSize);
    }

    @Override
    public void addUserToRole(String uid,String appid, String roleid) throws CircuitException {
        appRoleService.addUserToRole(uid, appid,roleid);
    }

    @Override
    public void removeUserFromRole(String uid,String appid, String roleid) throws CircuitException {
        appRoleService.removeUserFromRole(uid,appid, roleid);
    }
}
