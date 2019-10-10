package cj.netos.uc.model;

/**
 * Table: tenant_app
 */
public class TenantApp {
    /**
     * Column: app_id
     * Remark: 应用id
     */
    private String appId;

    /**
     * Column: app_name
     * Remark: 应用名
     */
    private String appName;

    /**
     * Column: tenant_id
     */
    private String tenantId;

    /**
     * Column: secret_key
     * Remark: 接入密钥
     */
    private String secretKey;

    /**
     * Column: token_expire
     * Remark: 令牌过期时间间隔
     */
    private Long tokenExpire;

    /**
     * Column: app_logo
     * Remark: 应用的logo图片，如需展示时使用
     */
    private String appLogo;

    /**
     * Column: callback_url
     * Remark: 登录 URL。验证成功后平台通过回调应用的应用地址发出通知
     */
    private String callbackUrl;

    /**
     * Column: logout_url
     * Remark: 注销 URL，注销成功后回调应用发出注销通知的应用地址
     */
    private String logoutUrl;

    /**
     * Column: home_url
     * Remark: 首页地址，如果有
     */
    private String homeUrl;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey == null ? null : secretKey.trim();
    }

    public Long getTokenExpire() {
        return tokenExpire;
    }

    public void setTokenExpire(Long tokenExpire) {
        this.tokenExpire = tokenExpire;
    }

    public String getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(String appLogo) {
        this.appLogo = appLogo == null ? null : appLogo.trim();
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl == null ? null : callbackUrl.trim();
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl == null ? null : logoutUrl.trim();
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl == null ? null : homeUrl.trim();
    }
}