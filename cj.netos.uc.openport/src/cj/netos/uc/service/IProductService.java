package cj.netos.uc.service;

import cj.netos.uc.model.ProductInfo;
import cj.netos.uc.model.ProductVersion;

import java.util.List;

public interface IProductService {
    void addProduct(ProductInfo info);

    ProductInfo getProduct(String id);

    List<ProductInfo> pageProduct(long limit, long offset);

    void publishVersion(ProductVersion productVersion);

    ProductVersion getVersion(String product, String version);

    List<ProductVersion> pageVersion(String product,long limit, long offset);

}
