package cj.netos.uc.model;

import java.util.Date;

/**
 * Table: uc_company
 */
public class UcCompany {
    /**
     * Column: company_id
     * Remark: 公司id
     */
    private String companyId;

    /**
     * Column: parent_id
     * Remark: 父公司id
     */
    private String parentId;

    /**
     * Column: company_name
     * Remark: 公司名
     */
    private String companyName;

    /**
     * Column: company_code
     * Remark: 公司编码
     */
    private String companyCode;

    /**
     * Column: create_time
     * Remark: 创建时间
     */
    private Date createTime;

    /**
     * Column: zip_code
     * Remark: 公司邮编
     */
    private String zipCode;

    /**
     * Column: address
     * Remark: 公司地址
     */
    private String address;

    /**
     * Column: email
     * Remark: 公司邮箱
     */
    private String email;

    /**
     * Column: website
     * Remark: 公司网站
     */
    private String website;

    /**
     * Column: fex
     * Remark: 公司传真
     */
    private String fex;

    /**
     * Column: tel
     * Remark: 公司电话
     */
    private String tel;

    /**
     * Column: bank
     * Remark: 开户银行
     */
    private String bank;

    /**
     * Column: bank_account
     * Remark: 开户银行账号
     */
    private String bankAccount;

    /**
     * Column: legal_name
     * Remark: 法人名字
     */
    private String legalName;

    /**
     * Column: legal_tel
     * Remark: 法人联系方式
     */
    private String legalTel;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getFex() {
        return fex;
    }

    public void setFex(String fex) {
        this.fex = fex == null ? null : fex.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName == null ? null : legalName.trim();
    }

    public String getLegalTel() {
        return legalTel;
    }

    public void setLegalTel(String legalTel) {
        this.legalTel = legalTel == null ? null : legalTel.trim();
    }
}