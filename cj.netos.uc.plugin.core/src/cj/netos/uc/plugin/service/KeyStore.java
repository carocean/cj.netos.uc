package cj.netos.uc.plugin.service;

import cj.netos.uc.model.TenantApp;
import cj.netos.uc.service.IAppService;
import cj.netos.uc.service.IKeyStore;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.ecm.net.CircuitException;

@CjService(name = "keyStore")
public class KeyStore implements IKeyStore {
    @CjServiceSite
    IServiceSite serviceSite;
    @CjServiceRef(refByName = "tenantAppService")
    IAppService appService;
    @Override
    public String getKey() throws CircuitException {
        String appid=(String) serviceSite.getService("#.app.id");
        TenantApp app=appService.getApp(appid);
        return app.getAppSecret();
    }
}
