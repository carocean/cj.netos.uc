package cj.netos.uc.domain;

import java.util.Date;

public class UcUser {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column uc_user.user_id
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	private String userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column uc_user.user_name
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	private String userName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column uc_user.create_time
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	private Date createTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column uc_user.sex
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	private Byte sex;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column uc_user.email
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	private String email;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column uc_user.mobile
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	private String mobile;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column uc_user.idcard
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	private String idcard;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column uc_user.user_id
	 * @return  the value of uc_user.user_id
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column uc_user.user_id
	 * @param userId  the value for uc_user.user_id
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column uc_user.user_name
	 * @return  the value of uc_user.user_name
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column uc_user.user_name
	 * @param userName  the value for uc_user.user_name
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column uc_user.create_time
	 * @return  the value of uc_user.create_time
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column uc_user.create_time
	 * @param createTime  the value for uc_user.create_time
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column uc_user.sex
	 * @return  the value of uc_user.sex
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	public Byte getSex() {
		return sex;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column uc_user.sex
	 * @param sex  the value for uc_user.sex
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	public void setSex(Byte sex) {
		this.sex = sex;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column uc_user.email
	 * @return  the value of uc_user.email
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column uc_user.email
	 * @param email  the value for uc_user.email
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column uc_user.mobile
	 * @return  the value of uc_user.mobile
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column uc_user.mobile
	 * @param mobile  the value for uc_user.mobile
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column uc_user.idcard
	 * @return  the value of uc_user.idcard
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	public String getIdcard() {
		return idcard;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column uc_user.idcard
	 * @param idcard  the value for uc_user.idcard
	 * @mbg.generated  Tue Oct 08 11:15:13 CST 2019
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
}