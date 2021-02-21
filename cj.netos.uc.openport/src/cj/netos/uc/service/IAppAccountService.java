package cj.netos.uc.service;

import cj.netos.uc.model.AppAccount;
import cj.netos.uc.model.UcUser;
import cj.studio.ecm.net.CircuitException;

import java.util.List;
import java.util.Map;

public interface IAppAccountService {
    String addAccount(String accountName, byte nameKind, String userId, String appId, String accountPwd, String nickName, String avatar, String signature) throws CircuitException;

    String addAccountBy(String accountName, String sourceSubSystem, String sourceOpenid, byte nameKind, String userId, String appId, String accountPwd, String nickName, String avatar, String signature) throws CircuitException;


    void addByPassword(String uid, String appid, String accountCode, String password, String nickName, String avatar, String signature) throws CircuitException;


    void addByIphone(String uid, String appid, String phone, String password, String nickName, String avatar, String signature) throws CircuitException;


    void addByEmail(String uid, String appid, String email, String password, String nickName, String avatar, String signature) throws CircuitException;

    void removeAccount(String accountid) throws CircuitException;

    List<AppAccount> pageAccount(String appid, long currPage, int pageSize) throws CircuitException;


    UcUser getUser(String appid, String accountName) throws CircuitException;

    AppAccount getAccount(String accountid) throws CircuitException;

    void setAccountEnable(String accountid, boolean enable) throws CircuitException;

    boolean existsAccount(String appid, String accountName) throws CircuitException;

    AppAccount getAccountByCode(String appid, String accountName);

    void updatePwd(String accountId, String newpwd);

    List<AppAccount> listAllAccount(String uid) throws CircuitException;

    List<AppAccount> listAccountByAppidAndUid(String appid, String userId);

    void removeAccount(String accountName, String appid);

    void updateAvatar(String accountId, String avatar);

    void updateSignature(String accountId, String signature);

    void updateNickName(String accountId, String nickName);

    Map<String, Object> sendVerifyCode(String principal, String phone) throws CircuitException;

    List<AppAccount> findAccounts(String keywords);

    boolean verifyCode(String appid, String phone, String verifyCode) throws CircuitException;

    List<AppAccount> findAccountsInApp(String appid, String keywords);

    boolean existsSource(String accountId, String subSystem);

    Map<String, String> listSource(String accountId);

    void addSource(String accountId, String subSystem, String openid);

}
