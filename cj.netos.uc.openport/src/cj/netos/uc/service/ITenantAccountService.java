package cj.netos.uc.service;

import cj.netos.uc.domain.TenantAccount;
import cj.netos.uc.domain.UcUser;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface ITenantAccountService {
    String addAccount(TenantAccount account) throws CircuitException;

    void addByIphone(String uid, String tenant, String phone, String password) throws CircuitException;

    void addByEmail(String uid, String tenant, String email, String password) throws CircuitException;

    void removeAccount(String accountid) throws CircuitException;

    List<TenantAccount> pageAccount(String tenantid, int currPage, int pageSize) throws CircuitException;

    List<TenantAccount> listAccount(String uid) throws CircuitException;

    UcUser getUser(String tenant, String accountName) throws CircuitException;

    TenantAccount getAccount(String accountid) throws CircuitException;

    void setAccountEnable(String accountid,boolean enable) throws CircuitException;

    boolean existsAccount(String tenant, String userId, String accountName) throws CircuitException;

}
