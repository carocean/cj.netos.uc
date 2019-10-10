package cj.netos.uc.plugin.service;

import cj.netos.uc.model.*;
import cj.netos.uc.plugin.mapper.AppRoleMapper;
import cj.netos.uc.plugin.mapper.UaAppRoleUserMapper;
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
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.UaAppRoleUserMapper")
    UaAppRoleUserMapper uaAppRoleUserMapper;

    @CjTransaction
    @Override
    public String addRole(String roleId,String extend,String appId,String roleName ) throws CircuitException {
        if (StringUtil.isEmpty(appId)) {
            throw new CircuitException("404", "应用标识为空");
        }
        if (StringUtil.isEmpty(extend)) {
            throw new CircuitException("404", "缺少继承角色");
        }
        if (StringUtil.isEmpty(roleId)) {
            throw new CircuitException("404", "缺少角色标识");
        }
        if (StringUtil.isEmpty(roleName)) {
            throw new CircuitException("404", "角色名为空");
        }
        if (existsRoleId(roleId,appId)) {
            throw new CircuitException("404", "已存在角色：" + roleId);
        }

        AppRole role = new AppRole();
        role.setExtend(extend);
        role.setRoleId(roleId);
        role.setRoleName(roleName);
        role.setAppId(appId);
        appRoleMapper.insertSelective(role);
        return role.getRoleId();
    }


    private boolean existsRoleId(String roleId, String appId) throws CircuitException {
        return  getRole(appId,roleId)!=null;
    }

    @CjTransaction
    @Override
    public void removeRole(String appId,String roleid) throws CircuitException {
        appRoleMapper.deleteByPrimaryKey(roleid,appId);
    }

    @CjTransaction
    @Override
    public AppRole getRole(String appId,String roleid) throws CircuitException {
        return appRoleMapper.selectByPrimaryKey(roleid,appId);
    }

    @CjTransaction
    @Override
    public List<AppRole> pageRole(String appid, int currPage, int pageSize) throws CircuitException {
        return appRoleMapper.pageRole(appid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public List<UcUser> pageUserInRole(String appId,String roleid, int currPage, int pageSize) throws CircuitException {
        return uaAppRoleUserMapper.pageUserInRole(appId,roleid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public List<AppRole> pageRoleOfUser(String uid,String appId, int currPage, int pageSize) throws CircuitException {
        return uaAppRoleUserMapper.pageRoleInUser(uid,appId, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public void addUserToRole(String uid,String appId, String roleid) throws CircuitException {
        UaAppRoleUser key = new UaAppRoleUser();
        key.setRoleId(roleid);
        key.setUserId(uid);
        key.setAppId(appId);
        uaAppRoleUserMapper.insert(key);
    }

    @CjTransaction
    @Override
    public void removeUserFromRole(String uid,String appId, String roleid) throws CircuitException {
        uaAppRoleUserMapper.deleteByPrimaryKey(roleid,uid,appId);
    }
}
