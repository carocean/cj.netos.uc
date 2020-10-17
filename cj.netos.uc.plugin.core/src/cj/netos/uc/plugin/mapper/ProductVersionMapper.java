package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.ProductVersion;
import cj.netos.uc.model.ProductVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductVersionMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(ProductVersionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(ProductVersionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("product") String product, @Param("os") String os, @Param("version") String version);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(ProductVersion record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(ProductVersion record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<ProductVersion> selectByExample(ProductVersionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    ProductVersion selectByPrimaryKey(@Param("product") String product, @Param("os") String os, @Param("version") String version);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") ProductVersion record, @Param("example") ProductVersionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") ProductVersion record, @Param("example") ProductVersionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(ProductVersion record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(ProductVersion record);

    List<ProductVersion> page(@Param(value = "product") String product, @Param(value = "limit") long limit, @Param(value = "offset") long offset);
}