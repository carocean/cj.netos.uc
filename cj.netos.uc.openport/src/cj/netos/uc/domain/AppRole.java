package cj.netos.uc.domain;

public class AppRole {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_role.role_id
     *
     * @mbg.generated Wed Aug 28 22:17:33 PHT 2019
     */
    private String roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_role.extend
     *
     * @mbg.generated Wed Aug 28 22:17:33 PHT 2019
     */
    private String extend;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_role.app_id
     *
     * @mbg.generated Wed Aug 28 22:17:33 PHT 2019
     */
    private String appId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_role.role_name
     *
     * @mbg.generated Wed Aug 28 22:17:33 PHT 2019
     */
    private String roleName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_role.role_id
     *
     * @return the value of app_role.role_id
     *
     * @mbg.generated Wed Aug 28 22:17:33 PHT 2019
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_role.role_id
     *
     * @param roleId the value for app_role.role_id
     *
     * @mbg.generated Wed Aug 28 22:17:33 PHT 2019
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_role.extend
     *
     * @return the value of app_role.extend
     *
     * @mbg.generated Wed Aug 28 22:17:33 PHT 2019
     */
    public String getExtend() {
        return extend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_role.extend
     *
     * @param extend the value for app_role.extend
     *
     * @mbg.generated Wed Aug 28 22:17:33 PHT 2019
     */
    public void setExtend(String extend) {
        this.extend = extend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_role.app_id
     *
     * @return the value of app_role.app_id
     *
     * @mbg.generated Wed Aug 28 22:17:33 PHT 2019
     */
    public String getAppId() {
        return appId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_role.app_id
     *
     * @param appId the value for app_role.app_id
     *
     * @mbg.generated Wed Aug 28 22:17:33 PHT 2019
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_role.role_name
     *
     * @return the value of app_role.role_name
     *
     * @mbg.generated Wed Aug 28 22:17:33 PHT 2019
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_role.role_name
     *
     * @param roleName the value for app_role.role_name
     *
     * @mbg.generated Wed Aug 28 22:17:33 PHT 2019
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}