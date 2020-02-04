package cj.netos.uc.model;

/**
 * Table: app_refresh_token
 */
public class AppRefreshToken {
    /**
     * Column: person
     */
    private String person;

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