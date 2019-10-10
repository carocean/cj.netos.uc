package cj.netos.uc.model;

/**
 * Table: tenant_role
 */
public class TenantRole {
    /**
     * Column: role_id
     * Remark: 租户角色标识
     */
    private String roleId;

    /**
     * Column: tenant_id
     * Remark: 租户标识
     */
    private String tenantId;

    /**
     * Column: extend
     * Remark: 派生于uc角色标识
     */
    private String extend;

    /**
     * Column: role_name
     * Remark: 角色名
     */
    private String roleName;

    /**
     * Column: is_Inheritable
     */
    private Boolean isInheritable;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Boolean getIsInheritable() {
        return isInheritable;
    }

    public void setIsInheritable(Boolean isInheritable) {
        this.isInheritable = isInheritable;
    }
}