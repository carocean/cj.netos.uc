package cj.netos.uc.port;

import cj.netos.uc.domain.UcUser;
import cj.netos.uc.domain.UcUserAttr;
import cj.netos.uc.domain.UcUserAttrVal;
import cj.netos.uc.domain.UcUserSegment;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.CircuitException;

import java.util.List;
@CjService(name = "/user")
public class UcUserPorts implements IUcUserPort {
    @Override
    public UcUser registerByPassword(String tenant, String accountName, String password) throws CircuitException {
        return null;
    }

    @Override
    public UcUser registerByIphone(String tenant, String phone) throws CircuitException {
        return null;
    }

    @Override
    public UcUser registerByEmail(String tenant, String email) throws CircuitException {
        return null;
    }

    @Override
    public UcUser getUser(String tenant, String accountName) throws CircuitException {
        return null;
    }

    @Override
    public void updateProfile(String uid, UcUser user) throws CircuitException {

    }

    @Override
    public void setAttributeValue(String uid, String attributeid, String value) throws CircuitException {

    }

    @Override
    public List<UcUserAttrVal> listAttributeValue(String uid, String segmentid) throws CircuitException {
        return null;
    }

    @Override
    public UcUserAttrVal getAttributeValue(String uid, String attibuteid) throws CircuitException {
        return null;
    }

    @Override
    public void emptyAttributes(String uid, String segmentid) throws CircuitException {

    }

    @Override
    public void addSegment(String name) throws CircuitException {

    }

    @Override
    public List<UcUserSegment> listSegment() throws CircuitException {
        return null;
    }

    @Override
    public void removeSegment(String segmentid) throws CircuitException {

    }

    @Override
    public void addAttribute(String segmentid, String name, String type, int sort) throws CircuitException {

    }

    @Override
    public UcUserAttr getAttibute(String attributeid) throws CircuitException {
        return null;
    }

    @Override
    public List<UcUserAttr> listAttribue(String segmentid) throws CircuitException {
        return null;
    }

    @Override
    public void removeAttribute(String attibuteid) throws CircuitException {

    }
}
