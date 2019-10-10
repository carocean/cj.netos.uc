package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.UcUserAttr;
import cj.netos.uc.model.UcUserAttrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcUserAttrMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UcUserAttrExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UcUserAttrExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String attributeId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(UcUserAttr record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(UcUserAttr record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UcUserAttr> selectByExample(UcUserAttrExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    UcUserAttr selectByPrimaryKey(String attributeId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") UcUserAttr record, @Param("example") UcUserAttrExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") UcUserAttr record, @Param("example") UcUserAttrExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(UcUserAttr record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(UcUserAttr record);
}