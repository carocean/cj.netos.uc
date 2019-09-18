package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.TenantApp;
import cj.netos.uc.plugin.dao.TenantAppMapper;
import cj.netos.uc.plugin.util.NumberGen;
import cj.netos.uc.service.IAppService;
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
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.TenantAppMapper")
    TenantAppMapper tenantAppMapper;

    @CjTransaction
    @Override
    public String addApp(TenantApp app) throws CircuitException {
        if (StringUtil.isEmpty(app.getTenantId())) {
            throw new CircuitException("404", "租户标识为空");
        }
        if (StringUtil.isEmpty(app.getAppName())) {
            throw new CircuitException("404", "应用名为空");
        }
        app.setAppId(NumberGen.gen());
        tenantAppMapper.insertSelective(app);
        return app.getAppId();
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
