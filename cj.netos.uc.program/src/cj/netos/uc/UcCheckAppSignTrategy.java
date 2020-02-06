package cj.netos.uc;

import cj.netos.uc.model.TenantApp;
import cj.netos.uc.service.IAppService;
import cj.netos.uc.util.Encript;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.CheckAppSignException;
import cj.studio.openport.DefaultSecuritySession;
import cj.studio.openport.ICheckAppSignStrategy;
import cj.studio.openport.ISecuritySession;
import cj.ultimate.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

public class UcCheckAppSignTrategy implements ICheckAppSignStrategy {
    IAppService appService;
    /**
     * 验证逻辑：appKey+nonce+appSecret
     * @param portsurl
     * @param methodName
     * @param appId
     * @param appKey
     * @param nonce
     * @param sign
     * @return
     * @throws CheckAppSignException
     */
    @Override
    public ISecuritySession checkAppSign(String portsurl, String methodName, String appId, String appKey, String nonce, String sign) throws CheckAppSignException {
        TenantApp app = null;
        try {
            app = appService.getApp(appId);
        } catch (CircuitException e) {
            throw new CheckAppSignException("801", "app验证失败，拒绝访问，原因：应用不存在");
        }
        if (app==null) {
            throw new CheckAppSignException("802", String.format("app验证失败，拒绝访问，原因：appid:%s 不存在",appId));
        }
        if (!appKey.equals(app.getAppKey())) {
            throw new CheckAppSignException("803", "app验证失败，拒绝访问，原因：公钥不匹配");
        }
        String genSign = Encript.md5(String.format("%s%s%s", appKey, nonce,app.getAppSecret()));
        if (!genSign.equals(sign)) {
            throw new CheckAppSignException("804", "app验证失败，拒绝访问，原因：签名不正确");
        }
        ISecuritySession securitySession = new DefaultSecuritySession(appId);
        return securitySession;
    }

    @Override
    public void init(IServiceSite site) {
        appService = (IAppService) site.getService("ucplugin.tenantAppService");
    }
}
