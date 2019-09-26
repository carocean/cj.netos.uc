package cj.netos.uc.domain;

import java.util.Date;

public class TenantApp {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tenant_app.app_id
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	private String appId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tenant_app.app_name
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	private String appName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tenant_app.tenant_id
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	private String tenantId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tenant_app.secret_key
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	private String secretKey;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tenant_app.token_expire
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	private Date tokenExpire;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tenant_app.app_logo
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	private String appLogo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tenant_app.callback_url
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	private String callbackUrl;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tenant_app.logout_url
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	private String logoutUrl;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tenant_app.home_url
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	private String homeUrl;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tenant_app.app_id
	 * @return  the value of tenant_app.app_id
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tenant_app.app_id
	 * @param appId  the value for tenant_app.app_id
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tenant_app.app_name
	 * @return  the value of tenant_app.app_name
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tenant_app.app_name
	 * @param appName  the value for tenant_app.app_name
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tenant_app.tenant_id
	 * @return  the value of tenant_app.tenant_id
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tenant_app.tenant_id
	 * @param tenantId  the value for tenant_app.tenant_id
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tenant_app.secret_key
	 * @return  the value of tenant_app.secret_key
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public String getSecretKey() {
		return secretKey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tenant_app.secret_key
	 * @param secretKey  the value for tenant_app.secret_key
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tenant_app.token_expire
	 * @return  the value of tenant_app.token_expire
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public Date getTokenExpire() {
		return tokenExpire;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tenant_app.token_expire
	 * @param tokenExpire  the value for tenant_app.token_expire
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public void setTokenExpire(Date tokenExpire) {
		this.tokenExpire = tokenExpire;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tenant_app.app_logo
	 * @return  the value of tenant_app.app_logo
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public String getAppLogo() {
		return appLogo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tenant_app.app_logo
	 * @param appLogo  the value for tenant_app.app_logo
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public void setAppLogo(String appLogo) {
		this.appLogo = appLogo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tenant_app.callback_url
	 * @return  the value of tenant_app.callback_url
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public String getCallbackUrl() {
		return callbackUrl;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tenant_app.callback_url
	 * @param callbackUrl  the value for tenant_app.callback_url
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tenant_app.logout_url
	 * @return  the value of tenant_app.logout_url
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public String getLogoutUrl() {
		return logoutUrl;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tenant_app.logout_url
	 * @param logoutUrl  the value for tenant_app.logout_url
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tenant_app.home_url
	 * @return  the value of tenant_app.home_url
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public String getHomeUrl() {
		return homeUrl;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tenant_app.home_url
	 * @param homeUrl  the value for tenant_app.home_url
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	public void setHomeUrl(String homeUrl) {
		this.homeUrl = homeUrl;
	}
}