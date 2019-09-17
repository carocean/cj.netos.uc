package cj.netos.uc.service;

import cj.netos.uc.domain.TenantAccount;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface ITenantAccountService {
    String addAccount(TenantAccount account) throws CircuitException;

    void removeAccount(String accountid) throws CircuitException;

    List<TenantAccount> pageAccount(String tenantid, int currPage, int pageSize) throws CircuitException;

    List<TenantAccount> listAccount(String uid) throws CircuitException;

    TenantAccount getAccount(String accountid) throws CircuitException;

    void setAccountEnable(boolean enable) throws CircuitException;
}
