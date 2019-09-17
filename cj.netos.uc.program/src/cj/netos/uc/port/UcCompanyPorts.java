package cj.netos.uc.port;

import cj.netos.uc.domain.UcCompany;
import cj.netos.uc.domain.UcDept;
import cj.netos.uc.domain.UcEmployee;
import cj.netos.uc.service.IUcCompanyService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

@CjService(name = "/company")
public class UcCompanyPorts implements IUcCompanyPort {
    @CjServiceRef(refByName = "ucplugin.ucCompanyService")
    IUcCompanyService ucCompanyService;

    @Override
    public String addCompany(UcCompany company) throws CircuitException {
        return ucCompanyService.addCompany(company);
    }

    @Override
    public void removeCompany(String companyid) throws CircuitException {
        ucCompanyService.removeCompany(companyid);
    }

    @Override
    public List<UcCompany> pageCompany(int currPage, int pageSize) throws CircuitException {
        return ucCompanyService.pageCompany(currPage, pageSize);
    }

    @Override
    public List<UcCompany> pageChildren(String pid, int currPage, int pageSize) throws CircuitException {
        return ucCompanyService.pageChildren(pid, currPage, pageSize);
    }

    @Override
    public void removeChildren(String companyid, String pid) {
        ucCompanyService.removeChildren(companyid, pid);
    }

    @Override
    public void addChildren(String companyid, String pid) {
        ucCompanyService.addChildren(companyid, pid);
    }

    @Override
    public void emptyChildren(String pid) throws CircuitException {
        ucCompanyService.emptyChildren(pid);
    }

    @Override
    public List<UcDept> listTopDeptOfCompany(String companyid) throws CircuitException {
        return ucCompanyService.listTopDeptOfCompany(companyid);
    }

    @Override
    public void addTopDeptToCompany(String deptid, String companyid) throws CircuitException {
        ucCompanyService.addTopDeptToCompany(deptid, companyid);
    }

    @Override
    public void removeTopDeptFromCompany(String deptid, String companyid) throws CircuitException {
        ucCompanyService.removeTopDeptFromCompany(deptid, companyid);
    }

    @Override
    public List<UcEmployee> pageEmployee(String companyid) throws CircuitException {
        return ucCompanyService.pageEmployee(companyid);
    }
}
