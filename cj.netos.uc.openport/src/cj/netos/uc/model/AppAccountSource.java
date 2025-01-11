package cj.netos.uc.model;

public class AppAccountSource {
    private String accountId;

    private String subSystem;

    private String subSysOpenid;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getSubSystem() {
        return subSystem;
    }

    public void setSubSystem(String subSystem) {
        this.subSystem = subSystem == null ? null : subSystem.trim();
    }

    public String getSubSysOpenid() {
        return subSysOpenid;
    }

    public void setSubSysOpenid(String subSysOpenid) {
        this.subSysOpenid = subSysOpenid == null ? null : subSysOpenid.trim();
    }
}