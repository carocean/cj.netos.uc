package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.AppAccount;
import cj.netos.uc.domain.AppAccountExample;
import cj.netos.uc.domain.UcUser;
import cj.netos.uc.plugin.dao.AppAccountMapper;
import cj.netos.uc.service.IAppAccountService;
import cj.netos.uc.service.IUcUserService;
import cj.netos.uc.util.Encript;
import cj.netos.uc.util.NumberGen;
import cj.studio.ecm.IServiceSetter;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.util.StringUtil;

import java.util.Date;
import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "appAccountService")
public class AppAccountService implements IAppAccountService, IServiceSetter {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.AppAccountMapper")
    AppAccountMapper accountMapper;
    IUcUserService ucUserService;

    @Override
    public void setService(String serviceId, Object service) {
        ucUserService = (IUcUserService) service;
    }

    @CjTransaction
    @Override
    public UcUser getUser(String appid, String accountName) {
        AppAccountExample example = new AppAccountExample();
        example.createCriteria().andAppIdEqualTo(appid).andAccountNameEqualTo(accountName);
        List<AppAccount> list = accountMapper.selectByExample(example);
        if (list.isEmpty()) return null;
        AppAccount account = list.get(0);
        return ucUserService.getUserById(account.getUserId());
    }

    @CjTransaction
    @Override
    public String addAccount(String accountName, byte nameKind, String userId, String appId, String accountPwd) throws CircuitException {
        if (StringUtil.isEmpty(accountName)) {
            throw new CircuitException("404", "缺少账户名");
        }
        if (StringUtil.isEmpty(appId)) {
            throw new CircuitException("404", "缺少应用编号");
        }
        if (StringUtil.isEmpty(userId)) {
            throw new CircuitException("404", "缺少用户编号");
        }
        if (existsAccount(appId, accountName)) {
            throw new CircuitException("500", String.format("用户%s在应用%s下已存在账户名：%s", userId, appId, accountName));
        }
        AppAccount appAccount = new AppAccount();
        appAccount.setAppId(appId);
        appAccount.setAccountId(NumberGen.gen());
        appAccount.setAccountName(accountName);
        appAccount.setAccountPwd(Encript.md5(accountPwd));
        appAccount.setCreateTime(new Date());
        appAccount.setIsEnable((byte) 1);
        appAccount.setNameKind(nameKind);
        appAccount.setUserId(userId);
        accountMapper.insertSelective(appAccount);
        return appAccount.getAccountId();
    }

    @CjTransaction
    @Override
    public void addByPassword(String uid, String appid, String accountName, String password) throws CircuitException {
        if (ucUserService.getUserCount() < 1) {
            throw new CircuitException("404", "用户不存在");
        }
        if (existsAccount(appid, accountName)) {
            throw new CircuitException("500", String.format("用户%s在应用%s下已存在账户名：%s", uid, appid, accountName));
        }
        password = Encript.md5(password);
        AppAccount account = new AppAccount();
        account.setAccountId(NumberGen.gen());
        account.setAppId(appid);
        account.setUserId(uid);
        account.setAccountName(accountName);
        account.setAccountPwd(password);
        account.setCreateTime(new Date());
        account.setNameKind((byte) 2);
        accountMapper.insertSelective(account);
    }

    @CjTransaction
    @Override
    public void addByIphone(String uid, String appid, String phone, String password) throws CircuitException {
        if (ucUserService.getUserCount() < 1) {
            throw new CircuitException("404", "用户不存在");
        }
        if (existsAccount(appid, phone)) {
            throw new CircuitException("500", String.format("用户%s在应用%s下已存在账户名：%s", uid, appid, phone));
        }
        password = Encript.md5(password);
        AppAccount account = new AppAccount();
        account.setAccountId(NumberGen.gen());
        account.setAppId(appid);
        account.setUserId(uid);
        account.setAccountName(phone);
        account.setAccountPwd(password);
        account.setCreateTime(new Date());
        account.setNameKind((byte) 2);
        accountMapper.insertSelective(account);
    }

    @CjTransaction
    @Override
    public void addByEmail(String uid, String appid, String email, String password) throws CircuitException {
        if (ucUserService.getUserCount() < 1) {
            throw new CircuitException("404", "用户不存在");
        }
        if (existsAccount(appid, email)) {
            throw new CircuitException("500", String.format("用户%s在应用%s下已存在账户名：%s", uid, appid, email));
        }
        password = Encript.md5(password);
        AppAccount account = new AppAccount();
        account.setAccountId(NumberGen.gen());
        account.setAppId(appid);
        account.setUserId(uid);
        account.setAccountName(email);
        account.setAccountPwd(password);
        account.setCreateTime(new Date());
        account.setNameKind((byte) 2);
        accountMapper.insertSelective(account);
    }

    @CjTransaction
    @Override
    public void removeAccount(String accountid) throws CircuitException {
        accountMapper.deleteByPrimaryKey(accountid);
    }

    @CjTransaction
    @Override
    public List<AppAccount> pageAccount(String appid, int currPage, int pageSize) throws CircuitException {
        return accountMapper.pageAccount(appid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public List<AppAccount> listAccount(String uid) throws CircuitException {
        AppAccountExample example = new AppAccountExample();
        example.createCriteria().andUserIdEqualTo(uid);
        return accountMapper.selectByExample(example);
    }


    @CjTransaction
    @Override
    public AppAccount getAccount(String accountid) throws CircuitException {
        return accountMapper.selectByPrimaryKey(accountid);
    }

    @CjTransaction
    @Override
    public void setAccountEnable(String accountid, boolean enable) throws CircuitException {
        accountMapper.updateAccountEnable(accountid, enable);
    }

    @CjTransaction
    @Override
    public boolean existsAccount(String appid, String accountName) throws CircuitException {
        AppAccountExample example = new AppAccountExample();
        example.createCriteria().andAppIdEqualTo(appid).andAccountNameEqualTo(accountName);
        return this.accountMapper.countByExample(example) > 0;
    }

    @CjTransaction
    @Override
    public AppAccount getAccountByName(String appid, String accountName) {
        AppAccountExample example = new AppAccountExample();
        example.createCriteria().andAppIdEqualTo(appid).andAccountNameEqualTo(accountName);

        List<AppAccount> list = accountMapper.selectByExample(example);
        if (list.isEmpty()) return null;
        return list.get(0);
    }

    @CjTransaction
    @Override
    public void updatePwd(String accountId, String newpwd) {
        accountMapper.updatePwd(accountId, newpwd);
    }
}
