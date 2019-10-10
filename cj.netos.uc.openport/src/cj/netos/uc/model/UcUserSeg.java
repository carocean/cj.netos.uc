package cj.netos.uc.model;

import java.util.Date;

/**
 * Table: uc_user_seg
 */
public class UcUserSeg {
    /**
     * Column: segment_id
     * Remark: 标识
     */
    private String segmentId;

    /**
     * Column: name
     * Remark: 段名，一定为中文，是要被显示到界面的
     */
    private String name;

    /**
     * Column: create_time
     */
    private Date createTime;

    public String getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(String segmentId) {
        this.segmentId = segmentId == null ? null : segmentId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}