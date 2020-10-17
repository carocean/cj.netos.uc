package cj.netos.uc.plugin.service;

import cj.netos.uc.model.ProductInfo;
import cj.netos.uc.model.ProductVersion;
import cj.netos.uc.plugin.mapper.PhoneVerifycodeMapper;
import cj.netos.uc.plugin.mapper.ProductInfoMapper;
import cj.netos.uc.plugin.mapper.ProductVersionMapper;
import cj.netos.uc.service.IProductService;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

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
    }

    @CjTransaction
    @Override
    public ProductVersion getVersion(String product, String version) {
        return productVersionMapper.selectByPrimaryKey(product, version);
    }

    @CjTransaction
    @Override
    public List<ProductVersion> pageVersion(String product,long limit, long offset) {
        return productVersionMapper.page(product,limit,offset);
    }
}
