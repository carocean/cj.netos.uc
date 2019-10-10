package cj.netos.uc.model;

/**
 * Table: uc_user_attr_val
 */
public class UcUserAttrVal {
    /**
     * Column: value_id
     * Remark: 标识
     */
    private String valueId;

    /**
     * Column: attribute_id
     * Remark: 属性
     */
    private String attributeId;

    /**
     * Column: user_id
     * Remark: 用户
     */
    private String userId;

    /**
     * Column: value
     * Remark: 属性值
     */
    private String value;

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId == null ? null : valueId.trim();
    }

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId == null ? null : attributeId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}