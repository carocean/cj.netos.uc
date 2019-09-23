package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.UaRoleUserKey;
import cj.netos.uc.domain.UcRole;
import cj.netos.uc.domain.UcRoleExample;
import cj.netos.uc.domain.UcUser;
import cj.netos.uc.plugin.dao.UaRoleUserMapper;
import cj.netos.uc.plugin.dao.UcRoleMapper;
import cj.netos.uc.plugin.dao.UcUserMapper;
import cj.netos.uc.service.IUcRoleService;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.util.StringUtil;

import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "ucRoleService")
public class UcRoleService implements IUcRoleService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UcRoleMapper")
    UcRoleMapper roleMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UaRoleUserMapper")
    UaRoleUserMapper roleUserMapper;

    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UcUserMapper")
    UcUserMapper userMapper;

    @CjTransaction
    @Override
    public String addRole(String roleid, String name, boolean isInheritable) throws CircuitException {
        if (StringUtil.isEmpty(roleid)) {
            throw new CircuitException("404", "角色标识为空");
        }
        if (existsRoleId(roleid)) {
            throw new CircuitException("500", "已存在同名角色:" + name);
        }
        UcRole role = new UcRole();
        role.setRoleId(roleid);
        role.setIsInheritable(isInheritable);
        role.setRoleName(name);
        roleMapper.insertSelective(role);
        return role.getRoleId();
    }

    private boolean existsRoleId(String roleid) {
        return roleMapper.selectByPrimaryKey(roleid) != null;
    }

    private boolean existsRoleName(String name) {
        UcRoleExample example = new UcRoleExample();
        example.createCriteria().andRoleNameEqualTo(name);
        return roleMapper.countByExample(example) > 0;
    }

    @CjTransaction
    @Override
    public void removeRole(String roleid) throws CircuitException {
        roleMapper.deleteByPrimaryKey(roleid);
    }

    @CjTransaction
    @Override
    public UcRole getRole(String roleid) throws CircuitException {
        return roleMapper.selectByPrimaryKey(roleid);
    }

    @CjTransaction
    @Override
    public List<UcRole> pageRole(int currPage, int pageSize) throws CircuitException {
        return roleMapper.pageRole(currPage, pageSize);
    }

    @CjTransaction
    @Override
    public List<UcUser> pageUserInRole(String roleid, int currPage, int pageSize) throws CircuitException {
        return roleMapper.pageUserInRole(roleid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public List<UcRole> pageRoleOfUser(String uid, int currPage, int pageSize) {
        return roleMapper.pageRoleOfUser(uid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public List<UcRole> pageRoleInUser(String uid, int currPage, int pageSize) throws CircuitException {
        return roleMapper.pageRoleOfUser(uid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public void addRoleToUser(String roleid, String uid) throws CircuitException {
        if (userMapper.selectByPrimaryKey(uid) == null) {
            throw new CircuitException("404", "不存在用户标识:" + uid);
        }
        if (getRole(roleid) == null) {
            throw new CircuitException("404", "不存在角色标识:" + uid);
        }
        UaRoleUserKey key = new UaRoleUserKey();
        key.setRoleId(roleid);
        key.setUserId(uid);
        roleUserMapper.insertSelective(key);
    }

    @CjTransaction
    @Override
    public void removeRoleFromUser(String roleid, String uid) throws CircuitException {
        UaRoleUserKey key = new UaRoleUserKey();
        key.setRoleId(roleid);
        key.setUserId(uid);
        roleUserMapper.deleteByPrimaryKey(key);
    }
}
