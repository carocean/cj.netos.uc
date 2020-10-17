package cj.netos.uc.port;

import cj.netos.uc.model.ProductInfo;
import cj.netos.uc.model.ProductVersion;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.AccessTokenIn;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "产品配置中心")
public interface IProductPorts extends IOpenportService {
    @CjOpenport(usage = "添加产品")
    void addProduct(ISecuritySession securitySession,
                    @CjOpenportParameter(name = "id", usage = "产品标识") String id,
                    @CjOpenportParameter(name = "name", usage = "产品名") String name,
                    @CjOpenportParameter(name = "rootPath", usage = "产品下载根路径") String rootPath,
                    @CjOpenportParameter(name = "note", usage = "备注") String note
    ) throws CircuitException;

    @CjOpenport(usage = "获取产品")
    ProductInfo getProduct(ISecuritySession securitySession,
                           @CjOpenportParameter(name = "id", usage = "产品标识") String id
    ) throws CircuitException;

    @CjOpenport(usage = "获取产品最新版本下载地址，如果不存在则返回空",tokenIn = AccessTokenIn.nope )
    String getNewestVersionDownloadUrl(ISecuritySession securitySession,
                                       @CjOpenportParameter(name = "product", usage = "产品标识") String product,
                                       @CjOpenportParameter(name = "os", usage = "系统：android|ios") String os
    ) throws CircuitException;

    @CjOpenport(usage = "分页产品")
    List<ProductInfo> pageProduct(ISecuritySession securitySession,
                                  @CjOpenportParameter(name = "limit", usage = "页大小") long limit,
                                  @CjOpenportParameter(name = "offset", usage = "页号") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "发布产品")
    void publishVersion(ISecuritySession securitySession,
                        @CjOpenportParameter(name = "product", usage = "产品标识") String product,
                        @CjOpenportParameter(name = "os", usage = "系统：android|ios") String os,
                        @CjOpenportParameter(name = "version", usage = "版本号") String version,
                        @CjOpenportParameter(name = "type", usage = "0调试版；1正式版") int type,
                        @CjOpenportParameter(name = "readmeFile", usage = "版本说明文件") String readmeFile,
                        @CjOpenportParameter(name = "note", usage = "备注") String note
    ) throws CircuitException;

    @CjOpenport(usage = "获取版本号")
    ProductVersion getVersion(ISecuritySession securitySession,
                              @CjOpenportParameter(name = "product", usage = "产品标识") String product,
                              @CjOpenportParameter(name = "os", usage = "系统：android|ios") String os,
                              @CjOpenportParameter(name = "version", usage = "版本号") String version
    ) throws CircuitException;

    @CjOpenport(usage = "分页版本号")
    List<ProductVersion> pageVersion(ISecuritySession securitySession,
                                     @CjOpenportParameter(name = "product", usage = "产品标识") String product,
                                     @CjOpenportParameter(name = "limit", usage = "页大小") long limit,
                                     @CjOpenportParameter(name = "offset", usage = "页号") long offset
    ) throws CircuitException;
}
