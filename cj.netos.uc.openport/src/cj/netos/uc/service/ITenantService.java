package cj.netos.uc.service;

import cj.netos.uc.domain.UcTenant;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface ITenantService {
    String addTenant(String name, String website, String creator, String secret_key) throws CircuitException;

    void removeTenant(String tenantid) throws CircuitException;

    List<UcTenant> pageTenant(int currPage, int pageSize) throws CircuitException;

    UcTenant getTenantById(String tenantid) throws CircuitException;

    List<UcTenant> getTenantByUser(String uid) throws CircuitException;

}
