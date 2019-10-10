package cj.netos.uc.model;

/**
 * Table: ua_app_role_user
 */
public class UaAppRoleUser {
    /**
     * Column: role_id
     */
    private String roleId;

    /**
     * Column: user_id
     */
    private String userId;

    /**
     * Column: app_id
     */
    private String appId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }
}