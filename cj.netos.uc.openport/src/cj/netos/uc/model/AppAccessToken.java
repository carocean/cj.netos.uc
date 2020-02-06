package cj.netos.uc.model;

/**
 * Table: app_access_token
 */
public class AppAccessToken {
    /**
     * Column: person
     * Remark: 即账户id
     */
    private String person;

    /**
     * Column: device
     * Remark: 设备 目的是让人可以同时在多个设备上使用同一个应用。即人可在多个设备上持有不同的访问令牌。如果没有设备字段，当小明即有ipad和iphone都装了gbera，当登了iphone记录了令牌，而后登ipad却把先前的令牌覆盖了，导致iphone上的令牌验证不通过。要知道同时拥有iphone和android的用户不在少数，他们一定会都装了gbera，所以一定得实现多设备
     */
    private String device;

    /**
     * Column: access_token
     * Remark: 访问令牌
     */
    private String accessToken;

    /**
     * Column: expire_time
     * Remark: 过期时间间隔
     */
    private Long expireTime;

    /**
     * Column: pub_time
     * Remark: 令牌发放时间
     */
    private Long pubTime;

    /**
     * Column: roles
     * Remark: 角色json列表
     */
    private String roles;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person == null ? null : person.trim();
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public Long getPubTime() {
        return pubTime;
    }

    public void setPubTime(Long pubTime) {
        this.pubTime = pubTime;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles == null ? null : roles.trim();
    }
}