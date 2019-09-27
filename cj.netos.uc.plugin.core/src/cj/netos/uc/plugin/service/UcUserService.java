package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.*;
import cj.netos.uc.plugin.dao.*;
import cj.netos.uc.util.Encript;
import cj.netos.uc.util.NumberGen;
import cj.netos.uc.service.IAppAccountService;
import cj.netos.uc.service.IUcEmployeeService;
import cj.netos.uc.service.IUcUserService;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceInvertInjection;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.util.StringUtil;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@CjBridge(aspects = "@transaction")
@CjService(name = "ucUserService")
public class UcUserService implements IUcUserService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UcUserMapper")
    UcUserMapper userMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UcUserSegmentMapper")
    UcUserSegmentMapper userSegmentMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UcUserAttrMapper")
    UcUserAttrMapper userAttrMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UcUserAttrValMapper")
    UcUserAttrValMapper userAttrValMapper;

    @CjServiceInvertInjection
    @CjServiceRef(refByName = "appAccountService")
    IAppAccountService appAccountService;

    @CjServiceRef
    IUcEmployeeService ucEmployeeService;

    @CjTransaction
    @Override
    public String addUser(String uid, String userName, byte sex, String email, String mobile, String idcard) throws CircuitException {
        if (StringUtil.isEmpty(userName)) {
            throw new CircuitException("404", "用户名为空");
        }
        UcUser ucUser = new UcUser();
        ucUser.setUserId(StringUtil.isEmpty(uid) ? NumberGen.gen() : uid);
        ucUser.setCreateTime(new Date());
        ucUser.setUserName(userName);
        ucUser.setEmail(email);
        ucUser.setIdcard(idcard);
        ucUser.setMobile(mobile);
        ucUser.setSex(sex);
        userMapper.insertSelective(ucUser);
        return ucUser.getUserId();
    }

    @CjTransaction
    @Override
    public long getUserCount() throws CircuitException {
        UcUserExample example = new UcUserExample();
        return userMapper.countByExample(example);
    }

    @CjTransaction
    @Override
    public List<UcUser> pageUser(int currPage, int pageSize) throws CircuitException {
        return userMapper.pageUser(currPage, pageSize);
    }

    @CjTransaction
    @Override
    public UcUser registerByPassword(String appid, String accountName, String password) throws CircuitException {
        if (StringUtil.isEmpty(appid)) {
            throw new CircuitException("404", "应用编号为空");
        }
        if (StringUtil.isEmpty(accountName)) {
            throw new CircuitException("404", "账户名为空");
        }
        if (StringUtil.isEmpty(password)) {
            throw new CircuitException("404", "密码为空");
        }

        UcUser user = new UcUser();
        user.setCreateTime(new Date());
        user.setUserName(accountName);
        user.setUserId(NumberGen.gen());
        userMapper.insert(user);
        password = Encript.md5(password);

        this.appAccountService.addAccount(accountName, (byte) 0, user.getUserId(), appid, password);
        return user;
    }

    @CjTransaction
    @Override
    public UcUser registerByIphone(String appid, String phone, String password) throws CircuitException {
        if (StringUtil.isEmpty(appid)) {
            throw new CircuitException("404", "应用编号为空");
        }
        if (StringUtil.isEmpty(phone)) {
            throw new CircuitException("404", "手机号为空");
        }
        if (StringUtil.isEmpty(password)) {
            throw new CircuitException("404", "密码为空");
        }

        UcUser user = new UcUser();
        user.setCreateTime(new Date());
        user.setUserName(phone);
        user.setUserId(NumberGen.gen());
        userMapper.insert(user);
        password = Encript.md5(password);

        this.appAccountService.addAccount(phone, (byte) 1, user.getUserId(), appid, password);
        return user;
    }

    @CjTransaction
    @Override
    public UcUser registerByEmail(String appid, String email, String password) throws CircuitException {
        if (StringUtil.isEmpty(appid)) {
            throw new CircuitException("404", "应用编号为空");
        }
        if (StringUtil.isEmpty(email)) {
            throw new CircuitException("404", "邮箱为空");
        }
        if (StringUtil.isEmpty(password)) {
            throw new CircuitException("404", "密码为空");
        }

        UcUser user = new UcUser();
        user.setCreateTime(new Date());
        user.setUserName(email);
        user.setUserId(NumberGen.gen());
        userMapper.insert(user);
        password = Encript.md5(password);

        this.appAccountService.addAccount(email, (byte) 2, user.getUserId(), appid, password);
        return user;
    }


    @CjTransaction
    @Override
    public UcUser getUserById(String uid) {
        return userMapper.selectByPrimaryKey(uid);
    }


    @CjTransaction
    @Override
    public void updateProfile(String uid, UcUser user) {
        user.setUserId(uid);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @CjTransaction
    @Override
    public List<UcUserAttrVal> listAttributeValue(String uid, String segmentid) {
        return userAttrValMapper.listAttributeValue(uid, segmentid);
    }

    @CjTransaction
    @Override
    public void setAttributeValue(String uid, String attributeid, String value) throws CircuitException {
        if (getUserById(uid) == null) {
            throw new CircuitException("404", String.format("用户不存在：%s", uid));
        }
        if (getAttribute(attributeid) == null) {
            throw new CircuitException("404", String.format("用户属性不存在：%s", attributeid));
        }
        UcUserAttrVal val = getAttributeValue(uid, attributeid);
        if (val == null) {
            val = new UcUserAttrVal();
            val.setUserId(uid);
            val.setAttributeId(attributeid);
            val.setValueId(NumberGen.gen());
            val.setValue(value);
            this.userAttrValMapper.insertSelective(val);
            return;
        }
        val.setValue(value);
        userAttrValMapper.updateByPrimaryKeySelective(val);
    }

    @CjTransaction
    @Override
    public UcUserAttrVal getAttributeValue(String uid, String attibuteid) {
        UcUserAttrValExample example = new UcUserAttrValExample();
        example.createCriteria().andUserIdEqualTo(uid).andAttributeIdEqualTo(attibuteid);
        List<UcUserAttrVal> list = userAttrValMapper.selectByExample(example);
        if (list.isEmpty()) return null;
        return list.get(0);
    }

    @CjTransaction
    @Override
    public void emptyAttributeValues(String uid, String segmentid) {
        userAttrValMapper.emptyAttributeValues(uid, segmentid);
    }

    @CjTransaction
    @Override
    public void addSegment(String name) throws CircuitException {
        if (existsSegment(name)) {
            throw new CircuitException("500", "已存在同名段:" + name);
        }
        UcUserSegment segment = new UcUserSegment();
        segment.setCreateTime(new Date());
        segment.setName(name);
        segment.setSegmentId(NumberGen.gen());
        userSegmentMapper.insertSelective(segment);
    }

    private boolean existsSegment(String name) {
        UcUserSegmentExample example = new UcUserSegmentExample();
        example.createCriteria().andNameEqualTo(name);
        return userSegmentMapper.countByExample(example) > 0;
    }

    @CjTransaction
    @Override
    public List<UcUserSegment> listSegment() {
        UcUserSegmentExample example = new UcUserSegmentExample();
        return userSegmentMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public void removeSegment(String segmentid) {
        userSegmentMapper.deleteByPrimaryKey(segmentid);
    }

    @CjTransaction
    @Override
    public void addAttribute(String segmentid, String name, String type, int sort) throws CircuitException {
        if (existsAttribute(segmentid, name)) {
            throw new CircuitException("500", String.format("段：%s内已存在属性：%s", segmentid, name));
        }
        UcUserAttr attr = new UcUserAttr();
        attr.setAttributeId(NumberGen.gen());
        attr.setName(name);
        attr.setSegmentId(segmentid);
        attr.setSort(sort);
        attr.setType(type);
        userAttrMapper.insertSelective(attr);
    }

    private boolean existsAttribute(String segmentid, String name) {
        UcUserAttrExample example = new UcUserAttrExample();
        example.createCriteria().andSegmentIdEqualTo(segmentid).andNameEqualTo(name);
        return userAttrMapper.countByExample(example) > 0;
    }

    @CjTransaction
    @Override
    public UcUserAttr getAttribute(String attributeid) {

        return userAttrMapper.selectByPrimaryKey(attributeid);
    }

    @CjTransaction
    @Override
    public List<UcUserAttr> listAttribute(String segmentid) {
        UcUserAttrExample example = new UcUserAttrExample();
        example.createCriteria().andSegmentIdEqualTo(segmentid);
        return userAttrMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public void removeAttribute(String attibuteid) {
        userAttrMapper.deleteByPrimaryKey(attibuteid);
    }


    @CjTransaction
    @Override
    public boolean isEmployee(String uid) throws CircuitException {
        return !ucEmployeeService.listMyEmployee(uid).isEmpty();
    }
}
