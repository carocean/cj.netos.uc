package cj.netos.uc.service;

import cj.netos.uc.domain.AppRole;
import cj.netos.uc.domain.TenantApp;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IAppService {
    String addApp(TenantApp app) throws CircuitException;

    void removeApp(String appid) throws CircuitException;

    TenantApp getApp(String appid) throws CircuitException;

    List<TenantApp> pageApp(String tenantid, int currPage, int pageSize) throws CircuitException;


}
