package cj.netos.uc.port;

import cj.netos.uc.model.TenantApp;
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
    public String addApp(String appid, String appName, String tenantId, long tokenExpire, String appLogo, String website, String loginCBUrl, String logoutCBUrl) throws CircuitException {
        return tenantAppService.addApp(appid, appName, tenantId, tokenExpire, appLogo, website, loginCBUrl, logoutCBUrl);
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

    @Override
    public void upgradeBecomeDeveloper(String appid, String accountName) throws CircuitException {
        tenantAppService.upgradeBecomeDeveloper(appid,accountName);
    }

    @Override
    public void updateWebsite(String appid, String website, String loginCBUrl, String logoutCBUrl) throws CircuitException {
        tenantAppService.updateWebsite(appid, website, loginCBUrl, logoutCBUrl);
    }

    @Override
    public void renameAppName(String appid, String newAppName) throws CircuitException {
        tenantAppService.updateAppName(appid, newAppName);
    }

    @Override
    public String issueDevelopToken(String appid, String accountName, String password) throws CircuitException {
        return tenantAppService.issueDevelopToken(appid, accountName, password);
    }
}
