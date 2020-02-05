package cj.netos.uc.plugin.service;

import cj.netos.uc.model.AppAccount;
import cj.netos.uc.model.AppAccountExample;
import cj.netos.uc.model.UcUser;
import cj.netos.uc.plugin.mapper.AppAccountMapper;
import cj.netos.uc.service.IAppAccountService;
import cj.netos.uc.service.IAppRoleService;
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
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.AppAccountMapper")
    AppAccountMapper accountMapper;
    IUcUserService ucUserService;
    @CjServiceRef(refByName = "tenantAppRoleService")
    IAppRoleService appRoleService;

    @Override
    public void setService(String serviceId, Object service) {
        ucUserService = (IUcUserService) service;
    }

    @CjTransaction
    @Override
    public UcUser getUser(String appid, String accountCode) {
        AppAccountExample example = new AppAccountExample();
        example.createCriteria().andAppIdEqualTo(appid).andAccountCodeEqualTo(accountCode);
        List<AppAccount> list = accountMapper.selectByExample(example);
        if (list.isEmpty()) return null;
        AppAccount account = list.get(0);
        return ucUserService.getUserById(account.getUserId());
    }

    @CjTransaction
    @Override
    public String addAccount(String accountCode, byte nameKind, String userId, String appId, String accountPwd, String nickName, String avatar, String signature) throws CircuitException {
        if (StringUtil.isEmpty(accountCode)) {
            throw new CircuitException("404", "缺少账户名");
        }
        if (StringUtil.isEmpty(appId)) {
            throw new CircuitException("404", "缺少应用编号");
        }
        if (StringUtil.isEmpty(userId)) {
            throw new CircuitException("404", "缺少用户编号");
        }
        if (existsAccount(appId, accountCode)) {
            throw new CircuitException("500", String.format("用户%s在应用%s下已存在账户名：%s", userId, appId, accountCode));
        }
        AppAccount account = new AppAccount();
        account.setAppId(appId);
        account.setAccountId(String.format("%s@%s", accountCode, appId));
        account.setAccountCode(accountCode);
        account.setAccountPwd(Encript.md5(accountPwd));
        account.setCreateTime(new Date());
        account.setIsEnable((byte) 1);
        account.setNameKind(nameKind);
        account.setUserId(userId);
        account.setNickName(nickName);
        account.setAvatar(avatar);
        account.setSignature(signature);
        accountMapper.insertSelective(account);
        String tenantid = appId.substring(appId.indexOf(".") + 1, appId.length());
        this.appRoleService.addAccountToRole(appId, account.getAccountId(), String.format("users@%s", appId), tenantid, account.getUserId());
        return account.getAccountId();
    }

    @CjTransaction
    @Override
    public void addByPassword(String uid, String appid, String accountCode, String password, String nickName, String avatar, String signature) throws CircuitException {
        if (ucUserService.getUserCount() < 1) {
            throw new CircuitException("404", "用户不存在");
        }
        if (existsAccount(appid, accountCode)) {
            throw new CircuitException("500", String.format("用户%s在应用%s下已存在账户名：%s", uid, appid, accountCode));
        }
        AppAccount account = new AppAccount();
        account.setAccountId(String.format("%s@%s", accountCode, appid));
        account.setAppId(appid);
        account.setUserId(uid);
        account.setAccountCode(accountCode);
        account.setAccountPwd(Encript.md5(password));
        account.setCreateTime(new Date());
        account.setNameKind((byte) 2);
        account.setNickName(nickName);
        account.setAvatar(avatar);
        account.setSignature(signature);
        accountMapper.insertSelective(account);
        String tenantid = appid.substring(appid.indexOf(".") + 1, appid.length());
        this.appRoleService.addAccountToRole(appid, account.getAccountId(), String.format("users@%s", appid), tenantid, account.getUserId());
    }

    @CjTransaction
    @Override
    public void addByIphone(String uid, String appid, String phone, String password, String nickName, String avatar, String signature) throws CircuitException {
        if (ucUserService.getUserCount() < 1) {
            throw new CircuitException("404", "用户不存在");
        }
        if (existsAccount(appid, phone)) {
            throw new CircuitException("500", String.format("用户%s在应用%s下已存在账户名：%s", uid, appid, phone));
        }
        AppAccount account = new AppAccount();
        account.setAccountId(String.format("%s@%s", phone, appid));
        account.setAppId(appid);
        account.setUserId(uid);
        account.setAccountCode(phone);
        account.setAccountPwd(Encript.md5(password));
        account.setCreateTime(new Date());
        account.setNameKind((byte) 2);
        account.setNickName(nickName);
        account.setAvatar(avatar);
        account.setSignature(signature);
        accountMapper.insertSelective(account);
        String tenantid = appid.substring(appid.indexOf(".") + 1, appid.length());
        this.appRoleService.addAccountToRole(appid, account.getAccountId(), String.format("users@%s", appid), tenantid, account.getUserId());
    }

    @CjTransaction
    @Override
    public void addByEmail(String uid, String appid, String email, String password, String nickName, String avatar, String signature) throws CircuitException {
        if (ucUserService.getUserCount() < 1) {
            throw new CircuitException("404", "用户不存在");
        }
        if (existsAccount(appid, email)) {
            throw new CircuitException("500", String.format("用户%s在应用%s下已存在账户名：%s", uid, appid, email));
        }
        AppAccount account = new AppAccount();
        account.setAccountId(String.format("%s@%s", Encript.md5(email), appid));
        account.setAccountCode(email);
        account.setAppId(appid);
        account.setUserId(uid);
        account.setAccountCode(email);
        account.setAccountPwd(Encript.md5(password));
        account.setCreateTime(new Date());
        account.setNameKind((byte) 2);
        account.setNickName(nickName);
        account.setAvatar(avatar);
        account.setSignature(signature);
        accountMapper.insertSelective(account);
        String tenantid = appid.substring(appid.indexOf(".") + 1, appid.length());
        this.appRoleService.addAccountToRole(appid, account.getAccountId(), String.format("users@%s", appid), tenantid, account.getUserId());
    }

    @CjTransaction
    @Override
    public void removeAccount(String accountid) throws CircuitException {
        accountMapper.deleteByPrimaryKey(accountid);
    }

    @CjTransaction
    @Override
    public List<AppAccount> pageAccount(String appid, long currPage, int pageSize) throws CircuitException {
        return accountMapper.pageAccount(appid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public List<AppAccount> listAllAccount(String uid) throws CircuitException {
        AppAccountExample example = new AppAccountExample();
        example.createCriteria().andUserIdEqualTo(uid);
        return accountMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public List<AppAccount> listAccountByAppidAndUid(String appid, String userId) {
        AppAccountExample example = new AppAccountExample();
        example.createCriteria().andUserIdEqualTo(userId).andAppIdEqualTo(appid);
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
        accountMapper.updateAccountEnable(accountid, (byte)(enable?1:0));
    }

    @CjTransaction
    @Override
    public boolean existsAccount(String appid, String accountCode) throws CircuitException {
        AppAccountExample example = new AppAccountExample();
        example.createCriteria().andAppIdEqualTo(appid).andAccountCodeEqualTo(accountCode);
        return this.accountMapper.countByExample(example) > 0;
    }

    @CjTransaction
    @Override
    public AppAccount getAccountByCode(String appid, String accountCode) {
        AppAccountExample example = new AppAccountExample();
        example.createCriteria().andAppIdEqualTo(appid).andAccountCodeEqualTo(accountCode);

        List<AppAccount> list = accountMapper.selectByExample(example);
        if (list.isEmpty()) return null;
        return list.get(0);
    }

    @CjTransaction
    @Override
    public void removeAccount(String accountCode, String appid) {
        AppAccountExample example = new AppAccountExample();
        example.createCriteria().andAppIdEqualTo(appid).andAccountCodeEqualTo(accountCode);
        accountMapper.deleteByExample(example);
    }

    @CjTransaction
    @Override
    public void updatePwd(String accountId, String newpwd) {
        accountMapper.updatePwd(accountId, Encript.md5(newpwd));
    }

    @CjTransaction
    @Override
    public void updateAvatar(String accountid, String avatar) {
        accountMapper.updateAvatar(accountid, avatar);
    }

    @CjTransaction
    @Override
    public void updateSignature(String accountId, String signature) {
        accountMapper.updateSignature(accountId, signature);
    }

    @CjTransaction
    @Override
    public void updateNickName(String accountId, String nickName) {
        accountMapper.updateNickName(accountId, nickName);
    }
}
