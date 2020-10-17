package cj.netos.uc.plugin.service;

import cj.netos.uc.model.ProductInfo;
import cj.netos.uc.model.ProductVersion;
import cj.netos.uc.model.ProductVersionExample;
import cj.netos.uc.plugin.mapper.PhoneVerifycodeMapper;
import cj.netos.uc.plugin.mapper.ProductInfoMapper;
import cj.netos.uc.plugin.mapper.ProductVersionMapper;
import cj.netos.uc.service.IProductService;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.util.StringUtil;

import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "productService")
public class ProductService implements IProductService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.ProductInfoMapper")
    ProductInfoMapper productInfoMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.ProductVersionMapper")
    ProductVersionMapper productVersionMapper;

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
        productInfoMapper.updateCurrentVersion(productVersion.getProduct(), productVersion.getVersion());
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
    public String getNewestVersionDownloadUrl(String product, String os) {
        ProductInfo info = getProduct(product);
        if (info == null || StringUtil.isEmpty(info.getCurrentVersion())) {
            return null;
        }
        ProductVersion version = getVersion(product, os, info.getCurrentVersion());
        if (version == null) {
            return null;
        }
        String root = info.getRootPath();
        if (!root.endsWith("/")) {
            root = root + "/";
        }
        //例：http://www.nodespower.com/product/downloads/microgeo/android/1.0.0/microgeo-1.0.0.apk
        String appPrefix = "";
        switch (os) {
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
}
