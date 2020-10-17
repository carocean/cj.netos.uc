package cj.netos.uc.port;

import cj.netos.uc.model.ProductInfo;
import cj.netos.uc.model.ProductVersion;
import cj.netos.uc.service.IProductService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.ultimate.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

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
    public void addProduct(ISecuritySession securitySession, String id, String name, String rootPath, String note) throws CircuitException {
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
        info.setNote(note);
        productService.addProduct(info);
    }


    @Override
    public ProductInfo getProduct(ISecuritySession securitySession, String id) throws CircuitException {
        if (StringUtil.isEmpty(id)) {
            return null;
        }
        return productService.getProduct(id);
    }

    @Override
    public List<ProductInfo> pageProduct(ISecuritySession securitySession, long limit, long offset) throws CircuitException {
        return productService.pageProduct(limit, offset);
    }

    @Override
    public void publishVersion(ISecuritySession securitySession, String product, String version, int type, String readmeFile, String note) throws CircuitException {
        _checkRights(securitySession);
        if (StringUtil.isEmpty(product)) {
            throw new CircuitException("404", "缺少参数:product");
        }
        if (StringUtil.isEmpty(version)) {
            throw new CircuitException("404", "缺少参数:version");
        }
        ProductVersion productVersion = new ProductVersion();
        productVersion.setNote(note);
        productVersion.setProduct(product);
        productVersion.setPubTime(System.currentTimeMillis() + "");
        productVersion.setReadmeFile(readmeFile);
        productVersion.setType(type);
        productVersion.setVersion(version);
        productService.publishVersion(productVersion);
    }

    @Override
    public ProductVersion getVersion(ISecuritySession securitySession, String product, String version) throws CircuitException {
        if (StringUtil.isEmpty(product)) {
            return null;
        }
        if (StringUtil.isEmpty(version)) {
            return null;
        }
        return productService.getVersion(product, version);
    }

    @Override
    public List<ProductVersion> pageVersion(ISecuritySession securitySession, String product,long limit, long offset) throws CircuitException {
        if (StringUtil.isEmpty(product)) {
            return new ArrayList<>();
        }
        return productService.pageVersion(product,limit,offset);
    }
}