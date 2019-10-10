package cj.netos.uc.plugin.service;

import cj.netos.uc.model.UcEmpl;
import cj.netos.uc.model.UcEmplExample;
import cj.netos.uc.plugin.mapper.UcEmplMapper;
import cj.netos.uc.service.IUcEmployeeService;
import cj.netos.uc.util.NumberGen;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.util.StringUtil;

import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "ucEmployeeService")
public class UcEmployeeService implements IUcEmployeeService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.UcEmplMapper")
    UcEmplMapper employeeMapper;

    @CjTransaction
    @Override
    public String addEmployee(UcEmpl employee) throws CircuitException {
        if (StringUtil.isEmpty(employee.getCompanyId())) {
            throw new CircuitException("404", "公司编号为空");
        }
        if (StringUtil.isEmpty(employee.getDeptId())) {
            throw new CircuitException("404", "部门编号为空");
        }
        if (StringUtil.isEmpty(employee.getUserId())) {
            throw new CircuitException("404", "用户编号为空");
        }
        if (StringUtil.isEmpty(employee.getEmplCode())) {
            throw new CircuitException("404", "员工编号为空");
        }
        if (existsEmployee(employee.getUserId(), employee.getCompanyId(), employee.getEmplCode())) {
            throw new CircuitException("500", String.format("用户%s在公司%s存在同名员工%s", employee.getUserId(), employee.getCompanyId(), employee.getEmplCode()));
        }
        employee.setEmplId(NumberGen.gen());
        employeeMapper.insertSelective(employee);
        return employee.getEmplId();
    }

    private boolean existsEmployee(String userId, String companyId, String emplCode) {
        UcEmplExample example = new UcEmplExample();
        example.createCriteria().andUserIdEqualTo(userId).andCompanyIdEqualTo(companyId).andEmplCodeEqualTo(emplCode);
        return employeeMapper.countByExample(example) > 0;
    }

    @CjTransaction
    @Override
    public void removeEmployee(String emplid) throws CircuitException {
        employeeMapper.deleteByPrimaryKey(emplid);
    }

    @CjTransaction
    @Override
    public UcEmpl getEmployee(String emplid) throws CircuitException {
        return employeeMapper.selectByPrimaryKey(emplid);
    }

    @CjTransaction
    @Override
    public List<UcEmpl> listMyEmployee(String uid) throws CircuitException {
        UcEmplExample example = new UcEmplExample();
        example.createCriteria().andUserIdEqualTo(uid);
        return employeeMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public List<UcEmpl> pageEmployeeOfCompany(String companyid) throws CircuitException {
        UcEmplExample example = new UcEmplExample();
        example.createCriteria().andCompanyIdEqualTo(companyid);
        return employeeMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public List<UcEmpl> pageEmployeeOfDept(String companyid, String deptid) throws CircuitException {
        UcEmplExample example = new UcEmplExample();
        example.createCriteria().andCompanyIdEqualTo(companyid).andDeptIdEqualTo(deptid);
        return employeeMapper.selectByExample(example);
    }
}
