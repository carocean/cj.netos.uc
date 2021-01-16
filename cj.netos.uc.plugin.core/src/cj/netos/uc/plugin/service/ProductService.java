package cj.netos.uc.plugin.service;

import cj.netos.uc.model.*;
import cj.netos.uc.plugin.mapper.ProductInfoMapper;
import cj.netos.uc.plugin.mapper.ProductMarketMapper;
import cj.netos.uc.plugin.mapper.ProductVersionMapper;
import cj.netos.uc.service.IProductService;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.gson2.com.google.gson.reflect.TypeToken;
import cj.ultimate.util.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CjBridge(aspects = "@transaction")
@CjService(name = "productService")
public class ProductService implements IProductService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.ProductInfoMapper")
    ProductInfoMapper productInfoMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.ProductVersionMapper")
    ProductVersionMapper productVersionMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.ProductMarketMapper")
    ProductMarketMapper productMarketMapper;

    @CjTransaction
    @Override
    public void addProduct(ProductInfo info) {
        productInfoMapper.insert(info);
    }

    @CjTransaction
    @Override
    public ProductInfo getProduct(String id) {
        return productInfoMapper.selectByPrimaryKey(id);
    }

    @CjTransaction
    @Override
    public List<ProductInfo> pageProduct(long limit, long offset) {
        return productInfoMapper.page(limit, offset);
    }

    @CjTransaction
    @Override
    public void publishVersion(ProductVersion productVersion) {
        productVersionMapper.insert(productVersion);
        ProductInfo info = productInfoMapper.selectByPrimaryKey(productVersion.getProduct());
        String json = info.getCurrentVersion();
        Map<String, String> map = new HashMap<>();
        if (!StringUtil.isEmpty(json)) {
            Map<String, String> kv = new Gson().fromJson(json, new TypeToken<HashMap<String, String>>() {
            }.getType());
            map.putAll(kv);
        }
        map.put(productVersion.getOs(), productVersion.getVersion());
        json = new Gson().toJson(map);
        productInfoMapper.updateCurrentVersion(productVersion.getProduct(), json);
    }

    @CjTransaction
    @Override
    public ProductVersion getVersion(String product, String os, String version) {
        return productVersionMapper.selectByPrimaryKey(product, os, version);
    }

    @CjTransaction
    @Override
    public List<ProductVersion> pageVersion(String product, long limit, long offset) {
        return productVersionMapper.page(product, limit, offset);
    }

    @CjTransaction
    @Override
    public void updateLayoutOfNewestVersion(String product, String os, String useLayout) {
        ProductInfo info = productInfoMapper.selectByPrimaryKey(product);
        if (info == null||StringUtil.isEmpty(info.getCurrentVersion())) {
            return;
        }
        ProductVersion version=productVersionMapper.selectByPrimaryKey(product,os,info.getCurrentVersion());
        if (version == null) {
            return;
        }
        version.setUseLayout(useLayout);
        productVersionMapper.updateByPrimaryKey(version);
    }

    @CjTransaction
    @Override
    public String getNewestVersionDownloadUrl(String product, String os) {
        ProductInfo info = getProduct(product);
        if (info == null || StringUtil.isEmpty(info.getCurrentVersion())) {
            return null;
        }
        Map<String, String> versions = new Gson().fromJson(info.getCurrentVersion(), new TypeToken<HashMap<String, String>>() {
        }.getType());
        String currentVersion = versions.get(os);
        if (StringUtil.isEmpty(currentVersion)) {
            return null;
        }
        ProductVersion version = getVersion(product, os, currentVersion);
        if (version == null) {
            return null;
        }
        return _loadUrl(info, version);
    }


    @CjTransaction
    @Override
    public Map<String, String> getNewestVersionDownloadUrls(String product) {
        ProductInfo info = getProduct(product);
        Map<String, String> map = new HashMap<>();
        if (info == null || StringUtil.isEmpty(info.getCurrentVersion())) {
            return map;
        }
        Map<String, String> versionMap = new Gson().fromJson(info.getCurrentVersion(), new TypeToken<HashMap<String, String>>() {
        }.getType());
        for (Map.Entry<String, String> entry : versionMap.entrySet()) {
            ProductVersionExample example = new ProductVersionExample();
            example.createCriteria().andProductEqualTo(product).andOsEqualTo(entry.getKey()).andVersionEqualTo(entry.getValue());
            List<ProductVersion> versions = productVersionMapper.selectByExample(example);
            if (versions.isEmpty()) {
                continue;
            }
            ProductVersion version = versions.get(0);
            map.put(version.getOs(), _loadUrl(info, version));
        }
        return map;
    }


    private String _loadUrl(ProductInfo info, ProductVersion version) {
        String root = info.getRootPath();
        if (!root.endsWith("/")) {
            root = root + "/";
        }
        //例：http://www.nodespower.com/product/downloads/microgeo/android/1.0.0/microgeo-1.0.0.apk
        String appPrefix = "";
        switch (version.getOs()) {
            case "android":
                appPrefix = "apk";
                break;
            case "ios":
                appPrefix = "ipa";
                break;
            default:
                break;
        }
        String url = String.format("%s%s/%s/%s/%s-%s.%s",
                root,
                info.getId(),
                version.getOs(),
                version.getVersion(),
                info.getId(),
                version.getVersion(),
                appPrefix
        );
        return url;
    }

    @CjTransaction
    @Override
    public void addMarket(ProductMarket market) {
        productMarketMapper.insert(market);
    }

    @CjTransaction
    @Override
    public void removeMarket(String brand) {
        productMarketMapper.deleteByPrimaryKey(brand);
    }

    @CjTransaction
    @Override
    public List<ProductMarket> listAllMarket(String product) {
        ProductMarketExample example = new ProductMarketExample();
        example.createCriteria().andProductEqualTo(product);
        return productMarketMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public void updateMarketState(String brand, int state) {
        productMarketMapper.updateState(brand, state);
    }

    @CjTransaction
    @Override
    public List<ProductMarket> listOpenedMarket(String product) {
        ProductMarketExample example = new ProductMarketExample();
        example.createCriteria().andProductEqualTo(product).andStateEqualTo(1);
        return productMarketMapper.selectByExample(example);
    }
}
