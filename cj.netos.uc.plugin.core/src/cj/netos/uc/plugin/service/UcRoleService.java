package cj.netos.uc.plugin.service;

import cj.netos.uc.model.*;
import cj.netos.uc.plugin.mapper.UaRoleUserMapper;
import cj.netos.uc.plugin.mapper.UcRoleMapper;
import cj.netos.uc.plugin.mapper.UcUserMapper;
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
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.UcRoleMapper")
    UcRoleMapper roleMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.UaRoleUserMapper")
    UaRoleUserMapper roleUserMapper;

    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.UcUserMapper")
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
    public boolean hasRoleOfUser(String roleid, String uid) {
        UaRoleUserExample example = new UaRoleUserExample();
        example.createCriteria().andRoleIdEqualTo(roleid).andUserIdEqualTo(uid);
        return roleUserMapper.countByExample(example) > 0;
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
        UaRoleUser uaRoleUser = new UaRoleUser();
        uaRoleUser.setRoleId(roleid);
        uaRoleUser.setUserId(uid);
        roleUserMapper.insertSelective(uaRoleUser);
    }

    @CjTransaction
    @Override
    public void removeRoleFromUser(String roleid, String uid) throws CircuitException {
        roleUserMapper.deleteByPrimaryKey(roleid, uid);
    }
}
