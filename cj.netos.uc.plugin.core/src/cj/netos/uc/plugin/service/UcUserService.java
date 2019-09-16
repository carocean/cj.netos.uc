package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.UcUser;
import cj.netos.uc.domain.UcUserAttr;
import cj.netos.uc.domain.UcUserAttrVal;
import cj.netos.uc.domain.UcUserSegment;
import cj.netos.uc.service.IUcUserService;
import cj.studio.ecm.annotation.CjService;

import java.util.List;

@CjService(name = "ucUserService")
public class UcUserService implements IUcUserService {
    @Override
    public UcUser registerByPassword(String tenant, String accountName, String password) {
        return null;
    }

    @Override
    public UcUser registerByIphone(String tenant, String phone) {
        return null;
    }

    @Override
    public UcUser registerByEmail(String tenant, String email) {
        return null;
    }

    @Override
    public UcUser getUser(String tenant, String accountName) {
        return null;
    }

    @Override
    public void updateProfile(String uid, UcUser user) {

    }

    @Override
    public List<UcUserAttrVal> listAttributeValue(String uid, String segmentid) {
        return null;
    }

    @Override
    public void setAttributeValue(String uid, String attributeid, String value) {

    }

    @Override
    public UcUserAttrVal getAttributeValue(String uid, String attibuteid) {
        return null;
    }

    @Override
    public void emptyAttributes(String uid, String segmentid) {

    }

    @Override
    public void addSegment(String name) {

    }

    @Override
    public List<UcUserSegment> listSegment() {
        return null;
    }

    @Override
    public void removeSegment(String segmentid) {

    }

    @Override
    public void addAttribute(String segmentid, String name, String type, int sort) {

    }

    @Override
    public UcUserAttr getAttibute(String attributeid) {
        return null;
    }

    @Override
    public List<UcUserAttr> listAttribue(String segmentid) {
        return null;
    }

    @Override
    public void removeAttribute(String attibuteid) {

    }
}
