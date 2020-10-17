package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.ProductInfo;
import cj.netos.uc.model.ProductInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductInfoMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(ProductInfoExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(ProductInfoExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(ProductInfo record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(ProductInfo record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<ProductInfo> selectByExample(ProductInfoExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    ProductInfo selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") ProductInfo record, @Param("example") ProductInfoExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") ProductInfo record, @Param("example") ProductInfoExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(ProductInfo record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(ProductInfo record);

    List<ProductInfo> page(@Param(value = "limit") long limit, @Param(value = "offset") long offset);

    void updateCurrentVersion(@Param(value = "id") String id, @Param(value = "currentVersion") String currentVersion);
}