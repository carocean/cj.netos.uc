package cj.netos.uc.model;

import java.util.Date;

/**
 * Table: uc_user
 */
public class UcUser {
    /**
     * Column: user_id
     * Remark: 用户标识
     */
    private String userId;

    /**
     * Column: user_name
     * Remark: 姓名
     */
    private String userName;

    /**
     * Column: create_time
     * Remark: 创建时间
     */
    private Date createTime;

    /**
     * Column: sex
     * Remark: 性别
     */
    private Byte sex;

    /**
     * Column: email
     * Remark: 邮箱
     */
    private String email;

    /**
     * Column: mobile
     * Remark: 手机
     */
    private String mobile;

    /**
     * Column: idcard
     * Remark: 身份证
     */
    private String idcard;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }
}