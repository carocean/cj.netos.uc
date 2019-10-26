package cj.netos.uc.model;

import java.util.List;

public class IdentityInfo {
    String uid;
    String accountid;
    String accountName;
    String appid;
    String tenantid;
    String accessToken;
    List<UcRole> ucRoles;
    List<TenantRole> tenantRoles;
    List<AppRole> appRoles;

    public void setUcRoles(List<UcRole> ucRoles) {
        this.ucRoles = ucRoles;
    }

    public void setTenantRoles(List<TenantRole> tenantRoles) {
        this.tenantRoles = tenantRoles;
    }

    public void setAppRoles(List<AppRole> appRoles) {
        this.appRoles = appRoles;
    }

    public String getTenantid() {
        return tenantid;
    }

    public void setTenantid(String tenantid) {
        this.tenantid = tenantid;
    }

    public List<UcRole> getUcRoles() {
        return ucRoles;
    }

    public List<TenantRole> getTenantRoles() {
        return tenantRoles;
    }

    public List<AppRole> getAppRoles() {
        return appRoles;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
