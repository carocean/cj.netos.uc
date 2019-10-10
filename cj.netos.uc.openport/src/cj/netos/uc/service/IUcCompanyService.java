package cj.netos.uc.service;

import cj.netos.uc.model.UcCompany;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IUcCompanyService {
    String addCompany(UcCompany company) throws CircuitException;

    UcCompany getCompany(String companyid);

    boolean existsCompany(String companyCode, String parentId);

    void removeCompany(String companyid) throws CircuitException;

    List<UcCompany> pageCompany(int currPage, int pageSize) throws CircuitException;

    List<UcCompany> pageChildren(String pid, int currPage, int pageSize) throws CircuitException;

    void emptyChildren(String pid) throws CircuitException;

}
