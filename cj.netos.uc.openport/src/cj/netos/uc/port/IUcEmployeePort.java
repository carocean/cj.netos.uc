package cj.netos.uc.port;

import cj.netos.uc.model.UcEmpl;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.InRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "员工")
public interface IUcEmployeePort extends IOpenportService {
    @CjOpenport(command = "post", usage = "添加员工", acl = {"allow administrators.role", "allow tests.role", "allow developers.role"})
    String addEmployee(@CjOpenportParameter(usage = "员工", name = "employee", in = InRequest.content,simpleModelFile = "/models/employee.json") UcEmpl employee) throws CircuitException;

    @CjOpenport(usage = "移除员工", acl = {"allow administrators.role", "allow tests.role", "allow developers.role"})
    void removeEmployee(@CjOpenportParameter(name = "emplid", usage = "员工标识") String emplid) throws CircuitException;

    @CjOpenport(usage = "获取员工", acl = {"allow administrators.role", "allow tests.role", "allow developers.role"})
    UcEmpl getEmployee(@CjOpenportParameter(name = "emplid", usage = "员工标识") String emplid) throws CircuitException;

    @CjOpenport(usage = "列出用户的所有员工身份", elementType = UcEmpl.class, acl = {"allow administrators.role", "allow tests.role", "allow developers.role"})
    List<UcEmpl> listMyEmployee(@CjOpenportParameter(name = "uid", usage = "用户标识") String uid) throws CircuitException;

    @CjOpenport(usage = "列出用户的所有员工身份", elementType = UcEmpl.class, acl = {"allow administrators.role", "allow tests.role", "allow developers.role"})
    List<UcEmpl> pageEmployeeOfCompany(@CjOpenportParameter(name = "companyid", usage = "公司标识") String companyid) throws CircuitException;

    @CjOpenport(usage = "列出用户的所有员工身份", elementType = UcEmpl.class, acl = {"allow administrators.role", "allow tests.role", "allow developers.role"})
    List<UcEmpl> pageEmployeeOfDept(@CjOpenportParameter(name = "companyid", usage = "公司标识") String companyid, @CjOpenportParameter(name = "deptid", usage = "部门标识") String deptid) throws CircuitException;
}
