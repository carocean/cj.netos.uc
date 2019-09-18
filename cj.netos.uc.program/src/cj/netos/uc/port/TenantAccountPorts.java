package cj.netos.uc.port;

import cj.netos.uc.domain.TenantAccount;
import cj.netos.uc.domain.UcUser;
import cj.netos.uc.service.ITenantAccountService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

@CjService(name = "/tenant/account")
public class TenantAccountPorts implements ITenantAccountPort {
    @CjServiceRef(refByName = "ucplugin.tenantAccountService")
    ITenantAccountService tenantAccountService;

    @Override
    public String addAccount(TenantAccount account) throws CircuitException {
        return tenantAccountService.addAccount(account);
    }

    @Override
    public void addByIphone(String uid, String tenant, String phone, String password) throws CircuitException {
        tenantAccountService.addByIphone(uid, tenant, phone, password);
    }

    @Override
    public void addByEmail(String uid, String tenant, String email, String password) throws CircuitException {
        tenantAccountService.addByEmail(uid, tenant, email, password);
    }

    @Override
    public UcUser getUser(String tenant, String accountName) throws CircuitException {
        return tenantAccountService.getUser(tenant, accountName);
    }

    @Override
    public void removeAccount(String accountid) throws CircuitException {
        tenantAccountService.removeAccount(accountid);
    }

    @Override
    public List<TenantAccount> pageAccount(String tenantid, int currPage, int pageSize) throws CircuitException {
        return tenantAccountService.pageAccount(tenantid, currPage, pageSize);
    }

    @Override
    public List<TenantAccount> listAccount(String uid) throws CircuitException {
        return tenantAccountService.listAccount(uid);
    }

    @Override
    public TenantAccount getAccount(String accountid) throws CircuitException {
        return tenantAccountService.getAccount(accountid);
    }

    @Override
    public void setAccountEnable(String accountid,boolean enable) throws CircuitException {
        tenantAccountService.setAccountEnable(accountid,enable);
    }
}
