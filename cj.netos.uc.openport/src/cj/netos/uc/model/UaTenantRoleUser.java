package cj.netos.uc.model;

/**
 * Table: ua_tenant_role_user
 */
public class UaTenantRoleUser {
    /**
     * Column: role_id
     */
    private String roleId;

    /**
     * Column: user_id
     */
    private String userId;

    /**
     * Column: tenant_id
     */
    private String tenantId;

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

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }
}