package cj.netos.uc.port;

import cj.netos.uc.model.*;
import cj.netos.uc.service.IDomainService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

import java.util.List;

@CjService(name = "/platform/self.service")
public class PlatformManangerSelfServicePorts implements IPlatformManangerSelfServicePorts {
    @CjServiceRef(refByName = "ucplugin.domainService")
    IDomainService domainService;

    @Override
    public void addDomainGroup(ISecuritySession securitySession, String groupId, String groupName) throws CircuitException {
        _checkDomainRights(securitySession);
        domainService.addDomainGroup(groupId, groupName);
    }

    private void _checkDomainRights(ISecuritySession securitySession) throws CircuitException {
        if (!securitySession.roleIn("platform:administrators") && !securitySession.roleIn("platform:tests")) {
            throw new CircuitException("801", "无权访问");
        }
    }

    @Override
    public void removeDomainGroup(ISecuritySession securitySession, String groupId) throws CircuitException {
        _checkDomainRights(securitySession);
        domainService.removeDomainGroup(groupId);
    }

    @Override
    public List<DomainGroup> listDomainGroup(ISecuritySession securitySession) throws CircuitException {
        return domainService.listAllDomainGroup();
    }

    @Override
    public void addDomainField(ISecuritySession securitySession, String fieldCode,String groupId, String fieldName, String fieldDesc) throws CircuitException {
        _checkDomainRights(securitySession);
        domainService.addDomainField(fieldCode,groupId, fieldName, fieldDesc);
    }

    @Override
    public void removeDomainField(ISecuritySession securitySession, String fieldId) throws CircuitException {
        _checkDomainRights(securitySession);
        domainService.removeDomainField(fieldId);
    }

    @Override
    public List<DomainField> listDomainField(ISecuritySession securitySession, String groupId) throws CircuitException {
        return domainService.listDomainField(groupId);
    }

    @Override
    public void emptyDomainField(ISecuritySession securitySession, String groupId) throws CircuitException {
        _checkDomainRights(securitySession);
        domainService.emptyDomainField(groupId);
    }

    @Override
    public void addTenant(ISecuritySession securitySession) {

    }

    @Override
    public void removeTenant(ISecuritySession securitySession) {

    }

    @Override
    public List<UcTenant> pageTenant(ISecuritySession securitySession, int limit, long offset) {
        return null;
    }

    @Override
    public void addRole(ISecuritySession securitySession, String roleid, String roleName, String extendUcRole) {

    }

    @Override
    public void removeRole(ISecuritySession securitySession, String roleId) {

    }

    @Override
    public UcRole getRole(ISecuritySession securitySession, String roleId) {
        return null;
    }

    @Override
    public List<UcRole> listRole(ISecuritySession securitySession) {
        return null;
    }

    @Override
    public void grantRoleToUser(ISecuritySession securitySession, String roleid, String uid) {

    }

    @Override
    public void ungrantRoleToUser(ISecuritySession securitySession, String roleid, String uid) {

    }

    @Override
    public List<UcRole> getRoleOfUser(ISecuritySession securitySession, String uid) {
        return null;
    }

    @Override
    public List<UcUser> getUserInRole(ISecuritySession securitySession, String roleid) {
        return null;
    }
}
