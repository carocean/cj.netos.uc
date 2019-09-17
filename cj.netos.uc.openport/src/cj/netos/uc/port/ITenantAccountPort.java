package cj.netos.uc.port;

import cj.netos.uc.domain.TenantAccount;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;

import java.util.List;

public interface ITenantAccountPort extends IOpenportService {
    String addAccount(String tenantid, String uid, String accountName, byte namekind, String pwd) throws CircuitException;

    void removeAccount(String accountid) throws CircuitException;

    List<TenantAccount> pageAccount(String tenantid, int currPage, int pageSize) throws CircuitException;

    List<TenantAccount> listAccount(String uid) throws CircuitException;

    TenantAccount getAccount(String accountid) throws CircuitException;

    void setAccountEnable(boolean enable) throws CircuitException;
}
