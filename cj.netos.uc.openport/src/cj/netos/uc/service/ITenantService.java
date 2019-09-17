package cj.netos.uc.service;

import cj.netos.uc.domain.TenantAccount;
import cj.netos.uc.domain.TenantApp;
import cj.netos.uc.domain.TenantRole;
import cj.netos.uc.domain.UcTenant;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface ITenantService {
    String addTenant(String name, String website, String creator, String secret_key) throws CircuitException;

    void removeTenant(String tenantid) throws CircuitException;

    List<UcTenant> pageTenant(int currPage, int pageSize) throws CircuitException;

    UcTenant getTenantById(String tenantid) throws CircuitException;

    List<UcTenant> getTenantByUser(String uid) throws CircuitException;

    List<TenantApp> pageApp(int currPage, int pageSize) throws CircuitException;

    List<TenantRole> pageRole(int currPage, int pageSize) throws CircuitException;

    List<TenantAccount> pageAccount(int currPage, int pageSize) throws CircuitException;

    void addApp(String tenantid, String appid) throws CircuitException;

    void removeApp(String tenantid, String appid) throws CircuitException;

    void addRole(String tenantid, String roleid) throws CircuitException;

    void removeRole(String tenantid, String roleid) throws CircuitException;
}
