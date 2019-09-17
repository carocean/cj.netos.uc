package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.*;
import cj.netos.uc.plugin.dao.TenantAccountMapper;
import cj.netos.uc.plugin.dao.UcUserMapper;
import cj.netos.uc.plugin.util.NumberGen;
import cj.netos.uc.service.IUcUserService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@CjService(name = "ucUserService")
public class UcUserService implements IUcUserService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UcUserMapper")
    UcUserMapper userMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.TenantAccountMapper")
    TenantAccountMapper accountMapper;

    @CjTransaction
    @Override
    public UcUser registerByPassword(String tenant, String accountName, String password) {
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
        accountMapper.insertSelective(account);


        return user;
    }

    @CjTransaction
    @Override
    public UcUser registerByIphone(String tenant, String phone, String password) {
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
        accountMapper.insertSelective(account);
        return user;
    }

    @CjTransaction
    @Override
    public UcUser registerByEmail(String tenant, String email, String password) {
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
        accountMapper.insertSelective(account);
        return user;
    }
    @CjTransaction
    @Override
    public UcUser addByIphone(String uid, String tenant, String phone, String password) throws CircuitException {
        UcUser user = getUserById(uid);
        if(user==null){
            throw new CircuitException("404","用户不存在");
        }
        TenantAccount account = new TenantAccount();
        account.setAccountId(UUID.randomUUID().toString());
        account.setTenantId(tenant);
        account.setUserId(user.getUserId());
        account.setAccountName(phone);
        account.setAccountPwd(password);
        account.setCreateTime(new Date());
        account.setNameKind((byte) 2);
        accountMapper.insertSelective(account);
        return user;
    }
    @CjTransaction
    @Override
    public UcUser addByEmail(String uid, String tenant, String email, String password) throws CircuitException {
        UcUser user = getUserById(uid);
        if(user==null){
            throw new CircuitException("404","用户不存在");
        }
        TenantAccount account = new TenantAccount();
        account.setAccountId(UUID.randomUUID().toString());
        account.setTenantId(tenant);
        account.setUserId(user.getUserId());
        account.setAccountName(email);
        account.setAccountPwd(password);
        account.setCreateTime(new Date());
        account.setNameKind((byte) 2);
        accountMapper.insertSelective(account);
        return user;
    }
    @CjTransaction
    @Override
    public UcUser getUserById(String uid) {
        return  userMapper.selectByPrimaryKey(uid);
    }

    @CjTransaction
    @Override
    public UcUser getUser(String tenant, String accountName) {
        TenantAccountExample example = new TenantAccountExample();
        example.createCriteria().andTenantIdEqualTo(tenant).andAccountNameEqualTo(accountName);
        List<TenantAccount> list = accountMapper.selectByExample(example);
        if(list.isEmpty())return null;
        TenantAccount account=list.get(0);
        return userMapper.selectByPrimaryKey(account.getUserId());
    }

    @CjTransaction
    @Override
    public void updateProfile(String uid, UcUser user) {

    }

    @CjTransaction
    @Override
    public List<UcUserAttrVal> listAttributeValue(String uid, String segmentid) {
        return null;
    }

    @CjTransaction
    @Override
    public void setAttributeValue(String uid, String attributeid, String value) {

    }

    @CjTransaction
    @Override
    public UcUserAttrVal getAttributeValue(String uid, String attibuteid) {
        return null;
    }

    @CjTransaction
    @Override
    public void emptyAttributes(String uid, String segmentid) {

    }

    @CjTransaction
    @Override
    public void addSegment(String name) {

    }

    @CjTransaction
    @Override
    public List<UcUserSegment> listSegment() {
        return null;
    }

    @CjTransaction
    @Override
    public void removeSegment(String segmentid) {

    }

    @CjTransaction
    @Override
    public void addAttribute(String segmentid, String name, String type, int sort) {

    }

    @CjTransaction
    @Override
    public UcUserAttr getAttibute(String attributeid) {
        return null;
    }

    @CjTransaction
    @Override
    public List<UcUserAttr> listAttribue(String segmentid) {
        return null;
    }

    @CjTransaction
    @Override
    public void removeAttribute(String attibuteid) {

    }

    @CjTransaction
    @Override
    public List<UcRole> pageRoleInUser(String uid, int currPage, int pageSize) throws CircuitException {
        return null;
    }

    @CjTransaction
    @Override
    public void addRoleToUser(String roleid, String uid) throws CircuitException {

    }

    @CjTransaction
    @Override
    public void removeRoleFromUser(String roleid, String uid) throws CircuitException {

    }

    @CjTransaction
    @Override
    public boolean isEmployee(String uid) throws CircuitException {
        return false;
    }
}
