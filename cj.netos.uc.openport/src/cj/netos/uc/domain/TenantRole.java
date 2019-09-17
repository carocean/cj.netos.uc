package cj.netos.uc.domain;

public class TenantRole {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tenant_role.role_id
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	private String roleId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tenant_role.extend
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	private String extend;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tenant_role.tenant_id
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	private String tenantId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tenant_role.role_name
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	private String roleName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tenant_role.is_Inheritable
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	private Boolean isInheritable;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tenant_role.role_id
	 * @return  the value of tenant_role.role_id
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tenant_role.role_id
	 * @param roleId  the value for tenant_role.role_id
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tenant_role.extend
	 * @return  the value of tenant_role.extend
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public String getExtend() {
		return extend;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tenant_role.extend
	 * @param extend  the value for tenant_role.extend
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public void setExtend(String extend) {
		this.extend = extend;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tenant_role.tenant_id
	 * @return  the value of tenant_role.tenant_id
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tenant_role.tenant_id
	 * @param tenantId  the value for tenant_role.tenant_id
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tenant_role.role_name
	 * @return  the value of tenant_role.role_name
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tenant_role.role_name
	 * @param roleName  the value for tenant_role.role_name
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tenant_role.is_Inheritable
	 * @return  the value of tenant_role.is_Inheritable
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public Boolean getIsInheritable() {
		return isInheritable;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tenant_role.is_Inheritable
	 * @param isInheritable  the value for tenant_role.is_Inheritable
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public void setIsInheritable(Boolean isInheritable) {
		this.isInheritable = isInheritable;
	}
}