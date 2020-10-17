package cj.netos.uc.model;

/**
 * Table: product_version
 */
public class ProductVersion {
    /**
     * Column: product
     * Remark: 所属产品
     */
    private String product;

    /**
     * Column: version
     * Remark: 版本号
     */
    private String version;

    /**
     * Column: readme_file
     * Remark: 说明文件
     */
    private String readmeFile;

    /**
     * Column: pub_time
     * Remark: 发布时间
     */
    private String pubTime;

    /**
     * Column: note
     * Remark: 备注
     */
    private String note;

    /**
     * Column: type
     * Remark: 0测试版 1发布版
     */
    private Integer type;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getReadmeFile() {
        return readmeFile;
    }

    public void setReadmeFile(String readmeFile) {
        this.readmeFile = readmeFile == null ? null : readmeFile.trim();
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime == null ? null : pubTime.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}