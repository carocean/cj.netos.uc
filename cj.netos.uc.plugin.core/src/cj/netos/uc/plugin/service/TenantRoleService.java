package cj.netos.uc.plugin.service;

import cj.netos.uc.model.TenantRole;
import cj.netos.uc.model.TenantRoleExample;
import cj.netos.uc.model.UaTenantRoleUser;
import cj.netos.uc.model.UcUser;
import cj.netos.uc.plugin.mapper.TenantRoleMapper;
import cj.netos.uc.plugin.mapper.UaTenantRoleUserMapper;
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
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.TenantRoleMapper")
    TenantRoleMapper roleMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.UaTenantRoleUserMapper")
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
        if (existsRoleId(roleid, tenantId)) {
            throw new CircuitException("500", "已存在角色标识：" + roleid);
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


    private boolean existsRoleId(String roleId, String tenantid) {
        return roleMapper.selectByPrimaryKey(roleId, tenantid) != null;
    }


    @CjTransaction
    @Override
    public void removeRole(String roleid, String tenantid) throws CircuitException {
        roleMapper.deleteByPrimaryKey(roleid, tenantid);
    }

    @CjTransaction
    @Override
    public TenantRole getRole(String roleid, String tenantid) throws CircuitException {
        return roleMapper.selectByPrimaryKey(roleid, tenantid);
    }

    @CjTransaction
    @Override
    public List<TenantRole> pageRole(String tenantid, int currPage, int pageSize) throws CircuitException {
        return roleMapper.pageRole(tenantid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public List<UcUser> pageUserInRole(String roleid, String tenantid, int currPage, int pageSize) throws CircuitException {
        return roleMapper.pageUserInRole(roleid, tenantid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public List<TenantRole> pageRoleOfUser(String uid, String tenantid, int currPage, int pageSize) {
        return roleMapper.pageRoleOfUser(uid, tenantid, currPage, pageSize);
    }


    @CjTransaction
    @Override
    public void addUserToRole(String uid, String roleid, String tenantid) throws CircuitException {
        UaTenantRoleUser uaTenantRoleUser = new UaTenantRoleUser();
        uaTenantRoleUser.setRoleId(roleid);
        uaTenantRoleUser.setUserId(uid);
        uaTenantRoleUser.setTenantId(tenantid);
        uaTenantRoleUserMapper.insertSelective(uaTenantRoleUser);
    }

    @CjTransaction
    @Override
    public void removeUserFromRole(String uid, String roleid, String tenantid) throws CircuitException {
        uaTenantRoleUserMapper.deleteByPrimaryKey(roleid, uid, tenantid);
    }
}
