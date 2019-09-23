package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.TenantAccount;
import cj.netos.uc.domain.TenantAccountExample;
import cj.netos.uc.domain.UcUser;
import cj.netos.uc.plugin.dao.TenantAccountMapper;
import cj.netos.uc.util.Encript;
import cj.netos.uc.util.NumberGen;
import cj.netos.uc.service.ITenantAccountService;
import cj.netos.uc.service.IUcUserService;
import cj.studio.ecm.IServiceSetter;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.Date;
import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "tenantAccountService")
public class TenantAccountService implements ITenantAccountService, IServiceSetter {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.TenantAccountMapper")
    TenantAccountMapper accountMapper;
    IUcUserService ucUserService;

    @Override
    public void setService(String serviceId, Object service) {
        ucUserService = (IUcUserService) service;
    }

    @CjTransaction
    @Override
    public UcUser getUser(String tenant, String accountName) {
        TenantAccountExample example = new TenantAccountExample();
        example.createCriteria().andTenantIdEqualTo(tenant).andAccountNameEqualTo(accountName);
        List<TenantAccount> list = accountMapper.selectByExample(example);
        if (list.isEmpty()) return null;
        TenantAccount account = list.get(0);
        return ucUserService.getUserById(account.getUserId());
    }

    @CjTransaction
    @Override
    public String addAccount(TenantAccount account) throws CircuitException {
        if (existsAccount(account.getTenantId(), account.getAccountName())) {
            throw new CircuitException("500", String.format("用户%s在租户%s下已存在账户名：%s", account.getUserId(), account.getTenantId(), account.getAccountName()));
        }
        accountMapper.insertSelective(account);
        return null;
    }

    @CjTransaction
    @Override
    public void addByIphone(String uid, String tenant, String phone, String password) throws CircuitException {
        if (ucUserService.getUserCount() < 1) {
            throw new CircuitException("404", "用户不存在");
        }
        if (ucUserService.existsUserName(phone)) {
            throw new CircuitException("500", "已存在用户名：" + phone);
        }
        password = Encript.md5(password);
        TenantAccount account = new TenantAccount();
        account.setAccountId(NumberGen.gen());
        account.setTenantId(tenant);
        account.setUserId(uid);
        account.setAccountName(phone);
        account.setAccountPwd(password);
        account.setCreateTime(new Date());
        account.setNameKind((byte) 2);
        accountMapper.insertSelective(account);
    }

    @CjTransaction
    @Override
    public void addByEmail(String uid, String tenant, String email, String password) throws CircuitException {
        if (ucUserService.getUserCount() < 1) {
            throw new CircuitException("404", "用户不存在");
        }
        if (ucUserService.existsUserName(email)) {
            throw new CircuitException("500", "已存在用户名：" + email);
        }
        password = Encript.md5(password);
        TenantAccount account = new TenantAccount();
        account.setAccountId(NumberGen.gen());
        account.setTenantId(tenant);
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
    public List<TenantAccount> pageAccount(String tenantid, int currPage, int pageSize) throws CircuitException {
        return accountMapper.pageAccount(tenantid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public List<TenantAccount> listAccount(String uid) throws CircuitException {
        TenantAccountExample example = new TenantAccountExample();
        example.createCriteria().andUserIdEqualTo(uid);
        return accountMapper.selectByExample(example);
    }


    @CjTransaction
    @Override
    public TenantAccount getAccount(String accountid) throws CircuitException {
        return accountMapper.selectByPrimaryKey(accountid);
    }

    @CjTransaction
    @Override
    public void setAccountEnable(String accountid, boolean enable) throws CircuitException {
        accountMapper.updateAccountEnable(accountid, enable);
    }

    @CjTransaction
    @Override
    public boolean existsAccount(String tenant, String accountName) throws CircuitException {
        TenantAccountExample example = new TenantAccountExample();
        example.createCriteria().andTenantIdEqualTo(tenant).andAccountNameEqualTo(accountName);
        return this.accountMapper.countByExample(example) > 0;
    }

    @CjTransaction
    @Override
    public TenantAccount getAccountByName(String tenantid, String accountName) {
        TenantAccountExample example = new TenantAccountExample();
        example.createCriteria().andTenantIdEqualTo(tenantid).andAccountNameEqualTo(accountName);

        List<TenantAccount> list = accountMapper.selectByExample(example);
        if (list.isEmpty()) return null;
        return list.get(0);
    }

    @CjTransaction
    @Override
    public void updatePwd(String accountId, String newpwd) {
        accountMapper.updatePwd(accountId,newpwd);
    }
}
