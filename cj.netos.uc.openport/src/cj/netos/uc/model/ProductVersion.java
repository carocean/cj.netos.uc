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
     * Column: os
     * Remark: 系统 android ios
     */
    private String os;

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
     * Column: pub_type
     * Remark: 发布类型 0测试版 1发布版
     */
    private Integer pubType;

    /**
     * Column: force_upgrade
     * Remark: 是否强制升级 0为非 1为强制
     */
    private Integer forceUpgrade;

    /**
     * Column: use_layout
     * Remark: 使用布局。 为了应付ios市场要求，在版审核期间临时使用的显示布局 - normal 即回恢为正常运营产品的布局 - simple 即简单应用ios的布局
     */
    private String useLayout;

    /**
     * Column: note
     * Remark: 备注
     */
    private String note;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os == null ? null : os.trim();
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

    public Integer getPubType() {
        return pubType;
    }

    public void setPubType(Integer pubType) {
        this.pubType = pubType;
    }

    public Integer getForceUpgrade() {
        return forceUpgrade;
    }

    public void setForceUpgrade(Integer forceUpgrade) {
        this.forceUpgrade = forceUpgrade;
    }

    public String getUseLayout() {
        return useLayout;
    }

    public void setUseLayout(String useLayout) {
        this.useLayout = useLayout == null ? null : useLayout.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}