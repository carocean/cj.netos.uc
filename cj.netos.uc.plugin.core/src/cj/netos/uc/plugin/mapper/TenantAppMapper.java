package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.TenantApp;
import cj.netos.uc.model.TenantAppExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TenantAppMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(TenantAppExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(TenantAppExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String appId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(TenantApp record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(TenantApp record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<TenantApp> selectByExample(TenantAppExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    TenantApp selectByPrimaryKey(String appId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") TenantApp record, @Param("example") TenantAppExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") TenantApp record, @Param("example") TenantAppExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(TenantApp record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(TenantApp record);

    List<TenantApp> pageApp(@Param(value = "tenantid") String tenantid, @Param(value = "currPage") long currPage, @Param(value = "pageSize") int pageSize);

    void updateWebsite(@Param(value = "appId") String appId, @Param(value = "website") String website, @Param(value = "loginCbUrl") String loginCbUrl, @Param(value = "logoutCbUrl") String logoutCbUrl);

    void updateAppName(@Param(value = "appId") String appId, @Param(value = "appName") String appName);

    void updateAppSecret(@Param(value = "appId") String appId, @Param(value = "appSecret") String appSecret, long tokenExpire);
}