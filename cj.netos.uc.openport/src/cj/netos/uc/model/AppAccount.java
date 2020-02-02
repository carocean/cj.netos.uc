package cj.netos.uc.model;

import java.util.Date;

/**
 * Table: app_account
 */
public class AppAccount {
    /**
     * Column: account_id
     * Remark: 账户id
     */
    private String accountId;

    /**
     * Column: account_name
     * Remark: 登录名，当name_kind是第三方时，如微信、支持宝等，该字段存储的是openid
     */
    private String accountName;

    /**
     * Column: nick_name
     * Remark: 昵称
     */
    private String nickName;

    /**
     * Column: avatar
     * Remark: 账户头像
     */
    private String avatar;

    /**
     * Column: signature
     */
    private String signature;

    /**
     * Column: name_kind
     * Remark: 账号名类别：0自定义；1为手机号；2为邮箱；3是微信；4是支付宝账号；5是qq；6是新浪微博；
     */
    private Byte nameKind;

    /**
     * Column: user_id
     * Remark: 登录账号关联的用户
     */
    private String userId;

    /**
     * Column: app_id
     * Remark: 应用编号
     */
    private String appId;

    /**
     * Column: account_pwd
     * Remark: 密码
     */
    private String accountPwd;

    /**
     * Column: is_enable
     * Remark: 是否可用（0可用，1不可用）
     */
    private Byte isEnable;

    /**
     * Column: create_time
     * Remark: 创建时间
     */
    private Date createTime;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public Byte getNameKind() {
        return nameKind;
    }

    public void setNameKind(Byte nameKind) {
        this.nameKind = nameKind;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAccountPwd() {
        return accountPwd;
    }

    public void setAccountPwd(String accountPwd) {
        this.accountPwd = accountPwd == null ? null : accountPwd.trim();
    }

    public Byte getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Byte isEnable) {
        this.isEnable = isEnable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}