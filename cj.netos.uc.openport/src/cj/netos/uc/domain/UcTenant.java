package cj.netos.uc.domain;

import java.util.Date;

public class UcTenant {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column uc_tenant.tenant_id
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	private String tenantId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column uc_tenant.tenant_name
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	private String tenantName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column uc_tenant.user_id
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	private String userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column uc_tenant.is_enable
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	private Byte isEnable;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column uc_tenant.secret_key
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	private String secretKey;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column uc_tenant.website
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	private String website;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column uc_tenant.create_time
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	private Date createTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column uc_tenant.tenant_id
	 * @return  the value of uc_tenant.tenant_id
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column uc_tenant.tenant_id
	 * @param tenantId  the value for uc_tenant.tenant_id
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column uc_tenant.tenant_name
	 * @return  the value of uc_tenant.tenant_name
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public String getTenantName() {
		return tenantName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column uc_tenant.tenant_name
	 * @param tenantName  the value for uc_tenant.tenant_name
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column uc_tenant.user_id
	 * @return  the value of uc_tenant.user_id
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column uc_tenant.user_id
	 * @param userId  the value for uc_tenant.user_id
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column uc_tenant.is_enable
	 * @return  the value of uc_tenant.is_enable
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public Byte getIsEnable() {
		return isEnable;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column uc_tenant.is_enable
	 * @param isEnable  the value for uc_tenant.is_enable
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public void setIsEnable(Byte isEnable) {
		this.isEnable = isEnable;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column uc_tenant.secret_key
	 * @return  the value of uc_tenant.secret_key
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public String getSecretKey() {
		return secretKey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column uc_tenant.secret_key
	 * @param secretKey  the value for uc_tenant.secret_key
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column uc_tenant.website
	 * @return  the value of uc_tenant.website
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column uc_tenant.website
	 * @param website  the value for uc_tenant.website
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column uc_tenant.create_time
	 * @return  the value of uc_tenant.create_time
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column uc_tenant.create_time
	 * @param createTime  the value for uc_tenant.create_time
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}