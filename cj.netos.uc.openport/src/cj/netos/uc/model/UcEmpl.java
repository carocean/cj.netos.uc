package cj.netos.uc.model;

import java.util.Date;

/**
 * Table: uc_empl
 */
public class UcEmpl {
    /**
     * Column: empl_id
     * Remark: 员工id
     */
    private String emplId;

    /**
     * Column: user_id
     * Remark: 用户id
     */
    private String userId;

    /**
     * Column: company_id
     * Remark: 公司id
     */
    private String companyId;

    /**
     * Column: dept_id
     * Remark: 部门id
     */
    private String deptId;

    /**
     * Column: create_time
     * Remark: 创建时间
     */
    private Date createTime;

    /**
     * Column: empl_code
     * Remark: 员工编号
     */
    private String emplCode;

    /**
     * Column: empl_position
     * Remark: 员工职位
     */
    private String emplPosition;

    /**
     * Column: entry_time
     * Remark: 入职时间
     */
    private Date entryTime;

    public String getEmplId() {
        return emplId;
    }

    public void setEmplId(String emplId) {
        this.emplId = emplId == null ? null : emplId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEmplCode() {
        return emplCode;
    }

    public void setEmplCode(String emplCode) {
        this.emplCode = emplCode == null ? null : emplCode.trim();
    }

    public String getEmplPosition() {
        return emplPosition;
    }

    public void setEmplPosition(String emplPosition) {
        this.emplPosition = emplPosition == null ? null : emplPosition.trim();
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }
}