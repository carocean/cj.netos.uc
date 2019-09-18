package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.TenantRole;
import cj.netos.uc.domain.TenantRoleExample;
import cj.netos.uc.domain.UaTenantRoleUserKey;
import cj.netos.uc.domain.UcUser;
import cj.netos.uc.plugin.dao.TenantRoleMapper;
import cj.netos.uc.plugin.dao.UaTenantRoleUserMapper;
import cj.netos.uc.service.ITenantRoleService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.ultimate.util.StringUtil;

import java.util.List;

@CjService(name = "tenantRoleService")
public class TenantRoleService implements ITenantRoleService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.TenantRoleMapper")
    TenantRoleMapper roleMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UaTenantRoleUserMapper")
    UaTenantRoleUserMapper uaTenantRoleUserMapper;

    @Override
    public String addRole(TenantRole role) throws CircuitException {
        if (StringUtil.isEmpty(role.getTenantId())) {
            throw new CircuitException("404", "缺少租户标识");
        }
        if (existsRoleName(role.getRoleName())) {
            throw new CircuitException("404", "已存在同名角色：" + role.getRoleName());
        }
        roleMapper.insert(role);
        return role.getRoleId();
    }

    private boolean existsRoleName(String roleName) {
        TenantRoleExample example = new TenantRoleExample();
        example.createCriteria().andRoleNameEqualTo(roleName);
        return roleMapper.countByExample(example) > 0;
    }

    @Override
    public void removeRole(String roleid) throws CircuitException {
        roleMapper.deleteByPrimaryKey(roleid);
    }

    @Override
    public TenantRole getRole(String roleid) throws CircuitException {
        return roleMapper.selectByPrimaryKey(roleid);
    }

    @Override
    public List<TenantRole> pageRole(String tenantid, int currPage, int pageSize) throws CircuitException {
        return roleMapper.pageRole(tenantid, currPage, pageSize);
    }

    @Override
    public List<UcUser> pageUserInRole(String roleid, int currPage, int pageSize) throws CircuitException {
        return roleMapper.pageUserInRole(roleid, currPage, pageSize);
    }

    @Override
    public List<TenantRole> listRoleOfUser(String uid) throws CircuitException {
        return roleMapper.listRoleOfUser(uid);
    }

    @Override
    public void addUserToRole(String uid, String roleid) throws CircuitException {
        UaTenantRoleUserKey key = new UaTenantRoleUserKey();
        key.setRoleId(roleid);
        key.setUserId(uid);
        uaTenantRoleUserMapper.insertSelective(key);
    }

    @Override
    public void removeUserFromRole(String uid, String roleid) throws CircuitException {
        UaTenantRoleUserKey key = new UaTenantRoleUserKey();
        key.setRoleId(roleid);
        key.setUserId(uid);
        uaTenantRoleUserMapper.deleteByPrimaryKey(key);
    }
}
