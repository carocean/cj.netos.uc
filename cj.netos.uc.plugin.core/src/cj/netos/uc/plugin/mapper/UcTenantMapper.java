package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.UcTenant;
import cj.netos.uc.model.UcTenantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcTenantMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UcTenantExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UcTenantExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String tenantId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(UcTenant record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(UcTenant record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UcTenant> selectByExample(UcTenantExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    UcTenant selectByPrimaryKey(String tenantId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") UcTenant record, @Param("example") UcTenantExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") UcTenant record, @Param("example") UcTenantExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(UcTenant record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(UcTenant record);


    List<UcTenant> pageTenant(@Param(value = "currPage") int currPage, @Param(value = "pageSize")int pageSize);
}