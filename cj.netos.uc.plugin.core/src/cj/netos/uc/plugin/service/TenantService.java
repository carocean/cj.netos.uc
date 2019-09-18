package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.*;
import cj.netos.uc.plugin.dao.TenantAccountMapper;
import cj.netos.uc.plugin.dao.UcTenantMapper;
import cj.netos.uc.plugin.util.NumberGen;
import cj.netos.uc.service.ITenantService;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.Date;
import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "tenantService")
public class TenantService implements ITenantService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UcTenantMapper")
    UcTenantMapper tenantMapper;

    @CjTransaction
    @Override
    public String addTenant(String name, String website, String creator, String secret_key) throws CircuitException {
        UcTenant tenant = new UcTenant();
        tenant.setCreateTime(new Date());
        tenant.setIsEnable((byte) 1);
        tenant.setSecretKey(secret_key);
        tenant.setTenantId(NumberGen.gen());
        tenant.setUserId(creator);
        tenant.setTenantName(name);
        tenant.setWebsite(website);
        tenantMapper.insertSelective(tenant);
        return tenant.getTenantId();
    }

    @CjTransaction
    @Override
    public void removeTenant(String tenantid) throws CircuitException {
        tenantMapper.deleteByPrimaryKey(tenantid);
    }

    @CjTransaction
    @Override
    public List<UcTenant> pageTenant(int currPage, int pageSize) throws CircuitException {
        return tenantMapper.pageTenant(currPage, pageSize);
    }

    @CjTransaction
    @Override
    public UcTenant getTenantById(String tenantid) throws CircuitException {
        return tenantMapper.selectByPrimaryKey(tenantid);
    }

    @CjTransaction
    @Override
    public List<UcTenant> getTenantByUser(String uid) throws CircuitException {
        UcTenantExample example = new UcTenantExample();
        example.createCriteria().andUserIdEqualTo(uid);
        return tenantMapper.selectByExample(example);
    }

}
