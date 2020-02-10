package cj.netos.uc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonInfo {
    String person;
    String uid;
    String accountCode;
    String nickName;
    String realName;
    String signature;
    String avatar;
    String appid;
    String sex;
    List<String> roles;
    Map<String,Object> domains;
    public PersonInfo(String accountCode, String appid) {
        roles = new ArrayList<>();
        this.accountCode = accountCode;
        this.appid=appid;
        this.person = String.format("%s@%s", accountCode, appid);
    }

    public Map<String, Object> getDomains() {
        return domains;
    }

    public void setDomains(Map<String, Object> domains) {
        this.domains = domains;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPerson() {
        return person;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAppid() {
        return appid;
    }


    public List<String> getRoles() {
        return roles;
    }
}
