package cj.netos.uc.service;

import cj.netos.uc.domain.AppAccount;
import cj.netos.uc.domain.UcUser;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IAppAccountService {
    String addAccount(String accountName, byte nameKind, String userId, String appId, String accountPwd) throws CircuitException;

    void addByPassword(String uid, String appid, String accountName, String password) throws CircuitException;

    void addByIphone(String uid, String appid, String phone, String password) throws CircuitException;

    void addByEmail(String uid, String appid, String email, String password) throws CircuitException;

    void removeAccount(String accountid) throws CircuitException;

    List<AppAccount> pageAccount(String appid, int currPage, int pageSize) throws CircuitException;

    List<AppAccount> listAccount(String uid) throws CircuitException;

    UcUser getUser(String appid, String accountName) throws CircuitException;

    AppAccount getAccount(String accountid) throws CircuitException;

    void setAccountEnable(String accountid, boolean enable) throws CircuitException;

    boolean existsAccount(String appid, String accountName) throws CircuitException;

    AppAccount getAccountByName(String appid, String accountName);

    void updatePwd(String accountId, String newpwd);

}
