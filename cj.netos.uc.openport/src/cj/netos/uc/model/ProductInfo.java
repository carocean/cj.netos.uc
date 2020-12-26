package cj.netos.uc.model;

/**
 * Table: product_info
 */
public class ProductInfo {
    /**
     * Column: id
     * Remark: 产品标识
     */
    private String id;

    /**
     * Column: name
     * Remark: 中文名
     */
    private String name;

    /**
     * Column: root_path
     * Remark: 上载的根路径,一般为url格式
     */
    private String rootPath;

    /**
     * Column: current_version
     * Remark: 当前版本 如:  {"android":"1.0.0","ios":"1.0.2"}
     */
    private String currentVersion;

    /**
     * Column: ctime
     */
    private String ctime;

    /**
     * Column: default_market
     * Remark: 默认应用市场的地微应用下载地址
     */
    private String defaultMarket;

    /**
     * Column: note
     * Remark: 备注
     */
    private String note;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath == null ? null : rootPath.trim();
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion == null ? null : currentVersion.trim();
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

    public String getDefaultMarket() {
        return defaultMarket;
    }

    public void setDefaultMarket(String defaultMarket) {
        this.defaultMarket = defaultMarket == null ? null : defaultMarket.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}