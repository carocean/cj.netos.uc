package cj.netos.uc.port;

import cj.netos.uc.domain.TenantApp;
import cj.netos.uc.service.IAppService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

@CjService(name = "/app")
public class AppPorts implements IAppPort {
    @CjServiceRef(refByName = "ucplugin.tenantAppService")
    IAppService tenantAppService;

    @Override
    public String addApp(String appName,String tenantId,long tokenExpire,String appLogo,String callbackUrl,String logoutUrl,String homeUrl) throws CircuitException {
        return tenantAppService.addApp(null,appName,tenantId,tokenExpire,appLogo,callbackUrl,logoutUrl,homeUrl);
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
    public List<TenantApp> pageApp(String tenantid, int currPage, int pageSize) throws CircuitException {
        return tenantAppService.pageApp(tenantid, currPage, pageSize);
    }
}
