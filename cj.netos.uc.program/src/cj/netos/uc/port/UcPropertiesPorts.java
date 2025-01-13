package cj.netos.uc.port;

import cj.netos.uc.service.IUcProperties;
import cj.netos.uc.service.IUcUserService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

import java.util.List;
@CjService(name = "/system/properties.ports")
public class UcPropertiesPorts implements  IUcPropertiesPorts {
    @CjServiceRef(refByName = "ucplugin.ucProperties")
    IUcProperties ucProperties;
    @Override
    public String get(ISecuritySession securitySession, String key) throws CircuitException {
        checkRights(securitySession);
        return ucProperties.get(key);
    }

    private void checkRights(ISecuritySession securitySession) throws CircuitException {
        if(!"superadmin@system.netos".equals(securitySession.principal())){
            throw new CircuitException("801","无权访问");
        }
    }

    @Override
    public void set(ISecuritySession securitySession, String key, String value) throws CircuitException {
        checkRights(securitySession);
        ucProperties.set(key,value);
    }

    @Override
    public List<String> keys(ISecuritySession securitySession) throws CircuitException {
        checkRights(securitySession);
        return ucProperties.keys();
    }
}
