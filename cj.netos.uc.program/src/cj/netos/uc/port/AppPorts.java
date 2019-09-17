package cj.netos.uc.port;

import cj.netos.uc.domain.AppRole;
import cj.netos.uc.domain.TenantApp;
import cj.netos.uc.service.ITenantAppService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

@CjService(name = "/app")
public class AppPorts implements IAppPort {
    @CjServiceRef(refByName = "ucplugin.tenantAppService")
    ITenantAppService tenantAppService;

    @Override
    public String addApp(TenantApp app) throws CircuitException {
        return tenantAppService.addApp(app);
    }

    @Override
    public void removeApp(String appid) throws CircuitException {
        tenantAppService.removeApp(appid);
    }

    @Override
    public TenantApp getApp(String appid) throws CircuitException {
        return tenantAppService.getApp(appid);
    }

    @Override
    public List<AppRole> pageRoleOfApp(String appid, int currPage, int pageSize) throws CircuitException {
        return tenantAppService.pageRoleOfApp(appid, currPage, pageSize);
    }

    @Override
    public void addRoleToApp(String roleid, String appid) throws CircuitException {
        tenantAppService.addRoleToApp(roleid, appid);
    }

    @Override
    public void removeRoleFromApp(String roleid, String appid) throws CircuitException {
        tenantAppService.removeRoleFromApp(roleid, appid);
    }

    @Override
    public void emptyRoleOfApp(String appid) throws CircuitException {
        tenantAppService.emptyRoleOfApp(appid);
    }
}
