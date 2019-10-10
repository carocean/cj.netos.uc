package cj.netos.uc.model;

import java.util.Date;

/**
 * Table: uc_dept
 */
public class UcDept {
    /**
     * Column: dept_id
     * Remark: 部门id
     */
    private String deptId;

    /**
     * Column: parent_id
     * Remark: 上级部门id
     */
    private String parentId;

    /**
     * Column: company_id
     * Remark: 所属公司id
     */
    private String companyId;

    /**
     * Column: dept_name
     * Remark: 部门名
     */
    private String deptName;

    /**
     * Column: create_time
     * Remark: 创建时间
     */
    private Date createTime;

    /**
     * Column: dept_code
     * Remark: 部门编码
     */
    private String deptCode;

    /**
     * Column: tel
     * Remark: 电话
     */
    private String tel;

    /**
     * Column: fax
     * Remark: 部门传真
     */
    private String fax;

    /**
     * Column: zip_code
     * Remark: 部门邮编
     */
    private String zipCode;

    /**
     * Column: address
     * Remark: 部门地址
     */
    private String address;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
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
}