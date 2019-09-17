package cj.netos.uc.service;

import cj.netos.uc.domain.UcCompany;
import cj.netos.uc.domain.UcDept;
import cj.netos.uc.domain.UcEmployee;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IUcCompanyService {
    String addCompany(UcCompany company)throws CircuitException;
    void removeCompany(String companyid)throws CircuitException;
    List<UcCompany> pageCompany(int currPage,int pageSize)throws CircuitException;
    List<UcCompany> pageChildren(String pid,int currPage,int pageSize)throws CircuitException;
    void removeChildren(String companyid,String pid);
    void addChildren(String companyid,String pid);
    void emptyChildren(String pid)throws CircuitException;
    List<UcDept> listTopDeptOfCompany(String companyid)throws CircuitException;
    void addTopDeptToCompany(String deptid,String companyid)throws CircuitException;
    void removeTopDeptFromCompany(String deptid,String companyid)throws CircuitException;
    List<UcEmployee> pageEmployee(String companyid)throws CircuitException;
}
