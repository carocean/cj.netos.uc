package cj.netos.uc.port;

import cj.netos.uc.model.UcDept;
import cj.netos.uc.service.IUcDeptmentService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

@CjService(name = "/dept")
public class UcDeptPorts implements IUcDeptPort {
    @CjServiceRef(refByName = "ucplugin.ucDeptService")
    IUcDeptmentService ucDeptmentService;

    @Override
    public String addDept(UcDept dept) throws CircuitException {
        return ucDeptmentService.addDept(dept);
    }

    @Override
    public void removeDept(String deptid) throws CircuitException {
        ucDeptmentService.removeDept(deptid);
    }

    @Override
    public UcDept getDept(String deptid) throws CircuitException {
        return ucDeptmentService.getDept(deptid);
    }

    @Override
    public List<UcDept> pageChildren(String parentDeptid, int currPage, int pageSize) throws CircuitException {
        return ucDeptmentService.pageChildren(parentDeptid, currPage, pageSize);
    }

    @Override
    public List<UcDept> pageDeptOfCompany(String companyid, int currPage, int pageSize) throws CircuitException {
        return ucDeptmentService.pageDeptOfCompany(companyid, currPage, pageSize);
    }
}
