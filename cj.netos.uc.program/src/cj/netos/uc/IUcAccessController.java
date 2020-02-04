package cj.netos.uc;

import cj.studio.openport.ISecuritySession;

import java.util.List;

public interface IUcAccessController {
    void demandMustBeSuperiorTenantByAppId(ISecuritySession securitySession, String appId);

    void demandMustBeNotRoles(ISecuritySession securitySession, List<String> asList);

    void demandMustBeSuperiorTenantByAccountId(ISecuritySession securitySession, String accountid);

    void demandMustBeRoles(ISecuritySession securitySession, List<String> asList);

    void demandMustBeTenant(ISecuritySession securitySession, String tenantid);

    void demandMustBeAppId(ISecuritySession securitySession, String appid);

}
