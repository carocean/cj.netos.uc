package cj.netos.uc.port;

import cj.netos.uc.model.ProductInfo;
import cj.netos.uc.model.ProductMarket;
import cj.netos.uc.model.ProductVersion;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.AccessTokenIn;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;
import java.util.Map;

@CjOpenports(usage = "产品配置中心")
public interface IProductPorts extends IOpenportService {
    @CjOpenport(usage = "添加产品")
    void addProduct(ISecuritySession securitySession,
                    @CjOpenportParameter(name = "id", usage = "产品标识") String id,
                    @CjOpenportParameter(name = "name", usage = "产品名") String name,
                    @CjOpenportParameter(name = "rootPath", usage = "产品下载根路径") String rootPath,
                    @CjOpenportParameter(name = "defaultMarket", usage = "默认的应用市场地微下载路径") String defaultMarket,
                    @CjOpenportParameter(name = "note", usage = "备注") String note
    ) throws CircuitException;

    @CjOpenport(usage = "添加支持的应用市场")
    void addMarket(ISecuritySession securitySession,
                   @CjOpenportParameter(name = "brand", usage = "手机品牌标识") String brand,
                   @CjOpenportParameter(name = "title", usage = "手机品牌名") String title,
                   @CjOpenportParameter(name = "product", usage = "归属产品") String product,
                   @CjOpenportParameter(name = "href", usage = "地微应用在市场中的地址") String href,
                   @CjOpenportParameter(name = "state", usage = "是否已上应用市场,0是未上，1为已上") int state
    ) throws CircuitException;

    @CjOpenport(usage = "移除支持的应用市场")
    void removeMarket(ISecuritySession securitySession,
                      @CjOpenportParameter(name = "brand", usage = "手机品牌标识") String brand
    ) throws CircuitException;

    @CjOpenport(usage = "更新应用市场状态")
    void updateMarketState(ISecuritySession securitySession,
                           @CjOpenportParameter(name = "brand", usage = "手机品牌标识") String brand,
                           @CjOpenportParameter(name = "state", usage = "是否已上应用市场,0是未上，1为已上") int state
    ) throws CircuitException;

    @CjOpenport(usage = "获取已打开的应用市场", tokenIn = AccessTokenIn.nope, elementType = ProductMarket.class)
    List<ProductMarket> listOpenedMarket(ISecuritySession securitySession,
                                         @CjOpenportParameter(name = "product", usage = "归属产品") String product
    ) throws CircuitException;

    @CjOpenport(usage = "获取默认的市场", tokenIn = AccessTokenIn.nope)
    String getDefaultMarket(ISecuritySession securitySession,
                            @CjOpenportParameter(name = "product", usage = "归属产品") String product
    ) throws CircuitException;

    @CjOpenport(usage = "获取所有配置的应用市场", tokenIn = AccessTokenIn.nope, elementType = ProductMarket.class)
    List<ProductMarket> listAllMarket(ISecuritySession securitySession,
                                      @CjOpenportParameter(name = "product", usage = "归属产品") String product
    ) throws CircuitException;

    @CjOpenport(usage = "获取产品")
    ProductInfo getProduct(ISecuritySession securitySession,
                           @CjOpenportParameter(name = "id", usage = "产品标识") String id
    ) throws CircuitException;

    @CjOpenport(usage = "获取产品", tokenIn = AccessTokenIn.nope)
    Map<String, String> getNewestVersion(ISecuritySession securitySession,
                                         @CjOpenportParameter(name = "id", usage = "产品标识") String id
    ) throws CircuitException;

    @CjOpenport(usage = "获取最新产品的布局，返回永不为空，默认是normal", tokenIn = AccessTokenIn.nope)
    String getUseLayoutOfNewestVersion(ISecuritySession securitySession,
                                       @CjOpenportParameter(name = "id", usage = "产品标识") String id,
                                       @CjOpenportParameter(name = "os", usage = "系统：android|ios") String os
    ) throws CircuitException;

    @CjOpenport(usage = "获取产品最新版本下载地址，如果不存在则返回空", tokenIn = AccessTokenIn.nope)
    String getNewestVersionDownloadUrl(ISecuritySession securitySession,
                                       @CjOpenportParameter(name = "product", usage = "产品标识") String product,
                                       @CjOpenportParameter(name = "os", usage = "系统：android|ios") String os
    ) throws CircuitException;

    @CjOpenport(usage = "获取产品最新版本下载地址", tokenIn = AccessTokenIn.nope)
    Map<String, String> getNewestVersionDownloadUrls(ISecuritySession securitySession,
                                                     @CjOpenportParameter(name = "product", usage = "产品标识") String product
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
                        @CjOpenportParameter(name = "forceUpgrade", usage = "是否强制升级：0不强制；1强制") int forceUpgrade,
                        @CjOpenportParameter(name = "useLayout", usage = "使用布局,normal|simple") String useLayout,
                        @CjOpenportParameter(name = "readmeFile", usage = "版本说明文件") String readmeFile,
                        @CjOpenportParameter(name = "note", usage = "功能清单，每一行以;号隔开") String note
    ) throws CircuitException;

    @CjOpenport(usage = "获取版本号", tokenIn = AccessTokenIn.nope)
    ProductVersion getVersion(ISecuritySession securitySession,
                              @CjOpenportParameter(name = "product", usage = "产品标识") String product,
                              @CjOpenportParameter(name = "os", usage = "系统：android|ios") String os,
                              @CjOpenportParameter(name = "version", usage = "版本号") String version
    ) throws CircuitException;

    @CjOpenport(usage = "更新最新版本的布局")
    void updateLayoutOfNewestVersion(ISecuritySession securitySession,
                                     @CjOpenportParameter(name = "product", usage = "产品标识") String product,
                                     @CjOpenportParameter(name = "os", usage = "系统：android|ios") String os,
                                     @CjOpenportParameter(name = "useLayout", usage = "使用布局,normal|simple") String useLayout
    ) throws CircuitException;

    @CjOpenport(usage = "分页版本号")
    List<ProductVersion> pageVersion(ISecuritySession securitySession,
                                     @CjOpenportParameter(name = "product", usage = "产品标识") String product,
                                     @CjOpenportParameter(name = "limit", usage = "页大小") long limit,
                                     @CjOpenportParameter(name = "offset", usage = "页号") long offset
    ) throws CircuitException;
}
