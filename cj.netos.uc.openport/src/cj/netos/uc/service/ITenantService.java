package cj.netos.uc.service;

import cj.netos.uc.model.UcTenant;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface ITenantService {
    String addTenant(String tenantid, String name, String website, String creator, String icon) throws CircuitException;

    void removeTenant(String tenantid) throws CircuitException;

    List<UcTenant> pageTenant(long currPage, int pageSize) throws CircuitException;

    UcTenant getTenantById(String tenantid) throws CircuitException;

    List<UcTenant> getTenantByUser(String uid) throws CircuitException;

}
