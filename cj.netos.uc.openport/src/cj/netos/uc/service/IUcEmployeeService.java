package cj.netos.uc.service;

import cj.netos.uc.domain.UcEmployee;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IUcEmployeeService {
    String addEmployee(UcEmployee employee) throws CircuitException;

    void removeEmployee(String emplid) throws CircuitException;

    UcEmployee getEmployee(String emplid) throws CircuitException;

}
