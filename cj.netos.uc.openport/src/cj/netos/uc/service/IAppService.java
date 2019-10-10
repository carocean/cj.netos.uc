package cj.netos.uc.service;

import cj.netos.uc.model.TenantApp;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IAppService {
    String addApp(String appid,String appName, String tenantId, long tokenExpire, String appLogo, String callbackUrl, String logoutUrl, String homeUrl) throws CircuitException;

    void removeApp(String appid) throws CircuitException;

    TenantApp getApp(String appid) throws CircuitException;

    List<TenantApp> pageApp(String tenantid, int currPage, int pageSize) throws CircuitException;


    boolean existsAppName(String tenantid, String appName);

    TenantApp getAppByName(String tenantid, String appName);

}
