package cj.netos.uc.port;

import cj.netos.uc.domain.UcDept;
import cj.netos.uc.domain.UcEmployee;
import cj.netos.uc.service.IUcDeptmentService;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.InRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "部门管理")
public interface IUcDeptPort extends IOpenportService {
    @CjOpenport(command = "post", usage = "添加部门")
    String addDept(@CjOpenportParameter(usage = "部门", name = "dept", in = InRequest.content) UcDept dept) throws CircuitException;

    @CjOpenport(usage = "移除部门")
    void removeDept(@CjOpenportParameter(name = "deptid", usage = "部门标识") String deptid) throws CircuitException;

    @CjOpenport(command = "get", usage = "获取部门")
    UcDept getDept(@CjOpenportParameter(name = "deptid", usage = "部门标识") String deptid) throws CircuitException;

    @CjOpenport(command = "get", usage = "分页子部门")
    List<UcDept> pageChildren(@CjOpenportParameter(name = "parentDeptid", usage = "父部门标识") String parentDeptid, @CjOpenportParameter(name = "currPage", usage = "当前页号") int currPage, @CjOpenportParameter(name = "pageSize", usage = "分页大小") int pageSize) throws CircuitException;

    @CjOpenport(command = "get", usage = "移除子部门")
    void removeChildren(@CjOpenportParameter(name = "deptid", usage = "部门标识") String deptid, @CjOpenportParameter(name = "parentDeptid", usage = "父部门标识") String parentDeptid) throws CircuitException;

    @CjOpenport(command = "get", usage = "添加子部门")
    void addChildren(@CjOpenportParameter(name = "deptid", usage = "部门标识") String deptid, @CjOpenportParameter(name = "parentDeptid", usage = "父部门标识") String parentDeptid) throws CircuitException;

    @CjOpenport(command = "get", usage = "分页部门员工")
    List<UcEmployee> pageEmployee(@CjOpenportParameter(name = "deptid", usage = "部门标识") String deptid) throws CircuitException;
}
