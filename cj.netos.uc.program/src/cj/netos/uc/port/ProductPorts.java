package cj.netos.uc.port;

import cj.netos.uc.model.ProductInfo;
import cj.netos.uc.model.ProductMarket;
import cj.netos.uc.model.ProductVersion;
import cj.netos.uc.service.IProductService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.gson2.com.google.gson.reflect.TypeToken;
import cj.ultimate.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CjService(name = "/product.ports")
public class ProductPorts implements IProductPorts {
    @CjServiceRef(refByName = "ucplugin.productService")
    IProductService productService;

    private void _checkRights(ISecuritySession securitySession) throws CircuitException {
        if (!securitySession.roleIn("platform:administrators")) {
            throw new CircuitException("801", "无权访问");
        }
    }

    @Override
    public void addProduct(ISecuritySession securitySession, String id, String name, String rootPath, String defaultMarket, String note) throws CircuitException {
        _checkRights(securitySession);
        if (StringUtil.isEmpty(id)) {
            throw new CircuitException("404", "缺少参数:id");
        }
        if (StringUtil.isEmpty(name)) {
            throw new CircuitException("404", "缺少参数:name");
        }
        if (StringUtil.isEmpty(rootPath)) {
            throw new CircuitException("404", "缺少参数:rootPath");
        }
        ProductInfo info = new ProductInfo();
        info.setCtime(System.currentTimeMillis() + "");
        info.setId(id);
        info.setName(name);
        info.setRootPath(rootPath);
        info.setDefaultMarket(defaultMarket);
        info.setNote(note);
        productService.addProduct(info);
    }

    @Override
    public void addMarket(ISecuritySession securitySession, String brand, String title, String product, String href, int state) throws CircuitException {
        _checkRights(securitySession);
        if (StringUtil.isEmpty(brand)) {
            throw new CircuitException("404", "缺少参数:brand");
        }
        if (StringUtil.isEmpty(title)) {
            throw new CircuitException("404", "缺少参数:title");
        }
        if (StringUtil.isEmpty(href)) {
            throw new CircuitException("404", "缺少参数:href");
        }
        if (StringUtil.isEmpty(product)) {
            throw new CircuitException("404", "缺少参数:product");
        }
        ProductMarket market = new ProductMarket();
        market.setGrand(brand);
        market.setHref(href);
        market.setTitle(title);
        market.setState(state);
        market.setProduct(product);
        productService.addMarket(market);
    }

    @Override
    public void removeMarket(ISecuritySession securitySession, String brand) throws CircuitException {
        _checkRights(securitySession);
        productService.removeMarket(brand);
    }

    @Override
    public List<ProductMarket> listAllMarket(ISecuritySession securitySession, String product) throws CircuitException {
        return productService.listAllMarket(product);
    }

    @Override
    public void updateMarketState(ISecuritySession securitySession, String brand, int state) throws CircuitException {
        _checkRights(securitySession);
        productService.updateMarketState(brand, state);
    }

    @Override
    public List<ProductMarket> listOpenedMarket(ISecuritySession securitySession, String product) throws CircuitException {
        return productService.listOpenedMarket(product);
    }

    @Override
    public ProductInfo getProduct(ISecuritySession securitySession, String id) throws CircuitException {
        if (StringUtil.isEmpty(id)) {
            return null;
        }
        return productService.getProduct(id);
    }

    @Override
    public String getDefaultMarket(ISecuritySession securitySession, String product) throws CircuitException {
        ProductInfo productInfo = productService.getProduct(product);
        if (productInfo == null) {
            return null;
        }
        return productInfo.getDefaultMarket();
    }

    @Override
    public Map<String, String> getNewestVersion(ISecuritySession securitySession, String id) throws CircuitException {
        Map<String, String> map = new HashMap<>();
        ProductInfo info = productService.getProduct(id);
        if (info == null || info.getCurrentVersion() == null) {
            return map;
        }
        map = new Gson().fromJson(info.getCurrentVersion(), new TypeToken<HashMap<String, String>>() {
        }.getType());
        return map;
    }

    @Override
    public String getUseLayoutOfNewestVersion(ISecuritySession securitySession, String id, String os) throws CircuitException {
        ProductInfo info = productService.getProduct(id);
        if (info == null || info.getCurrentVersion() == null) {
            return "normal";
        }
        ProductVersion version = productService.getVersion(id, os, info.getCurrentVersion());
        if (version == null) {
            return "normal";
        }
        return version.getUseLayout();
    }

    @Override
    public List<ProductInfo> pageProduct(ISecuritySession securitySession, long limit, long offset) throws CircuitException {
        return productService.pageProduct(limit, offset);
    }

    @Override
    public String getNewestVersionDownloadUrl(ISecuritySession securitySession, String product, String os) throws CircuitException {
        return productService.getNewestVersionDownloadUrl(product, os);
    }

    @Override
    public Map<String, String> getNewestVersionDownloadUrls(ISecuritySession securitySession, String product) throws CircuitException {
        return productService.getNewestVersionDownloadUrls(product);
    }

    @Override
    public void publishVersion(ISecuritySession securitySession, String product, String os, String version, int type, int forceUpgrade, String useLayout, String readmeFile, String note) throws CircuitException {
        _checkRights(securitySession);
        if (StringUtil.isEmpty(product)) {
            throw new CircuitException("404", "缺少参数:product");
        }
        if (StringUtil.isEmpty(os)) {
            throw new CircuitException("404", "缺少参数:os");
        }
        if (StringUtil.isEmpty(version)) {
            throw new CircuitException("404", "缺少参数:version");
        }
        ProductInfo info = productService.getProduct(product);
        if (info == null) {
            throw new CircuitException("404", "没有产品:" + product);
        }
        ProductVersion productVersion = new ProductVersion();
        productVersion.setNote(note);
        productVersion.setProduct(product);
        productVersion.setUseLayout(useLayout);
        productVersion.setPubTime(System.currentTimeMillis() + "");
        productVersion.setReadmeFile(readmeFile);
        productVersion.setPubType(type);
        productVersion.setVersion(version);
        productVersion.setOs(os);
        productVersion.setForceUpgrade(forceUpgrade);
        productService.publishVersion(productVersion);
    }

    @Override
    public ProductVersion getVersion(ISecuritySession securitySession, String product, String os, String version) throws CircuitException {
        if (StringUtil.isEmpty(product)) {
            return null;
        }
        if (StringUtil.isEmpty(os)) {
            return null;
        }
        if (StringUtil.isEmpty(version)) {
            return null;
        }
        return productService.getVersion(product, os, version);
    }

    @Override
    public void updateLayoutOfNewestVersion(ISecuritySession securitySession, String product, String os, String useLayout) throws CircuitException {
        _checkRights(securitySession);
        productService.updateLayoutOfNewestVersion(product, os, useLayout);
    }

    @Override
    public List<ProductVersion> pageVersion(ISecuritySession securitySession, String product, long limit, long offset) throws CircuitException {
        if (StringUtil.isEmpty(product)) {
            return new ArrayList<>();
        }
        return productService.pageVersion(product, limit, offset);
    }
}
