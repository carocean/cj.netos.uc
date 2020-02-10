package cj.netos.uc.model;

/**
 * Table: domain_value
 */
public class DomainValue {
    /**
     * Column: field_id
     */
    private String fieldId;

    /**
     * Column: uid
     */
    private String uid;

    /**
     * Column: content
     */
    private String content;

    /**
     * Column: group_id
     */
    private String groupId;

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId == null ? null : fieldId.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }
}