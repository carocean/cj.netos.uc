package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.UcUserAttrVal;
import cj.netos.uc.model.UcUserAttrValExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcUserAttrValMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UcUserAttrValExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UcUserAttrValExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String valueId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(UcUserAttrVal record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(UcUserAttrVal record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UcUserAttrVal> selectByExample(UcUserAttrValExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    UcUserAttrVal selectByPrimaryKey(String valueId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") UcUserAttrVal record, @Param("example") UcUserAttrValExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") UcUserAttrVal record, @Param("example") UcUserAttrValExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(UcUserAttrVal record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(UcUserAttrVal record);

    List<UcUserAttrVal> listAttributeValue(@Param(value = "uid") String uid, @Param(value = "segmentid") String segmentid);

    void emptyAttributeValues(@Param(value = "uid") String uid, @Param(value = "segmentid") String segmentid);
}