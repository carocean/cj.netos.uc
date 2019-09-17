package cj.netos.uc.port;

import cj.netos.uc.domain.TenantAccount;
import cj.netos.uc.domain.TenantApp;
import cj.netos.uc.domain.TenantRole;
import cj.netos.uc.domain.UcTenant;
import cj.netos.uc.service.ITenantService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public class UcTenantPorts implements ITenantPort {
    @CjServiceRef(refByName = "ucplugin.tenantService")
    ITenantService tenantService;

    @Override
    public String addTenant(String name, String website, String creator, String secret_key) throws CircuitException {
        return tenantService.addTenant(name, website, creator, secret_key);
    }

    @Override
    public void removeTenant(String tenantid) throws CircuitException {
        tenantService.removeTenant(tenantid);
    }

    @Override
    public List<UcTenant> pageTenant(int currPage, int pageSize) throws CircuitException {
        return tenantService.pageTenant(currPage, pageSize);
    }

    @Override
    public UcTenant getTenantById(String tenantid) throws CircuitException {
        return tenantService.getTenantById(tenantid);
    }

    @Override
    public List<UcTenant> getTenantsByUser(String uid) throws CircuitException {
        return tenantService.getTenantByUser(uid);
    }

    @Override
    public List<TenantApp> pageApp(int currPage, int pageSize) throws CircuitException {
        return tenantService.pageApp(currPage, pageSize);
    }

    @Override
    public List<TenantRole> pageRole(int currPage, int pageSize) throws CircuitException {
        return tenantService.pageRole(currPage, pageSize);
    }

    @Override
    public List<TenantAccount> pageAccount(int currPage, int pageSize) throws CircuitException {
        return tenantService.pageAccount(currPage, pageSize);
    }

    @Override
    public void addApp(String tenantid, String appid) throws CircuitException {
        tenantService.addApp(tenantid, appid);
    }

    @Override
    public void removeApp(String tenantid, String appid) throws CircuitException {
        tenantService.removeApp(tenantid, appid);
    }

    @Override
    public void addRole(String tenantid, String roleid) throws CircuitException {
        tenantService.addRole(tenantid, roleid);
    }

    @Override
    public void removeRole(String tenantid, String roleid) throws CircuitException {
        tenantService.removeRole(tenantid, roleid);
    }
}
