package cj.netos.uc.service;

import cj.netos.uc.domain.UcEmployee;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IUcEmployeeService {
    String addEmployee(UcEmployee employee) throws CircuitException;

    void removeEmployee(String emplid) throws CircuitException;

    UcEmployee getEmployee(String emplid) throws CircuitException;

    List<UcEmployee> listMyEmployee(String uid) throws CircuitException;

    List<UcEmployee> pageEmployeeOfCompany(String companyid) throws CircuitException;

    List<UcEmployee> pageEmployeeOfDept(String companyid,String deptid) throws CircuitException;
}
