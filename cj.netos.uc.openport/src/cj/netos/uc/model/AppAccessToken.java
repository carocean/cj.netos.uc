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