package cj.netos.uc.model;

/**
 * Table: app_role
 */
public class AppRole {
    /**
     * Column: role_id
     * Type: VARCHAR(50)
     * Remark: 应用角色标识，表示为：role_code@app_id
     */
    private String roleId;

    /**
     * Column: role_code
     * Type: VARCHAR(50)
     * Remark: 角色代码
     */
    private String roleCode;

    /**
     * Column: role_name
     * Type: VARCHAR(50)
     * Remark: 角色名
     */
    private String roleName;

    /**
     * Column: app_id
     * Type: VARCHAR(50)
     * Remark: 应用标识
     */
    private String appId;

    /**
     * Column: extend
     * Type: VARCHAR(50)
     * Remark: 派生于租户角色标识
     */
    private String extend;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }
}