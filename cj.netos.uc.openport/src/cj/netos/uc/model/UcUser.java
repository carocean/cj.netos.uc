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
     * Column: real_name
     * Remark: 真实姓名
     */
    private String realName;

    /**
     * Column: create_time
     * Remark: 创建时间
     */
    private Date createTime;

    /**
     * Column: sex
     * Remark: 性别:男（male)；女(female)，空为未设置
     */
    private String sex;

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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
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