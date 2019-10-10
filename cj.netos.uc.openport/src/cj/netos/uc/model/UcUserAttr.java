package cj.netos.uc.model;

/**
 * Table: uc_user_attr
 */
public class UcUserAttr {
    /**
     * Column: attribute_id
     */
    private String attributeId;

    /**
     * Column: name
     * Remark: 属性名
     */
    private String name;

    /**
     * Column: segment_id
     * Remark: 所属段
     */
    private String segmentId;

    /**
     * Column: type
     * Remark: 属性类型
     */
    private String type;

    /**
     * Column: sort
     * Remark: 属性在段中的顺序
     */
    private Integer sort;

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId == null ? null : attributeId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(String segmentId) {
        this.segmentId = segmentId == null ? null : segmentId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}