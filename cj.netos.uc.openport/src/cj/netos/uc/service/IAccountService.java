package cj.netos.uc.service;

import cj.netos.uc.domain.TenantAccount;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IAccountService {
    String addAccount(String tenantid, String uid, String accountName, byte namekind, String pwd) throws CircuitException;

    void removeAccount(String accountid) throws CircuitException;

    List<TenantAccount> pageAccount(String tenantid, int currPage, int pageSize) throws CircuitException;

    List<TenantAccount> listAccount(String uid) throws CircuitException;

    TenantAccount getAccount(String accountid) throws CircuitException;

    void setAccountEnable(boolean enable) throws CircuitException;
}
