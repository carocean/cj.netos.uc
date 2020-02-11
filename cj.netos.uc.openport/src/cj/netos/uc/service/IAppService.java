package cj.netos.uc.service;

import cj.netos.uc.model.AppAccount;
import cj.netos.uc.model.TenantApp;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

import java.util.List;

public interface IAppService {
    String addApp(String appcode, String appName,String portal, String tenantId, long tokenExpire, String appLogo, String website, String loginCBUrl, String logoutCBUrl) throws CircuitException;

    void removeApp(String appid) throws CircuitException;

    TenantApp getApp(String appid) throws CircuitException;

    List<TenantApp> pageApp(String tenantid, long currPage, int pageSize) throws CircuitException;


    boolean existsAppName(String tenantid, String appName);


    void reissueAppSecret(String appid, long tokenExpire);

    TenantApp getAppByName(String tenantid, String appName);


    void updateWebsite(String appid, String website, String loginCBUrl, String logoutCBUrl) throws CircuitException;

    void updateAppName(String appid, String newAppName) throws CircuitException;

    void upgradeBecomeDeveloper(String appid, String accountName)throws CircuitException;

    List<AppAccount> listMyAccount(String uid, String appid);

}
