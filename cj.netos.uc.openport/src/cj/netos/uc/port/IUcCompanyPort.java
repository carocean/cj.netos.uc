package cj.netos.uc.port;

import cj.netos.uc.domain.UcCompany;
import cj.netos.uc.domain.UcDept;
import cj.netos.uc.domain.UcEmployee;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.InRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.ArrayList;
import java.util.List;

@CjOpenports(usage = "平台所属的集团及其子公司的组织架构")
public interface IUcCompanyPort extends IOpenportService {
    @CjOpenport(usage = "添加公司", command = "post")
    String addCompany(@CjOpenportParameter(usage = "公司", name = "company", in = InRequest.content) UcCompany company) throws CircuitException;

    @CjOpenport(usage = "移除公司")
    void removeCompany(@CjOpenportParameter(usage = "公司标识", name = "companyid") String companyid) throws CircuitException;

    @CjOpenport(usage = "分页公司", elementType = UcCompany.class, type = ArrayList.class)
    List<UcCompany> pageCompany(@CjOpenportParameter(usage = "当前页", name = "currPage") int currPage, @CjOpenportParameter(usage = "页大小", name = "pageSize") int pageSize) throws CircuitException;

    @CjOpenport(usage = "分页子公司", elementType = UcCompany.class, type = ArrayList.class)
    List<UcCompany> pageChildren(@CjOpenportParameter(usage = "父公司标识", name = "pid") String pid, @CjOpenportParameter(usage = "当前页", name = "currPage") int currPage, @CjOpenportParameter(usage = "页大小", name = "pageSize") int pageSize) throws CircuitException;

    @CjOpenport(usage = "移除子公司")
    void removeChildren(@CjOpenportParameter(usage = "公司标识", name = "companyid") String companyid, @CjOpenportParameter(usage = "父公司标识", name = "pid") String pid);

    @CjOpenport(usage = "添加子公司")
    void addChildren(@CjOpenportParameter(usage = "公司标识", name = "companyid") String companyid, @CjOpenportParameter(usage = "父公司标识", name = "pid") String pid);

    @CjOpenport(usage = "清空父公司下的子公司")
    void emptyChildren(@CjOpenportParameter(usage = "父公司标识", name = "pid") String pid) throws CircuitException;

    @CjOpenport(usage = "列出公司一级部门", elementType = UcDept.class, type = ArrayList.class)
    List<UcDept> listTopDeptOfCompany(@CjOpenportParameter(usage = "公司标识", name = "companyid") String companyid) throws CircuitException;

    @CjOpenport(usage = "添加一级部门到公司")
    void addTopDeptToCompany(@CjOpenportParameter(usage = "部门标识", name = "deptid") String deptid, @CjOpenportParameter(usage = "公司标识", name = "companyid") String companyid) throws CircuitException;

    @CjOpenport(usage = "移除一级部门从公司")
    void removeTopDeptFromCompany(@CjOpenportParameter(usage = "部门标识", name = "deptid") String deptid, @CjOpenportParameter(usage = "公司标识", name = "companyid") String companyid) throws CircuitException;

    @CjOpenport(usage = "列出公司的所有员工", elementType = UcEmployee.class, type = ArrayList.class)
    List<UcEmployee> pageEmployee(@CjOpenportParameter(usage = "公司标识", name = "companyid") String companyid) throws CircuitException;
}
