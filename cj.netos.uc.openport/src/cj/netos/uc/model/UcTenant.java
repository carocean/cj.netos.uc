package cj.netos.uc.model;

import java.util.Date;

/**
 * Table: uc_tenant
 */
public class UcTenant {
    /**
     * Column: tenant_id
     */
    private String tenantId;

    /**
     * Column: tenant_name
     * Remark: 租户名
     */
    private String tenantName;

    /**
     * Column: user_id
     * Remark: 谁申请的租户，即租户的所有者
     */
    private String userId;

    /**
     * Column: is_enable
     * Remark: 是否可用，0是可用，1为失活
     */
    private Byte isEnable;

    /**
     * Column: website
     * Remark: 租户管理后台地址
     */
    private String website;

    /**
     * Column: create_time
     */
    private Date createTime;

    /**
     * Column: icon
     */
    private String icon;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName == null ? null : tenantName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Byte getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Byte isEnable) {
        this.isEnable = isEnable;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}