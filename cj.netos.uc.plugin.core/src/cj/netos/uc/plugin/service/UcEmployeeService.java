package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.UcEmployee;
import cj.netos.uc.domain.UcEmployeeExample;
import cj.netos.uc.plugin.dao.UcEmployeeMapper;
import cj.netos.uc.util.NumberGen;
import cj.netos.uc.service.IUcEmployeeService;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "ucEmployeeService")
public class UcEmployeeService implements IUcEmployeeService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UcEmployeeMapper")
    UcEmployeeMapper employeeMapper;

    @CjTransaction
    @Override
    public String addEmployee(UcEmployee employee) throws CircuitException {
        if (existsEmployee(employee.getUserId(), employee.getCompanyId(), employee.getEmplCode())) {
            throw new CircuitException("500", String.format("用户%s在公司%s存在同名员工%s", employee.getUserId(), employee.getCompanyId(), employee.getEmplCode()));
        }
        employee.setEmplId(NumberGen.gen());
        employeeMapper.insertSelective(employee);
        return employee.getEmplId();
    }

    private boolean existsEmployee(String userId, String companyId, String emplCode) {
        UcEmployeeExample example = new UcEmployeeExample();
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
    public UcEmployee getEmployee(String emplid) throws CircuitException {
        return employeeMapper.selectByPrimaryKey(emplid);
    }

    @CjTransaction
    @Override
    public List<UcEmployee> listMyEmployee(String uid) throws CircuitException {
        UcEmployeeExample example = new UcEmployeeExample();
        example.createCriteria().andUserIdEqualTo(uid);
        return employeeMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public List<UcEmployee> pageEmployeeOfCompany(String companyid) throws CircuitException {
        UcEmployeeExample example = new UcEmployeeExample();
        example.createCriteria().andCompanyIdEqualTo(companyid);
        return employeeMapper.selectByExample(example);
    }

    @Override
    public List<UcEmployee> pageEmployeeOfDept(String companyid,String deptid) throws CircuitException {
        UcEmployeeExample example = new UcEmployeeExample();
        example.createCriteria().andCompanyIdEqualTo(companyid).andDeptIdEqualTo(deptid);
        return employeeMapper.selectByExample(example);
    }
}
