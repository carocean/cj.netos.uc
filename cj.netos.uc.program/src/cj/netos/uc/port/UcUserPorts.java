package cj.netos.uc.port;

import cj.netos.uc.domain.*;
import cj.netos.uc.service.IUcUserService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

@CjService(name = "/user")
public class UcUserPorts implements IUcUserPort {
    @CjServiceRef(refByName = "ucplugin.ucUserService")
    IUcUserService ucUserService;

    @Override
    public UcUser registerByPassword(String tenant, String accountName, String password) throws CircuitException {
        return ucUserService.registerByPassword(tenant, accountName, password);
    }

    @Override
    public UcUser registerByIphone(String tenant, String phone) throws CircuitException {
        return ucUserService.registerByIphone(tenant, phone);
    }

    @Override
    public UcUser registerByEmail(String tenant, String email) throws CircuitException {
        return ucUserService.registerByEmail(tenant, email);
    }

    @Override
    public UcUser getUser(String tenant, String accountName) throws CircuitException {
        return ucUserService.getUser(tenant, accountName);
    }

    @Override
    public void updateProfile(String uid, UcUser user) throws CircuitException {
        ucUserService.updateProfile(uid, user);
    }

    @Override
    public void setAttributeValue(String uid, String attributeid, String value) throws CircuitException {
        ucUserService.setAttributeValue(uid, attributeid, value);
    }

    @Override
    public List<UcUserAttrVal> listAttributeValue(String uid, String segmentid) throws CircuitException {
        return ucUserService.listAttributeValue(uid, segmentid);
    }

    @Override
    public UcUserAttrVal getAttributeValue(String uid, String attibuteid) throws CircuitException {
        return ucUserService.getAttributeValue(uid, attibuteid);
    }

    @Override
    public void emptyAttributes(String uid, String segmentid) throws CircuitException {
        ucUserService.emptyAttributes(uid, segmentid);
    }

    @Override
    public void addSegment(String name) throws CircuitException {
        ucUserService.addSegment(name);
    }

    @Override
    public List<UcUserSegment> listSegment() throws CircuitException {
        return ucUserService.listSegment();
    }

    @Override
    public void removeSegment(String segmentid) throws CircuitException {
        ucUserService.removeSegment(segmentid);
    }

    @Override
    public void addAttribute(String segmentid, String name, String type, int sort) throws CircuitException {
        ucUserService.addAttribute(segmentid, name, type, sort);
    }

    @Override
    public UcUserAttr getAttibute(String attributeid) throws CircuitException {
        return ucUserService.getAttibute(attributeid);
    }

    @Override
    public List<UcUserAttr> listAttribue(String segmentid) throws CircuitException {
        return ucUserService.listAttribue(segmentid);
    }

    @Override
    public void removeAttribute(String attibuteid) throws CircuitException {
        ucUserService.removeAttribute(attibuteid);
    }

    @Override
    public List<UcRole> pageRoleInUser(String uid, int currPage, int pageSize) throws CircuitException {
        return ucUserService.pageRoleInUser(uid, currPage, pageSize);
    }

    @Override
    public void addRoleToUser(String roleid, String uid) throws CircuitException {
        ucUserService.addRoleToUser(roleid, uid);
    }

    @Override
    public void removeRoleFromUser(String roleid, String uid) throws CircuitException {
        ucUserService.removeRoleFromUser(roleid, uid);
    }

    @Override
    public boolean isEmployee(String uid) throws CircuitException {
        return ucUserService.isEmployee(uid);
    }
}
