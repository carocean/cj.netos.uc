package cj.netos.uc.service;

import cj.netos.uc.domain.AppRole;
import cj.netos.uc.domain.TenantApp;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface ITenantAppService {
    String addApp(TenantApp app)throws CircuitException;

    void removeApp(String appid)throws CircuitException;

    TenantApp getApp(String appid)throws CircuitException;

    List<AppRole> pageRoleOfApp(String appid, int currPage, int pageSize)throws CircuitException;

    void addRoleToApp(String roleid, String appid)throws CircuitException;

    void removeRoleFromApp(String roleid, String appid)throws CircuitException;

    void emptyRoleOfApp(String appid)throws CircuitException;
}
