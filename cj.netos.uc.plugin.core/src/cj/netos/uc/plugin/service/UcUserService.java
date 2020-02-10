package cj.netos.uc.plugin.service;

import cj.netos.uc.model.*;
import cj.netos.uc.plugin.mapper.UcUserMapper;
import cj.netos.uc.service.IAppAccountService;
import cj.netos.uc.service.IUcEmployeeService;
import cj.netos.uc.service.IUcUserService;
import cj.netos.uc.util.NumberGen;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceInvertInjection;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.util.StringUtil;

import java.util.Date;
import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "ucUserService")
public class UcUserService implements IUcUserService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.UcUserMapper")
    UcUserMapper userMapper;

    @CjServiceInvertInjection
    @CjServiceRef(refByName = "appAccountService")
    IAppAccountService appAccountService;

    @CjServiceRef
    IUcEmployeeService ucEmployeeService;

    @CjTransaction
    @Override
    public String addUser(String uid, String realName, String sex, String email, String mobile, String idcard) throws CircuitException {
        if (StringUtil.isEmpty(realName)) {
            throw new CircuitException("404", "真实名为空");
        }
        UcUser ucUser = new UcUser();
        ucUser.setUserId(StringUtil.isEmpty(uid) ? NumberGen.gen() : uid);
        ucUser.setCreateTime(new Date());
        ucUser.setRealName(realName);
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
    public UcUser registerByPassword(String appid, String accountCode, String password, String nickName, String avatar, String signature) throws CircuitException {
        if (StringUtil.isEmpty(appid)) {
            throw new CircuitException("404", "应用标识为空");
        }
        if (StringUtil.isEmpty(accountCode)) {
            throw new CircuitException("404", "账户名为空");
        }
        if (StringUtil.isEmpty(password)) {
            throw new CircuitException("404", "密码为空");
        }

        UcUser user = new UcUser();
        user.setCreateTime(new Date());
        user.setRealName(accountCode);
        user.setUserId(NumberGen.gen());
        userMapper.insert(user);

        this.appAccountService.addAccount(accountCode, (byte) 0, user.getUserId(), appid, password,nickName,avatar,signature);
        return user;
    }

    @CjTransaction
    @Override
    public UcUser registerByIphone(String appid, String phone, String password, String nickName, String avatar, String signature) throws CircuitException {
        if (StringUtil.isEmpty(appid)) {
            throw new CircuitException("404", "应用标识为空");
        }
        if (StringUtil.isEmpty(phone)) {
            throw new CircuitException("404", "手机号为空");
        }
        if (StringUtil.isEmpty(password)) {
            throw new CircuitException("404", "密码为空");
        }

        UcUser user = new UcUser();
        user.setCreateTime(new Date());
        user.setRealName(phone);
        user.setUserId(NumberGen.gen());
        user.setMobile(phone);
        userMapper.insert(user);

        this.appAccountService.addAccount(phone, (byte) 1, user.getUserId(), appid, password,nickName,avatar,signature);
        return user;
    }

    @CjTransaction
    @Override
    public UcUser registerByEmail(String appid, String email, String password, String nickName, String avatar, String signature) throws CircuitException {
        if (StringUtil.isEmpty(appid)) {
            throw new CircuitException("404", "应用标识为空");
        }
        if (StringUtil.isEmpty(email)) {
            throw new CircuitException("404", "邮箱为空");
        }
        if (StringUtil.isEmpty(password)) {
            throw new CircuitException("404", "密码为空");
        }

        UcUser user = new UcUser();
        user.setCreateTime(new Date());
        user.setRealName(email);
        user.setUserId(NumberGen.gen());
        user.setEmail(email);
        userMapper.insert(user);

        this.appAccountService.addAccount(email, (byte) 2, user.getUserId(), appid, password,nickName,avatar,signature);
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
    public void updateRealName(String userId, String realName) throws CircuitException {
        userMapper.updateRealName(userId,realName);
    }
    @CjTransaction
    @Override
    public void updateSex(String userId, String sex) {
        userMapper.updateSex(userId,sex);
    }

    @CjTransaction
    @Override
    public boolean isEmployee(String uid) throws CircuitException {
        return !ucEmployeeService.listMyEmployee(uid).isEmpty();
    }
}
