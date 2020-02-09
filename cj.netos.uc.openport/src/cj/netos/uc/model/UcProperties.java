package cj.netos.uc.model;

/**
 * Table: uc_properties
 */
public class UcProperties {
    /**
     * Column: prop_id
     */
    private String propId;

    /**
     * Column: prop_key
     */
    private String propKey;

    /**
     * Column: prop_value
     */
    private String propValue;

    /**
     * Column: prop_desc
     */
    private String propDesc;

    public String getPropId() {
        return propId;
    }

    public void setPropId(String propId) {
        this.propId = propId == null ? null : propId.trim();
    }

    public String getPropKey() {
        return propKey;
    }

    public void setPropKey(String propKey) {
        this.propKey = propKey == null ? null : propKey.trim();
    }

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue == null ? null : propValue.trim();
    }

    public String getPropDesc() {
        return propDesc;
    }

    public void setPropDesc(String propDesc) {
        this.propDesc = propDesc == null ? null : propDesc.trim();
    }
}