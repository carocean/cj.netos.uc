package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.UcDept;
import cj.netos.uc.domain.UcDeptExample;
import cj.netos.uc.plugin.dao.UcDeptMapper;
import cj.netos.uc.util.NumberGen;
import cj.netos.uc.service.IUcCompanyService;
import cj.netos.uc.service.IUcDeptmentService;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.util.StringUtil;

import java.util.Date;
import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "ucDeptService")
public class UcDeptService implements IUcDeptmentService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UcDeptMapper")
    UcDeptMapper deptMapper;
    @CjServiceRef
    IUcCompanyService ucCompanyService;

    @CjTransaction
    @Override
    public String addDept(UcDept dept) throws CircuitException {
        if (StringUtil.isEmpty(dept.getDeptCode())) {
            throw new CircuitException("404", "部门标识为空");
        }
        if (StringUtil.isEmpty(dept.getDeptName())) {
            throw new CircuitException("404", "部门名为空");
        }
        if (StringUtil.isEmpty(dept.getCompanyId())) {
            throw new CircuitException("404", "公司标识为空");
        }
        if (StringUtil.isEmpty(dept.getDeptCode())) {
            throw new CircuitException("404", "公司编号为空");
        }
        if (existsChildDeptInCompany(dept.getCompanyId(), dept.getParentId(), dept.getDeptCode())) {
            throw new CircuitException("500", String.format("在公司：%s的部门：%s下存在同名子部门：%s", dept.getCompanyId(), dept.getParentId(), dept.getDeptCode()));
        }
        if (ucCompanyService.getCompany(dept.getCompanyId()) == null) {
            throw new CircuitException("404", "公司不存在:" + dept.getCompanyId());
        }
        dept.setCreateTime(new Date());
        dept.setDeptId(NumberGen.gen());
        deptMapper.insertSelective(dept);
        return dept.getDeptId();
    }

    private boolean existsChildDeptInCompany(String companyId, String parentId, String deptCode) {
        UcDeptExample example = new UcDeptExample();
        example.createCriteria().andCompanyIdEqualTo(companyId).andParentIdEqualTo(parentId).andDeptCodeEqualTo(deptCode);
        return deptMapper.countByExample(example) > 0;
    }

    @CjTransaction
    @Override
    public void removeDept(String deptid) throws CircuitException {
        deptMapper.deleteByPrimaryKey(deptid);
    }

    @CjTransaction
    @Override
    public UcDept getDept(String deptid) throws CircuitException {
        return deptMapper.selectByPrimaryKey(deptid);
    }

    @CjTransaction
    @Override
    public List<UcDept> pageChildren(String parentDeptid, int currPage, int pageSize) throws CircuitException {
        return deptMapper.pageChildren(parentDeptid, currPage, pageSize);
    }

    @CjTransaction
    @Override
    public List<UcDept> pageDeptOfCompany(String companyid, int currPage, int pageSize) throws CircuitException {
        return deptMapper.pageDeptOfCompany(companyid, currPage, pageSize);
    }
}
