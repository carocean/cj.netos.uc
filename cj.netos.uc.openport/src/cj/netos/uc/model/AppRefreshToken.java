package cj.netos.uc.model;

/**
 * Table: app_refresh_token
 */
public class AppRefreshToken {
    /**
     * Column: person
     * Remark: 设备 目的是让人可以同时在多个设备上使用同一个应用。即人可在多个设备上持有不同的访问令牌。如果没有设备字段，当小明即有ipad和iphone都装了gbera，当登了iphone记录了令牌，而后登ipad却把先前的令牌覆盖了，导致iphone上的令牌验证不通过。要知道同时拥有iphone和android的用户不在少数，他们一定会都装了gbera，所以一定得实现多设备
     */
    private String person;

    /**
     * Column: device
     */
    private String device;

    /**
     * Column: refresh_token
     */
    private String refreshToken;

    /**
     * Column: pub_time
     */
    private Long pubTime;

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

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken == null ? null : refreshToken.trim();
    }

    public Long getPubTime() {
        return pubTime;
    }

    public void setPubTime(Long pubTime) {
        this.pubTime = pubTime;
    }
}