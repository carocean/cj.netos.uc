package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.UcProperties;
import cj.netos.uc.model.UcPropertiesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcPropertiesMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UcPropertiesExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UcPropertiesExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String propId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(UcProperties record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(UcProperties record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UcProperties> selectByExample(UcPropertiesExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    UcProperties selectByPrimaryKey(String propId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") UcProperties record, @Param("example") UcPropertiesExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") UcProperties record, @Param("example") UcPropertiesExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(UcProperties record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(UcProperties record);
}