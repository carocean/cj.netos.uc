package cj.netos.uc;

import cj.netos.uc.service.IKeyStore;
import cj.netos.uc.util.Encript;
import cj.studio.ecm.IServiceSite;
import cj.studio.openport.CheckAppSignException;
import cj.studio.openport.DefaultSecuritySession;
import cj.studio.openport.ICheckAppSignStrategy;
import cj.studio.openport.ISecuritySession;

public class UcCheckAppSignTrategy implements ICheckAppSignStrategy {
    IKeyStore keyStore;
    @Override
    public ISecuritySession checkAppSign(String portsurl, String methodName, String appId, String appKey, String nonce, String sign) throws CheckAppSignException {
        String genSign= Encript.md5(String.format("%s%s",appKey,nonce));
        if (!genSign.equals(sign)) {
            throw new CheckAppSignException("805","app验证失败，拒绝访问");
        }
        ISecuritySession securitySession=new DefaultSecuritySession(appId);
        return securitySession;
    }

    @Override
    public void init(IServiceSite site) {
        keyStore=(IKeyStore)site.getService("ucplugin.keyStore");
    }
}
