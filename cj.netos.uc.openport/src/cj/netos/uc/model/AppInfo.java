package cj.netos.uc.model;

import java.util.Date;

public class AppInfo {
    String appid;
    String appCode;
    String appName;
    String website;
    String tenantId;
    String tenantName;
    long tenantCTime;
    String appLogo;
    String loginCbUrl;
    String logoutCbUrl;
    long appCTime;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public long getTenantCTime() {
        return tenantCTime;
    }

    public void setTenantCTime(long tenantCTime) {
        this.tenantCTime = tenantCTime;
    }

    public String getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(String appLogo) {
        this.appLogo = appLogo;
    }

    public String getLoginCbUrl() {
        return loginCbUrl;
    }

    public void setLoginCbUrl(String loginCbUrl) {
        this.loginCbUrl = loginCbUrl;
    }

    public String getLogoutCbUrl() {
        return logoutCbUrl;
    }

    public void setLogoutCbUrl(String logoutCbUrl) {
        this.logoutCbUrl = logoutCbUrl;
    }

    public long getAppCTime() {
        return appCTime;
    }

    public void setAppCTime(long appCTime) {
        this.appCTime = appCTime;
    }
}
