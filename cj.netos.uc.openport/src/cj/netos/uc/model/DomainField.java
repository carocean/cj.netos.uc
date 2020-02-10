package cj.netos.uc.model;

/**
 * Table: domain_field
 */
public class DomainField {
    /**
     * Column: field_id
     */
    private String fieldId;

    /**
     * Column: field_name
     */
    private String fieldName;

    /**
     * Column: group_id
     */
    private String groupId;

    /**
     * Column: field_desc
     */
    private String fieldDesc;

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId == null ? null : fieldId.trim();
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getFieldDesc() {
        return fieldDesc;
    }

    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc == null ? null : fieldDesc.trim();
    }
}