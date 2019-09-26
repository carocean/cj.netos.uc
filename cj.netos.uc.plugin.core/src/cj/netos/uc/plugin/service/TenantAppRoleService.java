package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.*;
import cj.netos.uc.plugin.dao.AppRoleMapper;
import cj.netos.uc.plugin.dao.UaAppRoleUserMapper;
import cj.netos.uc.util.NumberGen;
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
        if (existsRoleId(roleId)) {
            throw new CircuitException("404", "已存在角色：" + roleId);
        }
        if (existsRoleName(roleName, appId)) {
            throw new CircuitException("500", String.format("在应用%s下存在同名角色：%s", appId, roleName));
        }
        AppRole role = new AppRole();
        role.setExtend(extend);
        role.setRoleId(roleId);
        role.setRoleName(roleName);
        role.setAppId(appId);
        appRoleMapper.insertSelective(role);
        return role.getRoleId();
    }

    private boolean existsRoleName(String roleName, String appId) {
        AppRoleExample example=new AppRoleExample();
        example.createCriteria().andAppIdEqualTo(appId).andRoleNameEqualTo(roleName);
        return appRoleMapper.countByExample(example)>0;
    }

    private boolean existsRoleId(String roleId) throws CircuitException {
        return  getRole(roleId)!=null;
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
    public List<AppRole> pageRoleOfUser(String uid, int currPage, int pageSize) throws CircuitException {
        return uaAppRoleUserMapper.pageRoleInUser(uid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public void addUserToRole(String uid, String roleid) throws CircuitException {
        UaAppRoleUserKey key = new UaAppRoleUserKey();
        key.setRoleId(roleid);
        key.setUserId(uid);
        uaAppRoleUserMapper.insert(key);
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
