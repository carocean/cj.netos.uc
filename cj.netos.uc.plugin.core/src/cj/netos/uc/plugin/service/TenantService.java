package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.*;
import cj.netos.uc.plugin.dao.UcTenantMapper;
import cj.netos.uc.util.NumberGen;
import cj.netos.uc.service.ITenantService;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.util.StringUtil;

import java.util.Date;
import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "tenantService")
public class TenantService implements ITenantService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UcTenantMapper")
    UcTenantMapper tenantMapper;

    @CjTransaction
    @Override
    public String addTenant(String tenantid,String name, String website, String creator) throws CircuitException {
        if(StringUtil.isEmpty(tenantid)){
            tenantid=NumberGen.gen();
        }
        if(StringUtil.isEmpty(name)){
            throw new CircuitException("404","缺少租户名");
        }
        if(StringUtil.isEmpty(creator)){
            throw new CircuitException("404","缺少租户创建人");
        }
        if (existsTenantName(name, creator)) {
            throw new CircuitException("500", String.format("创建者%s名下已存同名租户:%s", creator, name));
        }
        UcTenant tenant = new UcTenant();
        tenant.setCreateTime(new Date());
        tenant.setIsEnable((byte) 1);
        tenant.setTenantId(tenantid);
        tenant.setUserId(creator);
        tenant.setTenantName(name);
        tenant.setWebsite(website);
        tenantMapper.insertSelective(tenant);
        return tenant.getTenantId();
    }

    private boolean existsTenantName(String name, String uid) {
        UcTenantExample example = new UcTenantExample();
        example.createCriteria().andTenantNameEqualTo(name).andUserIdEqualTo(uid);
        return tenantMapper.countByExample(example) > 0;
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
