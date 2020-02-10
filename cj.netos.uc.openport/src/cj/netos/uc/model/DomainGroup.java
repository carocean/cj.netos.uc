package cj.netos.uc.model;

/**
 * Table: domain_group
 */
public class DomainGroup {
    /**
     * Column: group_id
     */
    private String groupId;

    /**
     * Column: group_name
     */
    private String groupName;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }
}