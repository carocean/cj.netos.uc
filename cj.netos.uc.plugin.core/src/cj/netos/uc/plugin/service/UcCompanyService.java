package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.UcCompany;
import cj.netos.uc.domain.UcCompanyExample;
import cj.netos.uc.plugin.dao.UcCompanyMapper;
import cj.netos.uc.util.NumberGen;
import cj.netos.uc.service.IUcCompanyService;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "ucCompanyService")
public class UcCompanyService implements IUcCompanyService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.dao.UcCompanyMapper")
    UcCompanyMapper companyMapper;
    @CjTransaction
    @Override
    public String addCompany(UcCompany company) throws CircuitException {
        if (existsCompany(company.getCompanyCode(), company.getParentId())) {
            throw new CircuitException("500", String.format("在公司%s下已存在子公司：%s", company.getParentId(), company.getCompanyCode()));
        }
        company.setCompanyId(NumberGen.gen());
        companyMapper.insertSelective(company);
        return company.getCompanyId();
    }

    @CjTransaction
    @Override
    public UcCompany getCompany(String companyid) {
        return companyMapper.selectByPrimaryKey(companyid);
    }

    @CjTransaction
    @Override
    public boolean existsCompany(String companyCode, String parentId) {
        UcCompanyExample example = new UcCompanyExample();
        example.createCriteria().andCompanyCodeEqualTo(companyCode).andParentIdEqualTo(parentId);
        return companyMapper.countByExample(example) > 0;
    }

    @CjTransaction
    @Override
    public void removeCompany(String companyid) throws CircuitException {
        companyMapper.deleteByPrimaryKey(companyid);
    }

    @CjTransaction
    @Override
    public List<UcCompany> pageCompany(int currPage, int pageSize) throws CircuitException {
        return companyMapper.pageCompany(currPage, pageSize);
    }

    @CjTransaction
    @Override
    public List<UcCompany> pageChildren(String pid, int currPage, int pageSize) throws CircuitException {
        return companyMapper.pageChildren(pid, currPage, pageSize);
    }


    @CjTransaction
    @Override
    public void emptyChildren(String pid) throws CircuitException {
        companyMapper.emptyChildren(pid);
    }



}
