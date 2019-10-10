package cj.netos.uc.port;

import cj.netos.uc.model.UcEmpl;
import cj.netos.uc.service.IUcEmployeeService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

@CjService(name = "/employee")
public class UcEmployeePorts implements IUcEmployeePort {
    @CjServiceRef(refByName = "ucplugin.ucEmployeeService")
    IUcEmployeeService ucEmployeeService;

    @Override
    public String addEmployee(UcEmpl employee) throws CircuitException {
        return ucEmployeeService.addEmployee(employee);
    }

    @Override
    public void removeEmployee(String emplid) throws CircuitException {
        ucEmployeeService.removeEmployee(emplid);
    }

    @Override
    public UcEmpl getEmployee(String emplid) throws CircuitException {
        return ucEmployeeService.getEmployee(emplid);
    }

    @Override
    public List<UcEmpl> listMyEmployee(String uid) throws CircuitException {
        return ucEmployeeService.listMyEmployee(uid);
    }

    @Override
    public List<UcEmpl> pageEmployeeOfCompany(String companyid) throws CircuitException {
        return ucEmployeeService.pageEmployeeOfCompany(companyid);
    }

    @Override
    public List<UcEmpl> pageEmployeeOfDept(String companyid, String deptid) throws CircuitException {
        return ucEmployeeService.pageEmployeeOfDept(companyid,deptid);
    }
}
