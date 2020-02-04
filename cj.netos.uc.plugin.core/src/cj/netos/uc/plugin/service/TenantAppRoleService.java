package cj.netos.uc.plugin.service;

import cj.netos.uc.model.*;
import cj.netos.uc.plugin.mapper.AppRoleMapper;
import cj.netos.uc.plugin.mapper.UaAppRolePersonMapper;
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
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.AppRoleMapper")
    AppRoleMapper appRoleMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.UaAppRolePersonMapper")
    UaAppRolePersonMapper uaAppRolePersonMapper;

    @CjTransaction
    @Override
    public String addRole(String roleCode, String extend, String appId, String roleName) throws CircuitException {
        if (StringUtil.isEmpty(appId)) {
            throw new CircuitException("404", "应用标识为空");
        }
        if (StringUtil.isEmpty(extend)) {
            throw new CircuitException("404", "缺少继承角色");
        }
        if (StringUtil.isEmpty(roleCode)) {
            throw new CircuitException("404", "角色编号为空");
        }
        if (StringUtil.isEmpty(roleName)) {
            throw new CircuitException("404", "角色名为空");
        }
        if (existsRoleId(roleCode, appId)) {
            throw new CircuitException("404", "已存在角色：" + roleCode);
        }

        AppRole role = new AppRole();
        role.setExtend(extend);
        role.setRoleCode(roleCode);
        role.setRoleId(String.format("%s@%s",roleCode,appId));
        role.setRoleName(roleName);
        role.setAppId(appId);
        appRoleMapper.insertSelective(role);
        return role.getRoleId();
    }


    private boolean existsRoleId(String roleCode, String appId) throws CircuitException {
        return getRole(appId, roleCode) != null;
    }

    @CjTransaction
    @Override
    public void removeRole(String appId, String roleCode) throws CircuitException {
        appRoleMapper.deleteByPrimaryKey(String.format("%s@%s",roleCode,appId));
    }

    @CjTransaction
    @Override
    public AppRole getRole(String appId, String roleCode) throws CircuitException {
        return appRoleMapper.selectByPrimaryKey(String.format("%s@%s",roleCode,appId));
    }

    @CjTransaction
    @Override
    public List<AppRole> pageRole(String appid, int currPage, int pageSize) throws CircuitException {
        return appRoleMapper.pageRole(appid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public List<AppAccount> pageAccountInRole(String appId, String rolecode, int offset, int limit) throws CircuitException {
        return uaAppRolePersonMapper.pageAccountInRole(appId, rolecode, offset, limit);
    }

    @CjTransaction
    @Override
    public List<AppRole> pageRoleOfAccount(String accountid, String appId, int offset, int limit) throws CircuitException {
        return uaAppRolePersonMapper.pageRoleOfAccount(accountid, appId, offset,limit );
    }

    @CjTransaction
    @Override
    public void addAccountToRole(String appId, String accountid, String roleid, String tenantid, String uid) throws CircuitException {
        UaAppRolePerson key = new UaAppRolePerson();
        key.setRoleId(roleid);
        key.setUserId(uid);
        key.setAppId(appId);
        key.setTenantId(tenantid);
        key.setAccountId(accountid);
        uaAppRolePersonMapper.insert(key);
    }


    @CjTransaction
    @Override
    public void removeAccountFromRole(String accountid, String appId, String roleCode) throws CircuitException {
        uaAppRolePersonMapper.deleteByPrimaryKey(String.format("%s@%s",roleCode,appId), accountid);
    }
}
