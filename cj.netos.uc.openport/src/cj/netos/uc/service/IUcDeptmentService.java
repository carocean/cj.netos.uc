package cj.netos.uc.service;

import cj.netos.uc.domain.UcDept;
import cj.netos.uc.domain.UcEmployee;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

//部门列表是在公司处索引的，平铺出来没意义
public interface IUcDeptmentService {
    String addDept(UcDept dept) throws CircuitException;

    void removeDept(String deptid) throws CircuitException;

    UcDept getDept(String deptid) throws CircuitException;

    List<UcDept> pageChildren(String parentDeptid, int currPage, int pageSize) throws CircuitException;

    List<UcDept> pageDeptOfCompany(String companyid, int currPage, int pageSize) throws CircuitException;


}
