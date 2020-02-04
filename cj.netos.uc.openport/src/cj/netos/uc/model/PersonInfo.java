package cj.netos.uc.model;

import java.util.ArrayList;
import java.util.List;

public class PersonInfo {
    String person;
    String uid;
    String accountCode;
    String nickName;
    String signature;
    String avatar;
    String appid;
    List<String> roles;

    public PersonInfo(String accountCode, String appid) {
        roles = new ArrayList<>();
        this.accountCode = accountCode;
        this.appid=appid;
        this.person = String.format("%s@%s", accountCode, appid);
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
