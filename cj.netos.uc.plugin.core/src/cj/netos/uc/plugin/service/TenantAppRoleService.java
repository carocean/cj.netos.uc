package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.AppRole;
import cj.netos.uc.domain.UaAppRoleUserKey;
import cj.netos.uc.domain.UcUser;
import cj.netos.uc.plugin.dao.AppRoleMapper;
import cj.netos.uc.plugin.dao.TenantAppMapper;
import cj.netos.uc.plugin.dao.UaAppRoleUserMapper;
import cj.netos.uc.plugin.util.NumberGen;
import cj.netos.uc.service.IAppRoleService;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.util.StringUtil;

import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "tenantAppRoleService")
public class TenantAppRoleService implements IAppRoleService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.AppRoleMapper")
    AppRoleMapper appRoleMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UaAppRoleUserMapper")
    UaAppRoleUserMapper uaAppRoleUserMapper;

    @CjTransaction
    @Override
    public String addRole(AppRole role) throws CircuitException {
        if (StringUtil.isEmpty(role.getAppId())) {
            throw new CircuitException("404", "应用标识为空");
        }
        if (StringUtil.isEmpty(role.getExtend())) {
            throw new CircuitException("404", "缺少继承角色");
        }
        if (StringUtil.isEmpty(role.getRoleName())) {
            throw new CircuitException("404", "角色名为空");
        }
        role.setRoleId(NumberGen.gen());
        appRoleMapper.insertSelective(role);
        return role.getRoleId();
    }

    @CjTransaction
    @Override
    public void removeRole(String roleid) throws CircuitException {
        appRoleMapper.deleteByPrimaryKey(roleid);
    }

    @CjTransaction
    @Override
    public AppRole getRole(String roleid) throws CircuitException {
        return appRoleMapper.selectByPrimaryKey(roleid);
    }

    @CjTransaction
    @Override
    public List<AppRole> pageRole(String appid, int currPage, int pageSize) throws CircuitException {
        return appRoleMapper.pageRole(appid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public List<UcUser> pageUserInRole(String roleid, int currPage, int pageSize) throws CircuitException {
        return uaAppRoleUserMapper.pageUserInRole(roleid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public List<AppRole> pageRoleInUser(String uid, int currPage, int pageSize) throws CircuitException {
        return uaAppRoleUserMapper.pageRoleInUser(uid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public void addUserToRole(String uid, String roleid) throws CircuitException {
        UaAppRoleUserKey key = new UaAppRoleUserKey();
        key.setRoleId(roleid);
        key.setUserId(uid);
        uaAppRoleUserMapper.deleteByPrimaryKey(key);
    }

    @CjTransaction
    @Override
    public void removeUserFromRole(String uid, String roleid) throws CircuitException {
        UaAppRoleUserKey key = new UaAppRoleUserKey();
        key.setRoleId(roleid);
        key.setUserId(uid);
        uaAppRoleUserMapper.deleteByPrimaryKey(key);
    }
}
