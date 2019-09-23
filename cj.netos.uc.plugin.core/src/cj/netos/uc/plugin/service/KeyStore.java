package cj.netos.uc.plugin.service;

import cj.netos.uc.service.IKeyStore;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceSite;

@CjService(name = "keyStore")
public class KeyStore implements IKeyStore {
    @CjServiceSite
    IServiceSite serviceSite;
    @Override
    public String getKey() {
        return serviceSite.getProperty("uc.auth.key");
    }
}
