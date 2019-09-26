package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.TenantRole;
import cj.netos.uc.domain.TenantRoleExample;
import cj.netos.uc.domain.UaTenantRoleUserKey;
import cj.netos.uc.domain.UcUser;
import cj.netos.uc.plugin.dao.TenantRoleMapper;
import cj.netos.uc.plugin.dao.UaTenantRoleUserMapper;
import cj.netos.uc.service.ITenantRoleService;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.util.StringUtil;

import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "tenantRoleService")
public class TenantRoleService implements ITenantRoleService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.TenantRoleMapper")
    TenantRoleMapper roleMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UaTenantRoleUserMapper")
    UaTenantRoleUserMapper uaTenantRoleUserMapper;

    @CjTransaction
    @Override
    public String addRole(String roleid, String extend, String tenantId, String roleName, boolean isInheritable) throws CircuitException {
        if (StringUtil.isEmpty(tenantId)) {
            throw new CircuitException("404", "缺少租户标识");
        }
        if (StringUtil.isEmpty(extend)) {
            throw new CircuitException("404", "缺少继承角色");
        }
        if (StringUtil.isEmpty(roleid)) {
            throw new CircuitException("404", "缺少角色标识");
        }
        if (StringUtil.isEmpty(roleName)) {
            throw new CircuitException("404", "缺少角色名");
        }
        if (existsRoleId(roleid)) {
            throw new CircuitException("500", "已存在角色标识：" + roleid);
        }
        if (existsRoleName(roleName, tenantId)) {
            throw new CircuitException("500", String.format("在租户%s下存在同名角色：%s", tenantId, roleName));
        }
        TenantRole role = new TenantRole();
        role.setExtend(extend);
        role.setIsInheritable(isInheritable);
        role.setRoleId(roleid);
        role.setRoleName(roleName);
        role.setTenantId(tenantId);
        roleMapper.insert(role);
        return role.getRoleId();
    }

    private boolean existsRoleName(String roleName, String tenantId) {
        TenantRoleExample example = new TenantRoleExample();
        example.createCriteria().andTenantIdEqualTo(tenantId).andRoleNameEqualTo(roleName);
        return roleMapper.countByExample(example) > 0;
    }

    private boolean existsRoleId(String roleId) {
        return roleMapper.selectByPrimaryKey(roleId) != null;
    }


    @CjTransaction
    @Override
    public void removeRole(String roleid) throws CircuitException {
        roleMapper.deleteByPrimaryKey(roleid);
    }

    @CjTransaction
    @Override
    public TenantRole getRole(String roleid) throws CircuitException {
        return roleMapper.selectByPrimaryKey(roleid);
    }

    @CjTransaction
    @Override
    public List<TenantRole> pageRole(String tenantid, int currPage, int pageSize) throws CircuitException {
        return roleMapper.pageRole(tenantid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public List<UcUser> pageUserInRole(String roleid, int currPage, int pageSize) throws CircuitException {
        return roleMapper.pageUserInRole(roleid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public List<TenantRole> pageRoleOfUser(String uid, int currPage, int pageSize) {
        return roleMapper.pageRoleOfUser(uid, currPage, pageSize);
    }


    @CjTransaction
    @Override
    public void addUserToRole(String uid, String roleid) throws CircuitException {
        UaTenantRoleUserKey key = new UaTenantRoleUserKey();
        key.setRoleId(roleid);
        key.setUserId(uid);
        uaTenantRoleUserMapper.insertSelective(key);
    }

    @CjTransaction
    @Override
    public void removeUserFromRole(String uid, String roleid) throws CircuitException {
        UaTenantRoleUserKey key = new UaTenantRoleUserKey();
        key.setRoleId(roleid);
        key.setUserId(uid);
        uaTenantRoleUserMapper.deleteByPrimaryKey(key);
    }
}
