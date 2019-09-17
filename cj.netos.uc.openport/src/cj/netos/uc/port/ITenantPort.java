package cj.netos.uc.port;

import cj.netos.uc.domain.UcTenant;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;

import java.util.List;

public interface ITenantPort extends IOpenportService {
    String addTenant(String name, String website, String creator, String secret_key) throws CircuitException;

    void removeTenant(String tenantid) throws CircuitException;

    List<UcTenant> pageTenant(int currPage, int pageSize) throws CircuitException;

    UcTenant getTenantById(String tenantid) throws CircuitException;

    UcTenant getTenantByUser(String uid) throws CircuitException;
}
