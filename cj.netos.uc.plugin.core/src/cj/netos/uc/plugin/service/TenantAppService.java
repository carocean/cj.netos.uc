package cj.netos.uc.plugin.service;

import cj.netos.uc.model.TenantApp;
import cj.netos.uc.model.TenantAppExample;
import cj.netos.uc.plugin.mapper.TenantAppMapper;
import cj.netos.uc.service.IAppService;
import cj.netos.uc.util.NumberGen;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.util.StringUtil;

import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "tenantAppService")
public class TenantAppService implements IAppService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.TenantAppMapper")
    TenantAppMapper tenantAppMapper;

    @CjTransaction
    @Override
    public String addApp(String appid, String appName, String tenantId, long tokenExpire, String appLogo, String callbackUrl, String logoutUrl, String homeUrl) throws CircuitException {
        if (StringUtil.isEmpty(tenantId)) {
            throw new CircuitException("404", "租户标识为空");
        }
        if (StringUtil.isEmpty(appName)) {
            throw new CircuitException("404", "应用名为空");
        }
        if (existsAppName(appName, tenantId)) {
            throw new CircuitException("500", String.format("租户%s下已存在应用:%s", tenantId, appName));
        }
        if (tokenExpire < 1) {
            tokenExpire = 24 * 60 * 60 * 1000L;
        }
        TenantApp app = new TenantApp();
        app.setAppId(StringUtil.isEmpty(appid) ? NumberGen.gen() : appid);
        app.setAppName(appName);
        app.setTenantId(tenantId);
        app.setSecretKey(NumberGen.gen());
        app.setTokenExpire(tokenExpire);
        app.setAppLogo(appLogo);
        app.setCallbackUrl(callbackUrl);
        app.setHomeUrl(homeUrl);
        app.setLogoutUrl(logoutUrl);

        tenantAppMapper.insertSelective(app);
        return app.getAppId();
    }

    @CjTransaction
    @Override
    public boolean existsAppName(String appName, String tenantId) {
        TenantAppExample example = new TenantAppExample();
        example.createCriteria().andTenantIdEqualTo(tenantId).andAppNameEqualTo(appName);
        return tenantAppMapper.countByExample(example) > 0;
    }

    @CjTransaction
    @Override
    public TenantApp getAppByName(String tenantid, String appName) {
        TenantAppExample example = new TenantAppExample();
        example.createCriteria().andTenantIdEqualTo(tenantid).andAppNameEqualTo(appName);
        List<TenantApp> list = tenantAppMapper.selectByExample(example);
        if (list.isEmpty()) return null;
        return list.get(0);
    }

    @CjTransaction
    @Override
    public void removeApp(String appid) throws CircuitException {
        tenantAppMapper.deleteByPrimaryKey(appid);
    }

    @CjTransaction
    @Override
    public TenantApp getApp(String appid) throws CircuitException {
        return tenantAppMapper.selectByPrimaryKey(appid);
    }

    @CjTransaction
    @Override
    public List<TenantApp> pageApp(String tenantid, int currPage, int pageSize) throws CircuitException {
        return tenantAppMapper.pageApp(tenantid, currPage, pageSize);
    }
}
