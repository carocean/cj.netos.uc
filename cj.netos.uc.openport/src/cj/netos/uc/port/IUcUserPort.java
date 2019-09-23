package cj.netos.uc.port;

import cj.netos.uc.domain.*;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "统一用户")
public interface IUcUserPort extends IOpenportService {
    @CjOpenport(usage = "用户数")
    long getUserCount() throws CircuitException;

    @CjOpenport(usage = "是否存在用户名")
    boolean existsUserName(@CjOpenportParameter(name = "userName", usage = "用户名") String userName) throws CircuitException;


    @CjOpenport(usage = "获取统一用户", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    UcUser getUserById(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid);


    @CjOpenport(usage = "更新用户身份信息", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void updateProfile(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid, @CjOpenportParameter(name = "user", usage = "用户信息") UcUser user) throws CircuitException;

    @CjOpenport(usage = "设置属性值", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void setAttributeValue(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid, @CjOpenportParameter(name = "attributeid", usage = "属性标识") String attributeid, @CjOpenportParameter(name = "value", usage = "属性值") String value) throws CircuitException;

    @CjOpenport(usage = "列出属性值", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<UcUserAttrVal> listAttributeValue(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid, @CjOpenportParameter(name = "segmentid", usage = "信息段标识") String segmentid) throws CircuitException;

    @CjOpenport(usage = "获取属性值", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    UcUserAttrVal getAttributeValue(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid, @CjOpenportParameter(name = "attibuteid", usage = "属性标识") String attibuteid) throws CircuitException;

    @CjOpenport(usage = "清空用户的指定段的属性", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void emptyAttributes(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid, @CjOpenportParameter(name = "segmentid", usage = "信息段标识") String segmentid) throws CircuitException;

    @CjOpenport(usage = "添加信息段", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void addSegment(@CjOpenportParameter(name = "name", usage = "信息段名") String name) throws CircuitException;

    @CjOpenport(usage = "列出信息段", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<UcUserSegment> listSegment() throws CircuitException;

    @CjOpenport(usage = "移除信息段", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void removeSegment(@CjOpenportParameter(name = "segmentid", usage = "信息段标识") String segmentid) throws CircuitException;

    @CjOpenport(usage = "添加属性", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void addAttribute(@CjOpenportParameter(name = "segmentid", usage = "信息段标识") String segmentid, @CjOpenportParameter(name = "name", usage = "属性名") String name, @CjOpenportParameter(name = "type", usage = "属性类型") String type, @CjOpenportParameter(name = "sort", usage = "在段中顺序") int sort) throws CircuitException;

    @CjOpenport(usage = "获取属性", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    UcUserAttr getAttibute(@CjOpenportParameter(name = "attibuteid", usage = "属性标识") String attributeid) throws CircuitException;

    @CjOpenport(usage = "列出属性", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<UcUserAttr> listAttribue(@CjOpenportParameter(name = "segmentid", usage = "信息段标识") String segmentid) throws CircuitException;


    @CjOpenport(usage = "移除属性", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    void removeAttribute(@CjOpenportParameter(name = "attibuteid", usage = "属性标识") String attibuteid) throws CircuitException;

    @CjOpenport(usage = "分页用户", elementType = UcUser.class, acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    List<UcUser> pageUser(@CjOpenportParameter(name = "currPage", usage = "当前页号") int currPage, @CjOpenportParameter(name = "pageSize", usage = "页大小") int pageSize) throws CircuitException;


    @CjOpenport(usage = "是否是雇员", acl = {"allow administrators.role", "allow tests.role", "allow developer.role"})
    boolean isEmployee(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid) throws CircuitException;
}
