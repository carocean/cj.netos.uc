package cj.netos.uc.port;

import cj.netos.uc.model.UcDept;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.InRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "部门管理")
public interface IUcDeptPort extends IOpenportService {
    @CjOpenport(command = "post", usage = "添加部门", acl = {"allow administrators.role", "allow tests.role", "allow developers.role"})
    String addDept(@CjOpenportParameter(usage = "部门", name = "dept", in = InRequest.content,simpleModelFile = "/models/dept.json") UcDept dept) throws CircuitException;

    @CjOpenport(usage = "移除部门", acl = {"allow administrators.role", "allow tests.role", "allow developers.role"})
    void removeDept(@CjOpenportParameter(name = "deptid", usage = "部门标识") String deptid) throws CircuitException;

    @CjOpenport(command = "get", usage = "获取部门", acl = {"allow administrators.role", "allow tests.role", "allow developers.role"})
    UcDept getDept(@CjOpenportParameter(name = "deptid", usage = "部门标识") String deptid) throws CircuitException;

    @CjOpenport(command = "get", usage = "分页子部门", elementType = UcDept.class, acl = {"allow administrators.role", "allow tests.role", "allow developers.role"})
    List<UcDept> pageChildren(@CjOpenportParameter(name = "parentDeptid", usage = "父部门标识") String parentDeptid, @CjOpenportParameter(name = "currPage", usage = "当前页号") int currPage, @CjOpenportParameter(name = "pageSize", usage = "分页大小") int pageSize) throws CircuitException;

    @CjOpenport(command = "get", usage = "分页公司的部门", elementType = UcDept.class, acl = {"allow administrators.role", "allow tests.role", "allow developers.role"})
    List<UcDept> pageDeptOfCompany(@CjOpenportParameter(name = "companyid", usage = "公司标识") String companyid, @CjOpenportParameter(name = "currPage", usage = "当前页号") int currPage, @CjOpenportParameter(name = "pageSize", usage = "分页大小") int pageSize) throws CircuitException;
}
