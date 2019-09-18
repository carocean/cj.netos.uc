package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.AppRole;
import cj.netos.uc.domain.TenantApp;
import cj.netos.uc.service.ITenantAppService;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.List;
@CjBridge(aspects = "@transaction")
@CjService(name = "tenantAppService")
public class TenantAppService implements ITenantAppService {
    @CjTransaction
    @Override
    public String addApp(TenantApp app) throws CircuitException {
        return null;
    }
    @CjTransaction
    @Override
    public void removeApp(String appid) throws CircuitException {

    }
    @CjTransaction
    @Override
    public TenantApp getApp(String appid) throws CircuitException {
        return null;
    }
    @CjTransaction
    @Override
    public List<AppRole> pageRoleOfApp(String appid, int currPage, int pageSize) throws CircuitException {
        return null;
    }
    @CjTransaction
    @Override
    public void addRoleToApp(String roleid, String appid) throws CircuitException {

    }
    @CjTransaction
    @Override
    public void removeRoleFromApp(String roleid, String appid) throws CircuitException {

    }
    @CjTransaction
    @Override
    public void emptyRoleOfApp(String appid) throws CircuitException {

    }
}
