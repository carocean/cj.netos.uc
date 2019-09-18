package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.*;
import cj.netos.uc.plugin.dao.*;
import cj.netos.uc.plugin.util.NumberGen;
import cj.netos.uc.service.ITenantAccountService;
import cj.netos.uc.service.IUcEmployeeService;
import cj.netos.uc.service.IUcRoleService;
import cj.netos.uc.service.IUcUserService;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceInvertInjection;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;

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
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UaRoleUserMapper")
    UaRoleUserMapper roleUserMapper;
    @CjServiceInvertInjection
    @CjServiceRef(refByName = "tenantAccountService")
    ITenantAccountService tenantAccountService;
    @CjServiceRef
    IUcRoleService ucRoleService;
    @CjServiceRef
    IUcEmployeeService ucEmployeeService;

    @CjTransaction
    @Override
    public long getUserCount() throws CircuitException {
        UcUserExample example = new UcUserExample();
        return userMapper.countByExample(example);
    }

    @Override
    public List<UcUser> pageUser(int currPage, int pageSize) throws CircuitException {
        return userMapper.pageUser(currPage, pageSize);
    }

    @CjTransaction
    @Override
    public boolean existsUserName(String userName) throws CircuitException {
        UcUserExample example = new UcUserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        return userMapper.countByExample(example) > 0;
    }

    @CjTransaction
    @Override
    public UcUser registerByPassword(String tenant, String accountName, String password) throws CircuitException {
        if (existsUserName(accountName)) {
            throw new CircuitException("500", "已存在用户名：" + accountName);
        }

        UcUser user = new UcUser();
        user.setCreateTime(new Date());
        user.setUserName(accountName);
        user.setUserId(NumberGen.gen());
        userMapper.insert(user);

        TenantAccount account = new TenantAccount();
        account.setAccountId(UUID.randomUUID().toString());
        account.setTenantId(tenant);
        account.setUserId(user.getUserId());
        account.setAccountName(accountName);
        account.setAccountPwd(password);
        account.setCreateTime(new Date());
        this.tenantAccountService.addAccount(account);
        return user;
    }

    @CjTransaction
    @Override
    public UcUser registerByIphone(String tenant, String phone, String password) throws CircuitException {
        if (existsUserName(phone)) {
            throw new CircuitException("500", "已存在用户名：" + phone);
        }
        UcUser user = new UcUser();
        user.setCreateTime(new Date());
        user.setUserName(phone);
        user.setUserId(NumberGen.gen());
        userMapper.insert(user);

        TenantAccount account = new TenantAccount();
        account.setAccountId(UUID.randomUUID().toString());
        account.setTenantId(tenant);
        account.setUserId(user.getUserId());
        account.setAccountName(phone);
        account.setNameKind((byte) 1);
        account.setAccountPwd(password);
        account.setCreateTime(new Date());
        this.tenantAccountService.addAccount(account);
        return user;
    }

    @CjTransaction
    @Override
    public UcUser registerByEmail(String tenant, String email, String password) throws CircuitException {
        if (existsUserName(email)) {
            throw new CircuitException("500", "已存在用户名：" + email);
        }
        UcUser user = new UcUser();
        user.setCreateTime(new Date());
        user.setUserName(email);
        user.setUserId(NumberGen.gen());
        userMapper.insert(user);

        TenantAccount account = new TenantAccount();
        account.setAccountId(UUID.randomUUID().toString());
        account.setTenantId(tenant);
        account.setUserId(user.getUserId());
        account.setAccountName(email);
        account.setAccountPwd(password);
        account.setCreateTime(new Date());
        account.setNameKind((byte) 2);
        this.tenantAccountService.addAccount(account);
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
    public List<UcRole> pageRoleInUser(String uid, int currPage, int pageSize) throws CircuitException {
        return userMapper.pageRoleInUser(uid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public void addRoleToUser(String roleid, String uid) throws CircuitException {
        if (getUserById(uid) == null) {
            throw new CircuitException("404", "不存在用户标识:" + uid);
        }
        if (ucRoleService.getRole(roleid) == null) {
            throw new CircuitException("404", "不存在角色标识:" + uid);
        }
        UaRoleUserKey key = new UaRoleUserKey();
        key.setRoleId(roleid);
        key.setUserId(uid);
        roleUserMapper.insertSelective(key);
    }

    @CjTransaction
    @Override
    public void removeRoleFromUser(String roleid, String uid) throws CircuitException {
        UaRoleUserKey key = new UaRoleUserKey();
        key.setRoleId(roleid);
        key.setUserId(uid);
        roleUserMapper.deleteByPrimaryKey(key);
    }

    @CjTransaction
    @Override
    public boolean isEmployee(String uid) throws CircuitException {
        return !ucEmployeeService.listMyEmployee(uid).isEmpty();
    }
}
