package cj.netos.uc.plugin.service;

import cj.netos.uc.service.*;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.context.IElement;
import cj.studio.ecm.context.IProperty;
import cj.studio.ecm.net.CircuitException;
import cj.ultimate.util.StringUtil;

@CjService(name = "ucInit")
public class UCInit implements IDBInit {
    @CjServiceRef
    IUcUserService ucUserService;
    @CjServiceRef
    ITenantService tenantService;
    @CjServiceRef(refByName = "tenantAppService")
    IAppService appService;
    @CjServiceRef
    IAppAccountService appAccountService;
    @CjServiceRef
    IUcRoleService ucRoleService;
    @CjServiceRef
    ITenantRoleService tenantRoleService;
    @CjServiceRef(refByName = "tenantAppRoleService")
    IAppRoleService appRoleService;

    @Override
    public void init(IServiceSite site, IElement args) throws CircuitException {//添加超级管理员，及管理员角色，并为将管理角授予超级管理员
        String uid = ((IProperty) args.getNode("uid")).getValue().getName();
        if (ucUserService.getUserById(uid) == null) {
            String userName = ((IProperty) args.getNode("userName")).getValue().getName();
            String email = ((IProperty) args.getNode("email")).getValue().getName();
            String mobile = ((IProperty) args.getNode("mobile")).getValue().getName();
            String idcard = ((IProperty) args.getNode("idcard")).getValue().getName();
            ucUserService.addUser(uid, userName, (byte) 0, email, mobile, idcard);
        }
        String tenantid = ((IProperty) args.getNode("tenantid")).getValue().getName();
        if (tenantService.getTenantById(tenantid) == null) {
            String tenantName = ((IProperty) args.getNode("tenantName")).getValue().getName();
            String tenantwebsite = ((IProperty) args.getNode("tenantWebsite")).getValue().getName();
            tenantService.addTenant(tenantid, tenantName, tenantwebsite, uid);
        }
        String appid = ((IProperty) args.getNode("appid")).getValue().getName();
        if (appService.getApp(appid) == null) {
            String appName = ((IProperty) args.getNode("appName")).getValue().getName();
            String tokenExpire = ((IProperty) args.getNode("tokenExpire")).getValue().getName();
            String appLogo = ((IProperty) args.getNode("appLogo")).getValue().getName();
            String callbackUrl = ((IProperty) args.getNode("callbackUrl")).getValue().getName();
            String logoutUrl = ((IProperty) args.getNode("logoutUrl")).getValue().getName();
            String homeUrl = ((IProperty) args.getNode("homeUrl")).getValue().getName();
            appService.addApp(appid, appName, tenantid, Long.valueOf(tokenExpire), appLogo, callbackUrl, logoutUrl, homeUrl);
        }
        String accountName = ((IProperty) args.getNode("accountName")).getValue().getName();
        String password = ((IProperty) args.getNode("password")).getValue().getName();
        if (!appAccountService.existsAccount(appid, accountName)) {
            appAccountService.addAccount(accountName, (byte) 0, uid, appid, password);
        }
        //初始化角色
        if (ucRoleService.getRole("administrators") == null) {
            ucRoleService.addRole("administrators", "超级管理员", true);
        }
        if (ucRoleService.getRole("tenantAdministrators") == null) {
            ucRoleService.addRole("tenantAdministrators", "租户管理员", true);
        }
        if (ucRoleService.getRole("tenantTests") == null) {
            ucRoleService.addRole("tenantTests", "租户测试员", true);
        }
        if (ucRoleService.getRole("tenantDevelops") == null) {
            ucRoleService.addRole("tenantDevelops", "租户开发者", true);
        }
        if (tenantRoleService.getRole("appAdministrators") == null) {
            tenantRoleService.addRole("appAdministrators", "tenantAdministrators", tenantid, "应用管理员", true);
        }
        if (tenantRoleService.getRole("appTests") == null) {
            tenantRoleService.addRole("appTests", "tenantTests", tenantid, "应用测试员", true);
        }
        if (tenantRoleService.getRole("appDevelops") == null) {
            tenantRoleService.addRole("appDevelops", "tenantDevelops", tenantid, "应用开发者", true);
        }
        if (appRoleService.getRole("administrators") == null) {
            appRoleService.addRole("administrators", "appAdministrators", appid, "管理员");
        }
        if (appRoleService.getRole("tests") == null) {
            appRoleService.addRole("tests", "appTests", appid, "测试员");
        }
        if (appRoleService.getRole("develops") == null) {
            appRoleService.addRole("develops", "appDevelops", appid, "开发者");
        }
        if(!ucRoleService.hasRoleOfUser("administrators",uid)) {
            ucRoleService.addRoleToUser("administrators", uid);
        }
        if(!ucRoleService.hasRoleOfUser("tenantAdministrators",uid)) {
            ucRoleService.addRoleToUser("tenantAdministrators", uid);
        }
        CJSystem.logging().info(getClass(), String.format("初始化UC完成。应用：%s, 账号：%s, 密码：%s", appid, accountName, password));
    }

}
