package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.UcRole;
import cj.netos.uc.domain.UcRoleExample;
import cj.netos.uc.domain.UcUser;
import cj.netos.uc.plugin.dao.UcRoleMapper;
import cj.netos.uc.plugin.util.NumberGen;
import cj.netos.uc.service.IUcRoleService;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "ucRoleService")
public class UcRoleService implements IUcRoleService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UcRoleMapper")
    UcRoleMapper roleMapper;

    @CjTransaction
    @Override
    public String addRole(String name, boolean isInheritable) throws CircuitException {
        if (existsRoleName(name)) {
            throw new CircuitException("500", "已存在同名角色:" + name);
        }
        UcRole role=new UcRole();
        role.setIsInheritable(isInheritable);
        role.setRoleName(name);
        role.setRoleId(NumberGen.gen());
        roleMapper.insertSelective(role);
        return role.getRoleId();
    }

    private boolean existsRoleName(String name) {
        UcRoleExample example=new UcRoleExample()   ;
        example.createCriteria().andRoleNameEqualTo(name);
        return  roleMapper.countByExample(example)>0;
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
        return roleMapper.pageRole(currPage,pageSize);
    }

    @CjTransaction
    @Override
    public List<UcUser> pageUserInRole(String roleid, int currPage, int pageSize) throws CircuitException {
        return roleMapper.pageUserInRole(roleid,currPage,pageSize);
    }

}
