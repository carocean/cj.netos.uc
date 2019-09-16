package cj.netos.uc.service;

import cj.netos.uc.domain.UcUser;
import cj.netos.uc.domain.UcUserAttr;
import cj.netos.uc.domain.UcUserAttrVal;
import cj.netos.uc.domain.UcUserSegment;

import java.util.List;

public interface IUcUserService {
    UcUser registerByPassword(String tenant, String accountName, String password);

    UcUser registerByIphone(String tenant, String phone);

    UcUser registerByEmail(String tenant, String email);

    UcUser getUser(String tenant, String accountName);

    void updateProfile(String uid, UcUser user);

    List<UcUserAttrVal> listAttributeValue(String uid, String segmentid);

    void setAttributeValue(String uid, String attributeid, String value);

    UcUserAttrVal getAttributeValue(String uid, String attibuteid);

    void emptyAttributes(String uid, String segmentid);

    void addSegment(String name);

    List<UcUserSegment> listSegment();

    void removeSegment(String segmentid);

    void addAttribute(String segmentid, String name, String type, int sort);

    UcUserAttr getAttibute(String attributeid);

    List<UcUserAttr> listAttribue(String segmentid);

    void removeAttribute(String attibuteid);

}
