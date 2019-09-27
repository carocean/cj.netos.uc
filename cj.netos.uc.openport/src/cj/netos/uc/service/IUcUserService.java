package cj.netos.uc.service;

import cj.netos.uc.domain.*;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;

import java.util.List;

public interface IUcUserService {
    String addUser(String uid,String userName, byte sex, String email, String mobile, String idcard) throws CircuitException;

    List<UcUser> pageUser(int currPage, int pageSize) throws CircuitException;

    long getUserCount() throws CircuitException;


    UcUser registerByPassword(String appid, String accountName, String password) throws CircuitException;

    UcUser registerByIphone(String appid, String phone, String password) throws CircuitException;

    UcUser registerByEmail(String appid, String email, String password) throws CircuitException;


    UcUser getUserById(String uid);


    void updateProfile(String uid, UcUser user) throws CircuitException;

    List<UcUserAttrVal> listAttributeValue(String uid, String segmentid) throws CircuitException;

    void setAttributeValue(String uid, String attributeid, String value) throws CircuitException;

    UcUserAttrVal getAttributeValue(String uid, String attibuteid) throws CircuitException;

    void emptyAttributeValues(String uid, String segmentid) throws CircuitException;

    void addSegment(String name) throws CircuitException;

    List<UcUserSegment> listSegment() throws CircuitException;

    void removeSegment(String segmentid) throws CircuitException;

    void addAttribute(String segmentid, String name, String type, int sort) throws CircuitException;

    UcUserAttr getAttribute(String attributeid) throws CircuitException;

    List<UcUserAttr> listAttribute(String segmentid) throws CircuitException;

    void removeAttribute(String attibuteid) throws CircuitException;

    boolean isEmployee(String uid) throws CircuitException;
}
