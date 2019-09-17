package cj.netos.uc.port;

import cj.netos.uc.domain.UcEmployee;
import cj.netos.uc.service.IUcCompanyService;
import cj.netos.uc.service.IUcEmployeeService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
@CjService(name = "/employee")
public class UcEmployeePorts implements IUcEmployeePort {
    @CjServiceRef(refByName = "ucplugin.ucEmployeeService")
    IUcEmployeeService ucEmployeeService;

    @Override
    public String addEmployee(UcEmployee employee) throws CircuitException {
        return ucEmployeeService.addEmployee(employee);
    }

    @Override
    public void removeEmployee(String emplid) throws CircuitException {
        ucEmployeeService.removeEmployee(emplid);
    }

    @Override
    public UcEmployee getEmployee(String emplid) throws CircuitException {
        return ucEmployeeService.getEmployee(emplid);
    }
}
