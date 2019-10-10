package cj.netos.uc.model;

/**
 * Table: ua_role_user
 */
public class UaRoleUser {
    /**
     * Column: role_id
     */
    private String roleId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}