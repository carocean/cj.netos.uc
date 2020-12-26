package cj.netos.uc.model;

/**
 * Table: product_market
 */
public class ProductMarket {
    /**
     * Column: grand
     * Remark: 品牌关键字
     */
    private String grand;

    /**
     * Column: title
     * Remark: 品牌中文名
     */
    private String title;

    /**
     * Column: product
     * Remark: 归属产品
     */
    private String product;

    /**
     * Column: href
     * Remark: 市场地址
     */
    private String href;

    /**
     * Column: state
     * Remark: 是否启用 0是停用 1为启用
     */
    private Integer state;

    public String getGrand() {
        return grand;
    }

    public void setGrand(String grand) {
        this.grand = grand == null ? null : grand.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}