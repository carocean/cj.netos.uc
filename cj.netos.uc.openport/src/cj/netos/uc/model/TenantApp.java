package cj.netos.uc.model;

/**
 * Table: tenant_app
 */
public class TenantApp {
    /**
     * Column: app_id
     * Remark: 应用id=app_code.tenant_id的组合
     */
    private String appId;

    /**
     * Column: app_code
     * Remark: 应用代码，表是在一个租户下的应用唯一代码
     */
    private String appCode;

    /**
     * Column: app_name
     * Remark: 应用名
     */
    private String appName;

    /**
     * Column: tenant_id
     * Remark: 租户
     */
    private String tenantId;

    /**
     * Column: app_key
     * Remark: 应用key
     */
    private String appKey;

    /**
     * Column: app_secret
     * Remark: 接入密钥
     */
    private String appSecret;

    /**
     * Column: token_expire
     * Remark: 访问令牌过期时间间隔
     */
    private Long tokenExpire;

    /**
     * Column: app_logo
     * Remark: 应用的logo图片相对地址，如需展示时使用
     */
    private String appLogo;

    /**
     * Column: portal
     * Remark: 应用使用的在终端上的渲染框架
     */
    private String portal;

    /**
     * Column: website
     * Remark: 应用的网站地址
     */
    private String website;

    /**
     * Column: login_cb_url
     * Remark: 登录相对website的回调地址。验证成功后uc通过回调应用的应用地址发出通知
     */
    private String loginCbUrl;

    /**
     * Column: logout_cb_url
     * Remark: 注销相对website的回调地址，注销成功后uc回调应用发出注销通知的应用地址
     */
    private String logoutCbUrl;

    /**
     * Column: ctime
     * Remark: App创建时间
     */
    private Long ctime;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode == null ? null : appCode.trim();
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

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
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

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal == null ? null : portal.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getLoginCbUrl() {
        return loginCbUrl;
    }

    public void setLoginCbUrl(String loginCbUrl) {
        this.loginCbUrl = loginCbUrl == null ? null : loginCbUrl.trim();
    }

    public String getLogoutCbUrl() {
        return logoutCbUrl;
    }

    public void setLogoutCbUrl(String logoutCbUrl) {
        this.logoutCbUrl = logoutCbUrl == null ? null : logoutCbUrl.trim();
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }
}