package cj.netos.uc.port;

import cj.netos.uc.model.UcUser;
import cj.netos.uc.model.UcUserAttr;
import cj.netos.uc.model.UcUserAttrVal;
import cj.netos.uc.model.UcUserSeg;
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
    public long getUserCount() throws CircuitException {
        return ucUserService.getUserCount();
    }

    @Override
    public List<UcUser> pageUser(int currPage, int pageSize) throws CircuitException {
        return ucUserService.pageUser(currPage, pageSize);
    }


    @Override
    public UcUser getUserById(String uid) {
        return ucUserService.getUserById(uid);
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
        ucUserService.emptyAttributeValues(uid, segmentid);
    }

    @Override
    public void addSegment(String name) throws CircuitException {
        ucUserService.addSegment(name);
    }

    @Override
    public List<UcUserSeg> listSegment() throws CircuitException {
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
        return ucUserService.getAttribute(attributeid);
    }

    @Override
    public List<UcUserAttr> listAttribue(String segmentid) throws CircuitException {
        return ucUserService.listAttribute(segmentid);
    }

    @Override
    public void removeAttribute(String attibuteid) throws CircuitException {
        ucUserService.removeAttribute(attibuteid);
    }


    @Override
    public boolean isEmployee(String uid) throws CircuitException {
        return ucUserService.isEmployee(uid);
    }
}
