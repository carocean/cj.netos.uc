package cj.netos.uc.model;

/**
 * Table: ua_app_role_person
 */
public class UaAppRolePerson {
    /**
     * Column: role_id
     */
    private String roleId;

    /**
     * Column: account_id
     */
    private String accountId;

    /**
     * Column: app_id
     */
    private String appId;

    /**
     * Column: tenant_id
     */
    private String tenantId;

    /**
     * Column: user_id
     */
    private String userId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}