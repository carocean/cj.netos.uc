package cj.netos.uc.port;

import cj.netos.uc.domain.UcUser;
import cj.netos.uc.domain.UcUserAttr;
import cj.netos.uc.domain.UcUserAttrVal;
import cj.netos.uc.domain.UcUserSegment;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "统一用户")
public interface IUcUserPort extends IOpenportService {
    @CjOpenport(usage = "通过账户密码注册")
    UcUser registerByPassword(@CjOpenportParameter(name = "tenant", usage = "租户标识") String tenant, @CjOpenportParameter(name = "accountName", usage = "帐号名") String accountName, @CjOpenportParameter(name = "password", usage = "密码") String password) throws CircuitException;

    @CjOpenport(usage = "通过电话号码注册")
    UcUser registerByIphone(@CjOpenportParameter(name = "tenant", usage = "租户标识") String tenant, @CjOpenportParameter(name = "phone", usage = "电话号码") String phone) throws CircuitException;

    @CjOpenport(usage = "通过邮箱注册")
    UcUser registerByEmail(@CjOpenportParameter(name = "tenant", usage = "租户标识") String tenant, @CjOpenportParameter(name = "email", usage = "电话号码") String email) throws CircuitException;

    @CjOpenport(usage = "获取统一用户")
    UcUser getUser(@CjOpenportParameter(name = "tenant", usage = "租户标识") String tenant, @CjOpenportParameter(name = "accountName", usage = "帐号名") String accountName) throws CircuitException;

    @CjOpenport(usage = "更新用户身份信息")
    void updateProfile(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid, @CjOpenportParameter(name = "user", usage = "用户信息") UcUser user) throws CircuitException;

    @CjOpenport(usage = "设置属性值")
    void setAttributeValue(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid, @CjOpenportParameter(name = "attributeid", usage = "属性标识")String attributeid,@CjOpenportParameter(name = "value", usage = "属性值") String value) throws CircuitException;

    @CjOpenport(usage = "列出属性值")
    List<UcUserAttrVal> listAttributeValue(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid, @CjOpenportParameter(name = "segmentid", usage = "信息段标识") String segmentid) throws CircuitException;

    @CjOpenport(usage = "获取属性值")
    UcUserAttrVal getAttributeValue(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid, @CjOpenportParameter(name = "attibuteid", usage = "属性标识") String attibuteid) throws CircuitException;

    @CjOpenport(usage = "清空用户的指定段的属性")
    void emptyAttributes(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid, @CjOpenportParameter(name = "segmentid", usage = "信息段标识") String segmentid) throws CircuitException;

    @CjOpenport(usage = "添加信息段")
    void addSegment(String name) throws CircuitException;

    @CjOpenport(usage = "列出信息段")
    List<UcUserSegment> listSegment() throws CircuitException;

    @CjOpenport(usage = "移除信息段")
    void removeSegment(@CjOpenportParameter(name = "segmentid", usage = "信息段标识") String segmentid) throws CircuitException;

    @CjOpenport(usage = "添加属性")
    void addAttribute(@CjOpenportParameter(name = "segmentid", usage = "信息段标识") String segmentid, @CjOpenportParameter(name = "name", usage = "属性名") String name, @CjOpenportParameter(name = "type", usage = "属性类型") String type, @CjOpenportParameter(name = "sort", usage = "在段中顺序") int sort) throws CircuitException;

    UcUserAttr getAttibute(@CjOpenportParameter(name = "attibuteid", usage = "属性标识") String attributeid) throws CircuitException;

    @CjOpenport(usage = "列出属性")
    List<UcUserAttr> listAttribue(@CjOpenportParameter(name = "segmentid", usage = "信息段标识") String segmentid) throws CircuitException;


    @CjOpenport(usage = "移除属性性")
    void removeAttribute(@CjOpenportParameter(name = "attibuteid", usage = "属性标识") String attibuteid) throws CircuitException;
}
