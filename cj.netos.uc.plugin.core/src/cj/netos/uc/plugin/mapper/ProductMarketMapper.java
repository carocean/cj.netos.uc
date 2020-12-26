package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.ProductMarket;
import cj.netos.uc.model.ProductMarketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMarketMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(ProductMarketExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(ProductMarketExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String grand);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(ProductMarket record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(ProductMarket record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<ProductMarket> selectByExample(ProductMarketExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    ProductMarket selectByPrimaryKey(String grand);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") ProductMarket record, @Param("example") ProductMarketExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") ProductMarket record, @Param("example") ProductMarketExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(ProductMarket record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(ProductMarket record);

    void updateState(@Param(value = "brand") String brand,@Param(value = "state") int state);

}