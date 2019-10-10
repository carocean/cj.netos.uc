package cj.netos.uc.model;

/**
 * Table: uc_role
 */
public class UcRole {
    /**
     * Column: role_id
     * Remark: uc角色标识
     */
    private String roleId;

    /**
     * Column: role_name
     * Remark: 角色名
     */
    private String roleName;

    /**
     * Column: is_Inheritable
     * Remark: 是否可见对tenant_role，即是否可被继承，1为是，0为否
     */
    private Boolean isInheritable;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
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