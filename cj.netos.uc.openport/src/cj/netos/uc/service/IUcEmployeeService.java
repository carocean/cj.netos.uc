package cj.netos.uc.service;

import cj.netos.uc.model.UcEmpl;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IUcEmployeeService {
    String addEmployee(UcEmpl employee) throws CircuitException;

    void removeEmployee(String emplid) throws CircuitException;

    UcEmpl getEmployee(String emplid) throws CircuitException;

    List<UcEmpl> listMyEmployee(String uid) throws CircuitException;

    List<UcEmpl> pageEmployeeOfCompany(String companyid) throws CircuitException;

    List<UcEmpl> pageEmployeeOfDept(String companyid, String deptid) throws CircuitException;
}
