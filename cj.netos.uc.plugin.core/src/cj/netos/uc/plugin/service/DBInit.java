package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.UcRole;
import cj.netos.uc.domain.UcUser;
import cj.netos.uc.service.IDBInit;
import cj.netos.uc.service.ITenantAccountService;
import cj.netos.uc.service.IUcRoleService;
import cj.netos.uc.service.IUcUserService;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.context.IElement;
import cj.studio.ecm.net.CircuitException;

@CjService(name = "dbInit")
public class DBInit implements IDBInit {
    @CjServiceRef
    IUcUserService ucUserService;
    @CjServiceRef
    IUcRoleService ucRoleService;
    @CjServiceRef
    ITenantAccountService tenantAccountService;

    @Override
    public void init(IServiceSite site, IElement args) throws CircuitException {//添加超级管理员，及管理员角色，并为将管理角授予超级管理员
        String supertenant_admin = site.getProperty("uc.supertenant.admin");
        String supertenant_password = site.getProperty("uc.supertenant.password");
        String supertenant_id = site.getProperty("uc.supertenant.id");
        UcUser user = tenantAccountService.getUser(supertenant_id, supertenant_admin);
        if (user == null) {
            user = ucUserService.registerByPassword(supertenant_id, supertenant_admin, supertenant_password);
        }
        if (ucRoleService.getRole("administrators") == null) {
            String roleid = ucRoleService.addRole("administrators", "管理员", false);
            ucRoleService.addRoleToUser(roleid, user.getUserId());
        }
        CJSystem.logging().info(getClass(), String.format("初始化DB成功。uc.supertenant.id=%s, uc.supertenant.admin=%s, uc.supertenant.password=%s", supertenant_id, supertenant_admin, supertenant_password));
    }

}
