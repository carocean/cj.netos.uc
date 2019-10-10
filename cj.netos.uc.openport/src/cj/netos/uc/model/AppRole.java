package cj.netos.uc.model;

/**
 * Table: app_role
 */
public class AppRole {
    /**
     * Column: role_id
     * Remark: 应用角色标识
     */
    private String roleId;

    /**
     * Column: app_id
     * Remark: 应用标识
     */
    private String appId;

    /**
     * Column: extend
     * Remark: 派生于租户角色标识
     */
    private String extend;

    /**
     * Column: role_name
     * Remark: 角色名
     */
    private String roleName;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}