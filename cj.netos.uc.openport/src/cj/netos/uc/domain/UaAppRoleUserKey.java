package cj.netos.uc.domain;

public class UaAppRoleUserKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ua_app_role_user.role_id
	 * @mbg.generated  Tue Oct 08 11:15:14 CST 2019
	 */
	private String roleId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ua_app_role_user.user_id
	 * @mbg.generated  Tue Oct 08 11:15:14 CST 2019
	 */
	private String userId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ua_app_role_user.role_id
	 * @return  the value of ua_app_role_user.role_id
	 * @mbg.generated  Tue Oct 08 11:15:14 CST 2019
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ua_app_role_user.role_id
	 * @param roleId  the value for ua_app_role_user.role_id
	 * @mbg.generated  Tue Oct 08 11:15:14 CST 2019
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ua_app_role_user.user_id
	 * @return  the value of ua_app_role_user.user_id
	 * @mbg.generated  Tue Oct 08 11:15:14 CST 2019
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ua_app_role_user.user_id
	 * @param userId  the value for ua_app_role_user.user_id
	 * @mbg.generated  Tue Oct 08 11:15:14 CST 2019
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
}