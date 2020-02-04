package cj.netos.uc.port;

import cj.netos.uc.model.*;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

/*******
 * - 账户管理
 * - 应用角色管理
 *
 */
@CjOpenports(usage = "应用管理者自助服务")
public interface IAppManangerSelfServicePorts extends IOpenportService {
    void freezenAccount(ISecuritySession securitySession, String account) throws CircuitException;
    void reissueAppSecurity(ISecuritySession securitySession, long tokenExpire);
    TenantApp getApp(ISecuritySession securitySession);
    List<AppAccount> pageAccount(ISecuritySession securitySession, int limit, long offset) throws CircuitException;

    AppAccount getAccount(ISecuritySession securitySession) throws CircuitException;

    void addRole(ISecuritySession securitySession, String roleid, String roleName, String extendTenantRole);

    void removeRole(ISecuritySession securitySession, String roleId);

    AppRole getRole(ISecuritySession securitySession, String roleId);

    List<AppRole> listRole(ISecuritySession securitySession);

    void grantRoleToPerson(ISecuritySession securitySession, String roleid, String person);

    void ungrantRoleToPerson(ISecuritySession securitySession, String roleid,  String person);

    List<AppRole> getRoleOfPerson(ISecuritySession securitySession,  String person);

    List<PersonInfo> getPersonInRole(ISecuritySession securitySession,  String person);
}
