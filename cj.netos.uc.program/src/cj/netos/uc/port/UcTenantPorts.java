package cj.netos.uc.port;

import cj.netos.uc.model.UcTenant;
import cj.netos.uc.service.ITenantService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

@CjService(name = "/tenant")
public class UcTenantPorts implements ITenantPort {
    @CjServiceRef(refByName = "ucplugin.tenantService")
    ITenantService tenantService;

    @Override
    public String addTenant(String tenantid,String name, String website, String creator) throws CircuitException {
        return tenantService.addTenant(tenantid,name, website, creator);
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
}
