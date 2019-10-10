package cj.netos.uc.model;

/**
 * Table: ua_role_empl
 */
public class UaRoleEmpl {
    /**
     * Column: empl_id
     */
    private String emplId;

    /**
     * Column: role_id
     */
    private String roleId;

    public String getEmplId() {
        return emplId;
    }

    public void setEmplId(String emplId) {
        this.emplId = emplId == null ? null : emplId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}